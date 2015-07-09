package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.name="New name";
		app.getGroupHelper().fillGroupPage(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
	}
}
