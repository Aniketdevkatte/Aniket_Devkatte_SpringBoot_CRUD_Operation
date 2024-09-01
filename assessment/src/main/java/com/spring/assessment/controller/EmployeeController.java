package com.spring.assessment.controller;

import com.spring.assessment.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.impl.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //build Get Employee Rest Api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(Long employee) {

        Long employeeId = null;
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

    }
    //Build get All Employees REST API
    @GetMapping

    public ResponseEntity<EmployeeDto>getAllEmployees(){
        List<EmployeeDto> employee = employeeService.getAllEmployees();
        return ResponseEntity.ok((EmployeeDto) employee);
    }
    //Build Update Employee REST API
    @PutMapping("{id}")

    public ResponseEntity<EmployeeDto> updateEmployee(Long employeeId,EmployeeDto updateEmployee){


        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updateEmployee);

                return ResponseEntity.ok(employeeDto);

    }
    //Build Delete Employee REST API
    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted Successfully!.");
    }
}

