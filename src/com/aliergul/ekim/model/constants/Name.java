package com.aliergul.ekim.model.constants;

import java.io.Serializable;

public class Name implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4402776191622164062L;
	private String name;
	private String MiddleName;
	private String surname;
	
	public Name(String name, String middleName, String surname) {
		super();
		this.name = name;
		MiddleName = middleName;
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		String middle = (MiddleName.length() > 0) ? " " + MiddleName + " " : " ";
		return name + middle + surname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMiddleName() {
		return MiddleName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
