package com.aliergul.ekim.model.worker;

import java.util.Arrays;

import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.School;

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
public class Officer extends Worker {
	
	public Officer() {
		super();
		this.registrationNumber = String.format("M-%03d", workerCount);
	}
	
	public Officer(Name name, String gender, String birthDay, String statusMarriage, String startDate, double salary,
			String[] phone) {
		super(name, gender, birthDay, statusMarriage, startDate, salary, phone);
		this.registrationNumber = String.format("M-%03d", workerCount);
	}
	
	public Officer(Worker worker) {
		super(worker.getName(), worker.getGender(), worker.getBirthDay(), worker.getStatusMarriage(),
				worker.getStartDate(), worker.getFinishDate(), worker.salary, worker.phone);
		this.registrationNumber = String.format("M-%03d", workerCount);
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.OFFICER;
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
