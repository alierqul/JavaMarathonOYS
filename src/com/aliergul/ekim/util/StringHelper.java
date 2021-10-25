package com.aliergul.ekim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;

public class StringHelper {
	private static final String DATE_PATTERN = "dd.MM.yyyy";
	
	/**
	 * String Format da Tarihi Date Çevirme
	 * 
	 * @param birthDay
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String strDate) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		Date date = new Date();
		try {
			date = format.parse(strDate.trim());
		} catch (ParseException e) {
			date = null;
			throw new ParseException("Hatalı Tarih Formatı\ndd.MM.yyyy Şeklinde Girilmeli", 0);
			
		}
		return date;
	}
	
	public static LocalDate stringToLocalDate(String strDate) {
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_PATTERN);
		LocalDate date = LocalDate.now();
		date = LocalDate.parse(strDate.trim(), format);
		return date;
	}
	
	public static EGender stringToEgender(String gender) {
		
		switch (gender.trim().toUpperCase()) {
			case "ERKEK", "E", "ER":
				return EGender.ERKEK;
			case "BAYAN", "B", "BA":
				return EGender.KADIN;
			case "KADIN", "K", "KA":
				return EGender.KADIN;
			default:
				throw new IllegalArgumentException("Hatalı Cinsiyet Girdiniz.");
			
		}
		
	}
	
	public static EMarriageStatus stringToEMarriage(String mary) {
		
		switch (mary.trim().toLowerCase()) {
			case "evli", "e", "ev":
				return EMarriageStatus.EVLI;
			case "bekar", "be":
				return EMarriageStatus.BEKAR;
			case "boşanmış", "bo":
				return EMarriageStatus.BOSANMIS;
			default:
				throw new IllegalArgumentException("Hatalı Evlilik durumu Girdiniz.");
			
		}
		
	}
}
