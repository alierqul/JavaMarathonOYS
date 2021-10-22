package com.aliergul.ekim.model.worker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;
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
public class Officer extends Worker implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 299554659875435738L;
	
	public Officer(Name name, EGender gender, LocalDate birthDay, EMarriageStatus statusMarriage, LocalDate startDate,
			double salary, String[] phone) {
		super(name, gender, birthDay, statusMarriage, startDate, salary, phone);
		this.registrationNumber = String.format("M-%03d", workerCount);
	}
	
	public Officer(Worker worker) {
		super(worker.getName(), worker.getGender(), worker.getBirthDay(), worker.getStatusMarriage(),
				worker.getStartDate(), worker.salary, worker.phone);
		this.registrationNumber = String.format("M-%03d", workerCount);
	}
	
	@Override
	public String toString() {
		return String.format("%-17s %s %s %-20s %s %s %s %s %s %-8s %s %-30s %s %s %s  %s %s %.02f %s %.02f %s %n",
				"Officer [Sicil= ", this.registrationNumber, " ,İsim= ", getName(), ", Cinsiyet=",
				getGender().toString(), ", Doğum Tarihi=", getBirthDay().toString(), ", Medeni Durumu=",
				getStatusMarriage().toString(), ", İletişim=", Arrays.toString(getPhone()), ", İşe Başlama Tarhi=",
				getStartDate().toString(), ", Ayrılış Tarihi=",
				((this.finishDate != null) ? getFinishDate().toString() : "DEVAM EDİYOR"), ", Başlangıç Ücreti=",
				getSalary(), ", Güncel Maaş=", getCurrentSallary(), "]");
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.OFFICER;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
}
