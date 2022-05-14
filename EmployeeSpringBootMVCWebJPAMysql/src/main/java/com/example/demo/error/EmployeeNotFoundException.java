package com.example.demo.error;

public class EmployeeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String s)
	{
		super(s);
	}

}
