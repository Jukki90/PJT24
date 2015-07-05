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
 

	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {

    openMainPage();
    openGroupPage();
    driver.findElement(By.name("new")).click();
    GroupData group = new GroupData();
    group.name="Alexander Army";
    group.header="header 1";
    group.footer="footer 1";
	fillGroupPage(group);
    pressSubmit();
    openMainPage();
  }


}
