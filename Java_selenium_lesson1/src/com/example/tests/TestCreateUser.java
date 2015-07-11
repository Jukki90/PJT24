package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class TestCreateUser extends TestBase{


  @Test
  public void testAddUser() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
    List<UserData> oldList = app.getContactHelper().getContacts();
    //actions
    app.getContactHelper().addNewUser();
    UserData user = new UserData();
    
    user.firstName="������";
    user.lastName="�����������";
    user.address="���������";
    user.homePhone="84950002211";
    user.mobilePhone="89097778879";
    user.email="alex@mail.ru";
    user.birthDay="30";
    user.birthMonth="July";
    user.birthYear="356";
    user.group="Alexander Army";
    user.address2="�������";
    
    app.contactHelper.fillUserAttributes(user);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state
    List<UserData> newList = app.getContactHelper().getContacts();
    
    
    //compare states
   oldList.add(user);
   Collections.sort(oldList);
   assertEquals(newList,oldList);
    
  }
}