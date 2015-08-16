package com.example.tests;


import static org.junit.Assert.assertThat;
import java.util.Random;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;

public class GroupRemovalTests extends TestBase{

	@Test
	public void deleteSomeGroup(){
	  //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUIGroups();
		
	  //actions
	    Random rnd=new Random();
	    int index = rnd.nextInt(oldList.size());
		app.getGroupHelper().deleteGroup(index);
		
		 //save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getUIGroups();
	        
	    //compare states
		assertThat(newList, equalTo(oldList.without(index)));
	    
	    
	}
	
}
