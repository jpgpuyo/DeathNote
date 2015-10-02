package com.jpuyo.deathnote.activities.playerinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.playerinfo.investigations.edit.EditInvestigationActivity;

public class PlayerInfoActivity extends FragmentActivity {

	int playerId;
	private PlayerSectionsBuilder playerSectionsBuilder;
	
	private final static int REQUEST_ADD_INVESTIGATIONS = 0;
	
	public int getPlayerId(){
		return playerId;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_info_activity);
		initPlayerId();
		showPlayerInfo();
	}
	
	private void showPlayerInfo() {
		showPlayerId();
		showPlayerSections();
	}

	private void initPlayerId() {
		playerId = getIntent().getIntExtra("player", 0);
	}
	
	private void showPlayerId() {
		TextView tv_player_id = (TextView) findViewById(R.id.lbl_player_id);
		tv_player_id.setText(Integer.toString(playerId));
	}
	
	private void showPlayerSections() {
		playerSectionsBuilder = new PlayerSectionsBuilder(this, getSupportFragmentManager());
		playerSectionsBuilder.createSections();
		
		ViewPager pager = (ViewPager)findViewById(R.id.player_sections_viewpager);
		pager.setAdapter(playerSectionsBuilder);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.player_info_activity, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override 
	public boolean onOptionsItemSelected(MenuItem item) {
  
		 if (item.getItemId() == R.id.add_investigations) {
			 addInvestigations();
			 return true;
			 
		 }
		 return super.onOptionsItemSelected(item);
	}
	
	private void addInvestigations() {
		 Intent i = new Intent(this, EditInvestigationActivity.class);
		 i.putExtra("operation","insert");
		 i.putExtra("player", playerId);	
		 startActivityForResult(i,REQUEST_ADD_INVESTIGATIONS);
	}
}