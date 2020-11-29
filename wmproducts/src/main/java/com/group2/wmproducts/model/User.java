package com.group2.wmproducts.model;

public class User {
	public String id;
	public String firstName;
	public String lastName;
	public User(String id, String fName, String lName) {
		super();
		this.id = id;
		this.firstName = fName;
		this.lastName = lName;
	}
	public User() {
		super();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return firstName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.firstName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lastName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lastName = lName;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", fName=" + firstName + ", lName=" + lastName + "]";
	}
	
}
