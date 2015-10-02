package com.jpuyo.deathnote.application.services;

import android.content.Context;

public class ServicesFactory {

	private static ServicesFactory instance;
	
	public static ServicesFactory initInstance(Context context) {
		if (instance == null) {
			instance = new ServicesFactory(context.getApplicationContext());
		}
		return instance;
	}

	public static ServicesFactory getInstance() {
		return instance;
	}
	
	public static void destroy(){
		stopServices();
		instance = null;
	}
	
	private ServicesFactory(Context context){
		createServices(context);
	}
	
	private void createServices(Context context){
		BDController.initInstance(context);
		DaoFactory.initInstance();
	}
	
	private static void stopServices(){
		BDController.getInstance().releaseSQLiteHelper();
	}
}
