package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.EmployeeModel.Employee;

public interface EmployeeDbRepository extends JpaRepository<Employee,Integer>{
			
}
