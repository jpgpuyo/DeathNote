package com.jpuyo.deathnote.activities.playerinfo.investigations;

import java.util.List;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.database.models.Investigation;

public class InvestigationAdapter extends ArrayAdapter<Investigation> {

	private final LayoutInflater inflater;
	private final List<Investigation> investigations;
    private SparseBooleanArray selectedItemsIds;
    
    public InvestigationAdapter(Context context, int textViewResourceId, List<Investigation> investigations) {
		super(context, textViewResourceId,investigations);
		this.investigations = investigations;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
       
        ViewHolder view;

        if(convertView == null)
        {           
        	convertView = inflater.inflate(R.layout.player_info_activity_investigation_adapter, null);
            view = new ViewHolder();
            view.card1= (TextView) convertView.findViewById(R.id.lbl_card1);
            view.card2= (TextView) convertView.findViewById(R.id.lbl_card2);
            view.card3= (TextView) convertView.findViewById(R.id.lbl_card3);

            convertView.setTag(view);
            
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        Investigation item = investigations.get(position);
        view.card1.setText(item.getCard1());
        view.card2.setText(item.getCard2());
        view.card3.setText(item.getCard3());

        return convertView;
    }

    private static class ViewHolder{
        protected TextView card1;
        protected TextView card2;
        protected TextView card3;
    }
	
	@Override
    public void remove(Investigation object) {
        investigations.remove(object);
        notifyDataSetChanged();
    }
	 
    public void toggleSelection(int position) {
    	selectView(position, !selectedItemsIds.get(position));
    }
 
    public void removeSelection() {
        selectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }
 
    public void selectView(int position, boolean value) {
        
    	if (value){
            selectedItemsIds.put(position, value);
        }else{
            selectedItemsIds.delete(position);
        }
        notifyDataSetChanged();
    }
 
    public int getSelectedCount() {
        return selectedItemsIds.size();
    }
 
    public SparseBooleanArray getSelectedIds() {
        return selectedItemsIds;
    }

}
