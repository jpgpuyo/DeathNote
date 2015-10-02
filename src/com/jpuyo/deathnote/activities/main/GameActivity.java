package com.jpuyo.deathnote.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.playerinfo.PlayerInfoActivity;

public class GameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_activity);
	}

	/**
	 * Callback from event OnClick defined on Player TextViews
	 */
	public void playerClick(View v) {
		int playerId = getPlayerIdClicked(v);
		Intent i = createIntentForPlayerInfoActivity(playerId);
		startActivity(i);
	}

	private int getPlayerIdClicked(View v) {
		int playerId = Integer.parseInt((String) v.getTag());
		return playerId;
	}
	
	private Intent createIntentForPlayerInfoActivity(int playerId){
		Intent i = new Intent(this, PlayerInfoActivity.class);
		i.putExtra("player", playerId);	
		return i;
	}
}
