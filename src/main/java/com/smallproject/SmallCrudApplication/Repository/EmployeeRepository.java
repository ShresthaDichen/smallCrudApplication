package com.smallproject.SmallCrudApplication.Repository;


import com.smallproject.SmallCrudApplication.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
