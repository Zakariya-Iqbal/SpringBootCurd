package com.spring.services;


import java.util.ArrayList;



import java.util.List;

import com.spring.dto.EmployeeRequest;
import com.spring.entity.Department;
import com.spring.entity.Employee;
import com.spring.entity.EmployeeDepartment;
import com.spring.repository.DepartmentRepository;
import com.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService,DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;

    }

//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {


        if (employee.getEmployeeName() == null ||  employee.getEmployeeName().isEmpty() ||
                employee.getEmployeeEmail() == null || employee.getEmployeeEmail().isEmpty() ||
                employee.getDepartmentName() == null || employee.getDepartmentName().isEmpty()){
            //  ||
            // employee.getDepartmentManager() == null ||  employee.getDepartmentManager().isEmpty()

            // Return an error response indicating that required fields are missing
            throw new IllegalArgumentException("All fields are required."); }

        return employeeRepository.save(employee);
    }

    //important
    // new department is created first, and then an employee is associated with that department.
    //also uncomment @GeneratedValue(strategy = GenerationType.AUTO) in Employee enity
    public Employee createEmployeeAndDepartment(EmployeeRequest employeeRequest) {
        Department department = new Department();
        department.setDepartmentName(employeeRequest.getDepartmentName());
        department.setDepartmentManager(employeeRequest.getDepartmentManager());

        Department createdDepartment = departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
        employee.setDepartment(createdDepartment);

        return employeeRepository.save(employee);
    }

    //important
    //to handle the creation of multiple employees associated with a single department:
    //if department already exists in department table
    public List<Employee> createEmployeesAndAssociateWithDepartment(List<EmployeeDepartment> employeeDepartments) {
        List<Employee> createdEmployees = new ArrayList<>();

        for (EmployeeDepartment employeeDepartment : employeeDepartments) {
            Department department = departmentService.getDepartmentById(employeeDepartment.getDepartmentId());

            if (department != null) {
                Employee newEmployee = new Employee();

                // newEmployee.setEmployeeId(employeeDepartment.getEmployeeId());
                newEmployee.setEmployeeName(employeeDepartment.getEmployeeName());
                newEmployee.setEmployeeEmail(employeeDepartment.getEmployeeEmail());
                newEmployee.setDepartment(department);


                Employee createdEmployee = employeeRepository.save(newEmployee);
                createdEmployees.add(createdEmployee);
            }
        }

        return createdEmployees;
    }



//for combined
//    public List<EmployeeDepartment> getEmployeesWithDepartments() {
//       return employeeRepository.getEmployeesWithDepartments();
//    }
//

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public List<EmployeeDepartment> getEmployeesWithDepartments() {
        List<Employee> employees = getAllEmployees();
        List<EmployeeDepartment> combinedList = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDepartment employeeDepartment = new EmployeeDepartment(
                    employee.getEmployeeId(),
                    employee.getEmployeeName(),
                    employee.getEmployeeEmail(),
                    employee.getDepartment().getDepartmentId(),
                    employee.getDepartment().getDepartmentName(),
                    employee.getDepartment().getDepartmentManager()
            );
            combinedList.add(employeeDepartment);
        }

        return combinedList;
    }


//    public List<EmployeeDepartment> getEmployeesWithDepartments() {
//        List<Employee> employees = getAllEmployees();
//        List<EmployeeDepartment> combinedList = new ArrayList<>();
//        for (Employee employee : employees) {
//            EmployeeDepartment employeeDepartment = new EmployeeDepartment(
//            		employee.getEmployeeId(),
//            		employee.getEmployeeName(),
//            		employee.getEmployeeEmail(),
//            		employee.getDepartment()
//            		);
//            combinedList.add(employeeDepartment);
//        }
//
//        return combinedList;
//    }




    //this will update the employee's name and email, while keeping the associated
    //department unchanged

//    public Employee updateEmployee(Integer id, Employee updatedEmployeeData) {
//        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
//        if (existingEmployee != null) {
//            // Update employee details if provided
//            if (updatedEmployeeData.getEmployeeName() != null) {
//                existingEmployee.setEmployeeName(updatedEmployeeData.getEmployeeName());
//            }
//            if (updatedEmployeeData.getEmployeeEmail() != null) {
//                existingEmployee.setEmployeeEmail(updatedEmployeeData.getEmployeeEmail());
//            }
//
//            // You can leave the department unchanged in this method
//            return employeeRepository.save(existingEmployee);
//        }
//        return null; // Employee not found
//    }

    //To update an employee and its associated department together
    public Employee updateEmployeeAndDepartment(Integer id, Employee updatedEmployeeData) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {
            // Update employee details
            existingEmployee.setEmployeeName(updatedEmployeeData.getEmployeeName());
            existingEmployee.setEmployeeEmail(updatedEmployeeData.getEmployeeEmail());

            Department updatedDepartment = updatedEmployeeData.getDepartment();
            if (updatedDepartment != null) {
                // Update department details
                Department existingDepartment = existingEmployee.getDepartment();
                existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
                existingDepartment.setDepartmentManager(updatedDepartment.getDepartmentManager());

                // Save the changes to the department back to the employee
                // existingEmployee.setDepartment(existingDepartment);
            }

            return employeeRepository.save(existingEmployee);
        }

        return null; // Employee not found
    }

//    public Employee updateEmployeeAndDepartment(Integer id, Employee updatedEmployeeData) {
//        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
//
//        if (existingEmployee != null) {
//            // Update employee details
//            existingEmployee.setEmployeeName(updatedEmployeeData.getEmployeeName());
//            existingEmployee.setEmployeeEmail(updatedEmployeeData.getEmployeeEmail());
//
//            // Update department details
//            Department updatedDepartment = new Department();
//            updatedDepartment.setDepartmentName(updatedEmployeeData.getDepartmentName());
//            updatedDepartment.setDepartmentManager(updatedEmployeeData.getDepartmentManager());
//
//            // Set the updated department details in the existing employee
//            existingEmployee.setDepartmentName(updatedDepartment.getDepartmentName());
//            existingEmployee.setDepartmentManager(updatedDepartment.getDepartmentManager());
//
//            return employeeRepository.save(existingEmployee);
//        }
//
//        return null; // Employee not found
//    }



    // to delete a single employee without affecting other employees with the same department
    public void deleteEmployee(Integer id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElse(null);

        if (employeeToDelete != null) {
            employeeRepository.delete(employeeToDelete);
        }
    }
}





















