package com.smallproject.SmallCrudApplication.controller;

import com.smallproject.SmallCrudApplication.service.EmployeeService;
import com.smallproject.SmallCrudApplication.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    //Create
    @PostMapping
    public ResponseEntity<EmployeeDto> create( @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }
    //Get ALl Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(
            @PathVariable Long id,
            @RequestBody EmployeeDto dto
    ) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
