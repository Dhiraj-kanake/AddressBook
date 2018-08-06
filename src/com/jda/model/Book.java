package com.jda.model;

import org.json.simple.JSONObject;

import com.jda.utility.Utility;

public class Book {
	private String firstName;
	private String lastName;
	private String district;
	private String city;
	private int pincode;
	private String state;
	private int mobileNumber;
	
	public Book(String name,String sirname, String district,String city,int pincode,String state,int number)
	{
		this.firstName=name;
		this.lastName=sirname;
		this.district=district;
		this.city=city;
		this.pincode=pincode;
		this.state=state;
		this.mobileNumber=number;
	}
	public Book()
	{
	//	firstName =""; lastName=""; address = ""; city = ""; pincode=0;	state="";	mobileNumber=0;
	}
	public void printEntry()
	{
		System.out.println("First Name :"+firstName);
		System.out.println("Last Name :"+lastName);
		System.out.println("Address :"+district);
		System.out.println("City :"+city);
		System.out.println("Pincode :"+pincode);
		System.out.println("State :"+state);
		System.out.println("Mobile Numebr : "+mobileNumber);
	}
	@SuppressWarnings("unchecked")
	public JSONObject createObject()
	{
		JSONObject object =new JSONObject();
		object.put("Name", firstName);
		object.put("Sirname", lastName);
		object.put("District", district);
		object.put("City", city);
		object.put("Pincode", pincode);
		object.put("State", state);
		object.put("Number", mobileNumber);
		
		return object;
	}
}
