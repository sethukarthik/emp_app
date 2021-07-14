package com.training.emp.test;

import java.util.Scanner;
import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.service.EmployeeService;
import com.training.emp.service.EmployeeServiceImpl;

public class EmployeeServiceTest {
	public static void main(String[] args) {

		Set<Employee> employeeSet;
		// 1. Create an object for service
		EmployeeService service = new EmployeeServiceImpl();
		System.out.println("---> From Employee Service Find All Employees <---");
		employeeSet = service.findAll();
		System.out.println(employeeSet);

		// 2. Get input to id
		System.out.println("Find By Id");
		Scanner getEmpId = new Scanner(System.in);
		int id = getEmpId.nextInt();
		try {
			employeeSet = service.findById(id);
			System.out.println(employeeSet);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}

//		System.out.println("Update Id");
//		// 1. Create New employee Data to be updated
//		Employee updateEmployee = new Employee(1, "Immanuel");
//		try {
//			// 2. call the update method in service with input emp obje
//			service.update(updateEmployee);
//			employeeSet = service.findAll();
//			System.out.println(employeeSet);
//		} catch (EmployeeNotFoundException e) {
//
//		}

//		System.out.println("Adding an employee");
//		Employee newEmployee = new Employee(4, "Kavin");
//		service.save(newEmployee);
//		employeeSet = service.findAll();
//		System.out.println(employeeSet);

		System.out.println("Deleting an employee");
		id = 3;
		try {
			service.delete(id);
			employeeSet = service.findAll();
			System.out.println(employeeSet);
		} catch (EmployeeNotFoundException e) {
		}

	}

}
