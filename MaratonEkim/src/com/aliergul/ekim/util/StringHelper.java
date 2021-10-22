package com.aliergul.ekim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;

public class StringHelper {
	
	/**
	 * String Format da Tarihi Date Çevirme
	 * 
	 * @param birthDay
	 * @return
	 */
	public static Date stringToDate(String strDate) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			date = null;
			throw new IllegalArgumentException("Hatalı Tarih Formatı\ndd.MM.yyyy Şeklinde Girilmeli");
			
		}
		return date;
	}
	
	public static EGender stringToEgender(String gender) {
		
		switch (gender.toUpperCase()) {
			case "ERKEK", "E":
				return EGender.ERKEK;
			case "BAYAN", "B":
				return EGender.KADIN;
			case "KADIN", "K":
				return EGender.KADIN;
			default:
				throw new IllegalArgumentException("Hatalı Cinsiyet Girdiniz.");
			
		}
		
	}
	
	public static EMarriageStatus stringToEMarriage(String mary) {
		
		switch (mary.toLowerCase()) {
			case "evli":
				return EMarriageStatus.EVLI;
			case "bekar":
				return EMarriageStatus.BEKAR;
			case "boşanmış":
				return EMarriageStatus.BOSANMIS;
			default:
				throw new IllegalArgumentException("Hatalı Evlilik durumu Girdiniz.");
			
		}
		
	}
}
