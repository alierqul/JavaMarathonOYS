package com.aliergul.ekim.model.lessons;

import java.io.Serializable;
import java.util.List;

import com.aliergul.ekim.model.constants.School;
import com.aliergul.ekim.model.students.Student;
import com.aliergul.ekim.model.worker.Teacher;

public class Lessons extends School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4784492732674654987L;
	public static int countLesson;
	private String lessonNumber;
	private Teacher primeTeacher; // asil
	private Teacher spareTeacher; // yedek
	private String name;
	private String period; // hangi dönem verildii
	private int timeLesson;
	
	private List<Student> listStudent;
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.LESSON;
	}
	
	public Lessons(Teacher primeTeacher, Teacher spareTeacher, String name, String period, int timeLesson) {
		super();
		this.primeTeacher = primeTeacher;
		this.spareTeacher = spareTeacher;
		this.name = name;
		this.period = period;
		this.timeLesson = timeLesson;
		
		if (++countLesson >= 1000 || countLesson <= 0) {
			countLesson = 1;
		}
		this.lessonNumber = String.format("LESSON-%03d", countLesson);
	}
	
	@Override
	public String toString() {
		return "Lessons [primeTeacher=" + primeTeacher + ", spareTeacher=" + spareTeacher + ", name=" + name
				+ ", period=" + period + ", timeLesson=" + timeLesson + ", listStudent=" + listStudent + "]";
	}
	
	public String getLessonNumber() {
		return lessonNumber;
	}
	
	public Teacher getPrimeTeacher() {
		return primeTeacher;
	}
	
	public void setPrimeTeacher(Teacher primeTeacher) {
		this.primeTeacher = primeTeacher;
	}
	
	public Teacher getSpareTeacher() {
		return spareTeacher;
	}
	
	public void setSpareTeacher(Teacher spareTeacher) {
		this.spareTeacher = spareTeacher;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public int getTimeLesson() {
		return timeLesson;
	}
	
	public void setTimeLesson(int timeLesson) {
		this.timeLesson = timeLesson;
	}
	
	public List<Student> getListStudent() {
		return listStudent;
	}
	
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
}
