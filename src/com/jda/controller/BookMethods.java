package com.jda.controller;


import com.jda.model.Book;
import com.jda.utility.Utility;

public class BookMethods {
Book book;
Utility utility = new Utility();
public Book addPerson()
{
	System.out.println("Enter Name Of the Person :");
	String name=utility.inputString();
	System.out.println("Enter Last Name Of " +name);
	String sirname=utility.inputString();
	System.out.println("Enter the Address of  "+name);
	String address=utility.inputString();
	System.out.println("Enter the City");
	String city=utility.inputString();
	System.out.println("Enter The Pincode");
	int pincode=utility.inputInteger();
	System.out.println("Enter The State");
	String state=utility.inputString();
	System.out.println("Enter the mobile number of "+name);
	int number=utility.inputInteger();
	book=new Book(name,sirname,address,city,pincode,state,number);
	return book;
}

}
