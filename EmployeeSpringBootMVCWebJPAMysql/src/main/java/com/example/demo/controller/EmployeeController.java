package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Employee;

import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees/")

	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);

	}
	
	//getting record
	@GetMapping("/employees")
	public List<Employee> fetchEmployeeList()
	{
		return employeeService.fetchEmployeeList();
	}
	
	//delete record
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeebyId(@PathVariable ("id") Integer eid)
	{
		employeeService.deleteEmployeebyId(eid);
		return "Record is Delete";
		
	}
	
	//update record
	@PutMapping("/employees/{id}")
	public Employee updateEmployeebyId(@PathVariable("id") Integer eid, @RequestBody Employee employee) throws EmployeeNotFoundException  {
		  
		  return employeeService.updateEmployee(eid,employee);
	  }
	
	//getting record by Id
	@GetMapping("/employees/{id}")
	public Employee findByEmployeeId(@PathVariable("id") Integer eid) throws EmployeeNotFoundException
	{
		return employeeService.findByEmployeeId(eid);
	}
	
	//getting record by name
	@GetMapping("/employees/name/{name}")
	public Employee findByEmployeeName(@PathVariable("name") String ename)
	{
		return employeeService.findByEmployeeName(ename);
	}
	
	//getting record by Salary
	@GetMapping("employee/salary/{salary}")
	public Employee findByEmployeeSalary(@PathVariable("salary") Float esalary)
	{
		return employeeService.findByEmployeeSalary(esalary);
	}
	
	//getting record by Age
	@GetMapping("employee/age/{age}")
	public Employee findByEmployeeAge(@PathVariable("age")  Integer eage)
	{
		return employeeService.findByEmployeeAge(eage);
	}
	
	
	  
	
	
}
