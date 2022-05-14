package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByEmployeeName(String ename);

	Employee findByEmployeeSalary(Float esalary);

	Employee findByEmployeeAge(Integer eage);

}
