package com.jpuyo.deathnote.database.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.jpuyo.deathnote.database.models.Deduction;
import com.jpuyo.deathnote.database.sqlite.SQLiteHelper;
import com.jpuyo.deathnote.database.sqlite.Tables;

public class DeductionDaoImpl extends GenericDaoImpl<Deduction, Long> implements DeductionDao{
	
	public DeductionDaoImpl(SQLiteHelper sqliteHelper) {
		super(sqliteHelper);
	}

	@Override
	protected Class<Deduction> getEntityClassName() {
		return Tables.DEDUCTION.getTableClass();
	}
	
	public List<Deduction> findDeductionForPlayer(int playerId, String deductionDescription) {
		
		List<Deduction> playerDeductions = new ArrayList<Deduction>();

		try {
			QueryBuilder<Deduction, Long> queryBuilder = dao.queryBuilder();
			Where<Deduction, Long> where = queryBuilder.where();
			where.eq("player", playerId).and().eq("description", deductionDescription);
			PreparedQuery<Deduction> preparedQuery = queryBuilder.prepare();
			playerDeductions = dao.query(preparedQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO 
		}

		return playerDeductions;
	}
	
	public void deleteDeductionFromPlayer(int playerId, String deductionDescription) {
		  
		try {
			DeleteBuilder<Deduction, Long> deleteBuilder = dao.deleteBuilder();
			Where<Deduction, Long> where = deleteBuilder.where();
			where.eq("player", playerId).and().eq("description", deductionDescription);
			dao.delete(deleteBuilder.prepare());
		} catch (SQLException e) {
			throwFatalException(e);
		}	
	}
}
