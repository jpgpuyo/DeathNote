package com.jpuyo.deathnote.database.sqlite;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.jpuyo.deathnote.database.models.Deduction;
import com.jpuyo.deathnote.database.models.Investigation;

public class SQLiteConfigUtil extends OrmLiteConfigUtil {

	private static final Class<?>[] classes = new Class[] { Investigation.class, Deduction.class};

	public static void main(String[] args) throws Exception {
		writeConfigFile("ormlite_config.txt", classes);
	}
}
