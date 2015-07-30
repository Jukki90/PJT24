package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.generateRandomString;
import static com.example.tests.ContactDataGenerator.generateRandomNumber;

public class TestBase {
	
	protected static ApplicationManager app;
	

	
	@BeforeTest
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		app=new ApplicationManager(properties);
	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupDataForProvider(generateRandomGroups(5)).iterator();
				
	}
	


	public static List<Object[]> wrapGroupDataForProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>() ;
		for (GroupData group : groups){
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(int i=0; i<3;i++){
			UserData user = new UserData();
			user.firstName=generateRandomString();
			user.lastName=generateRandomString();
			user.email=generateRandomString();
			user.mobilePhone=generateRandomString();
			user.homePhone=generateRandomString();
			user.birthDay=generateRandomNumber(30);
			user.birthMonth=generateRandomMonth();
			user.birthYear=generateRandomNumber(2000);
			//user.group="Rob";
			user.address2=generateRandomString();
			list.add(new Object[]{user});
					
		}
		return list.iterator();
				
	}

	
/*	
	public String generateRandomNumber(int max) {
		Random rnd= new Random();
		String str="";
		str+=(rnd.nextInt(max)+1);
		return str;
	}
	
*/	
	
	public String generateRandomMonth() {
		String[] arr={
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December",
			"-"
				
		};
		
		Random rnd= new Random();
		return arr[rnd.nextInt(11)];
	}


}
