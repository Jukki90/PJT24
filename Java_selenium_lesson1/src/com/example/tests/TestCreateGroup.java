package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestCreateGroup extends TestBase {

@Test(dataProvider="randomValidGroupGenerator")
  public void testGroup—reationWithValidData(GroupData group) throws Exception {

	app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupPage();
    
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    //actions
    app.getGroupHelper().createGroup();
    app.getGroupHelper().fillGroupPage(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    
    //compare states
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList,oldList);
    
  }


}
