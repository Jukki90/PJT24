package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{

	@Test
	public void deleteSomeGroup(){
		  
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupPage();
		 //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    
	    //compare states
	   
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	    
	}
	
}
