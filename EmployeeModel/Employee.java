package com.example.demo.EmployeeModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee_Details")

public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int empid;
	@Column(nullable = false,unique=true)
	@NotEmpty(message = "Name cannot be left empty")
	@Size(min=1,message="Name must be more than 1 letter")
	String name;
	@Column(name="Designation")
	@Size(min=2,message="The Designation size should be more than 2")
	String jobRole;
	String bloodgroup;

}
