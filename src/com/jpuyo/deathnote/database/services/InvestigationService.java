package com.jpuyo.deathnote.database.services;

import java.util.ArrayList;
import java.util.List;

import com.jpuyo.deathnote.activities.playerinfo.investigations.edit.CardPicker;
import com.jpuyo.deathnote.application.services.DaoFactory;
import com.jpuyo.deathnote.database.daos.InvestigationDao;
import com.jpuyo.deathnote.database.models.Investigation;

public class InvestigationService {
	
	public Investigation getInvestigation(Long rowId){
		InvestigationDao investigationDao = getInvestigationDao();
		Investigation investigation = investigationDao.findByPrimaryKey(rowId);
		return investigation;
	}
	
	public List<Investigation> getAllInvestigationsFromPlayer(int playerId) {
		List<Investigation> playerInvestigations =  getInvestigationDao().findAllFromPlayer(playerId);
		return playerInvestigations;
	}
	
	public void createInvestigationForPlayer(int playerId, CardPicker cardPicker){
		String card1 = cardPicker.getCard1();
		String card2 = cardPicker.getCard2();
		String card3 = cardPicker.getCard3();
		Investigation investigation = new Investigation(playerId,card1,card2,card3);
		saveInvestigation(investigation);
	}
	
	public void updateInvestigationFromCardPicker(Long rowId, CardPicker cardPicker) {
		Investigation investigation = getInvestigation(rowId);
		investigation.setCard1(cardPicker.getCard1());
		investigation.setCard2(cardPicker.getCard2());
		investigation.setCard3(cardPicker.getCard3());
		updateInvestigation(investigation);
	}
	
	public void removeInvestigations(ArrayList<Investigation> investigations) {
		getInvestigationDao().delete(investigations);
	}
	
	public void deleteAllInvestigations() {
		getInvestigationDao().deleteAll();
	}
	
	private void saveInvestigation(Investigation investigation) {
		getInvestigationDao().save(investigation);	
	}
	
	private void updateInvestigation(Investigation investigation) {
		getInvestigationDao().update(investigation);
	}
	
	private InvestigationDao getInvestigationDao() {
		InvestigationDao investigationDao = DaoFactory.getInstance().getInvestigationDao();
		return investigationDao;
	}
}
