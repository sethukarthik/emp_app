package com.training.emp.model;

import java.util.Objects;

public class Salary {
	private double fixedPay;

	public Salary(double fixedPay) {
		super();
		this.fixedPay = fixedPay;
	}
	
	public double getFixedPay() {
		return fixedPay;
	}

	public void setFixedPay(double fixedPay) {
		this.fixedPay = fixedPay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fixedPay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		return Double.doubleToLongBits(fixedPay) == Double.doubleToLongBits(other.fixedPay);
	}

	@Override
	public String toString() {
		return ("Salary fixedPay: " + fixedPay);
	}
	
	
}
