package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import com.example.utils.SortedListOf;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class GroupModificationTests extends TestBase{
	@Test(dataProvider="randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
		//app.navigateTo().mainPage();
		//app.getGroupHelper().openGroupPage();
		 //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
	    Random rnd=new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    
	    
	    
		app.getGroupHelper().modifyGroup(index, group);
		
		 
	    //save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    
	    //compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
		
	   
	    
	}
}
