package com.aliergul.ekim.model.lessons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.aliergul.ekim.model.constants.School;
import com.aliergul.ekim.model.students.Student;
import com.aliergul.ekim.model.worker.Teacher;

public class ClassRoom extends School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1715278882692650847L;
	private String name;
	private Teacher teacher;
	private List<Student> listStudent;
	
	public ClassRoom(String name) {
		super();
		this.name = name;
		listStudent = new ArrayList<>();
	}
	
	public ClassRoom(String name, Teacher teacher) {
		super();
		this.name = name;
		this.teacher = teacher;
		listStudent = new ArrayList<>();
	}
	
	@Override
	public int getId() {
		
		return School.CLASS_ROOM;
	}
	
	public void addListStudent(Student s) {
		if (listStudent == null) {
			listStudent = new ArrayList<>();
			listStudent.add(s);
		} else {
			listStudent.add(s);
		}
	}
	
	@Override
	public String toString() {
		return "ClassRoom [name=" + name + ", teacher=" + teacher + ", listStudent=" + listStudent + ", getId()="
				+ getId() + ", getTeacher()=" + getTeacher() + ", getListStudent()=" + getListStudent() + "]";
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public List<Student> getListStudent() {
		return listStudent;
	}
	
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
