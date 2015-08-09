package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;



public class TestBase {
	
	protected static ApplicationManager app;
	

	
	@BeforeTest
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		app=new ApplicationManager(properties);
	    
	  }

	//@AfterTest
	public void tearDown() throws Exception {
		//app.stop();
		ApplicationManager.getInstance(null).stop();
	  
	  }
	
	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws IOException{
		if (configFile == null){
			configFile = System.getProperty("configFile");
		}
		if (configFile == null){
			configFile = System.getenv("configFile");
		}
		if (configFile == null){
			configFile = "application.properties";
		}
		Properties props = new Properties();
		props.load(new FileReader(configFile));
		app = ApplicationManager.getInstance(props);
	
	}

}
