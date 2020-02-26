package com.oded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oded.entity.Address;
import com.oded.entity.Employee;
import com.oded.repo.AddressRepo;
import com.oded.repo.EmployeeRepo;

@RestController
public class MyController {
	@Autowired
	private AddressRepo arepo;
	@Autowired
	private EmployeeRepo erepo;
	
	@GetMapping("/save")
	public String save() {
		
		arepo.save(new Address("hyderabad"));
		erepo.save(new Employee("kumar"));
		return "save";
		
		
	}
	@GetMapping("/")
	public String savehello() {
		
		
		return "Hello";
		
		
	}


}
