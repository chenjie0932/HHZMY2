package com.hhzmy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class Vpadapter extends PagerAdapter {
private Context context;
private ArrayList<Integer> list;
public Vpadapter(Context context,ArrayList<Integer> list) {
	this.context=context;
	this.list=list;
}
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView iv=new ImageView(context);
		iv.setImageResource(list.get(position%list.size()));
		container.addView(iv);
		return iv;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//super.destroyItem(container, position, object);
		container.removeView((View) object);
	}

}
