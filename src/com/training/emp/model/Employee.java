package com.training.emp.model;

public class Employee {
	private int id;
	private String name;
	private String email;
	private static final String org = "Training";
	
	public Employee() {
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
		return true;
	}

	public String toString() {
		return id + " " + name + " " + email + " " + org;
	}

}
