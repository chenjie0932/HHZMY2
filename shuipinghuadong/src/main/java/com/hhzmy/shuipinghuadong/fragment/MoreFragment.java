package com.hhzmy.shuipinghuadong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hhzmy.shuipinghuadong.R;

/**
 * Created by johpo on 2016/11/11 0011.
 */
public class MoreFragment  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        System.out.println("MoreFragment");
        return inflater.inflate(R.layout.main_more, container, false);
    }
}