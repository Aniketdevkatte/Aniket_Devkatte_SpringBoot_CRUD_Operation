package com.spring.assessment.repository;

import com.spring.assessment.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;




public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
