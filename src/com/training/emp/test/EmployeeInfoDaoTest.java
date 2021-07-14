package com.training.emp.test;

import com.emp_app.database_connection.EmployeeInfo;

public class EmployeeInfoDaoTest {
	
	public static void main(String[] args) {
		EmployeeInfo empInfo = new EmployeeInfo();
		// Find all the employees
		System.out.println(empInfo.findAll());
	}
}
