package com.training.emp.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import com.emp_app.designation.Roles;

public class EmployeeTest {
	static Employee emp = null;
	
	@BeforeClass
	public static void before() {		
		emp = new Employee();
	}
	
	@Test
	public void testSetId() {
		emp.setId(1);
		assertEquals(emp.getId(), 1);
	}
	
	@Test
	public void testCorpId() {
		emp.setCorpId((short)1002);
		assertEquals(emp.getCorpId(), 1002);
	}
	
	@Test
	public void testEmail() {
		String mail = "sethu@mail.com";
		emp.setEmail(mail);
		assertEquals(emp.getEmail(), mail);
	}
	
	@Test
	public void testBand() {
		String band = "L3";
		emp.setBand(band);
		assertEquals(emp.getBand(), band);
	}
	
	@Test
	public void testDesignation() {
		Roles role = Roles.SENIOR_SOFTWARE_ENGINEER;
		emp.setRoles(role);
		assertEquals(emp.getRoles(), role);
	}
	
	@Test
	public void testPhoneNumber() {
		long phone = 234567890l;
		emp.setPhoneNumber(phone);
		assertEquals(emp.getPhoneNumber(), phone);
	}
	
	//UnitTest for Constructor without ID
	public void testEmployeeCons() {
		Employee emp1 = new Employee(8, "nagesh", "nageshkomban@mail.com", (short) 1006, Roles.GRADUATE_TRAINEE, "L2", 8866554433l);
		assertEquals(emp.getName(), "nagesh");
	}
	
}
