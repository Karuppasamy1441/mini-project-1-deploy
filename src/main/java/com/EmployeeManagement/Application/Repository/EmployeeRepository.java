package com.EmployeeManagement.Application.Repository;

import com.EmployeeManagement.Application.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    void deleteById(Long Id);

    boolean existsByEmail(String Email);
}
