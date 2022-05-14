package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> fetchEmployeeList();

	void deleteEmployeebyId(Integer eid);

	Employee updateEmployee(Integer eid, Employee employee) throws EmployeeNotFoundException;

	Employee findByEmployeeId(Integer eid) throws EmployeeNotFoundException;

	Employee findByEmployeeName(String ename);

	Employee findByEmployeeSalary(Float esalary);

	Employee findByEmployeeAge(Integer eage);

	

	

}
