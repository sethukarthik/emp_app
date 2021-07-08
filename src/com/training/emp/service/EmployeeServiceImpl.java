package com.training.emp.service;

import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.repository.EmployeeRepository;
import com.training.emp.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeRepository repository;

	public EmployeeServiceImpl() {
		repository = new EmployeeRepositoryImpl();
//		dao = new EmployeeDAOImpl();
	}

	@Override
	public Set<Employee> findAll() {
		return repository.findAll();
//		return dao.findAll();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException {
		Employee employee = repository.findById(id);
//		Employee employee = dao.findById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Id Not Found");
		} else {
			return employee;
		}
	}

	@Override
	public void save(Employee employee) {
		repository.save(employee);
//		dao.save(employee);

	}

	@Override
	public void update(Employee employee) throws EmployeeNotFoundException {
		Employee result = repository.findById(employee.getId());
//		Employee result = dao.findById(employee.getId());
		if (result == null) {
			throw new EmployeeNotFoundException("Employee Id Not Found");
		} else {
			repository.update(employee);
//			dao.update(employee);
		}

	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		 Employee employee = repository.findById(id);
//		Employee employee = dao.findById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee doesn't exist!!");
		} else {
			// repository.delete(id);
//			dao.delete(id);
			repository.delete(id);
		}
	}

}
