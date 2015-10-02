package com.jpuyo.deathnote.activities.playerinfo.investigations;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.playerinfo.BaseSectionFragment;
import com.jpuyo.deathnote.activities.playerinfo.investigations.edit.EditInvestigationActivity;
import com.jpuyo.deathnote.database.models.Investigation;

public class InvestigationsListFragment extends BaseSectionFragment{

	InvestigationAdapter investigationAdapter;
	
	private final static int REQUEST_EDIT_INVESTIGATION = 0;
	
	public static final InvestigationsListFragment newInstance() {
		InvestigationsListFragment instance = new InvestigationsListFragment();
		instance.fragmentLayout = R.layout.player_info_activity_investigations_list_fragment;
		return instance;
	}

	@Override
	protected void showSectionContent(){
		List<Investigation> playerInvestigations = getInvestigationService().getAllInvestigationsFromPlayer(playerId);
		populateInvestigationsListView(playerInvestigations);
	}

	private void populateInvestigationsListView(List<Investigation> playerInvestigations) {
		
		investigationAdapter = new InvestigationAdapter(getActivity().getApplicationContext(),
														R.layout.player_info_activity_investigation_adapter,
														playerInvestigations);

		InvestigationChoiceModeListener listener = 
				new InvestigationChoiceModeListener(this, getListView());

		setListAdapter(investigationAdapter);
		getListView().setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
		getListView().setMultiChoiceModeListener(listener);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		l.setItemChecked(position, true);
	}
	
	public boolean performActions(MenuItem item) {
		
		 if (item.getItemId() == R.id.edit_investigation) {
			 editInvestigation();
			 return true;	 
		 }
		 else if (item.getItemId() == R.id.delete_investigations) {
			 deleteInvestigations();
			 return true;
		 }
		  
		 return false;
	}
	
	private void editInvestigation() {		
		ArrayList<Investigation> selectedInvestigations = getSelectedInvestigations();
		Investigation investigation = selectedInvestigations.iterator().next();		
		Long rowId = investigation.getRowId();
		
		Intent intent = new Intent(getActivity(), EditInvestigationActivity.class);
		intent.putExtra("operation","update");
		intent.putExtra("player", playerId);	
		intent.putExtra("rowId", rowId);
		startActivityForResult(intent,REQUEST_EDIT_INVESTIGATION);
	}

	private void deleteInvestigations() {
		ArrayList<Investigation> selectedInvestigations = getSelectedInvestigations();
		getInvestigationService().removeInvestigations(selectedInvestigations);
		refresh();
	}
	
	private ArrayList<Investigation> getSelectedInvestigations() {
		 SparseBooleanArray checked=getListView().getCheckedItemPositions();
		 ArrayList<Investigation> selectedInvestigations = new ArrayList<Investigation>();
		 
		 for (int i = 0; i < checked.size(); i++) {	
			 int position = checked.keyAt(i);
			 
			 if (checked.valueAt(i)){
				 Investigation investigation=investigationAdapter.getItem(position);
				 selectedInvestigations.add(investigation);
			 }	
		 }
		 return selectedInvestigations;
	}
}
