package service.impl;

import com.spring.assessment.dto.EmployeeDto;
import com.spring.assessment.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    <ExampleDto> EmployeeDto updateEmployee(Long employeeId, ExampleDto updateEmployee);
    void deleteEmployee(Long employeeId);
}
