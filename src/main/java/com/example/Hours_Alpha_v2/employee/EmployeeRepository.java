package com.example.Hours_Alpha_v2.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> findEmployeeByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.id=?1")
    Optional<Employee> findEmployeeById(Long id);
}
