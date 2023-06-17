package com.college.employeeservice.Rapository;

import com.college.employeeservice.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee getEmployeeById(Long id);
    Optional<Employee> findByEmail(String email);
}
