package com.example.fw;

import java.io.IOException;
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
	private static ApplicationManager singleton;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;
	
	//public  WebDriver driver;
	//public  String baseUrl;
	//private static StringBuffer verificationErrors = new StringBuffer();
	//private Properties properties;
	private Properties props;
	
	
	
	//-----Methods--------
	
	public static ApplicationManager getInstance(Properties props) throws IOException{
		if(singleton == null){
			singleton = new ApplicationManager();
			singleton.setProperties(props);
			singleton.start();
		}
		return singleton;
	}
	
	public ApplicationManager() { //???? or private???
		
	}
	
	
	public ContactHelper getContactHelper(){
		if (contactHelper == null){
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public ProcessHelper getProcessHelper(){
		if (processHelper == null){
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}
	
	public AutoItHelper getAutoItHelper(){
		if (autoItHelper == null){
			autoItHelper = new AutoItHelper(this);
		}
		return autoItHelper;
	}
	
	
	public ApplicationManager(Properties properties){
		this.props = properties; //???
		
		String browser = properties.getProperty("browser");
		/*
		if ("firefox".equals(browser)){
			driver = new FirefoxDriver();
		}else if("ie".equals(browser)){
			driver = new InternetExplorerDriver();
		}else {
			throw new Error("Unsupported browser:"+browser);
		}
		baseUrl = properties.getProperty("baseUrl");
		driver.get(baseUrl);
		*/
	}
	

	


	public void setProperties(Properties props){
		this.props = props;
	}
	
	public String getProperties(String key){
		return props.getProperty(key);
	}


	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();
	}

	public void stop() {
		getProcessHelper().stopAppUnderTest();
		
	}





}
