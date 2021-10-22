package com.aliergul.ekim.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.aliergul.ekim.model.worker.Worker;

public class DatabaseHelper {
	private static final String PATH_WORKER = "C:\\BilgeAdamTemp\\worker.db";
	
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
	
	// @Override
	// public String toString() {
	// return registrationNumber + ";" + startDate + ";" + finishDate + ";"
	// + salary + ";" + Arrays.toString(phone)
	// + ";" + getId() + ";" + getStartDate() + ";" + getFinishDate() + ";" +
	// getSalary() + ";"
	// + Arrays.toString(getPhone());
	// }
	public static List<Worker> readWriterMethod() {
		List<Worker> listWorker = new ArrayList<>();
		String path = "C:\\BilgeAdamTemp\\data.db";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_WORKER))) {
			
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				listWorker.add(lineToWorker(satir));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listWorker;
	}
	
	private static Worker lineToWorker(String satir) {
		Worker w = new Worker();
		w.setName(null);
		return w;
	}
}
