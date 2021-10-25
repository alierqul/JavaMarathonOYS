package com.aliergul.ekim.globalstrings;

import java.util.Map;
import java.util.TreeMap;

public class MenuCreator {
	GlobalStrings glaGlobalStrings;
	
	public MenuCreator(GlobalStrings glaGlobalStrings) {
		this.glaGlobalStrings = glaGlobalStrings;
	}
	
	public Map<Integer, String> menuCreateMain() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, glaGlobalStrings.getString("Globalization.NEW_WORKER_ADD"));
		mainMenu.put(2, glaGlobalStrings.getString("Globalization.AKTIVE_WORKER_LIST"));
		mainMenu.put(3, glaGlobalStrings.getString("Globalization.PASIVE_WORKER_LIST"));
		mainMenu.put(4, glaGlobalStrings.getString("Globalization.NEW_CLASS_CREATE"));
		mainMenu.put(5, glaGlobalStrings.getString("Globalization.NEW_LESSON_CREATE"));
		mainMenu.put(6, glaGlobalStrings.getString("Globalization.SELECT_STUDENT"));
		mainMenu.put(7, glaGlobalStrings.getString("Globalization.LIST_CLASS"));
		mainMenu.put(8, glaGlobalStrings.getString("Globalization.SELECIONS_LESSON_AT_STUDENT"));
		mainMenu.put(9, glaGlobalStrings.getString("Globalization.GIFT_LIST"));
		mainMenu.put(10, glaGlobalStrings.getString("Globalization.CURRENT_SALARY_LIST"));
		mainMenu.put(11, glaGlobalStrings.getString("Globalization.SELECT_LEANGUE"));
		mainMenu.put(99, glaGlobalStrings.getString("Globalization.EXIT_MAIN"));
		return mainMenu;
	}
	
	public Map<Integer, String> menuCreatPersonList() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, glaGlobalStrings.getString("Globalization.ADD_NEW_TEACHER"));
		mainMenu.put(2, glaGlobalStrings.getString("Globalization.ADD_NEW_SERVANT"));
		mainMenu.put(3, glaGlobalStrings.getString("Globalization.ADD_NEW_OFFICER"));
		mainMenu.put(4, glaGlobalStrings.getString("Globalization.PERSONEL_CHECK_OUT"));
		
		mainMenu.put(99, glaGlobalStrings.getString("Globalization.EXIT_MAIN"));
		return mainMenu;
	}
	
	public Map<Integer, String> menuCreatStudentLessonList() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, glaGlobalStrings.getString("Globalization.LIST_STUDENT_LESSON"));
		mainMenu.put(2, glaGlobalStrings.getString("Globalization.SELECTED_LESSON"));
		
		mainMenu.put(99, glaGlobalStrings.getString("Globalization.EXIT_MAIN"));
		return mainMenu;
	}
	
	public Map<Integer, String> menuCreatStudentList() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, glaGlobalStrings.getString("Globalization.NEW_STUDENT"));
		mainMenu.put(2, glaGlobalStrings.getString("Globalization.SEARCH_STUDENT"));
		
		mainMenu.put(99, glaGlobalStrings.getString("Globalization.EXIT_MAIN"));
		return mainMenu;
	}
	
	public Map<Integer, String> menuCreatClastList() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, glaGlobalStrings.getString("Globalization.ALL_CLASS_LIST"));
		mainMenu.put(2, glaGlobalStrings.getString("Globalization.SEARCH_CLASS"));
		
		mainMenu.put(99, glaGlobalStrings.getString("Globalization.EXIT_MAIN"));
		return mainMenu;
	}
	
	public Map<Integer, String> menuCreatTobeContinued() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, glaGlobalStrings.getString("Globalization.REPEAT") + "02 "
				+ glaGlobalStrings.getString("Globalization.CANCEL"));
		
		return mainMenu;
	}
}
