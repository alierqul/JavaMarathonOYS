package com.aliergul.ekim.model.constants;

public class Name {
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
		String middle = (MiddleName.length() > 0) ? ", MiddleName=" + MiddleName : "";
		return "Name [name=" + name + middle + ", surname=" + surname + "]";
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
