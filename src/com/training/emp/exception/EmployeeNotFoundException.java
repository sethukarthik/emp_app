package com.training.emp.exception;

public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String message) {
		System.out.println(message);
	}
}
