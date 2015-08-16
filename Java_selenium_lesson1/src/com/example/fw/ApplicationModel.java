package com.example.fw;

import java.util.List;

import com.example.tests.GroupData;
import com.example.tests.UserData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	private SortedListOf<GroupData> groups;
	private SortedListOf<UserData> users;
	
	//----Groups------
	public SortedListOf<GroupData> getGroups(){
		return groups;
	}
	
	public void setGroups(List<GroupData> groups){
		this.groups = new SortedListOf<GroupData> (groups);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}
	
	//----Contacts-------
	public SortedListOf<UserData> getContacts(){
		return users;
	}
	
	public void setContacts(List<UserData> users){
		this.users = new SortedListOf<UserData> (users);
	}

	public ApplicationModel addContact(UserData user) {
		users.add(user);
		return this;
	}

	public ApplicationModel removeContact(int index) {
		users.remove(index);
		return this;
	}
	

}
