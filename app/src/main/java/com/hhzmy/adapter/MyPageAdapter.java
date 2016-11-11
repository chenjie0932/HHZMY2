package com.hhzmy.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhzmy.R;
import com.hhzmy.activity.WelcomActivity;
import com.hhzmy.bean.Pages;

import java.util.ArrayList;

public class MyPageAdapter extends PagerAdapter {
	private WelcomActivity mainActivity;
	private ArrayList<Pages> pagesList;

	public MyPageAdapter(WelcomActivity mainActivity, ArrayList<Pages> pagesList) {
		this.mainActivity = mainActivity;
		this.pagesList = pagesList;
	}

	@Override
	public int getCount() {
		return pagesList.size();
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = View.inflate(mainActivity, R.layout.viewpage_item, null);
		ImageView iv_viewpager = (ImageView) view
				.findViewById(R.id.iv_viewpager);
		TextView tv_viewpage_name = (TextView) view
				.findViewById(R.id.tv_viewpage_name);
		iv_viewpager.setImageResource(pagesList.get(position).getResId());
		tv_viewpage_name.setText(pagesList.get(position).getName());

		container.addView(view);

		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
}
