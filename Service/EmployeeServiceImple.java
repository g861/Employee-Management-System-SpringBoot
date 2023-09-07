package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.*;
import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.EmployeeModel.*;

@Service
public class EmployeeServiceImple {

	@Autowired
	EmployeeDbRepository empRepo;

	public List<Employee> findAll(Pageable page)
	{
		return empRepo.findAll(page).toList();
	}

	public Employee findById(int id) throws EmployeeNotFound 
	{
		Optional<Employee> emp = empRepo.findById(id);
		return emp.orElseThrow(()->new EmployeeNotFound("Employee not found: " + id));
	}

	public Employee addEmployee(Employee emp)
	{
		return empRepo.save(emp);
	}

	public Employee updateEmployee(int id,Employee emp) throws EmployeeNotFound 
	{
		Employee emp1 = findById(id);
		emp1.setName(emp.getName());
		emp1.setJobRole(emp.getJobRole());
		emp1.setBloodgroup(emp.getBloodgroup());
		empRepo.save(emp1);
		return emp1;
	}

	public void deleteEmployee(int id) throws EmployeeNotFound 
	{
		Employee emp = findById(id);
		empRepo.delete(emp);	
	}

}


