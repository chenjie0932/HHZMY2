package com.hhzmy.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hhzmy.R;
import com.hhzmy.fragment.F01;
import com.hhzmy.fragment.F02;
import com.hhzmy.fragment.F03;
import com.hhzmy.fragment.F04;

public class OtherActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{


    private FrameLayout fl;
    private android.app.FragmentManager fragmentManager;
    private FragmentManager mFragmentManager;
    private F01 fragmentClasss;
    private F02 fragmentHome;
    private F03 fragmentShopping;
    private F04 fragmentMyebuy;
    private FrameLayout content;
    private FragmentTransaction beginTransaction;
    private RadioButton  tab_one;
    private RadioButton  tab_two;
    private RadioButton  tab_three;
    private RadioButton  tab_four;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        content = (FrameLayout) findViewById(R.id.fl_main);
        ((RadioGroup)findViewById(R.id.radioGroup)).setOnCheckedChangeListener(this);

        initFragment();
    }

    private void initFragment() {
        mFragmentManager = this.getSupportFragmentManager();
        FragmentTransaction beginTransaction = mFragmentManager.beginTransaction();

        fragmentClasss = new F01();
        fragmentHome = new F02();
        fragmentShopping = new F03();
        fragmentMyebuy = new F04();

        beginTransaction.add(R.id.fl_main,fragmentHome);
        beginTransaction.add(R.id.fl_main,fragmentClasss);
        beginTransaction.add(R.id.fl_main,fragmentMyebuy);
        beginTransaction.add(R.id.fl_main,fragmentShopping);
        beginTransaction.show(fragmentHome).hide(fragmentClasss).hide(fragmentShopping).hide(fragmentMyebuy);
        beginTransaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.tab_one:
               // beginTransaction.replace(R.id.fl_main,fragmentHome);
              beginTransaction.show(fragmentHome).hide(fragmentClasss).hide(fragmentShopping).hide(fragmentMyebuy);

                tab_one.setBackgroundResource(R.mipmap.tab_home_pressed);
                tab_two.setBackgroundResource(R.mipmap.tab_class_normal);
                tab_three.setBackgroundResource(R.mipmap.tab_shopping_normal);
                tab_four.setBackgroundResource(R.mipmap.tab_myebuy_normal);
                break;
            case R.id.tab_two:
             //   beginTransaction.replace(R.id.fl_main,fragmentClasss);
                beginTransaction.hide(fragmentHome).show(fragmentClasss).hide(fragmentShopping).hide(fragmentMyebuy);
                tab_one.setBackgroundResource(R.mipmap.tab_home_pressed);
                tab_two.setBackgroundResource(R.mipmap.tab_class_normal);
                tab_three.setBackgroundResource(R.mipmap.tab_shopping_normal);
                tab_four.setBackgroundResource(R.mipmap.tab_myebuy_normal);
                break;
            case R.id.tab_three:
              //  beginTransaction.replace(R.id.fl_main,fragmentShopping);
                beginTransaction.hide(fragmentHome).hide(fragmentClasss).show(fragmentShopping).hide(fragmentMyebuy);
                tab_one.setBackgroundResource(R.mipmap.tab_home_pressed);
                tab_two.setBackgroundResource(R.mipmap.tab_class_normal);
                tab_three.setBackgroundResource(R.mipmap.tab_shopping_normal);
                tab_four.setBackgroundResource(R.mipmap.tab_myebuy_normal);
                break;
            case R.id.tab_four:
              //  beginTransaction.replace(R.id.fl_main,fragmentMyebuy);
                beginTransaction.hide(fragmentHome).hide(fragmentClasss).hide(fragmentShopping).show(fragmentMyebuy);
                tab_one.setBackgroundResource(R.mipmap.tab_home_pressed);
                tab_two.setBackgroundResource(R.mipmap.tab_class_normal);
                tab_three.setBackgroundResource(R.mipmap.tab_shopping_normal);
                tab_four.setBackgroundResource(R.mipmap.tab_myebuy_normal);
                break;
        }
        beginTransaction.commit();
    }



}
