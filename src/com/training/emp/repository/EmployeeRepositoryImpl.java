package com.training.emp.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.training.emp.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	// dummy database
	private static Set<Employee> employeeSet;

	public EmployeeRepositoryImpl() {
		employeeSet = new HashSet<>();
		Employee employee1 = new Employee(101, "Immanuel", "Immanuel@mail.com");
		Employee employee2 = new Employee(102, "Saranya", "saranya@mail.com");
//		Employee employee3 = new Employee(103, "Prithivi");
		employeeSet.add(employee1);
		employeeSet.add(employee2);
//		employeeSet.add(employee3);

	}

	@Override
	public Set<Employee> findAll() {
		return employeeSet;

	}

	@Override
	public Employee findById(int id) {
		for (Employee employee : employeeSet) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
	
	@Override
	public Employee findByEmail(String mail) {
		Iterator<Employee> employee = employeeSet.iterator();
		while (employee.hasNext()) {
			Employee data = employee.next();
			if (data.getEmail() == mail) {
				return data;
			}
		}
		return null;
	}	

//	@Override
//	public Employee findByEmail(String mail) {
//		for (Employee employee : employeeSet) {
//			if (employee.getEmail() == mail) {
//				return (Employee) employee;
//			}
//		}
//		return null;
//	}	
	
	@Override
	public void save(Employee employee) {
		employeeSet.add(employee);
	}

	@Override
	public void update(Employee employee) {
		// emp - exisiting emp
		// employee - new data to be updated
		for (Employee emp : employeeSet) {
			if (emp.getId() == employee.getId()) {
				emp.setName(employee.getName());
			}
		}

	}

	@Override
	public void delete(int id) {
		Iterator<Employee> it = employeeSet.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
			}
		}

	}

}
