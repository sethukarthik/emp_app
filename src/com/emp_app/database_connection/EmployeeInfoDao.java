package com.emp_app.database_connection;

import java.util.Set;

import com.training.emp.model.Employee;

public interface EmployeeInfoDao {
	Set<Employee> findAll();
	
	Set<Employee> findById(int id);
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Employee employee);
}
