package com.emp_app.database_connection;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import org.junit.After;
import java.sql.Connection;

public class EmployeeInfoTest {
	private Connection con = null;
	private Statement stmt;
	
	@Before
	public void enableConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_app","root","Stunning.0093");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.toString());
		}
	}
	
	@After
	public void disableConnection() {
		EmployeeInfo.systcloseConnection(stmt, con);
	}
	
	@Test
	public void testSQLConnection() throws SQLException {
		stmt = con.createStatement();
		EmployeeInfo.systcloseConnection(stmt, con);
        assertTrue(stmt.isClosed());
	}
	
	@Test
	public void testFindAll() throws SQLException {
		EmployeeInfo empInfo = new EmployeeInfo();
        assertEquals(empInfo.findAll().isEmpty(), false);
	}
	
}
