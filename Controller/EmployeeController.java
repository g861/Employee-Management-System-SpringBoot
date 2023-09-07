package com.example.demo.Controller;

import com.example.demo.Service.*;
import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.EmployeeModel.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Main class is here
@RestController
@RequestMapping("/api/v1/Employee")		//Common URI for all the requests
public class EmployeeController {

	@Autowired
	EmployeeServiceImple emp;

	public EmployeeController()
	{
		System.out.println("Hello 1");
	}

	//http://localhost:8080/api/v1/Employee
	@GetMapping

	//ResponseEntity   --- ResponseBody + Header + Status Code
	public ResponseEntity<List<Employee>> getAllEmployee(Pageable page)
	{
		System.out.println("Hello");
		return new ResponseEntity<List<Employee>> (emp.findAll(page), HttpStatus.OK);
	}

	@GetMapping("/{empid}")

	public ResponseEntity<Employee> findById(@PathVariable int empid) throws EmployeeNotFound 
	{
		return new ResponseEntity<Employee> (emp.findById(empid),HttpStatus.OK);
	}

	@PostMapping

	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee> (emp.addEmployee(employee),HttpStatus.CREATED);
	}

	@PutMapping("/{empid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empid, @RequestBody Employee employee ) throws EmployeeNotFound 
	{
		return new ResponseEntity<Employee> (emp.updateEmployee(empid,employee),HttpStatus.OK);
	}
	@DeleteMapping("/{empid}")

	public ResponseEntity<Employee> deleteEmployee(@PathVariable int empid) throws EmployeeNotFound 
	{
		emp.deleteEmployee(empid);
		return new ResponseEntity(HttpStatus.OK);
	}


}
