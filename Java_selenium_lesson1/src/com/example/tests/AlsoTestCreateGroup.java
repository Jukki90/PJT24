package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AlsoTestCreateGroup extends TestBase{
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
}
