package com.hhzmy.recyclerview;

import android.app.Application;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//  this  当前Activity的this activity.this
		//	 getApplicationContext  
		ImageLoaderUtils.initConfiguration(getApplicationContext());
	}
}
