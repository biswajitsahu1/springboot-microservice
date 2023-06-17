package com.college.departmentservice.controller;

import com.college.departmentservice.Dto.DepartmentDto;
import com.college.departmentservice.entities.Department;
import com.college.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name= "Department service-DepartmentController",
        description = "Department Controller exposes REST APIs for Department-service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

     @Operation(
             summary = "Save Department REST API",
             description = "save department object in database"
     )
     @ApiResponse(
             responseCode = "201",
             description = "HTTP Status 201 CREATED"
     )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Department REST API",
            description = "get department object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentCode) {
        DepartmentDto department = departmentService.getDepartmentBYCode(departmentCode);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
}
