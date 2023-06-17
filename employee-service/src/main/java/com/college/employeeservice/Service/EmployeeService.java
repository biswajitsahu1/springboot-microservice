package com.college.employeeservice.Service;

import com.college.employeeservice.Dto.ApiResponseDto;
import com.college.employeeservice.Dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeByEmpId(long id);
}
