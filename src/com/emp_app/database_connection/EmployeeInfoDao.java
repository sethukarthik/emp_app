package com.emp_app.database_connection;

import java.util.Set;

import com.training.emp.model.Employee;

public interface EmployeeInfoDao {
	//find all the emp from emp_info
	Set<Employee> findAll();
	
	//find employee using corp id
	Set<Employee> findById(int id);
	
	//create a new employee
	void save(Employee employee);
	
	//Update employee profile
	void update(Employee employee);
	
	//delete a employee
	void delete(int id);
	
	//To find all the employee with salary
	Set<Employee> findSalary();
	
	//To find the high paid employee in the organization
	Set<Employee> getMaxPaidEmp();
}
