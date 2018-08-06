package com.jda.service;

import com.jda.controller.BookMethods;
import com.jda.model.Book;
import com.jda.utility.Utility;

public class Methods {
	Utility utility = new Utility();
	BookMethods BM=new BookMethods();
	Book[] book;
	public Book[] createBook()
	{
		System.out.println("How many entries you want to enter");
		int numberOfPersons=utility.inputInteger();
			book=new Book[numberOfPersons];
			for(int personNumber=0;personNumber<numberOfPersons;personNumber++)
			{
				book[personNumber]=BM.addPerson();
			}
			return book;
	}
}
