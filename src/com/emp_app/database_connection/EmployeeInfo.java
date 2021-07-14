package com.emp_app.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;

public class EmployeeInfo implements EmployeeInfoDao {
	// Database connection variables
	private Connection con = null;
	//private Statement selectEmpInfo = null;
	private ResultSet result = null;
	private PreparedStatement pstmt;
	private static Set<Employee> employeeSet;
	private Employee emp;
	
	// Database Connection established in the constructor
	public EmployeeInfo() {
		try {
			System.err.println("Coming to COns");
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_app","root","Stunning.0093");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.toString());
		}
	}
	
	void closeConnection() {
		try {				
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	// Find all the employee from the EmployeeInfo Table
	@Override
	public Set<Employee> findAll() {
		try {
			pstmt = con.prepareStatement("select * from employee_info");
			result = pstmt.executeQuery();
			employeeSet = new LinkedHashSet<>();
			while (result.next()) {
				emp = new Employee(	result.getInt("id"), 
									result.getString("name"), 
									result.getString("email"), 
									result.getShort("corp_id"), 
									result.getString("band"), 
									result.getLong("phone_number") 
								  );
				employeeSet.add(emp);
			}
			return employeeSet;
		}catch (SQLException e) {
			System.err.println(e.toString());
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public Set<Employee> findById(int id) {
		try {
			pstmt = con.prepareStatement("select * from employee_info where id=(?)");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			employeeSet = new LinkedHashSet<>();
			while(result.next()) {
				emp = new Employee( result.getInt("id"), 
									result.getString("name"), 
									result.getString("email"), 
									result.getShort("corp_id"), 
									result.getString("band"), 
									result.getLong("phone_number") 
								  );
				employeeSet.add(emp);
			}
			return employeeSet;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
//		try {
//			// initiate the deriver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			//Establish the connection using DriverManager
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_app","root","Stunning.0093");
//			System.out.println(con);
//			selectEmpInfo = con.createStatement();
//			result = selectEmpInfo.executeQuery("select * from employee_info"); 
//			System.out.println(result);
//			List<Employee> empSet = new ArrayList();
//			
//			while (result.next()) {
//				Employee emp = new Employee();
//				emp.setId(result.getInt("id"));
//				emp.setName(result.getString("name"));
//				emp.setEmail(result.getString("email"));
//				empSet.add(emp);
//			}
//			
//			System.out.println(empSet);
//			
//			// resultSet = statement.executeQuery(result);
//		} catch (SQLException | ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {				
//				if(selectEmpInfo != null) {
//					selectEmpInfo.close();
//				}
//				if(con != null) {
//					con.close();
//				}
//			} catch (SQLException e) {
//				System.out.println(e.toString());
//			}
//		}
	}
}
