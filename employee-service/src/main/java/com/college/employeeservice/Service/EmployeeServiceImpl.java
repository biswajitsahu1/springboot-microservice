package com.college.employeeservice.Service;

import com.college.employeeservice.Dto.ApiResponseDto;
import com.college.employeeservice.Dto.DepartmentDto;
import com.college.employeeservice.Dto.EmployeeDto;
import com.college.employeeservice.Dto.OrganizationDto;
import com.college.employeeservice.Entities.Employee;
import com.college.employeeservice.Exception.EmailAlreadyExistsException;
import com.college.employeeservice.Exception.ResourceNotFoundException;
import com.college.employeeservice.Rapository.EmployeeRepository;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private WebClient webClient;

    //private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists for the employee");
        }
        return modelMapper.map(
                employeeRepository.save(
                        modelMapper.map(employeeDto, Employee.class))
                , EmployeeDto.class);

    }

//    @CircuitBreaker(name = "{$spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "{$spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeeByEmpId(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        //RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        //WebClient
        //get department Code
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        //get organization code
        OrganizationDto organizationDto=webClient.get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }

    public ApiResponseDto getDefaultDepartment(long id,Exception exception) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
     DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentName("R&D  Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}