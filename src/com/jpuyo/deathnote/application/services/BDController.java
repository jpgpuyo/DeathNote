package com.jpuyo.deathnote.application.services;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.jpuyo.deathnote.database.sqlite.SQLiteHelper;

public class BDController {

	private static BDController instance;
	private SQLiteHelper sqliteHelper = null;

	public static void initInstance(Context ctx) {
		if (instance == null) {
			instance = new BDController(ctx);
		}
	}

	public static BDController getInstance() {
		return instance;
	}
	
	public SQLiteHelper getSQLiteHelper() {
		return sqliteHelper;
	}
	
	public void releaseSQLiteHelper(){
		if (sqliteHelper != null) {
			OpenHelperManager.releaseHelper();
			sqliteHelper = null;
		}
    }

	private BDController(Context ctx) {
		sqliteHelper=OpenHelperManager.getHelper(ctx, SQLiteHelper.class);
	}
}
