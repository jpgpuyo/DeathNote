package com.jpuyo.deathnote.database.daos;

import com.jpuyo.deathnote.database.models.Investigation;
import com.jpuyo.deathnote.database.sqlite.SQLiteHelper;
import com.jpuyo.deathnote.database.sqlite.Tables;

public class InvestigationDaoImpl extends GenericDaoImpl<Investigation, Long> implements InvestigationDao{
	
	public InvestigationDaoImpl(SQLiteHelper sqliteHelper) {
		super(sqliteHelper);
	}

	@Override
	protected Class<Investigation> getEntityClassName() {
		return Tables.INVESTIGATION.getTableClass();
	}
}
