package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deleteSomeContact(){

		//save old state
		SortedListOf<UserData> oldList = app.getContactHelper().getContacts();
	    //actions
	    Random rnd=new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    app.getContactHelper().removeContact(index);

	    
	  //save new state 
	    SortedListOf<UserData> newList = app.getContactHelper().getContacts(); 

	  //compare states 
	    assertThat(newList, equalTo(oldList.without(index)));
	   
	}
}
