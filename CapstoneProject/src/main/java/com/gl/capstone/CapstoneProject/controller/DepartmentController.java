package com.gl.capstone.CapstoneProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.capstone.CapstoneProject.Dto.DepartmentDto;
import com.gl.capstone.CapstoneProject.service.DepartmentServiceImpl;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")

public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentService;

	// Build Create or Add Department REST API
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto department = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}

	// Build Get Department REST API
	@GetMapping("{id}") // /api/departments/id
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
		DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(departmentDto);
	}

	// Build Get All Departments REST API
	@GetMapping // /api/departments
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
		List<DepartmentDto> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}

	// Build Update Departments REST API
	@PutMapping("{id}") // /api/departments/id
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
			@RequestBody DepartmentDto updatedDepartment) {

		DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
		return ResponseEntity.ok(departmentDto);
	}

	// Build Delete Departments REST API
	@DeleteMapping("{id}") // /api/departments/id
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department deleted successfully!.");
	}
}
