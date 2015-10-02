package com.jpuyo.deathnote.activities.playerinfo;

import com.google.common.collect.ObjectArrays;

public final class Constants {
	
	public final static String IDENTITIES[] = new String[] {
		"Matsuda",
		"Aizawa",
		"Penber",
		"Naomi",
		"Soichiro",
		"Light",
		"Misa",
		"Ryuzaki"};
	
	public final static String MISSIONS[] = new String[] {
		"Poli", 
		"L", 
		"Kira", 
		"X-Kira", 
		};

	public final static String CARDS[] = ObjectArrays.concat(IDENTITIES, MISSIONS, String.class);	
}
