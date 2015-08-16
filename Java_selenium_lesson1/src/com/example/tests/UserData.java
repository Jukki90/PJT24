package com.example.tests;

public class UserData implements Comparable<UserData>{
	public String id;
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	//public String group;
	public String address2;
	public String phone2;
	
	
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
		this.workPhone = workPhone;
		this.email = email;
		this.email2 = email2;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		//this.group = group;
		this.address2 = address2;
		this.phone2 = phone2;
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
	
	
	//-----With-methods -------
	
	public UserData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public UserData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public UserData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	
	public UserData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}
	
	public UserData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}
	
	public UserData withAddress(String address) {
		this.address = address;
		return this;
	}

	
	
	//------Getters------------
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public String getHomePhone() {
		return homePhone;
	}

	public String getId() {
		return id;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

	//---setters
	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	
	
	
}