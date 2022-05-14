package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.type.TrueFalseType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
public class Employee {
	@Id
	@GeneratedValue(generator= "seq", strategy =GenerationType.AUTO)
	@SequenceGenerator(name="seq", initialValue=1000) 
	private int employeeId;
	@NotNull(message="Employee cannot be null")
	@NotBlank(message="Employee cannot be blank")
	private String employeeName;
	@Range(min=21, message="Employee Age cannot be less than 21 years")
	private int employeeAge;
	@Column(unique =true)
	@Length(min =10, max=13,message="Cell number cannot be less than 10 characters")
	private String employeeMobile;
	private float employeeSalary;
	//Constructor without arguments
	public Employee() {
		super();
	}
    //Constructor with arguments
	public Employee(int employeeId, String employeeName, int employeeAge, String employeeMobile, float employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeMobile = employeeMobile;
		this.employeeSalary = employeeSalary;
	}
	//getter and setter
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeeMobile() {
		return employeeMobile;
	}
	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
	public float getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	//to string
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeMobile=" + employeeMobile + ", employeeSalary=" + employeeSalary + "]";
	}
	
	
	
	
	

}
