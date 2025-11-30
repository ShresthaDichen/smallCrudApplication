package com.smallproject.SmallCrudApplication.Service;


import com.smallproject.SmallCrudApplication.Entity.Employee;
import com.smallproject.SmallCrudApplication.Repository.EmployeeRepository;
import com.smallproject.SmallCrudApplication.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public EmployeeDto createEmployee (EmployeeDto dto){
        Employee emp = new Employee();
        emp.setFirstName(dto.getFirstName());
        emp.setLastname(dto.getLastname());
        emp.setEmail(dto.getEmail());

        Employee saved = employeeRepository.save(emp);
        return mapToDto(saved);
    }
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    public EmployeeDto getEmployeeById(Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return mapToDto(emp);
    }
    // Update
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setFirstName(dto.getFirstName());
        emp.setLastname(dto.getLastname());
        emp.setEmail(dto.getEmail());

        Employee updated = employeeRepository.save(emp);

        return mapToDto(updated);
    }
    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Helper: convert Entity → DTO
    private EmployeeDto mapToDto(Employee emp) {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(emp.getFirstName());
        dto.setLastname(emp.getLastname());
        dto.setEmail(emp.getEmail());
        return dto;
    }
}
