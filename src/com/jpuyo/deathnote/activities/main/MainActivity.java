package com.jpuyo.deathnote.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.BaseActivity;

public class MainActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
	}

	public void onClickNewGame(View v) {
		deleteAllInvestigations();
		deleteAllDeductions();
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

	public void onClickContinue(View v) {
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

	private void deleteAllInvestigations() {
		getInvestigationService().deleteAllInvestigations();
	}
	
	private void deleteAllDeductions() {
		getDeductionService().deleteAllDeductions();
	}
}