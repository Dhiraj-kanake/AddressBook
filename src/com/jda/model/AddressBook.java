package com.jda.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jda.controller.BookMethods;
import com.jda.service.Methods;
import com.jda.utility.Utility;

public class AddressBook {
	static JSONParser parser = new JSONParser();

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		Book book = new Book();
		Book book2 = new Book();
		Utility utility = new Utility();
		Methods methods = new Methods();
		boolean flag = false, demo = false;
		BookMethods Bm = new BookMethods();
		int bookNumber = 0;
		HashMap<Integer, Book[]> bookList = new HashMap<>();
		while (true) {
			System.out.println("***Address Book***");
			System.out.println("1.Create New Address Book");
			if (demo) {
				System.out.println("2.Print existing Address book");
				System.out.println("3.Store into database");
			}
			System.out.println("4.exit");
			int choice = utility.inputInteger();
			switch (choice) {
			case 1: {
				demo = true;
				bookNumber += 1;
				bookList.put(bookNumber, methods.createBook());
				break;
			}
			case 2: {
				Book book1[] = bookList.get(1);
				book1[0].printEntry();
				break;
			}
			case 3: {
				utility.storeFile(bookList);
				
				
			}
			case 4: {
				flag = true;
				break;
			}
			}
			if (flag)
				break;
		}

	}
}
