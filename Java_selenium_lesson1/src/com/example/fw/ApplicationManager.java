package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class ApplicationManager {
	public  WebDriver driver;
	public  String baseUrl;
	
	private static StringBuffer verificationErrors = new StringBuffer();

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	public ContactHelper contactHelper;
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private ApplicationModel model;
	
	public ApplicationManager(Properties properties){
		this.properties = properties;
		model = new ApplicationModel();
		model.setGroups(getHibernateHelper().listGroups());
		model.setContacts(getHibernateHelper().listContacts());
	}

	public ApplicationModel getModel(){
		return model;
	}

	public void stop() {
		
		  driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      Assert.fail(verificationErrorString);
		    }
	}

	public NavigationHelper navigateTo(){
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


	public WebDriver getDriver() {
		if (driver==null){
			String browser = properties.getProperty("browser");
			if ("firefox".equals(browser)){
				driver = new FirefoxDriver();
			}else if("ie".equals(browser)){
				driver = new InternetExplorerDriver();
			}else {
				throw new Error("Unsupported browser:"+browser);
			}
			baseUrl = properties.getProperty("baseUrl");
			driver.get(baseUrl);	
		}
		return driver;
	}


	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper==null){
			hibernateHelper=new HibernateHelper(this);			
		}
		return hibernateHelper;
		
	}
	
	public String getProperty(String key){
		return properties.getProperty(key);	
	}
}
