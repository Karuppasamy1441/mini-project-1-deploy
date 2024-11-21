package com.EmployeeManagement.Application.Service;

import com.EmployeeManagement.Application.Exception.EmailAlreadyExistsException;
import com.EmployeeManagement.Application.Exception.IdAlreadyExistsException;
import com.EmployeeManagement.Application.Repository.EmployeeRepository;
import com.EmployeeManagement.Application.Entity.Employee;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmoployeeService {
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeDetails() {

        return employeeRepository.findAll();
    }

    public Employee getEmployeeDetailsById(Long id) {

        return employeeRepository.findById(id).get();
    }

    public void addEmployeeDetails(Employee employee) {


        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employee.getEmail()+"  try another!");
        }
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployeeDetails(Long Id) {
         employeeRepository.deleteById(Id);

    }
}
