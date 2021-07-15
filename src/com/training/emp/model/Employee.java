package com.training.emp.model;

import com.emp_app.designation.Roles;

public class Employee {
	private int id;
	private String name;
	private String email;
	private short corpId;
	private String band;
	private long phoneNumber;
	private static final String org = "Training";
	public Roles designation;
	
	public Employee() {
	}

	public Employee(int id, String name, String email, short copr_id, String band, long phone_number) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.corpId = copr_id;
		this.band = band;
		this.phoneNumber = phone_number;
		this.designation = Roles.SENIOR_SOFTWARE_ENGINEER;
	}
	
	public Employee(int id, String name, String email, short copr_id, Roles designation, String band, long phone_number) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.corpId = copr_id;
		this.designation = designation;
		this.band = band;
		this.phoneNumber = phone_number;
	}
	
	//For creating a new Employee the ID is auto increment and we use this constructor new employee.
	public Employee(String name, String email, short copr_id, Roles designation, String band, long phone_number) {
		this.name = name;
		this.email = email;
		this.corpId = copr_id;
		this.designation = designation;
		this.band = band;
		this.phoneNumber = phone_number;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public Roles getRoles() {
		return designation;
	}
	
	public short getCorpId() {
		return corpId;
	}
	
	public String getBand() {
		return band;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setRoles(Roles roles) {
		this.designation = roles;
	}
	
	public void setCorpId(short corpId) {
		this.corpId = corpId;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (email == null) {
			if(other.email != null)
				return false;
		}else if(!email.equals(other.email)) {
			return false;
		}
		if (corpId == 0) {
			if(other.corpId != 0)
				return false;
		}
		return true;
	}

	public String toString() {
		return( "EmployeeId: " + id + " " + 
				"Employee Name: " + name + " " + 
				"MailId: " + email + " " + 
				"Designation: " + designation  + " " + 
				"CorpId: " + corpId + " " + 
				"Organization Band: " + band + " " + 
				"Contact Number: " + phoneNumber+ " " );
	}

}
