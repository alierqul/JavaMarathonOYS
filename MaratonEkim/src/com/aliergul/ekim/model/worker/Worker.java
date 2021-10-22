package com.aliergul.ekim.model.worker;

import java.util.Arrays;
import java.util.Date;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;
import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.Person;
import com.aliergul.ekim.model.constants.School;
import com.aliergul.ekim.util.StringHelper;

/**
 * Her çalışanın sicil numarası (M/H/Ö-nnnn şeklinde: M-023, H-452 gibi) ismi,
 * cinsiyeti, evlilik durumu, doğum tarihi, işe başlama ve bitirme tarihleri, iş
 * başlangıcında aldıkları maaş ve en fazla iki adet telefonu (cep, ev) kayıt
 * altında tutulmak zorunda. İsim (önisim, göbek adı ve soyismi) evlilik dışında
 * değiştiremeyecek bir çalışan özelliği. Her çalışanın göbek adı olması
 * zorunluluğu yok, ama varsa bir daha değiştirilemez
 * 
 * @author ERGUL
 *
 */
public class Worker extends Person {
	protected static int workerCount;
	protected Date startDate;
	protected Date finishDate;
	protected double salary; // maaş
	protected String[] phone = new String[2];
	protected String registrationNumber;
	
	public Worker() {
		super();
		if (++workerCount >= 1000 || workerCount <= 0) {
			workerCount = 1;
		}
	}
	
	public Worker(Name name, EGender gender, Date birthDay, EMarriageStatus statusMarriage, Date startDate,
			Date finishDate, double salary, String[] phone) {
		super(name, gender, birthDay, statusMarriage);
		
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.salary = salary;
		this.phone = phone;
	}
	
	public Worker(Name name, String gender, String birthDay, String statusMarriage, String startDate, double salary,
			String[] phone) {
		super(name, gender, birthDay, statusMarriage);
		if (++workerCount >= 1000 || workerCount <= 0) {
			workerCount = 1;
		}
		
		this.startDate = StringHelper.stringToDate(startDate);
		this.salary = salary;
		this.phone = phone;
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.WORKER;
	}
	
	@Override
	public String toString() {
		return registrationNumber + ";" + startDate + ";" + finishDate + ";" + salary + ";" + Arrays.toString(phone)
				+ ";" + getId() + ";" + getStartDate() + ";" + getFinishDate() + ";" + getSalary() + ";"
				+ Arrays.toString(getPhone());
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = StringHelper.stringToDate(startDate);
	}
	
	public Date getFinishDate() {
		return finishDate;
	}
	
	public void setFinishDate(String finishDate) {
		this.finishDate = StringHelper.stringToDate(finishDate);
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String[] getPhone() {
		return phone;
	}
	
	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
}
