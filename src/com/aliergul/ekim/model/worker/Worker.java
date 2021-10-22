package com.aliergul.ekim.model.worker;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;
import com.aliergul.ekim.model.constants.IWorkerProcess;
import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.Person;
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

public class Worker extends Person implements IWorkerProcess, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7868971912348048786L;
	public static int workerCount;
	protected LocalDate startDate;
	protected LocalDate finishDate;
	protected double salary; // maaş
	protected String[] phone = new String[2];
	protected String registrationNumber;
	
	public Worker(Name name, EGender gender, LocalDate birthDay, EMarriageStatus statusMarriage, LocalDate startDate,
			double salary, String[] phone) {
		super(name, gender, birthDay, statusMarriage);
		if (++workerCount >= 1000 || workerCount <= 0) {
			workerCount = 1;
		}
		this.startDate = startDate;
		this.salary = salary;
		this.phone = phone;
		this.finishDate = null;
	}
	
	@Override
	public int getId() {
		return School.WORKER;
	}
	
	@Override
	public String isthereGiftthisMounth() {
		String msjBirthDay = String.format("[İsim = %-25s] Doğum Günü Bu Ayın         %2d .Günü ", this.getName(),
				this.getBirthDay().getDayOfMonth());
		
		String msjStarDate = String.format("[İsim = %-25s] İşe Başlama Tarihi Bu Ayın %2d .Günü ", this.getName(),
				this.getStartDate().getDayOfMonth());
		LocalDate now = LocalDate.now();
		boolean isStartThisMounth = now.getMonth() == this.startDate.getMonth() && this.finishDate == null;
		boolean isBirthThisMounth = now.getMonth() == this.getBirthDay().getMonth() && this.finishDate == null;
		if (isStartThisMounth && isBirthThisMounth)
			return msjBirthDay + "\n" + msjStarDate;
		if (isBirthThisMounth) {
			return msjBirthDay;
		}
		if (isStartThisMounth)
			return msjStarDate;
		return null;
	}
	
	/**
	 * İşe başladıkları tarihten sonra geçen her altı ayda bir
	 * öğretmenlere %10, memurlara %9 ve hizmetlilere %8.5 zam yapılıyor
	 * • İstenilen bir tarihte güncel maaşların listesinin çıkartılabilinmesi gerekl
	 */
	@Override
	public double getCurrentSallary() {
		LocalDate now = LocalDate.now();
		double cuurentSalary = this.getSalary();
		int mounthCount = (int) Math.floor(this.startDate.until(now, ChronoUnit.MONTHS) / 6);
		for (int i = 1; i <= mounthCount; i++) {
			if (this instanceof Teacher) {
				cuurentSalary = cuurentSalary * 1.10;
			} else if (this instanceof Servant) {
				cuurentSalary = cuurentSalary * 1.085;
			} else if (this instanceof Officer) {
				cuurentSalary = cuurentSalary * 1.09;
			}
		}
		return cuurentSalary;
	}
	
	@Override
	public String toString() {
		return String.format("%-17s %s %s %-20s %s %s %s %s %s %-8s %s %-30s %s %s %s  %s %s %.02f %s %.02f %s %n",
				"Worker [Sicil= ", this.registrationNumber, " ,İsim= ", getName(), ", Cinsiyet=",
				getGender().toString(), ", Doğum Tarihi=", getBirthDay().toString(), ", Medeni Durumu=",
				getStatusMarriage().toString(), ", İletişim=", Arrays.toString(getPhone()), ", İşe Başlama Tarhi=",
				getStartDate().toString(), ", Ayrılış Tarihi=",
				((this.finishDate != null) ? getFinishDate().toString() : "DEVAM EDİYOR"), ", Başlangıç Ücreti=",
				getSalary(), ", Güncel Maaş=", getCurrentSallary(), "]");
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getFinishDate() {
		
		return finishDate;
	}
	
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
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
