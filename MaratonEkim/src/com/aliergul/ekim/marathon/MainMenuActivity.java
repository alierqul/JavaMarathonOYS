package com.aliergul.ekim.marathon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.lessons.ClassRoom;
import com.aliergul.ekim.model.lessons.Lessons;
import com.aliergul.ekim.model.students.Student;
import com.aliergul.ekim.model.worker.Officer;
import com.aliergul.ekim.model.worker.Servant;
import com.aliergul.ekim.model.worker.Teacher;
import com.aliergul.ekim.model.worker.Worker;
import com.aliergul.ekim.util.ConsoleHelper;

public class MainMenuActivity {
	private static List<Worker> listWorker;
	private static List<ClassRoom> listClass;
	private static List<Student> listStudent;
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		listWorker = new ArrayList<>();
		listClass = new ArrayList<>();
		listStudent = new ArrayList<>();
		// Name name, String gender, String birthDay, String statusMarriage, String
		// startDate, String finishDate,
		// double salary, String[] phone
		String[] phone = { "1", "2" };
		Teacher teacher1 = new Teacher(new Name("ali", "", "Ergül"), "erkek", "21.01.1987", "evli", "01.01.1990", 6000,
				phone);
		Teacher teacher2 = new Teacher(new Name("melih", "", "Ergül"), "erkek", "21.01.1987", "evli", "01.01.1990",
				6000, phone);
		Servant teacher3 = new Servant(new Name("mehmet", "", "Ergül"), "erkek", "21.01.1987", "evli", "01.01.1999",
				6000, phone);
		Officer teacher4 = new Officer(new Name("hamza", "", "Ergül"), "erkek", "21.01.1987", "evli", "01.01.1999",
				6000, phone);
		;
		listWorker.add(teacher1);
		listWorker.add(teacher2);
		listWorker.add(teacher3);
		listWorker.add(teacher4);
		listClass.add(new ClassRoom("1A", teacher1));
		// Name name, String gender, String birthDay, String statusMarriage
		Student s1 = new Student(new Name("ali", "", "Ergül"), "erkek", "01.01.2000", "bekar");
		Student s2 = new Student(new Name("veli", "", "Ergül"), "erkek", "01.01.2000", "bekar");
		Student s3 = new Student(new Name("cengiz", "", "Ergül"), "erkek", "01.01.2000", "bekar");
		listStudent.add(s1);
		listStudent.add(s2);
		listStudent.add(s3);
		Lessons l1 = new Lessons(teacher1, teacher2, "Edebiyat", "2020-01", 40);
		Lessons l2 = new Lessons(teacher1, teacher2, "Tarih", "2020-01", 40);
		Lessons l3 = new Lessons(teacher1, teacher2, "Matematik", "2020-01", 40);
		listStudent.get(0).addListLesson(l1);
		listStudent.get(0).addListLesson(l1);
		listStudent.get(0).addListLesson(l2);
		listStudent.get(1).addListLesson(l1);
		listStudent.get(1).addListLesson(l1);
		listStudent.get(2).addListLesson(l2);
		ClassRoom c1 = new ClassRoom("1A", teacher2);
		ClassRoom c2 = new ClassRoom("1B", teacher1);
		c1.addListStudent(s1);
		c2.addListStudent(s2);
		c2.addListStudent(s3);
		s1.addListLesson(l1);
		s1.addListLesson(l2);
		s2.addListLesson(l3);
		s2.addListLesson(l1);
		s2.addListLesson(l2);
		s2.addListLesson(l3);
		s1.addListClassRoom(c1);
		s2.addListClassRoom(c2);
		listClass.add(c1);
		listClass.add(c2);
		
		int choose = 0;
		while ((choose = ConsoleHelper.showMenu("Maraton Sınavı", menuCreateMain())) != 99) {
			switch (choose) {
				case 1:
					addNewWorker();
					break;
				case 2:
					viewListWorkerList();
					break;
				case 3:
					viewListNotWorkerList();
					break;
				case 4:
					viewNewClass();
					break;
				case 5:
					viewOgrenciAtama();
					break;
				case 6:
					viewClassList();
					break;
				case 7:
					viewOgrencininKatildigiSiniflar();
					break;
				case 8:
					
					break;
				case 9:
					maasListesi();
					break;
				case 99, 0:
					continue;
				
				default:
					break;
			}
		}
		ConsoleHelper.printTitle("Ali ERGÜL", 30);
		ConsoleHelper.printTitle("Maraton Ödevi", 30);
		ConsoleHelper.printTitle("Teşekkürler", 30);
	}
	
	private static void maasListesi() {
		for (Worker w : listWorker) {
			System.out.println("Name: " + w.getName().toString() + "    " + "Maaş: " + w.getSalary());
		}
		
	}
	
	private static void viewOgrencininKatildigiSiniflar() {
		Student s = searchStudent();
		if (s != null) {
			for (ClassRoom l : s.getListClassRoom()) {
				System.out.println(l.toString());
			}
		} else {
			System.out.println("Öğrenci Bulunamadı.");
		}
	}
	
	private static void viewClassList() {
		ClassRoom classRoom = null;
		int key;
		do {
			
			classRoom = searchClass();
			if (classRoom == null) {
				System.out.println("Sınıf Bulunamadı");
			} else {
				System.out.println(classRoom.toString());
			}
			key = ConsoleHelper.readInteger("Çıkmak İçin Sıfır a Basınız.");
		} while (key != 0);
		
	}
	
	private static void viewNewClass() {
		Worker teacher = null;
		String className = "";
		char key;
		do {
			className = ConsoleHelper.readString("Sınıf Adı Giriniz: ");
			teacher = searchWorker();
			if (teacher == null) {
				System.out.println("Öğretmen Bulunamadı");
			}
			
		} while (teacher == null);
		
		ClassRoom classRoom = new ClassRoom(className);
		classRoom.setTeacher((Teacher) teacher);
		listClass.add(classRoom);
		
	}
	
	private static void viewOgrenciAtama() {
		int chooseWorker = 0;
		
		while ((chooseWorker = ConsoleHelper.showMenu("5 Öğrenci Atama", menuCreatStudentList())) != 99) {
			
			switch (chooseWorker) {
				case 1:
					Student s = addNewStudent();
					listStudent.add(s);
					break;
				case 2:
					sinifaKayitEtmeVarOlanOgrenci();
					break;
				
				default:
					break;
			}
			
			if (chooseWorker == 0)
				break;
		}
	}
	
	private static void sinifaKayitEtmeVarOlanOgrenci() {
		Student student = null;
		do {
			String nameClass = ConsoleHelper.readString("Öğrenci Adı Giriniz: ");
			student = listStudent.stream().filter(p -> nameClass.equals(p.getName())).findAny().orElse(null);
			if (student == null) {
				System.out.println("Öğrenci Bulunamadı");
			}
		} while (student == null);
		ClassRoom classRoom = null;
		do {
			String nameClass = ConsoleHelper.readString("Sınıf Adı Giriniz: ");
			classRoom = listClass.stream().filter(p -> nameClass.equals(p.getName())).findAny().orElse(null);
			if (classRoom == null) {
				System.out.println("Sınıf Bulunamadı");
			}
		} while (classRoom != null);
		classRoom.addListStudent(student);
	}
	
	/**
	 * Menü 1 Yeni Çalışan ekleme
	 */
	private static void addNewWorker() {
		int chooseWorker = 0;
		
		while ((chooseWorker = ConsoleHelper.showMenu("Yeni Çalışan Ekleme", menuCreatPersonList())) != 99) {
			Worker person = null;
			switch (chooseWorker) {
				case 1:
					person = addTeacher();
					break;
				case 2:
					person = addServant();
					break;
				case 3:
					person = addSOfficer();
					break;
				
				default:
					break;
			}
			listWorker.add(person);
			if (chooseWorker == 0)
				break;
		}
	}
	
	private static void setPersonelFinishDate() {
		String search = ConsoleHelper.readString("Personel ismi Yazınız: ");
		listWorker.stream().filter(s -> s instanceof Worker)
				.filter(p -> ((Worker) p).getName().getName().startsWith(search)).forEach(System.out::println);
		String index = ConsoleHelper.readString("Sicil No Numarasını Giriniz:");
		Date date = ConsoleHelper.readDate("Çıkış Tarihini Giriniz.");
		
	}
	
	private static void viewListNotWorkerList() {
		listWorker.stream().filter(s -> s instanceof Worker).filter(p -> ((Worker) p).getFinishDate() != null)
				.forEach(System.out::println);
		
	}
	
	private static void viewListWorkerList() {
		listWorker.stream().filter(s -> s instanceof Worker).filter(p -> ((Worker) p).getFinishDate() == null)
				.forEach(System.out::println);
		
	}
	
	private static Worker addSOfficer() {
		try {
			Officer newPerson = new Officer(addNewWoker());
			return newPerson;
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	private static Worker addServant() {
		try {
			Servant newPerson = new Servant(addNewWoker());
			return newPerson;
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	private static Worker addTeacher() {
		try {
			Teacher newPerson = new Teacher(addNewWoker());
			return newPerson;
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	private static Name addNewName() {
		String name, middleName, surnama;
		// Soruda middlename set methodu olmasın dendiği için önce değiken tanımladım.
		
		name = (ConsoleHelper.readString("Adınızı: "));
		System.out.println("Varsa İkinci Adınız Giriniz: ");
		middleName = s.next();
		surnama = (ConsoleHelper.readString("Soyadınız: "));
		
		return new Name(name, middleName, surnama);
	}
	
	// String finishDate,
	// double salary, String[] phone
	private static Worker addNewWoker() {
		Worker worker = new Worker();
		worker.setName(addNewName());
		worker.setGender(ConsoleHelper.readString("Cinsiyetiniz: "));
		worker.setBirthDay(ConsoleHelper.readString("Doğum Tarihiniz: "));
		worker.setStatusMarriage(ConsoleHelper.readString("Evlilik Durumunuz: "));
		worker.setStartDate(ConsoleHelper.readString("İşe Başlama Tarihi:"));
		worker.setSalary(ConsoleHelper.readDouble("Güncel Maaşı:"));
		String[] phone = new String[2];
		phone[0] = (ConsoleHelper.readString("1.Telefon Giriniz:"));
		phone[1] = (ConsoleHelper.readString("2.Telefon Giriniz:"));
		worker.setPhone(phone);
		return worker;
	}
	
	private static Student searchStudent() {
		Student student = null;
		String nameClass = ConsoleHelper.readString("Öğrenci Numarası Giriniz: ");
		student = listStudent.stream().filter(p -> nameClass.equalsIgnoreCase(p.getNumber())).findAny().orElse(null);
		return student;
	}
	
	private static Worker searchWorker() {
		Worker worker = null;
		String nameClass = ConsoleHelper.readString("Çalışan Sicil Numarası Giriniz: ");
		worker = listWorker.stream().filter(p -> nameClass.equalsIgnoreCase(p.getRegistrationNumber())).findAny()
				.orElse(null);
		return worker;
	}
	
	private static ClassRoom searchClass() {
		ClassRoom clasroom = null;
		String nameClass = ConsoleHelper.readString("Sınıf Numarası Giriniz: ");
		clasroom = listClass.stream().filter(p -> nameClass.equalsIgnoreCase(p.getName())).findAny().orElse(null);
		return clasroom;
	}
	
	private static Student addNewStudent() {
		Student student = new Student();
		
		student.setName(addNewName());
		student.setGender(ConsoleHelper.readString("Cinsiyetiniz: "));
		student.setBirthDay(ConsoleHelper.readString("Doğum Tarihiniz: "));
		String[] phone = new String[3];
		phone[0] = (ConsoleHelper.readString("1.Telefon Giriniz:"));
		phone[1] = (ConsoleHelper.readString("2.Telefon Giriniz:"));
		phone[1] = (ConsoleHelper.readString("3.Telefon Giriniz:"));
		student.setPhone(phone);
		return student;
	}
	
	private static Map<Integer, String> menuCreateMain() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, "Yeni Çalışan");
		mainMenu.put(2, "Çalışan Listesi");
		mainMenu.put(3, "Eski Çalışanlar");
		mainMenu.put(4, "Yeni Sınıf");
		mainMenu.put(5, "Öğrenci Atama");
		mainMenu.put(6, "Sınıf Listesi");
		mainMenu.put(7, "Öğrencinin Sınıfları");
		mainMenu.put(8, "Hediye Listesi");
		mainMenu.put(9, "Maaş Listesi");
		mainMenu.put(99, "Çıkış için [99] [0]");
		return mainMenu;
	}
	
	private static Map<Integer, String> menuCreatPersonList() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, "Yeni Öğretmen");
		mainMenu.put(2, "Yeni Hizmetli");
		mainMenu.put(3, "Yeni Memur");
		
		mainMenu.put(99, "Çıkış için [99] [0]");
		return mainMenu;
	}
	
	private static Map<Integer, String> menuCreatStudentList() {
		Map<Integer, String> mainMenu = new TreeMap<>();
		mainMenu.put(1, "Yeni Öğrenci");
		mainMenu.put(2, "Öğrenci Arama");
		
		mainMenu.put(99, "Çıkış için [99] [0]");
		return mainMenu;
	}
}
