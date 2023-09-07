package com.example.demo.Repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.EmployeeModel.*;
import com.example.demo.exceptions.EmployeeNotFound;


@Repository
public class EmployeeRepository {

	List<Employee> emps= new ArrayList<>();

	//	public EmployeeRepository()
	//	{
	//		emps.add(new Employee("Raj","Software Developer","B+",1));
	//		emps.add(new Employee("Raj Lakshmi","Software Engineer","B+",2));
	//	}
	//	
	public List<Employee> findAll()
	{
		return emps;
	}

	public Employee findById(int id) throws EmployeeNotFound 
	{
		Optional<Employee> emp = emps.stream().filter((e1)->e1.getEmpid()==id).findAny();
		return emp.orElseThrow(()->new EmployeeNotFound("Employee not found: " + id));

	}
	public Employee addEmployee(Employee emp)
	{
		emps.add(emp);
		return emp;
	}

	public Employee updateEmployee(int id, Employee emp) throws EmployeeNotFound 
	{
		Employee emp1 = findById(id);
		emp1.setName(emp.getName());
		emp1.setJobRole(emp.getJobRole());
		emp1.setBloodgroup(emp.getBloodgroup());
		return emp1;
	}

	public void deleteEmployee(int id) throws EmployeeNotFound 
	{
		Employee emp = findById(id);
		emps.remove(emp);

	}

}
