package com.example.fw;

public class Contact {
	public String lastname;
	public String firstname;
	
	
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	
	
	
	public Contact setFirstName(String firstname){
		this.firstname = firstname;
		return this;
	}
	public Contact setLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

}
