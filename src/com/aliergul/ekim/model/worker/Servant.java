package com.aliergul.ekim.model.worker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;
import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.School;

public class Servant extends Worker implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3744889424668139462L;
	
	public Servant(Name name, EGender gender, LocalDate birthDay, EMarriageStatus statusMarriage, LocalDate startDate,
			double salary, String[] phone) {
		super(name, gender, birthDay, statusMarriage, startDate, salary, phone);
		this.registrationNumber = String.format("H-%03d", workerCount);
	}
	
	public Servant(Worker worker) {
		super(worker.getName(), worker.getGender(), worker.getBirthDay(), worker.getStatusMarriage(),
				worker.getStartDate(), worker.salary, worker.phone);
		this.registrationNumber = String.format("H-%03d", workerCount);
	}
	
	@Override
	public int getId() {
		return School.SERVANT;
	}
	
	@Override
	public String toString() {
		return String.format("%-17s %s %s %-20s %s %s %s %s %s %-8s %s %-30s %s %s %s  %s %s %.02f %s %.02f %s %n",
				"Servant [Sicil= ", this.registrationNumber, " ,İsim= ", getName(), ", Cinsiyet=",
				getGender().toString(), ", Doğum Tarihi=", getBirthDay().toString(), ", Medeni Durumu=",
				getStatusMarriage().toString(), ", İletişim=", Arrays.toString(getPhone()), ", İşe Başlama Tarhi=",
				getStartDate().toString(), ", Ayrılış Tarihi=",
				((this.finishDate != null) ? getFinishDate().toString() : "DEVAM EDİYOR"), ", Başlangıç Ücreti=",
				getSalary(), ", Güncel Maaş=", getCurrentSallary(), "]");
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
}
