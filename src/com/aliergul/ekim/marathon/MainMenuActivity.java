package com.aliergul.ekim.marathon;

import com.aliergul.ekim.globalstrings.GlobalStrings;

public class MainMenuActivity {
	private static final String SCHOOL_NAME = "MARATON SINAVI ÖRNEĞİ";
	
	public static void main(String[] args) {
		GlobalStrings globalStrings = new GlobalStrings("tr");
		SchoolView oys = new SchoolView(globalStrings);
		
		oys.showMainMenu(SCHOOL_NAME);
	}
	
}
