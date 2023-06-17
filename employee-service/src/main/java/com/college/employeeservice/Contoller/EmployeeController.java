package com.college.employeeservice.Contoller;

import com.college.employeeservice.Dto.ApiResponseDto;
import com.college.employeeservice.Dto.EmployeeDto;
import com.college.employeeservice.Service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name= "Organization service-OrganizationController",
        description = "Organization Controller exposes REST APIs for Organization-service"
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @Operation(
            summary = "Save Employee REST API",
            description = "save Employee object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeByEmail(@PathVariable Long id){
        ApiResponseDto employee = employeeService.getEmployeeByEmpId(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
