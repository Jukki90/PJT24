package com.example.tests;

public class UserData implements Comparable<UserData>{
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String email;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String group;
	public String address2;
	public String id;
	
	public UserData() {
		
	}

	public UserData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String email,
			String birthDay, String birthMonth, String birthYear, String group,
			String address2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.group = group;
		this.address2 = address2;
	}

	@Override
	public String toString() {
		return "UserData [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
	/*	if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
			*/
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(UserData other) {
		int i;
		i= this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	    if (i != 0) return i;
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		

		
		//return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		
	}
	
	
	
}