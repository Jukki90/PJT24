package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;





import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.TestBase.wrapContactDataForProvider;

public class ContactCreationTest extends TestBase{

	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapContactDataForProvider(loadContactsFromCsvFile(new File("contacts.xml"))).iterator();		
	}

 
   @Test(dataProvider="randomValidContactGenerator")
  public void testAddUser(UserData user) throws Exception {
	app.navigateTo().mainPage();
	
	//save old state
	SortedListOf<UserData> oldList = app.getModel().getContacts();
    //actions
    app.getContactHelper().createContact(user);
    
    //save new state
    SortedListOf<UserData> newList = app.getModel().getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList));
    
    
    if("yes".equals(app.getProperty("check.db"))){
    	if (wantToCheck()){
    	assertThat(app.getModel().getContacts(),equalTo(app.getHibernateHelper().listContacts()));
    	}
    }
    if("yes".equals(app.getProperty("check.yi"))){
    	if (wantToCheck()){
    	assertThat(app.getModel().getContacts(),equalTo(app.getContactHelper().getUIContacts()));
    	}
    }
  }
}