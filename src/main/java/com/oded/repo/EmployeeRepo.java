package com.oded.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oded.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
