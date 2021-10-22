package com.aliergul.ekim.marathon;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.aliergul.ekim.globalstrings.GlobalStrings;
import com.aliergul.ekim.globalstrings.MenuCreator;
import com.aliergul.ekim.model.constants.EGender;
import com.aliergul.ekim.model.constants.EMarriageStatus;
import com.aliergul.ekim.model.constants.Name;
import com.aliergul.ekim.model.constants.School;
import com.aliergul.ekim.model.lessons.ClassRoom;
import com.aliergul.ekim.model.lessons.Lessons;
import com.aliergul.ekim.model.students.Student;
import com.aliergul.ekim.model.worker.Officer;
import com.aliergul.ekim.model.worker.Servant;
import com.aliergul.ekim.model.worker.Teacher;
import com.aliergul.ekim.model.worker.Worker;
import com.aliergul.ekim.util.ArraysHelper;
import com.aliergul.ekim.util.ConsoleHelper;
import com.aliergul.ekim.util.FileIOHelper;

public class SchoolView {
	private GlobalStrings globalStrings;
	MenuCreator menuCreator;
	private List<Worker> listWorker;
	private List<ClassRoom> listClass;
	private List<Student> listStudent;
	private List<Lessons> listLessons;
	
	private Scanner s = new Scanner(System.in);
	private String name;
	
	public SchoolView(GlobalStrings globalStrings) {
		this.globalStrings = globalStrings;
		
	}
	
	public void showMainMenu(String name) {
		menuCreator = new MenuCreator(globalStrings);
		int choose = 0;
		readFileIO();
		while ((choose = ConsoleHelper.showMenu(name, menuCreator.menuCreateMain())) != 99) {
			
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
					viewCreateNewClass();
					break;
				case 5:
					viewCreateNewDers();
					break;
				case 6:
					viewOgrenciAtama();
					break;
				case 7:
					viewClassList();
					break;
				case 8:
					viewSelectLessonStudent();
					break;
				case 9:
					viewListCurrentGift();
					break;
				case 10:
					viewListCurrentSallary();
					break;
				case 11:
					if (globalStrings.getLeangue().equals("tr")) {
						globalStrings = new GlobalStrings("en");
					} else {
						globalStrings = new GlobalStrings("tr");
					}
					menuCreator = new MenuCreator(globalStrings);
					break;
				
				case 99, 0:
					choose = 99;
					break;
				default:
					break;
			}
			if (choose == 99)
				break;
			
		}
		ConsoleHelper.printTitle("Ali ERGÜL", 30);
		ConsoleHelper.printTitle(globalStrings.getString("Globalization.MARATHON"), 30);
		ConsoleHelper.printTitle(globalStrings.getString("Globalization.THANKS"), 30);
	}
	
	private void readFileIO() {
		
		listStudent = FileIOHelper.readDosyadan(FileIOHelper.PATH_STUDENT);
		listWorker = FileIOHelper.readDosyadan(FileIOHelper.PATH_WORKER);
		listClass = FileIOHelper.readDosyadan(FileIOHelper.PATH_CLASS_ROOM);
		listLessons = FileIOHelper.readDosyadan(FileIOHelper.PATH_LESSON);
		if (listWorker.size() > 0)
			Worker.workerCount = listWorker.size();
		if (listStudent.size() > 0)
			Student.countStudent = listStudent.size();
		if (listLessons.size() > 0)
			Lessons.countLesson = listLessons.size();
	}
	
	private void writeFileIO() {
		FileIOHelper.writeDosyaya(listStudent, FileIOHelper.PATH_STUDENT);
		FileIOHelper.writeDosyaya(listWorker, FileIOHelper.PATH_WORKER);
		FileIOHelper.writeDosyaya(listClass, FileIOHelper.PATH_CLASS_ROOM);
		FileIOHelper.writeDosyaya(listLessons, FileIOHelper.PATH_LESSON);
		
	}
	
	/**
	 * mainMenu.put(10, "Maaş Listesi");
	 */
	private void viewListCurrentSallary() {
		ConsoleHelper.printTitle(globalStrings.getString("Globalization.CURRENT_SALARY_LIST"), 30);
		listWorker.forEach(p -> {
			System.out.printf("%-8s: %s: %s: %-30s %s : %s %s : %.02f %n", "SicilNo", p.getRegistrationNumber(), "İsim",
					p.getName().toString(), "Başlangıç Tarihi", p.getStartDate(), "Güncel Maaşı",
					p.getCurrentSallary());
		});
		
		ConsoleHelper.readString("Ana Menü İçin Bir Tuşa seçip entere Basınız.");
	}
	
	/**
	 *
	 * 
	 * Menü 9 Güncel Hediye Listesi
	 */
	private void viewListCurrentGift() {
		
		ConsoleHelper.printTitle(globalStrings.getString("Globalization.GIFT_LIST"), 30);
		List<Worker> giftList = listWorker.stream().filter(w -> w.isthereGiftthisMounth() != null)
				.collect(Collectors.toList());
		if (giftList != null && giftList.size() > 0) {
			giftList.forEach(p -> {
				System.out.println(p.isthereGiftthisMounth());
			});
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * Menü 8 Öğrencinin Seçtiği Dersler
	 */
	private void viewSelectLessonStudent() {
		int chooseStudent = 0;
		
		while ((chooseStudent = ConsoleHelper.showMenu(
				globalStrings.getString("Globalization.SELECIONS_LESSON_AT_STUDENT"),
				menuCreator.menuCreatStudentLessonList())) != 99) {
			
			switch (chooseStudent) {
				case 1:
					showListSelectedStudentLessons();
					break;
				case 2:
					addStudentToTheSelectedLesson();
					break;
				case 0:
					chooseStudent = 99;
					break;
				
			}
			
			if (chooseStudent == 99) {
				break;
			}
			
		}
		writeFileIO();
	}
	
	private void addStudentToTheSelectedLesson() {
		do {
			System.out.println("Öğrenci Seç: ");
			Map<String, Object> searchStudent = ArraysHelper.searchStudent(listStudent);
			if (searchStudent != null) {
				do {
					Map<String, Object> searchLesson = ArraysHelper.searchLessons(listLessons);
					if (searchLesson != null) {
						Lessons val = (Lessons) searchLesson.get(ArraysHelper.OBJECT);
						ConsoleHelper.printLine(30);
						System.out
								.println("Öğrenci  : " + ((Student) searchStudent.get(ArraysHelper.OBJECT)).getName());
						System.out.println("Ders İsmi: " + val.getName());
						listStudent.get((int) searchStudent.get(ArraysHelper.INDEX)).addListLesson(val);
						if (FileIOHelper.writeDosyaya(listStudent, FileIOHelper.PATH_STUDENT)) {
							System.out.println("Ders Eklendi.");
						}
						
						ConsoleHelper.printLine(30);
						
					}
				} while (ConsoleHelper.showMenu("Tekrar Ders Eklemek istiyorum.", null) != 0);
			}
			
		} while (ConsoleHelper.showMenu("Başka Öğrenci ders ekleme için [1] Ana Menü için [0]", null) != 0);
		
	}
	
	private void showListSelectedStudentLessons() {
		do {
			Map<String, Object> searchStudent = ArraysHelper.searchStudent(listStudent);
			if (searchStudent != null) {
				Student val = (Student) searchStudent.get(ArraysHelper.OBJECT);
				ConsoleHelper.printLine(30);
				System.out.println("Öğrenci No: " + val.getNumber());
				System.out.println("Öğreni İsmi: " + val.getName());
				System.out.println("Aldığı Dersler");
				val.getListLessons().forEach(System.out::println);
				ConsoleHelper.printLine(30);
			}
			
		} while (ConsoleHelper.showMenu("Başka Sınıf için [1] Ana Menü için [0]", null) != 0);
	}
	
	/**
	 *
	 * Menü 7 Sınıf listesi
	 */
	private void viewClassList() {
		do {
			ConsoleHelper.printTitle(globalStrings.getString("Globalization.LIST_CLASS"), 30);
			Map<String, Object> classRoom = ArraysHelper.searchClass(listClass);
			if (classRoom != null) {
				ClassRoom val = (ClassRoom) classRoom.get(ArraysHelper.OBJECT);
				ConsoleHelper.printLine(30);
				System.out.println("Sınıf İsmi: " + val.getName());
				System.out.println("Sınıf Öğretmeni: " + val.getTeacher().getName());
				System.out.println("Sınıf Listesi");
				val.getListStudent().forEach(System.out::println);
				ConsoleHelper.printLine(30);
			}
			
		} while (ConsoleHelper.showMenu("Başka Sınıf için [1] Ana Menü için [0]", null) != 0);
		
	}
	
	/**
	 * Menü 6 Öğrenci Atama
	 */
	private void viewOgrenciAtama() {
		
		int chooseStudent = 0;
		
		while ((chooseStudent = ConsoleHelper.showMenu(globalStrings.getString("Globalization.SELECT_STUDENT"),
				menuCreator.menuCreatStudentList())) != 99) {
			
			switch (chooseStudent) {
				case 1:
					Student s = addNewStudent();
					listStudent.add(s);
					if (FileIOHelper.writeDosyaya(listStudent, FileIOHelper.PATH_STUDENT)) {
						System.out.println("Öğrenci Eklendi.");
					}
					break;
				case 2:
					addStudentToTheCreatedClassRoom();
					break;
				case 0:
					chooseStudent = 99;
					break;
				
			}
			
			if (chooseStudent == 99) {
				break;
			}
			
		}
		writeFileIO();
		
	}
	
	private Student addNewStudent() {
		
		Name name = addNewName();
		EGender gender = ConsoleHelper.readEGender("Cinsiyetiniz: ");
		LocalDate birthday = ConsoleHelper.readLocalDate("Doğum Tarihiniz: ");
		String[] phone = new String[3];
		phone[0] = (ConsoleHelper.readString("1.Telefon Giriniz:"));
		phone[1] = (ConsoleHelper.readString("2.Telefon Giriniz:"));
		phone[1] = (ConsoleHelper.readString("3.Telefon Giriniz:"));
		EMarriageStatus marriageStatus = ConsoleHelper.readEMarriageStatus("Medeni Durumu:");
		return new Student(name, gender, birthday, marriageStatus, phone);
	}
	
	// Var Olan Sınıf a Öğrenci Ekleme
	private void addStudentToTheCreatedClassRoom() {
		Map<String, Object> classRoom = null;
		do {
			classRoom = ArraysHelper.searchClass(listClass);
			if (classRoom != null) {
				addStudentClassRoom((int) classRoom.get(ArraysHelper.INDEX));
			}
		} while (ConsoleHelper.showMenu("Tekrar Denemek ister misiniz.", null) != 0);
		
	}
	
	/**
	 * Menü 5 Yeni Ders Oluşturma
	 */
	private void viewCreateNewDers() {
		// Teacher primeTeacher, Teacher spareTeacher, String name, String period, int
		// timeLesson
		do {
			ConsoleHelper.printTitle(globalStrings.getString("Globalization.NEW_LESSON_CREATE"), 30);
			System.out.println("Asil Öğrentmen Seçiniz: ");
			Map<String, Object> teacherPrimary = ArraysHelper.searchWorker(listWorker);
			if (teacherPrimary != null && ((int) teacherPrimary.get(ArraysHelper.TYPE)) == School.TEACHER) {
				System.out.println("Yedek Öğrentmen Seçiniz: ");
				Map<String, Object> teacherScondary = ArraysHelper.searchWorker(listWorker);
				if (teacherScondary != null && ((int) teacherScondary.get(ArraysHelper.TYPE)) == School.TEACHER) {
					String LessonName = ConsoleHelper.readString("Ders Adını Yazınız: ");
					String LessonPriyod = ConsoleHelper.readString("Hangi Dönem Veriliyor: ");
					int LessonCredit = ConsoleHelper.readInteger("Ders Kaç Kredi: ");
					listLessons.add(new Lessons((Teacher) teacherPrimary.get(ArraysHelper.OBJECT),
							(Teacher) teacherScondary.get(ArraysHelper.OBJECT), LessonName, LessonPriyod,
							LessonCredit));
					if (FileIOHelper.writeDosyaya(listLessons, FileIOHelper.PATH_LESSON)) {
						System.out.println("Yeni Ders Eklendi.");
					}
					
				}
			}
			
		} while (ConsoleHelper.showMenu("Yeni Ders Oluşturmak İster misiniz?", null) != 0);
		
	}
	
	/**
	 * Menü 4 Yeni Sınıf Açma
	 */
	private void viewCreateNewClass() {
		
		Map<String, Object> teacher = null;
		String className = "";
		
		do {
			ConsoleHelper.printTitle(globalStrings.getString("Globalization.NEW_CLASS_CREATE"), 30);
			className = ConsoleHelper.readString("Sınıf Adı Giriniz: ");
			teacher = ArraysHelper.searchWorker(listWorker);
			if (teacher == null) {
				System.out.println("Önce Öğretmen Ekleyiniz.");
			} else {
				ClassRoom classRoom = new ClassRoom(className);
				
				classRoom.setTeacher((Teacher) teacher.get(ArraysHelper.OBJECT));
				int indexClassRoom = listClass.size();
				listClass.add(classRoom);
				if (FileIOHelper.writeDosyaya(listClass, FileIOHelper.PATH_CLASS_ROOM)) {
					System.out.println("Yeni Sınıf Açıldı.");
				}
				
				addStudentClassRoom(indexClassRoom);
				
			}
			
		} while (ConsoleHelper.showMenu("Çıkmak İçin Sıfır a Basınız.", null) != 0);
	}
	
	private void addStudentClassRoom(int indexClassRoom) {
		do {
			Map<String, Object> student = ArraysHelper.searchStudent(listStudent);
			if (student != null) {
				Student val = (Student) student.get(ArraysHelper.OBJECT);
				listClass.get(indexClassRoom).addListStudent(val);
				listStudent.get((int) student.get(ArraysHelper.INDEX)).setClassName(listClass.get(indexClassRoom));
				FileIOHelper.writeDosyaya(listStudent, FileIOHelper.PATH_STUDENT);
				if (FileIOHelper.writeDosyaya(listClass, FileIOHelper.PATH_CLASS_ROOM)) {
					System.out.println(
							val.getName() + " " + listClass.get(indexClassRoom).getName() + " Sınıfına Eklendi.");
				}
				
			}
			
		} while (ConsoleHelper.showMenu("Tekrar Eklemek ister misiniz?", null) != 0);
		
	}
	
	/**
	 * Menü 3 Eski Çalışanlar
	 */
	private void viewListNotWorkerList() {
		ConsoleHelper.printTitle(globalStrings.getString("Globalization.PASIVE_WORKER_LIST"), 36);
		List<Worker> findList = listWorker.stream().filter(p -> p.getFinishDate() != null).collect(Collectors.toList());
		
		if (findList != null && findList.size() > 0) {
			findList.forEach(System.out::println);
		} else {
			System.out.println();
			System.err.println("\nKayıt Yok");
		}
		
		ConsoleHelper.readString("\n\nMenü için [1] e basıp [ENTER] a basınız...");
	}
	
	/**
	 * Menü 2 Çalışanlar Listesi
	 * 
	 */
	private void viewListWorkerList() {
		ConsoleHelper.printTitle(globalStrings.getString("Globalization.AKTIVE_WORKER_LIST"), 36);
		List<Worker> findList = listWorker.stream().filter(p -> p.getFinishDate() == null).collect(Collectors.toList());
		if (findList != null && findList.size() > 0) {
			findList.stream().forEach(System.out::println);
		} else {
			System.out.println();
			System.out.println("\nKayıt Yok");
		}
		
		ConsoleHelper.readString("\n\nMenü için [1] e basıp [ENTER] a basınız...");
	}
	
	/**
	 * Menü 1 Yeni Çalışan ekleme
	 */
	private void addNewWorker() {
		int chooseWorker = 0;
		
		while ((chooseWorker = ConsoleHelper.showMenu(globalStrings.getString("Globalization.NEW_WORKER_ADD"),
				menuCreator.menuCreatPersonList())) != 99) {
			
			switch (chooseWorker) {
				case 1:
					listWorker.add(new Teacher(addNewWoker()));
					if (FileIOHelper.writeDosyaya(listWorker, FileIOHelper.PATH_WORKER)) {
						System.out.println("Kayıt Başarılı");
					}
					break;
				case 2:
					listWorker.add(new Servant(addNewWoker()));
					if (FileIOHelper.writeDosyaya(listWorker, FileIOHelper.PATH_WORKER)) {
						System.out.println("Kayıt Başarılı");
					}
					break;
				case 3:
					listWorker.add(new Officer(addNewWoker()));
					if (FileIOHelper.writeDosyaya(listWorker, FileIOHelper.PATH_WORKER)) {
						System.out.println("Kayıt Başarılı");
					}
					break;
				case 4:
					setPersonelFinishDate();
					break;
				
				case 0:
					chooseWorker = 99;
					break;
			}
			if (chooseWorker == 99)
				break;
			
		}
	}
	
	/**
	 * Personel Ayrılış tarihini güncelleme
	 */
	private void setPersonelFinishDate() {
		do {
			Map<String, Object> map = ArraysHelper.searchWorker(listWorker);
			if (map != null) {
				LocalDate date = ConsoleHelper.readLocalDate("Çıkış Tarihini Giriniz.");
				int index = (int) map.get(ArraysHelper.INDEX);
				listWorker.get(index).setFinishDate(date);
				if (FileIOHelper.writeDosyaya(listWorker, FileIOHelper.PATH_WORKER)) {
					System.out.println(listWorker.get(index).getName() + " Çıkış Tarihi :" + date.toString()
							+ " olarak güncellendi.");
				}
				
			}
		} while (ConsoleHelper.showMenu("Tekrar Denemek ister misiniz?", null) != 0);
		
	}
	
	/**
	 * Yeni İsim Ekle
	 * 
	 * @return
	 */
	private Name addNewName() {
		String name, middleName, surnama;
		name = (ConsoleHelper.readString("Adınızı: "));
		middleName = ConsoleHelper.readString("Varsa İkinci Adınız Giriniz: ");
		surnama = (ConsoleHelper.readString("Soyadınız: "));
		
		return new Name(name, middleName, surnama);
	}
	
	/**
	 * Yeni Personel ekle
	 * 
	 * @return
	 */
	private Worker addNewWoker() {
		Name name = addNewName();
		EGender gender = ConsoleHelper.readEGender("Cinsiyetiniz: ");
		LocalDate birthDay = ConsoleHelper.readLocalDate("Doğum Tarihiniz: ");
		EMarriageStatus marriageStatus = ConsoleHelper.readEMarriageStatus("Evlilik Durumunuz: ");
		LocalDate startDate = ConsoleHelper.readLocalDate("İşe Başlama Tarihi:");
		double salary = ConsoleHelper.readDouble("Başlangıç Maaşı:");
		String[] phone = new String[2];
		phone[0] = (ConsoleHelper.readString("1.Telefon Giriniz:"));
		phone[1] = (ConsoleHelper.readString("2.Telefon Giriniz:"));
		
		return new Worker(name, gender, birthDay, marriageStatus, startDate, salary, phone);
	}
	
}
