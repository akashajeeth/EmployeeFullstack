package com.gl.capstone.CapstoneProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.capstone.CapstoneProject.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
