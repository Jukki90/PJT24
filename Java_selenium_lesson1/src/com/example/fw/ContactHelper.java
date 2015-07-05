package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.TestBase;
import com.example.tests.UserData;

public class ContactHelper extends HelperBase{
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}


	public void fillUserAttributes(ApplicationManager manager, TestBase testBase, UserData user) {
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(user.firstName);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(user.lastName);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(user.address);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(user.homePhone);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(user.mobilePhone);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(user.email);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(user.birthDay);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(user.birthMonth);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(user.birthYear);
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(user.group);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(user.address2);
	}

	public void addNewUser() {
		driver.findElement(By.linkText("add new")).click();
	}

}
