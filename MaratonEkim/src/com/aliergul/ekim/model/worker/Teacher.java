package com.aliergul.ekim.model.worker;

import java.util.Arrays;

import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.School;

/**
 * Öğretmen
 * 
 * @author ERGUL
 *
 */
public class Teacher extends Worker {
	
	public Teacher(Name name, String gender, String birthDay, String statusMarriage, String startDate, double salary,
			String[] phone) {
		super(name, gender, birthDay, statusMarriage, startDate, salary, phone);
		this.registrationNumber = String.format("Ö-%03d", workerCount);
		
	}
	
	public Teacher(Worker worker) {
		super(worker.getName(), worker.getGender(), worker.getBirthDay(), worker.getStatusMarriage(),
				worker.getStartDate(), worker.getFinishDate(), worker.salary, worker.phone);
		this.registrationNumber = String.format("Ö-%03d", workerCount);
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.TEACHER;
	}
	
	@Override
	public String toString() {
		return "Servant [registrationNumber=" + registrationNumber + ", getStartDate()=" + getStartDate()
				+ ", getFinishDate()=" + getFinishDate() + ", getSalary()=" + getSalary() + ", getPhone()="
				+ Arrays.toString(getPhone()) + ", getName()=" + getName() + ", getGender()=" + getGender()
				+ ", getBirthDay()=" + getBirthDay() + ", getStatusMarriage()=" + getStatusMarriage() + "]";
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
}
