package com.jpuyo.deathnote.activities.playerinfo.investigations.edit;

import java.util.Arrays;
import java.util.List;

import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.playerinfo.Constants;

public class CardAdapter extends AbstractWheelTextAdapter {
	
	private final String cards[] = Constants.CARDS;

	public CardAdapter(Context context) {
		super(context, R.layout.edit_investigation_activity_card_adapter, NO_RESOURCE);

		setItemTextResource(R.id.card);
	}

	@Override
	public View getItem(int index, View cachedView, ViewGroup parent) {
		View view = super.getItem(index, cachedView, parent);
		return view;
	}

	@Override
	public int getItemsCount() {
		return cards.length;
	}

	@Override
	public CharSequence getItemText(int index) {
		return cards[index];
	}
	
	public int getItemIndex(String card){
		List<String> cardsList = Arrays.asList(cards);
		return cardsList.indexOf(card);
	}

}
