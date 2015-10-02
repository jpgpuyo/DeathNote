package com.jpuyo.deathnote.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "investigations")
public class Investigation {

	@DatabaseField(generatedId  = true)
	private long rowId;

	@DatabaseField
	private int player;

	@DatabaseField
	private String card1;

	@DatabaseField
	private String card2;

	@DatabaseField
	private String card3;

	public Investigation() {
	}

	public Investigation(int player, String card1, String card2,
			String card3) {
		super();
		
		this.player = player;
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
	}

	public long getRowId() {
		return rowId;
	}

	public void setRowId(long rowId) {
		this.rowId = rowId;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public String getCard1() {
		return card1;
	}

	public void setCard1(String card1) {
		this.card1 = card1;
	}

	public String getCard2() {
		return card2;
	}

	public void setCard2(String card2) {
		this.card2 = card2;
	}

	public String getCard3() {
		return card3;
	}

	public void setCard3(String card3) {
		this.card3 = card3;
	}

}
