package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<UserData> oldList = app.getContactHelper().getContacts();
	    //actions
		app.getContactHelper().initContactModification(0);
		UserData user = new UserData();
		
		user.firstName="�����";
		app.contactHelper.fillUserAttributes( user);
		app.getContactHelper().SubmitContactModification();
		app.getContactHelper().returnToHomePage();
		
		//save new state
	    List<UserData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    user.lastName =oldList.get(0).lastName;
	    user.email =oldList.get(0).email;
	    
	    oldList.remove(0);
	    oldList.add(user);
	    Collections.sort(newList);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	}
}
