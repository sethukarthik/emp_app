package com.training.emp.service;

import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;

public interface EmployeeService {
	//find all the emp from emp_info
	Set<Employee> findAll();
	
	//find employee using corp id
	Set<Employee> findById(int id) throws EmployeeNotFoundException;
	
	//create a new employee
	void save(Employee employee);
	
	//Update employee profile
	void update(Employee employee) throws EmployeeNotFoundException;
	
	//delete a employee
	void delete(int id) throws EmployeeNotFoundException;
	
	//To find all the employee with salary
	Set<Employee> findSalary();
	
	//To find the high paid employee in the organization
	Set<Employee> getMaxPaidEmp();
	
	//To find the low paid employee in the organization
	Set<Employee> getMinPaidEmp();
}
