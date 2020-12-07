package com.group2.wmproducts.model;

public class User {
	public String id;
	public String fName;
	public String lName;
	
	public User( String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}
	public User() {
		super();
	}
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
}
