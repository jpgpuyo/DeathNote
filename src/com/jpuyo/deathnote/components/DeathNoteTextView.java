package com.jpuyo.deathnote.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.jpuyo.deathnote.R;

public class DeathNoteTextView extends TextView {
	
	String font;

    public DeathNoteTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public DeathNoteTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}
	
	public DeathNoteTextView(Context context) {
		super(context);
		init(context);
	}

	
	private void init(Context context) {
		init(context,null);
	}

	private void init(Context context, AttributeSet attrs) {
		
		setFont(context, attrs);
		
		String pathFontFile = "fonts/" + this.font +".ttf";
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), pathFontFile);
        setTypeface(tf ,1);
    }
	
	private void setFont(Context context, AttributeSet attrs) {
		
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DeathNoteTextView);
		String font = ta.getString(R.styleable.DeathNoteTextView_font);
		ta.recycle();
		
		if (font == null){
			this.font = "LTransmission";
		}else{
			this.font = font;
		}
	}

}
