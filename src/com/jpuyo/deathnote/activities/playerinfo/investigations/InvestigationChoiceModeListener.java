/***
  Copyright (c) 2012 CommonsWare, LLC
  
  Licensed under the Apache License, Version 2.0 (the "License"); you may
  not use this file except in compliance with the License. You may obtain
  a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package com.jpuyo.deathnote.activities.playerinfo.investigations;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.jpuyo.deathnote.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class InvestigationChoiceModeListener implements
    AbsListView.MultiChoiceModeListener {
	
  InvestigationsListFragment host;
  ActionMode activeMode;
  ListView lv;

  public InvestigationChoiceModeListener(InvestigationsListFragment host, ListView lv) {
    this.host=host;
    this.lv=lv;
  }

  @Override
  public boolean onCreateActionMode(ActionMode mode, Menu menu) {
   
    mode.getMenuInflater().inflate(R.menu.player_info_activity_investigations_list, menu); 
    activeMode=mode;

    return true;
  }
  
  @Override
  public void onDestroyActionMode(ActionMode mode) {
    activeMode=null;
  }

  @Override
  public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
    return false;
  }

  @Override
  public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
    
	boolean result=host.performActions(item);  
    return result;
  }


  @Override
  public void onItemCheckedStateChanged(ActionMode mode, int position,
                                        long id, boolean checked) {
	  updateTitle(mode);
	  activateDeactivateEditAction(mode);
  }

  private void updateTitle(ActionMode mode) {
    mode.setTitle(lv.getCheckedItemCount() + " selected");
  }
  
  private void activateDeactivateEditAction(ActionMode mode) {
	  
	  MenuItem editAction=mode.getMenu().findItem(R.id.edit_investigation);
	  
	  if (lv.getCheckedItemCount() == 1){ 
		  editAction.setVisible(true);
	  }else{
		  editAction.setVisible(false);
	  }
  }
  
}