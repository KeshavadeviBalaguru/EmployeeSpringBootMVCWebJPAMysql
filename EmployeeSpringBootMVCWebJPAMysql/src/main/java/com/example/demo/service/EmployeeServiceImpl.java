package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Employee;
import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeerepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeerepo.save(employee);
	}

	@Override
	public List<Employee> fetchEmployeeList() {
		
		return employeerepo.findAll();
	}

	@Override
	public void deleteEmployeebyId(Integer eid) {
	
		employeerepo.deleteById(eid);;
		
	}

	@Override
	public Employee updateEmployee(Integer eid, Employee employee) throws EmployeeNotFoundException {
		
		Optional<Employee> employee1=employeerepo.findById(eid);
		Employee empdb=null;
		if(employee1.isPresent())
		{
			empdb=employeerepo.findById(eid).get();
			if(Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName()))
			{
				empdb.setEmployeeName(employee.getEmployeeName());
			}
			if(Objects.nonNull(employee.getEmployeeAge()) && !"".equals(employee.getEmployeeAge()))
			{
				empdb.setEmployeeAge(employee.getEmployeeAge());
			}
			if(Objects.nonNull(employee.getEmployeeSalary()) && !"".equals(employee.getEmployeeSalary()))
			{
				empdb.setEmployeeSalary(employee.getEmployeeSalary());
			}
			if(Objects.nonNull(employee.getEmployeeMobile()) && !"".equals(employee.getEmployeeMobile()))
			{
				empdb.setEmployeeMobile(employee.getEmployeeMobile());
			}
			return employeerepo.save(empdb);
		
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Not Available");
		}
		
	}

	@Override
	public Employee findByEmployeeId(Integer eid) throws EmployeeNotFoundException {
		
		Optional<Employee> employee1=employeerepo.findById(eid);
		if(!employee1.isPresent())
		{
			throw new EmployeeNotFoundException("Employee Not Available");
		}
		
		return employeerepo.findById(eid).get();
	}

	@Override
	public Employee findByEmployeeName(String ename) {
		
		
		return employeerepo.findByEmployeeName(ename);
	}

	@Override
	public Employee findByEmployeeSalary(Float esalary) {
		
		return employeerepo.findByEmployeeSalary(esalary);
	}

	@Override
	public Employee findByEmployeeAge(Integer eage) {
		
		return employeerepo.findByEmployeeAge(eage);
	}

	
	}

	

	

	
	


