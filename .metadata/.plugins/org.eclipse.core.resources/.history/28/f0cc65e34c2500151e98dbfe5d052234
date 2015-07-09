package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ApplicationManager {
	public  WebDriver driver;
	public  String baseUrl;
	
	private static StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	public ContactHelper contactHelper;
	
	public ApplicationManager(){
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8081/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void pressSubmit() {
		driver.findElement(By.name("submit")).click();
	}
	
	
	

	public void stop() {
		
		  driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      Assert.fail(verificationErrorString);
		    }
	}

	public NavigationHelper getNavigationHelper(){
		if (navigationHelper==null){
			navigationHelper=new NavigationHelper(this);			
		}
		return navigationHelper;
	
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper==null){
			groupHelper=new GroupHelper(this);			
		}
		return groupHelper;
	
	}
	
	public ContactHelper getContactHelper(){
		if (contactHelper==null){
			contactHelper=new ContactHelper(this);			
		}
		return contactHelper;
	
	}
}
