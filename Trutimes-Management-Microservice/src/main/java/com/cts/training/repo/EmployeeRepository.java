package com.cts.training.repo;




import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Optional<Employee> findByEmail(String email);
    
    // To fetch all employees under a specific manager
    java.util.List<Employee> findByManagerId(Long managerId);
}
