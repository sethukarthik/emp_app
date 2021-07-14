package com.training.emp.service;

import java.util.LinkedHashSet;
import java.util.Set;

import com.emp_app.database_connection.EmployeeInfo;
import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.repository.EmployeeRepository;
import com.training.emp.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeRepository repository;
	private static EmployeeInfo dao;

	public EmployeeServiceImpl() {
		repository = new EmployeeRepositoryImpl();
	}

	@Override
	public Set<Employee> findAll() {
		dao = new EmployeeInfo();
		return dao.findAll();
	}

	@Override
	public Set<Employee> findById(int id) throws EmployeeNotFoundException {
		dao = new EmployeeInfo();
		return dao.findById(id);
	}

	//Insert New Employee data
	@Override
	public void save(Employee employee) {
		dao = new EmployeeInfo();
		dao.save(employee);
	}

	@Override
	public void update(Employee employee) throws EmployeeNotFoundException {
		dao = new EmployeeInfo();
		Set<Employee> result = new LinkedHashSet<>();
		result = dao.findById(employee.getCorpId());
		if (result.isEmpty() || result == null) {
			throw new EmployeeNotFoundException("Employee Id Not Found");
		} else {
			dao = new EmployeeInfo();
			dao.update(employee);
		}
	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		dao = new EmployeeInfo();
		Set<Employee> result = new LinkedHashSet<>();
		result = dao.findById(id);
		if (result.isEmpty() || result == null) {
			throw new EmployeeNotFoundException("Employee Id Not Found");
		} else {
			dao = new EmployeeInfo();
			dao.delete(id);
		}
	}

}
