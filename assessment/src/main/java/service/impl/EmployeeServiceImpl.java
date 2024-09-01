package service.impl;

import com.spring.assessment.dto.EmployeeDto;
import com.spring.assessment.entity.Employee;
import com.spring.assessment.exception.ResourceNotFoundException;
import com.spring.assessment.mapper.EmployeeMapper;
import com.spring.assessment.repository.EmployeeRepository;
import io.micrometer.observation.Observation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exists with given id:"+employeeId));

        Employee employee = null;
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
        .collect(Collectors.toList());
    }

    @Override
    public <ExampleDto> EmployeeDto updateEmployee(Long employeeId, ExampleDto updateEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow();
    {
            Observation.CheckedCallable<ResourceNotFoundException, Throwable> resourceNotFoundExceptionThrowableCheckedCallable = () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId);
        }
        employee.setFirstName(String.valueOf(updateEmployee.getClass()));
        employee.setLastName(String.valueOf(updateEmployee.getClass()));
        employee.setEmail(String.valueOf(updateEmployee.getClass()));
        Employee updatedEmployeeObj= employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        {
            Observation.CheckedCallable<ResourceNotFoundException, Throwable> resourceNotFoundExceptionThrowableCheckedCallable = () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId);
        };
        employeeRepository.deleteById(employeeId);

    }
    //Build update Employee REST API


}
