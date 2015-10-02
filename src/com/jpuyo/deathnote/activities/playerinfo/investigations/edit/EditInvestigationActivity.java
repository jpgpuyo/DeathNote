package com.jpuyo.deathnote.activities.playerinfo.investigations.edit;

import kankan.wheel.widget.WheelView;
import android.os.Bundle;
import android.view.View;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.BaseActivity;


public class EditInvestigationActivity extends BaseActivity {

	private CardPicker cardPicker;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_investigation_activity);
		showInvestigationCards();
	}
	
	private void showInvestigationCards(){
		WheelView card1 = (WheelView) findViewById(R.id.wv_card1);
		WheelView card2 = (WheelView) findViewById(R.id.wv_card2);
		WheelView card3 = (WheelView) findViewById(R.id.wv_card3);
		
		String operation = getOperationFromIntent();
		Long rowId=getRowIdFromIntent();
		
		cardPicker = new CardPicker(new CardAdapter(this), new WheelView[]{card1,card2,card3},getInvestigationService());
		
		if (operation.equals("update")){
			cardPicker.loadCards(rowId);
		}
	}
	
	/**
	 * Callback from event OnClick defined on Button for confirm changes
	 */
	public void editInvestigationClick(View v) {
		String operation = getOperationFromIntent();
		
		if (operation.equals("insert")){
			insertInvestigation();
		}
		else if (operation.equals("update")){
			updateInvestigation();
		}
		setResult(RESULT_OK);
		finish();
	}
	
	private void insertInvestigation() {
		getInvestigationService().createInvestigationForPlayer(getPlayerIdFromIntent(), cardPicker);
	}
	
	private void updateInvestigation() {
		getInvestigationService().updateInvestigationFromCardPicker(getRowIdFromIntent(), cardPicker);
	}
	
	private String getOperationFromIntent() {
		return getIntent().getExtras().getString("operation");
	}
	
	private int getPlayerIdFromIntent() {
		return getIntent().getExtras().getInt("player");
	}
	
	private long getRowIdFromIntent() {
		return getIntent().getExtras().getLong("rowId");
	}
}
