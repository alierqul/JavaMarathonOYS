package com.aliergul.ekim.model.constants;

import java.util.Date;

import com.aliergul.ekim.util.StringHelper;

public class Person extends School {
	private Name name;
	private EGender gender;
	private Date birthDay;
	private EMarriageStatus statusMarriage; // Evlilik Durumu
	
	public Person(Name name, String gender, String birthDay, String statusMarriage) {
		super();
		this.name = name;
		this.gender = StringHelper.stringToEgender(gender);
		this.birthDay = StringHelper.stringToDate(birthDay);
		this.statusMarriage = StringHelper.stringToEMarriage(statusMarriage);
		
	}
	
	public Person() {
		super();
		
	}
	
	public Person(Name name, EGender gender, Date birthDay, EMarriageStatus statusMarriage) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.statusMarriage = statusMarriage;
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
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
	
	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = StringHelper.stringToDate(birthDay);
	}
	
	public EMarriageStatus getStatusMarriage() {
		return statusMarriage;
	}
	
	public void setStatusMarriage(String statusMarriage) {
		this.statusMarriage = StringHelper.stringToEMarriage(statusMarriage);
	}
	
}