package com.jpuyo.deathnote.activities.playerinfo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpuyo.deathnote.database.services.DeductionService;
import com.jpuyo.deathnote.database.services.InvestigationService;

public abstract class BaseSectionFragment extends ListFragment implements PlayerSectionFragment{
	
	protected int playerId;
	protected int fragmentLayout;
	private InvestigationService investigationService = new InvestigationService();
	private DeductionService deductionService = new DeductionService();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(fragmentLayout, container, false);
	}
	
	@Override
	public void onResume(){
	    super.onResume();
	    refresh();
	}
	
	@Override
	public void refresh() {
		initPlayerId();
		showSectionContent();
	}
	
	public InvestigationService getInvestigationService() {
		return investigationService;
	}
	
	public DeductionService getDeductionService() {
		return deductionService;
	}
	
	private void initPlayerId() {
		PlayerInfoActivity playerInfoActivity = (PlayerInfoActivity) getActivity();
		this.playerId=playerInfoActivity.getPlayerId();
	}
	
	protected abstract void showSectionContent();
}
