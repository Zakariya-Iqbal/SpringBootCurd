package com.spring.repository;

import java.util.List;
import com.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    // Custom query to join Employee and Department tables
//	@Query("SELECT NEW com.project.entity.EmployeeDepartment(e.employeeId, e.employeeName, e.employeeEmail, "
//	           + "d.departmentId, d.departmentName, d.departmentManager) "
//	           + "FROM Employee e JOIN e.department d")
    //List<EmployeeDepartment> getEmployeesWithDepartments();

    // Use the default findAll method to retrieve all employees and their departments
    List<Employee> findAll();

}


