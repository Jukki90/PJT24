package com.example.tests;


import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static com.example.tests.TestBase.wrapGroupDataForProvider;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;

public class GroupCreationTest extends TestBase {
	
	private static Logger LOG = LoggerFactory.getLogger(GroupCreationTest.class);
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupDataForProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
				
	}


@Test(dataProvider="groupsFromFile")
  public void testGroup—reationWithValidData(GroupData group) throws Exception {
	LOG.info("Start test :)");
    //save old state
	SortedListOf<GroupData> oldList = app.getModel().getGroups();
    //actions
	LOG.info("Create group:)");
	
    app.getGroupHelper().createGroup(group);
   
    //save new state
    LOG.info("save new state :)");
    
   SortedListOf<GroupData> newList = app.getModel().getGroups();
    
    //compare states
    LOG.info("compare states :)");
    assertThat(newList, equalTo(oldList));
    
    if("yes".equals(app.getProperty("check.db"))){
    	if (wantToCheck()){
    	assertThat(app.getModel().getGroups(),equalTo(app.getHibernateHelper().listGroups()));
    	}
    }
    if("yes".equals(app.getProperty("check.yi"))){
    	if (wantToCheck()){
    	assertThat(app.getModel().getGroups(),equalTo(app.getGroupHelper().getUIGroups()));
    	}
    }
  }


}
