package com.jpuyo.deathnote.activities.playerinfo.deductions;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.playerinfo.BaseSectionFragment;
import com.jpuyo.deathnote.activities.playerinfo.Constants;
import com.jpuyo.deathnote.database.models.Deduction;

public class DeductionsListFragment extends BaseSectionFragment{
	
	public static final DeductionsListFragment newInstance() {
		DeductionsListFragment instance = new DeductionsListFragment();
		instance.fragmentLayout = R.layout.player_info_activity_deductions_list_fragment;
		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	protected void showSectionContent() {
		 List <Deduction> rows = getDeductions();
	     setListAdapter(new DeductionAdapter(this.getActivity().getApplicationContext(), rows, this.playerId));
	}

	private List<Deduction> getDeductions(){
		List <Deduction> deductionsList = new ArrayList<Deduction>();
		for (String deductionDescription:Constants.CARDS){
			Deduction deduction = new Deduction();
			deduction.setPlayer(this.playerId);
			deduction.setDescription(deductionDescription);
			deductionsList.add(deduction);
		}
		return deductionsList;
	}
}
