package com.college.departmentservice.service;

import com.college.departmentservice.Dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto department);

    DepartmentDto getDepartmentBYCode(String code);
}
