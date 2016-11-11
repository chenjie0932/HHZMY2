package com.hhzmy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hhzmy.R;
import com.hhzmy.adapter.MyPageAdapter;
import com.hhzmy.bean.Pages;

import java.util.ArrayList;

public class WelcomActivity extends AppCompatActivity {
    private ViewPager vp;
    private ArrayList<Pages> pagesList;
    private Button bt_start;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        bt_start = (Button) findViewById(R.id.bt_start);

        //sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        //boolean flag = sharedPreferences.getBoolean("flag", false);

        //if (flag) {
        //startActivity();
        //}

        initData();
        viewPager.setAdapter(new MyPageAdapter(this, pagesList));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // 选中的页面 position当前页面索引值
            @Override
            public void onPageSelected(int position) {
                // 代表滑动到最后一页
                if (position == pagesList.size() - 1) {
                    bt_start.setVisibility(View.VISIBLE);
                } else {
                    bt_start.setVisibility(View.GONE);
                }
            }

            /**
             * 划动界面时，可以获取当前的偏移量
             */
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            /**
             * 活动状态改变
             *
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    // 拖拽
                    case ViewPager.SCROLL_STATE_DRAGGING:

                        break;
                    // 停止
                    case ViewPager.SCROLL_STATE_IDLE:

                        break;

                    default:
                        break;
                }
            }
        });

    }

    private void initData() {
        pagesList = new ArrayList<Pages>();
        pagesList.add(new Pages("我是第一页", R.mipmap.guide_page1));
        pagesList.add(new Pages("我是第二页", R.mipmap.guide_page2));
        pagesList.add(new Pages("我是第三页", R.mipmap.guide_page3));

    }
    public void start(View v) {
        startActivity();
        //Editor edit = sharedPreferences.edit();
        //edit.putBoolean("flag", true);
        //edit.commit();
    }
    private void startActivity() {
        // Toast.makeText(this, "我跳转啦", 0).show();
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
//		overridePendingTransition(enterAnim, exitAnim);
        finish();
    }
}




