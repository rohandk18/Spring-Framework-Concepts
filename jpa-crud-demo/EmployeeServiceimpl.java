package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDao;
import com.luv2code.springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceimpl implements EmployeeService {

	private EmployeeDao employeeDAO;
	
	public EmployeeServiceimpl(@Qualifier("employeeDAOJpaImpl")EmployeeDao theEmployeeDAO)
	{
		employeeDAO = theEmployeeDAO;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findall();
	}

	@Override
	@Transactional
	public Employee findById(int theId) 
	{
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		employeeDAO.deleteById(theId);

	}

}
