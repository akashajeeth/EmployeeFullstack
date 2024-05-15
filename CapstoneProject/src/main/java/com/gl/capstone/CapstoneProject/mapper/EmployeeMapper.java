package com.gl.capstone.CapstoneProject.mapper;


import com.gl.capstone.CapstoneProject.Dto.EmployeeDto;

import com.gl.capstone.CapstoneProject.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstname(),
				employee.getLastname(),
				employee.getEmail(),
				employee.getDepartment().getId(),
				employee.getDepartment().getDepartmentName()
				);
	}

	// convert employee dto into employee jpa entity
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setFirstname(employeeDto.getFirstname());
		employee.setLastname(employeeDto.getLastname());
		employee.setEmail(employeeDto.getEmail());
		
		return employee;
	}
}




