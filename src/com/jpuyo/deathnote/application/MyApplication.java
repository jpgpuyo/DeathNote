package com.jpuyo.deathnote.application;

import android.app.Application;

import com.jpuyo.deathnote.application.services.ServicesFactory;

public class MyApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		ServicesFactory.initInstance(getApplicationContext());
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		ServicesFactory.destroy();
	}
}