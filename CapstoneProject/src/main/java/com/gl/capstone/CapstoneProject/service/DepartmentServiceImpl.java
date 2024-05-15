package com.gl.capstone.CapstoneProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.capstone.CapstoneProject.Dto.DepartmentDto;
import com.gl.capstone.CapstoneProject.entity.Department;
import com.gl.capstone.CapstoneProject.mapper.DepartmentMapper;
import com.gl.capstone.CapstoneProject.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department SavedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(SavedDepartment);
	}

	public DepartmentDto getDepartmentById(Long departmentId) {
		Optional<Department> opt = departmentRepository.findById(departmentId);
		if (opt.get() != null) {
			Department department = opt.get();
			return DepartmentMapper.mapToDepartmentDto(department);
		}
		return null;
	}

	public List<DepartmentDto> getAllDepartments() {
		List<Department> departments = departmentRepository.findAll();
		return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
		Optional<Department> opt = departmentRepository.findById(departmentId);

		Department department = null;
		if (opt.get() != null) {
			department = opt.get();
			department.setDepartmentName(updatedDepartment.getDepartmentName());
			department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

			Department savedDepartment = departmentRepository.save(department);

			return DepartmentMapper.mapToDepartmentDto(savedDepartment);
		}
		return null;
	}

	public void deleteDepartment(Long departmentId) {
//		departmentRepository.findById(departmentId).orElseThrow(
//				() -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId));
		departmentRepository.deleteById(departmentId);
	}
}
