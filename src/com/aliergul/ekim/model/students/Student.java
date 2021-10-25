package com.aliergul.ekim.model.students;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;
import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.Person;
import com.aliergul.ekim.model.constants.School;
import com.aliergul.ekim.model.lessons.ClassRoom;
import com.aliergul.ekim.model.lessons.Lessons;
import com.aliergul.ekim.util.ExceptionMarriageStatus;

public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6900817231157489390L;
	public static int countStudent;
	private String number;
	private LocalDate startDate;
	private LocalDate finishDate;
	private ClassRoom className;
	private String[] phone = new String[3];
	private List<Lessons> listLessons;
	
	public Student(Name name, EGender gender, LocalDate birthDay, EMarriageStatus statusMarriage, String[] phone)
			throws ExceptionMarriageStatus {
		super(name, gender, birthDay, statusMarriage);
		
		if (this.getStatusMarriage() == EMarriageStatus.EVLI) {
			throw new ExceptionMarriageStatus("Öğrenciler Evli Olamaz.");
		}
		if (++countStudent >= 1000 || countStudent <= 0) {
			countStudent = 1;
		}
		Date date = new Date();
		this.number = String.format("%d-%03d", (date.getYear() + 1900), countStudent);
		listLessons = new ArrayList<>();
		
		this.phone = phone;
		
	}
	
	public void addListLesson(Lessons l) {
		listLessons.add(l);
	}
	
	public List<Lessons> getListLessons() {
		return listLessons;
	}
	
	/**
	 * String.format("%-17s %s %s %-20s %s %s %s %s %s %-8s %s %-30s %s %s %s %s %s
	 * %.02f %s %.02f %s %n",
	 * "Teacher [Sicil= ", this.registrationNumber, " ,İsim= ", getName(), ",
	 * Cinsiyet=",
	 * getGender().toString(), ", Doğum Tarihi=", getBirthDay().toString(), ",
	 * Medeni Durumu=",
	 * getStatusMarriage().toString(), ", İletişim=", Arrays.toString(getPhone()),
	 * ", İşe Başlama Tarhi=",
	 * getStartDate().toString(), ", Ayrılış Tarihi=",
	 * ((this.finishDate != null) ? getFinishDate().toString() : "DEVAM EDİYOR"), ",
	 * Başlangıç Ücreti=",
	 * getSalary(), ", Güncel Maaş=", getCurrentSallary(), "]");
	 */
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return School.STUDENT;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Student [Öğrenci No= %s , Öğrenci Adı= %-20s Cinsiyeti= %s Doğum Tarihi= %s Sınıfı=%s Başlangıç Yılı %s Mezuniyet=%s İletişim =",
				number, getName(), getGender(), getBirthDay(), className.getName(), getStartDate(),
				(getFinishDate() != null ? getFinishDate() : "Devam Ediyor"), Arrays.toString(phone));
		
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getFinishDate() {
		return finishDate;
	}
	
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}
	
	public ClassRoom getClassName() {
		return className;
	}
	
	public void setClassName(ClassRoom className) {
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
