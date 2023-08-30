package com.spring.controller;


import java.util.ArrayList;
import java.util.List;
import com.spring.entity.Employee;
import com.spring.entity.EmployeeDepartment;
import com.spring.services.DepartmentService;
import com.spring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/combined")
public class CombinedController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public CombinedController(EmployeeService employeeService,DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }
    /*
     * @GetMapping
     *  public List<EmployeeDepartment> getCombinedEmployeeDepartment() {
     * return employeeService.getEmployeesWithDepartments(); }
     */

    @GetMapping
    public List<EmployeeDepartment> getCombinedEmployeeDepartment() {
        List<Employee> employees = employeeService.getAllEmployees();
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

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees-with-departments")
    public List<EmployeeDepartment> getEmployeesWithDepartments() {
        return employeeService.getEmployeesWithDepartments();
    }

}












//    @GetMapping
//    public List<EmployeeDepartment> getCombinedEmployeeDepartment() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        List<Department> departments = departmentService.getAllDepartments();
//
//        List<EmployeeDepartment> combinedList = new ArrayList<>();
//
//        for (Employee employee : employees) {
//            Department department = employee.getDepartment();
//            EmployeeDepartment employeeDepartment = new EmployeeDepartment(
//            		employee.getEmployeeId(),
//            		employee.getEmployeeName(),
//            		employee.getEmployeeEmail(),
//            		employee.getDepartmentId(),
//            		employee.getDepartmentName(),
//            		employee.getDepartmentEmail()
//
//           );
//
//
//            combinedList.add(employeeDepartment);
//        }
//
//        return combinedList;
//    }
//}
