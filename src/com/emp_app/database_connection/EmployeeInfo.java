package com.emp_app.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.training.emp.model.Employee;

public class EmployeeInfo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Statement statement1 = null;
		ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_app","root","Stunning.0093"); 
			System.out.println(connection);
			statement = connection.createStatement();
			result = statement.executeQuery("select * from employee_info"); 
//			String sql = "insert into employee_info values(2,'karthik','karthik@mail')";
//			statement.execute(sql);
			statement1 = connection.createStatement();
			String sql1 = "select * from employee_info";
			result = statement1.executeQuery(sql1);
			System.out.println(result);
			Set<Employee> empSet = new HashSet();
			
			while (result.next()) {
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setName(result.getString("name"));
				emp.setEmail(result.getString("email"));
				empSet.add(emp);
			}
			
			System.out.println(empSet);
			
//			resultSet = statement.executeQuery(result);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
				
			}
			if(statement != null) {
				
			}
		}
	}
}
