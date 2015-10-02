package com.jpuyo.deathnote.activities.playerinfo;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.activities.playerinfo.deductions.DeductionsListFragment;
import com.jpuyo.deathnote.activities.playerinfo.investigations.InvestigationsListFragment;

public class PlayerSectionsBuilder extends FragmentPagerAdapter{

	private ArrayList<String> sectionTitles = new ArrayList<String>();
	private ArrayList<Fragment> sectionFragments = new ArrayList<Fragment>();
	private Context context;
	
	public PlayerSectionsBuilder(Context context, FragmentManager fragmentManager) {
		super(fragmentManager);
		this.context = context;
	}

	public void createSections() {
		initSectionTitles();
		initSectionFragments();
	}
	
	private void initSectionTitles() {
		sectionTitles.add(context.getResources().getString(R.string.tabInvestigations));
		sectionTitles.add(context.getResources().getString(R.string.tabDeductions));
	}

	private void initSectionFragments() {
		sectionFragments.add(InvestigationsListFragment.newInstance());
		sectionFragments.add(DeductionsListFragment.newInstance());
	}

	@Override
	public Fragment getItem(int position) {
		return sectionFragments.get(position);
	}

	@Override
	public int getCount() {
		return sectionFragments.size();
	}
	
	@Override
    public CharSequence getPageTitle (int position) {
        return sectionTitles.get(position);
    }
}
