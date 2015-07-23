package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;



import org.testng.annotations.Test;

import com.example.fw.ContactHelper;

import static com.example.fw.ContactHelper.CREATION;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;

public class ContactCreationTest extends TestBase{


  @Test(dataProvider="randomValidContactGenerator")
  public void testAddUser(UserData user) throws Exception {
	app.navigateTo().mainPage();
	
	//save old state
	SortedListOf<UserData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().createContact(user);
    
    //save new state
    SortedListOf<UserData> newList = app.getContactHelper().getContacts();
    
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(user)));
    
  }
}