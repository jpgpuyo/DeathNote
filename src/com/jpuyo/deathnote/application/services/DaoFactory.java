package com.jpuyo.deathnote.application.services;

import java.sql.SQLException;

import com.jpuyo.deathnote.database.daos.DeductionDao;
import com.jpuyo.deathnote.database.daos.DeductionDaoImpl;
import com.jpuyo.deathnote.database.daos.InvestigationDao;
import com.jpuyo.deathnote.database.daos.InvestigationDaoImpl;
import com.jpuyo.deathnote.database.sqlite.SQLiteHelper;

public class DaoFactory {
	
	private static DaoFactory instance;
	private InvestigationDao investigationDao;
	private DeductionDao deductionDao;

	public static void initInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
	}

	public static DaoFactory getInstance() {
		return instance;
	}
	
	public InvestigationDao getInvestigationDao(){
		return investigationDao;
	}
	
	public DeductionDao getDeductionDao(){
		return deductionDao;
	}

	private DaoFactory() {
		try {
			createDaos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void createDaos() throws SQLException{
		SQLiteHelper sqliteHelper = BDController.getInstance().getSQLiteHelper();
		investigationDao = new InvestigationDaoImpl(sqliteHelper);
		deductionDao = new DeductionDaoImpl(sqliteHelper);
	}
}