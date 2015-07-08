package com.example.tests;

import org.testng.annotations.Test;

public class AlsoTestCreateGroup extends TestBase{

	
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupPage();
    app.getGroupHelper().createGroup();
    app.getGroupHelper().fillGroupPage(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
  

}
