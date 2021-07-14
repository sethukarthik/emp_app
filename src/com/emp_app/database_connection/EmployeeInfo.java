package com.emp_app.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.training.emp.model.Employee;

public class EmployeeInfo implements EmployeeInfoDao {
	// Database connection variables
	private Connection con = null;
	private ResultSet result = null;
	private int ackResult;
	private PreparedStatement pstmt;
	private Statement stmt;
	private static Set<Employee> employeeSet;
	private Employee emp;
	private static final String newEmp = "Insert into employee_info (name, email, corp_id, designation_id, band, phone_number) VALUES (?,?,?,?,?,?)";
	private static final String updEmp = "Update employee_info SET name=?, email=?, designation_id=?, band=?, phone_number=? WHERE corp_id=?";
	private static final String delEmp = "Delete from employee_info WHERE corp_id=?";
	
	// Database Connection established in the constructor
	public EmployeeInfo() {
		try {
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
	
	void systcloseConnection() {
		try {				
			if(stmt != null) {
				stmt.close();
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
			stmt = con.createStatement();
			result = stmt.executeQuery("select * from employee_info");
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
			systcloseConnection();
		}
		return null;
	}

	@Override
	public Set<Employee> findById(int id) {
		try {
			pstmt = con.prepareStatement("select * from employee_info where corp_id=(?)");
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
		try {
			pstmt = con.prepareStatement(newEmp);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setShort(3, employee.getCorpId());
			pstmt.setInt(4, 1);
			pstmt.setString(5, employee.getBand());
			pstmt.setLong(6, employee.getPhoneNumber());
			ackResult = pstmt.executeUpdate();
			System.err.println(ackResult);
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			closeConnection();
		}
	}

	@Override
	public void update(Employee employee) {
		try {
			pstmt = con.prepareStatement(updEmp);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getEmail());
			pstmt.setInt(3, 3);
			pstmt.setString(4, employee.getBand());
			pstmt.setLong(5, employee.getPhoneNumber());
			pstmt.setInt(6, employee.getCorpId());
			ackResult = pstmt.executeUpdate();
			System.err.println(ackResult);
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			closeConnection();
		}
	}

	@Override
	public void delete(int corpId) {
		try {
			pstmt = con.prepareStatement(delEmp);
			pstmt.setInt(1, corpId);
			ackResult = pstmt.executeUpdate();
			System.err.println(ackResult);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			closeConnection();
		}
	}
}
