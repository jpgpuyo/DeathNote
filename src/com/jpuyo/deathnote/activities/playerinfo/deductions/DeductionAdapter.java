package com.jpuyo.deathnote.activities.playerinfo.deductions;
 
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.jpuyo.deathnote.R;
import com.jpuyo.deathnote.database.models.Deduction;
import com.jpuyo.deathnote.database.services.DeductionService;
 
public class DeductionAdapter extends ArrayAdapter<Deduction> implements OnCheckedChangeListener {
	
	private final LayoutInflater inflater;
	private final List<Deduction> deductions;
	private final int playerId;
	
	private DeductionService deductionService = new DeductionService();
 
    public DeductionAdapter(Context context, List<Deduction> deductions, int playerId)
    {
        super(context, 0, deductions);
        this.deductions = deductions;
        this.inflater = LayoutInflater.from(context);
        this.playerId = playerId;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       
        ViewHolder view;

        if(convertView == null)
        {           
        	convertView = inflater.inflate(R.layout.player_info_activity_deduction_adapter, null);
            view = new ViewHolder();
            view.description= (TextView) convertView.findViewById(R.id.txt_deduction_description);
            view.checked = (CheckBox) convertView.findViewById(R.id.chk_deduction);
            view.checked.setOnCheckedChangeListener(this);
            convertView.setTag(view);
            
        } else {
            view = (ViewHolder) convertView.getTag();
        }

        Deduction item = deductions.get(position);
        boolean playerHasDeduction = deductionService.playerHasDeduction(this.playerId, item.getDescription());
        
        view.description.setText(item.getDescription());   
        view.checked.setChecked(playerHasDeduction);
        view.checked.setTag(item.getDescription());
        
        return convertView;
    }
    
    @Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		CheckBox deductionCheckBox = (CheckBox) buttonView;
		String deductionDescription = (String) deductionCheckBox.getTag();
		deductionService.saveDeductionForPlayer(this.playerId, deductionDescription,isChecked);
	}
    
    private static class ViewHolder{
        protected TextView description;
        protected CheckBox checked;
    }
}