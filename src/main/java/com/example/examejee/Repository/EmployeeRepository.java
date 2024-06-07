package com.example.examejee.Repository;

import com.example.examejee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
    Optional<Employee> findByName(String name);
}
