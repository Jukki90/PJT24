package com.example.fw;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase{
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	


	
	public SortedListOf<GroupData> getUIGroups() {
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		manager.navigateTo().openGroupPage();
		
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes){
			String title=checkbox.getAttribute("title");
			String name=title.substring("Select (".length(), title.length()-")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}


	public GroupHelper createGroup(GroupData group) {
			manager.navigateTo().openGroupPage();
		    initGroupCreation();
		    fillGroupPage(group);
		    submitGroupCreation();
		    returnToGroupPage();
		    // update model
		    manager.getModel().addGroup(group);
		    
		    return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupRemoval();
		returnToGroupPage();
		manager.getModel().removeGroup(index);
		
		return this;
		
	}



	
	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupPage(group);
		submitGroupModification();
		returnToGroupPage();
		manager.getModel().removeGroup(index).addGroup(group);
		
		return this;
	}


	
	
	//---------------------------------------------------------------------------------------------------------------------
	


	
	public GroupHelper initGroupCreation() {
		manager.navigateTo().openGroupPage();
		driver.findElement(By.name("new")).click();
		return this;
	}
	
	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}
	
	
	

	public GroupHelper fillGroupPage(GroupData groupData) {
	    type(By.name("group_name"), groupData.getName());
	    type(By.name("group_header"), groupData.getHeader());
	    type(By.name("group_footer"), groupData.getFooter());
	    return this;
	}
	
	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
	}


	private void submitGroupRemoval() {
		click(By.name("delete"));
		
	}



	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		
		return this;
		
	}
	
	public GroupHelper submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
		
		return this;
	}

	public void returnToGroupPage() {
		click(By.linkText("group page"));
	}
	


}
