package com.jpuyo.deathnote.database.daos;

import java.util.List;

import com.jpuyo.deathnote.database.models.Deduction;


public interface DeductionDao  extends GenericDao<Deduction, Long> {
	List<Deduction> findDeductionForPlayer(int playerId, String deductionDescription);
	public void deleteDeductionFromPlayer(int playerId, String deductionDescription);
}