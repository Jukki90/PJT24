package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.GroupData;
import com.example.tests.TestBase;
import com.example.tests.UserData;

public class ContactHelper extends HelperBase {
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void fillUserAttributes(UserData user) {
		type(By.name("firstname"), user.firstName);
		type(By.name("lastname"), user.lastName);
		type(By.name("address"), user.address);
		type(By.name("home"), user.homePhone);
		type(By.name("mobile"), user.mobilePhone);
		type(By.name("email"), user.email);
		type(By.name("byear"), user.birthYear);
		type(By.name("address2"), user.address2);

		selectByText(By.name("bday"), user.birthDay);
		selectByText(By.name("bmonth"), user.birthMonth);

		selectByText(By.name("new_group"), user.group);

	}

	public void addNewUser() {
		click(By.linkText("add new"));
	}

	public void deleteContact(int index) {
		initContactModification(index);
		click(By.xpath("//input[@value='Delete']"));

	}

	public void SubmitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	}

	public void initContactModification(int index) {
		++index;
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));

	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public List<UserData> getContacts() {
		  List<UserData> contacts = new ArrayList<UserData>();  
		  
		  
		  WebElement table = driver.findElement(By.id("maintable")); 
		// Now get all the TR elements from the table 

		  //List<WebElement> allRows = table.findElements(By.tagName("tr")); 
		  List<WebElement> allRows = table.findElements(By.xpath("//tr[@name='entry']")); 

		  // And iterate over them, getting the cells 

		  for (WebElement row : allRows) {
			  UserData contact = new UserData();
			  
		   List<WebElement> cells = row.findElements(By.tagName("td")); 
		   	contact.id=cells.get(0).getText();
		   	contact.lastName=cells.get(1).getText();
		   	contact.firstName=cells.get(2).getText();
		   	contact.email=cells.get(3).getText();
		   	contact.mobilePhone=cells.get(4).getText();
		   	
		    //for (WebElement cell : cells) { 

		      // And so on 
		   //	if (contact.id!="1"){
		   		contacts.add(contact);
		   	//}

		    } 
	  
		  return contacts;
	}
		
		

}
