package com.jpuyo.deathnote.activities;

import android.app.Activity;

import com.jpuyo.deathnote.database.services.DeductionService;
import com.jpuyo.deathnote.database.services.InvestigationService;

public class BaseActivity extends Activity {

	private InvestigationService investigationService = new InvestigationService();
	private DeductionService deductionService = new DeductionService();

	public InvestigationService getInvestigationService() {
		return investigationService;
	}
	
	public DeductionService getDeductionService() {
		return deductionService;
	}
}
