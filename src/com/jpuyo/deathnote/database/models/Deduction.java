package com.jpuyo.deathnote.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "deductions")
public class Deduction
{
	@DatabaseField(uniqueCombo = true)
	private int player;
	
	@DatabaseField(uniqueCombo = true)
    private String description;
 
    public String getDescription()
    {
        return description;
    }
 
    public void setDescription(String description)
    {
        this.description = description;
    }

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}
}