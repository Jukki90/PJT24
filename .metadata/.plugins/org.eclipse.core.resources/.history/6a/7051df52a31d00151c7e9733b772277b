package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCreateUser extends TestBase{


  @Test
  public void testAddUser() throws Exception {
	openMainPage();
    addNewUser();
    UserData user = new UserData();
    user.firstName="Александр";
    user.lastName="Македонский";
    user.address="Македония";
    user.homePhone="84950002211";
    user.mobilePhone="89097778879";
    user.email="alex@mail.ru";
    user.birthDay="30";
    user.birthMonth="July";
    user.birthYear="356";
    user.group="Alexander Army";
    user.address2="Вавилон";
    
    fillUserAttributes(user);
    pressSubmit();
    openMainPage();
  }
}