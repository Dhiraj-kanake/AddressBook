package com.jda.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jda.model.Book;

public class Utility {
	static JSONParser parser = new JSONParser();
Scanner scanner;
public Utility()
{
	scanner =new Scanner(System.in);
}
public String inputString()
{
	return scanner.next();
}
public Long inputLong()
{
	return scanner.nextLong();
}
public int inputInteger()
{
	return scanner.nextInt();
}
public void storeFile(HashMap<Integer,Book[]> list) throws FileNotFoundException, IOException, ParseException
{
	String filename = "/home/bridgelabz/Documents/addressBook.json";
	Object obj = parser.parse(new FileReader(filename));
	JSONObject object = (JSONObject)obj;
	JSONObject addressBook=(JSONObject) object.get("AddressBook");
	JSONArray jArray=(JSONArray)addressBook.get("Book");
	Book book[]=list.get(1);
	HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
	
	int lengthOfBook=book.length;
	for(int i=0;i<lengthOfBook;i++)
	{
		JSONObject jObject = book[i].createObject();
		jArray.add(jObject);
	}
	addressBook.put("Book", jArray);
	hMap2.put("AddressBook",addressBook );
	
	 
	 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
	 
	//System.out.println("jason"+newObjectdemo);
	
	@SuppressWarnings("resource")
	FileWriter file = new FileWriter(filename);     //writing into file
	
	 file.write(newObjectdemo.toJSONString());
	 //System.out.println("passed"+companyName);
	 file.flush();
	 
	
}
public void editPersonDetail(HashMap<Integer,Book[]> list) throws FileNotFoundException, IOException, ParseException
{
	String filename = "/home/bridgelabz/Documents/addressBook.json";
	Object obj = parser.parse(new FileReader(filename));
	JSONObject object = (JSONObject)obj;
	JSONObject addressBook=(JSONObject) object.get("AddressBook");
	JSONArray jArray=(JSONArray)addressBook.get("Book");
	Book book[]=list.get(1);
	HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
	
	System.out.println("Enter the name of the person to edit"+jArray);
	String Name=inputString();
	JSONArray tempArray=new JSONArray();
 Iterator itr = jArray.iterator();
	while(itr.hasNext())
	{
		JSONObject jobject=(JSONObject) itr.next();
		String name=(String) jobject.get("Name");
		if(!Name.equals(name))
		{
			tempArray.add(jobject);
		}
		else if(Name.equals(name))
{
	System.out.println("what do you want to edit?");
	String edit=inputString();
	System.out.println("enter "+edit);
	if(edit.equals("pincode") || edit.equals("number"))
	{
		int number=inputInteger();
	jobject.put(edit, number);}
	else
	{
		String string=inputString();
		jobject.put(edit, string);
	}
		tempArray.add(jobject);
}
	}
	addressBook.put("Book", tempArray);
	hMap2.put("AddressBook",addressBook);
	
	 
	 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
	 
	//System.out.println("jason"+newObjectdemo);
	
	@SuppressWarnings("resource")
	FileWriter file = new FileWriter(filename);     //writing into file
	
	 file.write(newObjectdemo.toJSONString());
	 //System.out.println("passed"+companyName);
	 file.flush();
	 
	
}
@SuppressWarnings("unchecked")
public void deletePerson(HashMap<Integer,Book[]> list) throws FileNotFoundException, IOException, ParseException
{
	String filename = "/home/bridgelabz/Documents/addressBook.json";
	Object obj = parser.parse(new FileReader(filename));
	JSONObject object = (JSONObject)obj;
	JSONObject addressBook=(JSONObject) object.get("AddressBook");
	JSONArray jArray=(JSONArray)addressBook.get("Book");
	Book book[]=list.get(1);
	HashMap<String,JSONObject> hMap2=new HashMap<>();      //creating 2nd hashmap to store all the entries from file
	
	System.out.println("Enter the name of the person to delete"+jArray);
	String Name=inputString();
	JSONArray tempArray=new JSONArray();
 Iterator itr = jArray.iterator();
	while(itr.hasNext())
	{
		JSONObject jobject=(JSONObject) itr.next();
		String name=(String) jobject.get("Name");
		if(!Name.equals(name))
		{
			tempArray.add(jobject);
		}
}
	addressBook.put("Book", tempArray);
	hMap2.put("AddressBook",addressBook);
	
	 
	 JSONObject newObjectdemo=new JSONObject(hMap2);     //converting that hashmap2 into jasonobject
	 
	//System.out.println("jason"+newObjectdemo);
	
	@SuppressWarnings("resource")
	FileWriter file = new FileWriter(filename);     //writing into file
	
	 file.write(newObjectdemo.toJSONString());
	 //System.out.println("passed"+companyName);
	 file.flush();
	 
	
}

}
