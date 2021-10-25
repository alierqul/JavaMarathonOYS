package com.aliergul.ekim.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.aliergul.ekim.model.lessons.ClassRoom;
import com.aliergul.ekim.model.lessons.Lessons;
import com.aliergul.ekim.model.students.Student;
import com.aliergul.ekim.model.worker.Worker;

public class ArraysHelper {
	public static final String OBJECT = "object";
	public static final String INDEX = "index";
	public static final String TYPE = "type";
	
	private static Map<Integer, String> menuSearch(String findPerson) {
		Map<Integer, String> menu = new TreeMap<>();
		menu.put(1, "Onay [ " + findPerson + " ]");
		menu.put(2, "[2] Tekrar Dene\t[0] Çıkış");
		
		return menu;
	}
	
	public static Map<String, Object> searchStudent(List<Student> listStudent) {
		Map<String, Object> map = new HashMap<>();
		do {
			Student result = null;
			String seachKey = ConsoleHelper.readString("Öğrenci Numarası Giriniz: ");
			result = listStudent.stream().filter(s -> s.getNumber().equals(seachKey)).findFirst().orElse(null);
			int index = listStudent.stream().map(s -> s.getNumber()).collect(Collectors.toList()).indexOf(seachKey);
			
			if ((result != null) && ConsoleHelper.showMenu("Tekrar Denemek İster misiniz?",
					menuSearch(result.getNumber() + " " + result.getName())) == 1) {
				map.put(OBJECT, result);
				map.put(INDEX, index);
				map.put(TYPE, result.getId());
				return result != null ? map : null;
			}
		} while (ConsoleHelper.showMenu("Öğrenci Bulunamadı", null) != 0);
		return null;
	}
	
	public static Map<String, Object> searchWorker(List<Worker> listWorker) {
		Map<String, Object> map = new HashMap<>();
		do {
			
			Worker result = null;
			String seachKey = ConsoleHelper.readString("Çalışan Sicil Numarası Giriniz: ").toUpperCase();
			result = listWorker.stream().filter(p -> seachKey.equalsIgnoreCase(p.getRegistrationNumber())).findFirst()
					.orElse(null);
			
			int index = listWorker.stream().map(s -> s.getRegistrationNumber()).collect(Collectors.toList())
					.indexOf(seachKey);
			
			if ((result != null) && ConsoleHelper.showMenu("Tekrar Denemek İster misiniz?",
					menuSearch(result.getRegistrationNumber() + " " + result.getName())) == 1) {
				map.put(OBJECT, result);
				map.put(INDEX, index);
				map.put(TYPE, result.getId());
				return result != null ? map : null;
			}
		} while (ConsoleHelper.showMenu("Öğrenci Bulunamadı", null) != 0);
		return null;
	}
	
	public static Map<String, Object> searchClass(List<ClassRoom> listClass) {
		Map<String, Object> map = new HashMap<>();
		do {
			ClassRoom result = null;
			String seachKey = ConsoleHelper.readString("Sınıf Numarası Giriniz: ").toUpperCase();
			result = listClass.stream().filter(p -> seachKey.equalsIgnoreCase(p.getName())).findFirst().orElse(null);
			int index = listClass.stream().map(s -> s.getName()).collect(Collectors.toList()).indexOf(seachKey);
			if ((result != null) && ConsoleHelper.showMenu("Tekrar Denemek İster misiniz?",
					menuSearch(result.getId() + " " + result.getName())) == 1) {
				map.put(OBJECT, result);
				map.put(INDEX, index);
				map.put(TYPE, result.getId());
				return result != null ? map : null;
			}
		} while (ConsoleHelper.showMenu("Öğrenci Bulunamadı", null) != 0);
		return null;
	}
	
	public static Map<String, Object> searchLessons(List<Lessons> listClass) {
		Map<String, Object> map = new HashMap<>();
		do {
			Lessons result = null;
			String seachKey = ConsoleHelper.readString("Ders Kodunu Giriniz: ").toUpperCase();
			result = listClass.stream().filter(p -> seachKey.equalsIgnoreCase(p.getLessonNumber())).findFirst()
					.orElse(null);
			int index = listClass.stream().map(s -> s.getName()).collect(Collectors.toList()).indexOf(seachKey);
			if ((result != null) && ConsoleHelper.showMenu("Tekrar Denemek İster misiniz?",
					menuSearch(result.getId() + " " + result.getName())) == 1) {
				map.put(OBJECT, result);
				map.put(INDEX, index);
				map.put(TYPE, result.getId());
				return result != null ? map : null;
			}
		} while (ConsoleHelper.showMenu("Öğrenci Bulunamadı", null) != 0);
		return null;
	}
}
