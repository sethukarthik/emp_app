package com.training.emp.test;

import java.util.Scanner;
import java.util.Set;

import com.emp_app.designation.Roles;
import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.service.EmployeeService;
import com.training.emp.service.EmployeeServiceImpl;

public class EmployeeServiceTest {
	public static void main(String[] args) {

		Set<Employee> employeeSet;
		Set<Employee> empSalarySet;
		// 1. Create an object for service
		EmployeeService service = new EmployeeServiceImpl();
		System.out.println("---> From Employee Service Find All Employees <---");
		employeeSet = service.findAll();
		System.out.println(employeeSet);

		// 2. Get input to id
		System.out.println("Please enter Employee CorpId: \n");
		Scanner getEmpId = new Scanner(System.in);
		int id = getEmpId.nextShort();
		try {
			employeeSet = service.findById(id);
			System.out.println(employeeSet);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}

		// 3. Update employee Data
		System.out.println("---> Update Employee Info <---");
		Employee updateEmployee = new Employee("nagesh", "nageshkomban@mail.com", (short) 1006, Roles.GRADUATE_TRAINEE, "L2", 8866554433l);
		try {
			// 2. call the update method in service with input emp object
			service.update(updateEmployee);
			employeeSet = service.findAll();
			System.out.println(employeeSet);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.toString());
		}

		// 4. Adding new employee info to EmployeeInfo
		System.out.println("---> Adding an employee <---");
		Employee newEmployee = new Employee("Kavin", "kavin@mail.com", (short) 1007, Roles.GRADUATE_TRAINEE, "L2", 9876483664l);
		service.save(newEmployee);
		employeeSet = service.findAll();
		System.out.println(employeeSet);

		// 5. Find Employee using CORP ID
		System.out.println("---> Enter corp id to Deleting an employee: ");
		Scanner delEmpId = new Scanner(System.in);
		int corpId = delEmpId.nextShort();
		try {
			service.delete(corpId);
			employeeSet = service.findAll();
			System.out.println(employeeSet);
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.toString());;
		}
		
		//6. Find all employee with Salary
		System.out.println("---> From all employees with salary <---");
		empSalarySet = service.findSalary();
		System.out.println(empSalarySet);

		//7. Find High paid Employee with Salary
		System.out.println("---> From high paid employee with Salary <---");
		empSalarySet = service.getMaxPaidEmp();
		System.out.println(empSalarySet);
		
		//8. Find Min paid Employee with Salary
		System.out.println("---> From high paid employee with Salary <---");
		empSalarySet = service.getMinPaidEmp();
		System.out.println(empSalarySet);
	}

}
