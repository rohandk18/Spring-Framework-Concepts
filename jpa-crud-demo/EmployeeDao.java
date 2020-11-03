package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {
	
  public List<Employee> findall();
  
  public Employee findById(int theId);
  
  public void save(Employee theEmployee);
  
  public void deleteById(int theId);
  
}
