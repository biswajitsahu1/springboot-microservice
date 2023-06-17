package com.college.departmentservice.service;

import com.college.departmentservice.Dto.DepartmentDto;
import com.college.departmentservice.entities.Department;
import com.college.departmentservice.rapository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMap;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto department) {

        return modelMap.map(
                departmentRepository.save(
                        modelMap.map(department, Department.class)),
                DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentBYCode(String code) {
        Department departmentCode = departmentRepository.findByDepartmentCode(code);
        return modelMap.map(departmentCode,DepartmentDto.class);
    }
}
