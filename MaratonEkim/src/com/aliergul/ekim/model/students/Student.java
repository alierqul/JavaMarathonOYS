package com.aliergul.ekim.model.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.aliergul.ekim.model.constants.EMarriageStatus;
import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.Person;
import com.aliergul.ekim.model.constants.School;
import com.aliergul.ekim.model.lessons.ClassRoom;
import com.aliergul.ekim.model.lessons.Lessons;

public class Student extends Person {
	private static int countStudent;
	private String number;
	private Date startDate;
	private Date finishDate;
	private String className;
	private String[] phone = new String[3];
	private List<Lessons> listLessons;
	private List<ClassRoom> listClassRoom;
	
	public Student(Name name, String gender, String birthDay, String statusMarriage) {
		super(name, gender, birthDay, statusMarriage);
		
		if (this.getStatusMarriage() == EMarriageStatus.EVLI) {
			throw new IllegalArgumentException("Öğrenciler Evli Olamaz.");
		}
		if (++countStudent >= 1000 || countStudent <= 0) {
			countStudent = 1;
		}
		Date date = new Date();
		this.number = String.format("%d-%03d", (date.getYear() + 1900), countStudent);
		listLessons = new ArrayList<>();
		listClassRoom = new ArrayList<>();
		
	}
	
	public Student() {
		super();
		if (++countStudent >= 1000 || countStudent <= 0) {
			countStudent = 1;
		}
		Date date = new Date();
		this.number = String.format("%d-%03d", (date.getYear() + 1900), countStudent);
		System.out.println(number);
		listLessons = new ArrayList<>();
		listClassRoom = new ArrayList<>();
	}
	
	public void addListLesson(Lessons l) {
		listLessons.add(l);
	}
	
	public List<Lessons> getListLessons() {
		return listLessons;
	}
	
	public void addListClassRoom(ClassRoom c) {
		listClassRoom.add(c);
	}
	
	public List<ClassRoom> getListClassRoom() {
		return listClassRoom;
	}
	
	@Override
	public String toString() {
		return "Student [number=" + number + ", startDate=" + startDate + ", finishDate=" + finishDate + ", className="
				+ className + ", phone=" + Arrays.toString(phone) + ", getName()=" + getName() + ", getGender()="
				+ getGender() + ", getBirthDay()=" + getBirthDay() + "]";
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.STUDENT;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String[] getPhone() {
		return phone;
	}
	
	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	
	public String getNumber() {
		return number;
	}
	
}
