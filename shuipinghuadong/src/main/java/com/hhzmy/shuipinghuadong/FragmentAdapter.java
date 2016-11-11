package com.hhzmy.shuipinghuadong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hhzmy.shuipinghuadong.fragment.BuyFragment;
import com.hhzmy.shuipinghuadong.fragment.CarFragment;
import com.hhzmy.shuipinghuadong.fragment.CategoryFragment;
import com.hhzmy.shuipinghuadong.fragment.HomeFragment;
import com.hhzmy.shuipinghuadong.fragment.MoreFragment;

/**
 * Created by johpo on 2016/11/11 0011.
 */
public class FragmentAdapter  extends FragmentPagerAdapter {
    public final static int TAB_COUNT = 5;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int id) {
        switch (id) {
            case MainActivity.TAB_HOME:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case MainActivity.TAB_CATAGORY:
                CategoryFragment categoryFragment = new CategoryFragment();
                return categoryFragment;
           case MainActivity.TAB_CAR:
                CarFragment carFragment = new CarFragment();
                return carFragment;
            case MainActivity.TAB_BUY:
                BuyFragment buyFragment = new BuyFragment();
                return buyFragment;
            case MainActivity.TAB_MORE:
                MoreFragment moreFragment = new MoreFragment();
                return moreFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
