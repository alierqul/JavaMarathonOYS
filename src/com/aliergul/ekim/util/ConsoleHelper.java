/**
 * 
 */
package com.aliergul.ekim.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;

/**
 * @author ERGUL
 */
public class ConsoleHelper {
	
	public static String selectMenu(String msg) {
		Scanner secim = new Scanner(System.in);
		
		printLine(20);
		print(msg, 2, false);
		String s = secim.next().trim();
		secim.close();
		return s;
	}
	
	public static String readString(String msg) {
		Scanner in = new Scanner(System.in);
		String strLine = "";
		do {
			try {
				
				System.out.print(msg);
				strLine = in.nextLine();
				return strLine;
				
			} catch (IllegalArgumentException e) {
				System.out.println(strLine + " = " + e.getMessage());
			}
		} while (true);
		
	}
	
	public static double readDouble(String msg) {
		Scanner scan = new Scanner(System.in);
		String secim;
		
		do {
			int countNokta = 0;
			System.out.print(msg);
			boolean isDigit = true;
			secim = scan.next().trim();
			for (int i = 0; i < secim.length(); i++) {
				if (secim.charAt(i) == '.' && countNokta < 1)
					countNokta++;
				else if (!Character.isDigit(secim.charAt(i))) {
					isDigit = false;
				}
				
			}
			
			if (isDigit)
				return Double.parseDouble(secim);
			else
				System.out.println("sadece Sayı Giriniz.");
		} while (true);
	}
	
	public static int readInteger(String msg) {
		Scanner scan = new Scanner(System.in);
		String secim;
		
		do {
			System.out.print(msg);
			boolean isDigit = true;
			secim = scan.next().trim();
			for (int i = 0; i < secim.length(); i++) {
				
				if (!Character.isDigit(secim.charAt(i))) {
					isDigit = false;
				}
				
			}
			
			if (isDigit)
				return Integer.parseInt(secim);
			else
				System.out.println("sadece Sayı Giriniz.");
		} while (true);
	}
	
	public static EGender readEGender(String msg) {
		Scanner scan = new Scanner(System.in);
		String secim;
		
		do {
			try {
				System.out.print(msg);
				secim = scan.next().trim();
				EGender gender = StringHelper.stringToEgender(secim);
				return gender;
			} catch (Exception e) {
				System.err.println("HATA: " + e.getMessage());
			}
			
		} while (true);
	}
	
	public static EMarriageStatus readEMarriageStatus(String msg) {
		Scanner scan = new Scanner(System.in);
		String secim;
		
		do {
			try {
				System.out.print(msg);
				
				secim = scan.next().trim();
				EMarriageStatus gender = StringHelper.stringToEMarriage(secim);
				return gender;
			} catch (Exception e) {
				System.err.println("HATA: " + e.getMessage());
			}
			
		} while (true);
	}
	
	public static Date readDate(String msg) {
		Scanner scan = new Scanner(System.in);
		String secim;
		
		do {
			System.out.print(msg);
			
			secim = scan.next().trim();
			try {
				Date date = StringHelper.stringToDate(secim);
				return date;
			} catch (ParseException e) {
				System.out.println("HATA: " + e.getMessage());
				scan.nextLine();
			}
			
		} while (true);
	}
	
	public static LocalDate readLocalDate(String msg) {
		Scanner scan = new Scanner(System.in);
		String secim;
		
		do {
			System.out.print(msg);
			
			secim = scan.next().trim();
			try {
				LocalDate date = StringHelper.stringToLocalDate(secim);
				return date;
			} catch (IllegalArgumentException e) {
				System.out.println("HATA: " + e.getMessage());
				scan.nextLine();
			}
			
		} while (true);
	}
	
	public static int selectDigitSecim() {
		Scanner scan = new Scanner(System.in);
		String secim;
		do {
			boolean isDigit = true;
			secim = scan.next().trim();
			for (int i = 0; i < secim.length(); i++) {
				if (!Character.isDigit(secim.charAt(i))) {
					isDigit = false;
				}
			}
			
			if (isDigit)
				return Integer.parseInt(secim + "");
			
		} while (true);
	}
	
	public static int showMenu(String title, Map<Integer, String> menu) {
		int lineCount = title.length() < 30 ? 30 : title.length();
		printTitle(title, lineCount);
		if (menu == null) {
			menu = new TreeMap<>();
			menu.put(1, "Tekrar Dene");
			menu.put(0, "Çıkış Yap");
		}
		for (Map.Entry<Integer, String> entry : menu.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			print(String.format("[  %02d - %-" + lineCount + "s ]", key, val), 2, true);
			
		}
		printLine(lineCount);
		
		return selectDigitSecim();
	}
	
	public static void print(String msg, int tabCount, boolean ln) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < tabCount; i++) {
			b.append("\t");
		}
		b.append(msg);
		b.append(ln ? "\n" : "");
		System.out.print(b);
		
	}
	
	public static void printTitle(String msg) {
		printTitle(msg, msg.length());
	}
	
	public static void printTitle(String msg, int length) {
		
		if (length <= msg.length()) {
			length = msg.length() + 10;
		}
		printLine(length);
		// int center = (Math.round((length + 10) / 2) - 5);
		int center = (length - msg.length()) / 2;
		// int end = (length + 10) - (center + msg.length());
		int end = (length - msg.length()) / 2;
		print(String.format("%-" + (center + 5) + "s%s%" + (end + 5 + msg.length() % 2) + "s", "=====", msg, "====="),
				2, true);
		printLine(length);
	}
	
	public static void printLine(int msgLong) {
		int lineLong = (msgLong % 2 == 0) ? msgLong + 10 : msgLong + 11;
		StringBuilder line = new StringBuilder();
		line.append("\t\t");
		for (int i = 0; i < lineLong; i++) {
			line.append("=");
		}
		System.out.printf("%s\n", line);
	}
	
	public static void printLine(String msg) {
		printLine(msg.length());
	}
	
	public static void animate(int remain, int total) {
		if (remain > total) {
			throw new IllegalArgumentException();
		}
		int maxBareSize = 10; // 10unit for 100%
		int remainProcent = ((100 * remain) / total) / maxBareSize;
		char defaultChar = '-';
		String icon = "*";
		String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
		StringBuilder bareDone = new StringBuilder();
		bareDone.append("[");
		for (int i = 0; i < remainProcent; i++) {
			bareDone.append(icon);
		}
		String bareRemain = bare.substring(remainProcent, bare.length());
		System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 10 + "%");
		if (remain == total) {
			System.out.print("\n");
		}
	}
	
}
