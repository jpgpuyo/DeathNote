package com.jpuyo.deathnote.database.services;

import java.util.List;

import com.jpuyo.deathnote.application.services.DaoFactory;
import com.jpuyo.deathnote.database.daos.DeductionDao;
import com.jpuyo.deathnote.database.models.Deduction;

public class DeductionService {
	
	public List<Deduction> getAllDeductionsFromPlayer(int playerId) {
		List<Deduction> playerDeductions =  getDeductionDao().findAllFromPlayer(playerId);
		return playerDeductions;
	}
	
	public void saveDeductionForPlayer(int playerId, String deductionDescription, boolean isChecked){
		
		Deduction deduction = new Deduction();
		deduction.setPlayer(playerId);
		deduction.setDescription(deductionDescription);
		
		if (isChecked){
			saveDeduction(deduction);
		}else{
			getDeductionDao().deleteDeductionFromPlayer(playerId, deductionDescription);
		}
	}

	public void saveDeductionsForPlayer(int playerId, List<String> deductions) {
		
		deleteAllDeductionsFromPlayer(playerId);
		
		for (String deductionDescription:deductions){
			Deduction deduction = new Deduction();
			deduction.setPlayer(playerId);
			deduction.setDescription(deductionDescription);
			saveDeduction(deduction);
		}
	}
	
	public void deleteAllDeductions() {
		getDeductionDao().deleteAll();
	}
	
	private void deleteAllDeductionsFromPlayer(int playerId) {
		getDeductionDao().deleteAll();
	}
	
	private void saveDeduction(Deduction deduction) {
		getDeductionDao().save(deduction);	
	}
	 
	private DeductionDao getDeductionDao() {
		DeductionDao deductionDao = DaoFactory.getInstance().getDeductionDao();
		return deductionDao;
	}

	public boolean playerHasDeduction(int playerId, String deductionDescription) {
		return !(getDeductionDao().findDeductionForPlayer(playerId, deductionDescription).isEmpty());
	}
}
