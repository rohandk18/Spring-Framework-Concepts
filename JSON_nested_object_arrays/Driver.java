package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;



public class Driver {

	public static void main(String[] args) 
	{

		try
		{
			//create object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/convert it to java POJO:  data/sample-lite.json
			
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print firstName and lastName
			
			System.out.println("firstName: "+theStudent.getFirstName()+" lastName: "+theStudent.getLastName());
			
			//printing nested objects and arrays
			
			System.out.println(theStudent.getAddress());
			int [] arr = new int[7];
			for(String templang:theStudent.getLanguages())
			{
				System.out.println(templang);
			}
			
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}

	}

}
