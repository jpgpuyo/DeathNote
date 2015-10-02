package com.jpuyo.deathnote.activities.playerinfo.investigations.edit;

import kankan.wheel.widget.WheelView;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.database.models.Investigation;
import com.jpuyo.deathnote.database.services.InvestigationService;

public class CardPicker {
	
	private WheelView[] cards;
	private CardAdapter cardAdapter;
	private InvestigationService investigationService;
	
	public CardPicker(CardAdapter cardAdapter, WheelView[] cards, InvestigationService investigationService) {
		super();
		this.cardAdapter=cardAdapter;
		this.cards = cards;
		this.investigationService = investigationService;
		createCardItems();
	}
	
	public void loadCards(Long rowId) {
		Investigation investigation = investigationService.getInvestigation(rowId);
		setCard1(investigation.getCard1());
		setCard2(investigation.getCard2());
		setCard3(investigation.getCard3());
	}

	private void createCardItems(){
		for (int i=0; i<this.cards.length; i++) {	
			WheelView card = this.cards[i];
			card.setVisibleItems(3);
			card.setWheelBackground(R.drawable.wheel_view_background);
			card.setWheelForeground(R.drawable.wheel_view_foreground);
			card.setShadowColor(0xFF000000, 0x88000000, 0x00000000);
			card.setViewAdapter(cardAdapter);
			card.setCurrentItem(3);
		}
	}
	
	public String getCard1(){
		return getCardByIndex(0);	
	}
	
	public String getCard2(){
		return getCardByIndex(1);	
	}
	
	public String getCard3(){
		return getCardByIndex(2);	
	}
	
	public void setCard1(String card){
		setCardByIndex(0,card);	
	}
	
	public void setCard2(String card){
		setCardByIndex(1,card);	
	}
	
	public void setCard3(String card){
		setCardByIndex(2,card);	
	}
	
	private String getCardByIndex(int index){
		int currentItem=this.cards[index].getCurrentItem();
		return (String) this.cardAdapter.getItemText(currentItem);
	}
	
	private void setCardByIndex(int index,String card){
		int itemIndex=this.cardAdapter.getItemIndex(card);
		this.cards[index].setCurrentItem(itemIndex);
	}
}
