package com.aliergul.ekim.util;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.aliergul.ekim.model.worker.Worker;

public class FileIOHelper {
	public static final String PATH_WORKER = "./src/com/aliergul/ekim/data/worker.db";
	public static final String PATH_LESSON = "./src/com/aliergul/ekim/data/lesson.db";
	public static final String PATH_STUDENT = "./src/com/aliergul/ekim/data/student.db";
	public static final String PATH_CLASS_ROOM = "./src/com/aliergul/ekim/data/classroom.db";
	
	public static void fileWriterMethod(List<Worker> list) {
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_WORKER))) {
			// true dosyayı ekleme modunda açıyor
			// true koymazsak dosyayı silip yeniden yazıyor.
			for (Worker worker : list) {
				bufferedWriter.write(worker.toString() + "\n");
			}
			
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Kısa kulanım Dosyanın içinde Oluşştur başını yazmaya gerek yok :D
	 * "./src/com/aliergul/data/chatDB.txt"
	 * 
	 * @param <T>
	 * @param path
	 * @return
	 */
	public static <T> List<T> readDosyadan(String path) {
		List<Worker> listCitys = new ArrayList<>();
		
		// "./src/com/aliergul/data/chatDB.txt"
		File file = new File(path);
		try {
			FileInputStream foutput = new FileInputStream(file);
			ObjectInputStream output = new ObjectInputStream(foutput);
			Object obj = null;
			if ((obj = output.readObject()) != null)
				return (List<T>) obj;
			
			output.close();
			
		} catch (ClassNotFoundException | EOFException ex) {
			
			return new ArrayList<>();
			
		} catch (Exception e) {
			return new ArrayList<>();
		}
		return new ArrayList<>();
	}
	
	public static <T> boolean writeDosyaya(List<T> list, String path) {
		// File file = new
		// File("D:\\ECLIPSE\\eclipse-workspace\\ServerIslemleri\\src\\com\\aliergul\\data\\Citys.txt");
		File file = new File(path);
		try {
			FileOutputStream foutput = new FileOutputStream(file);
			ObjectOutputStream output = new ObjectOutputStream(foutput);
			output.writeObject(list);// result is a File
			output.flush();
			output.close();
			
			return true;
		} catch (IOException ex) {
			System.err.println("Hata!\nDosyaya Yazılamadı.");
			return false;
		}
	}
}
