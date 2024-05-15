package com.gl.capstone.CapstoneProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
		private Long id;
		private String departmentName;
		private String departmentDescription;
}
