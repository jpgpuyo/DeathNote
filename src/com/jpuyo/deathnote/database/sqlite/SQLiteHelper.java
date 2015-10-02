package com.jpuyo.deathnote.database.sqlite;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jpuyo.deathnote.R;

public class SQLiteHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "DeathNote";
	private static final int DATABASE_VERSION = 1;

	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION,
				R.raw.ormlite_config);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			executeCommandsCreateTables(connectionSource);
		} catch (SQLException e) {
			logErrorAndThrowRunTimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		try {
			executeCommandsDropTables(connectionSource);
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			logErrorAndThrowRunTimeException(e);
		}
	}

	private void executeCommandsCreateTables(ConnectionSource connectionSource)
			throws SQLException {
		for(Tables table : Tables.values()) {
    		TableUtils.createTable(connectionSource, table.getTableClass());
    	}
	}

	private void executeCommandsDropTables(ConnectionSource connectionSource)
			throws SQLException {
		for(Tables table : Tables.values()) {
    		TableUtils.dropTable(connectionSource, table.getTableClass(),true);
    	}
	}

	private void logErrorAndThrowRunTimeException(SQLException e) {
		Log.e(SQLiteHelper.class.getName(), e.getMessage(), e);
		throw new RuntimeException(e);
	}

	@Override
	public void close() {
		super.close();
	}
}
