package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;

public class ContactModificationTests extends TestBase {
	@Test(dataProvider="randomValidContactGenerator")
	public void modifySomeContact(UserData user){
		app.navigateTo().mainPage();
		
		//save old state
		SortedListOf<UserData> oldList = app.getContactHelper().getContacts();
	    //actions
	   
	    Random rnd=new Random();
	    
	    int index = rnd.nextInt(oldList.size()-1);  
	    
		app.getContactHelper().modifyContact(index, user);
		
		//save new state
		SortedListOf<UserData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(user)));
	    
	  
	    
	}
}
