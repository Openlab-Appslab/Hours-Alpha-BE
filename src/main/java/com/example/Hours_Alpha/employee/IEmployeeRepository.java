package com.example.Hours_Alpha.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
