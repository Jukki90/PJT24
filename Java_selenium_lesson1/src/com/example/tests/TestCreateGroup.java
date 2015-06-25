package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCreateGroup extends TestBase {
  @BeforeClass
public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8081/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	 //start Page
    openMainPage();
    
    //open group page
    openGroupPage();
    //init new group
    driver.findElement(By.name("new")).click();
    //fill group page
    GroupData group = new GroupData();
    group.name="group name 1";
    group.header="header 1";
    group.footer="footer 1";
	fillGroupPage(group);
    //submit
    submitCreationGroupPage();
    //return to group page
    returnToGroupPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	 //start Page
    openMainPage();
    
    //open group page
    openGroupPage();
    //init new group
    driver.findElement(By.name("new")).click();
    //fill group page
    fillGroupPage(new GroupData("", "", ""));
    //submit
    submitCreationGroupPage();
    //return to group page
    returnToGroupPage();
  }
  
private void returnToGroupPage() {
	driver.findElement(By.linkText("group page")).click();
}

private void submitCreationGroupPage() {
	driver.findElement(By.name("submit")).click();
}

private void fillGroupPage(GroupData parameterObject) {
	driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(parameterObject.name);
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(parameterObject.header);
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(parameterObject.footer);
}

private void openGroupPage() {
	driver.findElement(By.linkText("groups")).click();
}

private void openMainPage() {
	driver.get(baseUrl + "/addressbookv4.1.4/");
}

  @AfterClass
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}