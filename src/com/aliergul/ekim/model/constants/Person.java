package com.aliergul.ekim.model.constants;

import java.io.Serializable;
import java.time.LocalDate;

import com.aliergul.ekim.util.StringHelper;

public abstract class Person extends School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -864137605447537485L;
	private Name name;
	private EGender gender;
	private LocalDate birthDay;
	private EMarriageStatus statusMarriage; // Evlilik Durumu
	
	public Person(Name name, EGender gender, LocalDate birthDay, EMarriageStatus statusMarriage) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.statusMarriage = statusMarriage;
	}
	
	@Override
	public int getId() {
		return School.PERSON;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", birthDay=" + birthDay + ", statusMarriage="
				+ statusMarriage + "]";
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public EGender getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = StringHelper.stringToEgender(gender);
	}
	
	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	
	public EMarriageStatus getStatusMarriage() {
		return statusMarriage;
	}
	
	public void setStatusMarriage(EMarriageStatus statusMarriage) {
		this.statusMarriage = statusMarriage;
	}
	
	public void setStatusMarriage(String statusMarriage) {
		this.statusMarriage = StringHelper.stringToEMarriage(statusMarriage);
	}
	
}