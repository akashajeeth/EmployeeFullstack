package com.gl.capstone.CapstoneProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.capstone.CapstoneProject.Dto.EmployeeDto;
import com.gl.capstone.CapstoneProject.entity.Department;
import com.gl.capstone.CapstoneProject.entity.Employee;
import com.gl.capstone.CapstoneProject.mapper.EmployeeMapper;
import com.gl.capstone.CapstoneProject.repository.DepartmentRepository;
import com.gl.capstone.CapstoneProject.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		Optional<Department> opt = departmentRepository.findById(employeeDto.getDepartmentId());
		
		Department department = null;
		if(opt != null) {
			department=opt.get();
		}
		
		employee.setDepartment(department);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	public EmployeeDto getEmployeeById(Long employeeId) {
			Employee employee = null;
			Optional<Employee> opt = employeeRepository.findById(employeeId);
			if(opt != null) {
				employee=opt.get();
				return EmployeeMapper.mapToEmployeeDto(employee);
			}
			return null;
			
		
	}

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = null;
		
		Optional<Employee> opt = employeeRepository.findById(employeeId);
		
		if(opt != null) {
			employee=opt.get();
		}
		
		employee.setFirstname(updatedEmployee.getFirstname());
		employee.setLastname(updatedEmployee.getLastname());
		employee.setEmail(updatedEmployee.getEmail());

		Optional<Department> optDepartment = departmentRepository.findById(updatedEmployee.getDepartmentId());
		Department department = null;
		
		if(optDepartment != null) {
			department=optDepartment.get();
		}
		
		employee.setDepartment(department);
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
		
	}

	public void deleteEmployee(Long employeeId) {
//		departmentRepository.findById(departmentId).orElseThrow(
//				() -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId));
		employeeRepository.deleteById(employeeId);
	}
}


