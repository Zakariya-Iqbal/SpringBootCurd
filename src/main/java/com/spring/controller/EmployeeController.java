package com.spring.controller;



//import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.spring.dto.EmployeeRequest;
import com.spring.entity.Employee;
import com.spring.entity.EmployeeDepartment;
import com.spring.services.DepartmentService;
import com.spring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // new department is created first, and then an employee is associated with that department.
//also uncomment @GeneratedValue(strategy = GenerationType.AUTO) in Employee enity
    @PostMapping
    public ResponseEntity<Object> createEmployeeAndDepartment(@RequestBody EmployeeRequest employeeRequest) {
        Employee createdEmployee = employeeService.createEmployeeAndDepartment(employeeRequest);

        if (createdEmployee != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
        } else {
            return ResponseEntity.badRequest().body("Failed to create employee and department.");
        }
    }


    ////important
//// to handle the creation of multiple employees associated with a single department:
    @PostMapping("/create-multiple-employees")
    public ResponseEntity<Object> createMultipleEmployeesAndAssociateWithDepartment(
            @RequestBody List<EmployeeDepartment> employeeDepartments) {

        List<Employee> createdEmployees = employeeService.createEmployeesAndAssociateWithDepartment(employeeDepartments);

        if (createdEmployees.isEmpty()) {
            return ResponseEntity.badRequest().body("No employees were created.");
        }

        // Prepare the response JSON with success message and created employees
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employees created and associated with the department");
        response.put("employees", createdEmployees);

        return ResponseEntity.ok(response);
    }




    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }


    //To update an employee
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployeeAndDepartment(@PathVariable Integer id, @RequestBody Employee updatedEmployeeData) {
        Employee updatedEmployee = employeeService.updateEmployeeAndDepartment(id, updatedEmployeeData);

        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.badRequest().body("Employee not found.");
        }
    }

    //to delete a single employee without affecting other employees with the same department
//for delete remove cascade attribute from employee entity.
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

////very impprtant
////this will update the employee's name and email, while keeping the associated
////department unchanged
//@PutMapping("/{id}")
//public ResponseEntity<Object> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
//  Employee updatedEmployee = employeeService.updateEmployee(id, employee);
//
//  if (updatedEmployee != null) {
//      return ResponseEntity.ok(updatedEmployee);
//  } else {
//      return ResponseEntity.badRequest().body("Employee not found.");
//  }
//}





















//@PutMapping("/{id}")
//public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
//    return employeeService.updateEmployee(id, employee);
//}



//@DeleteMapping("/{id}")
//public void deleteEmployee(@PathVariable Integer id) {
//    employeeService.deleteEmployee(id);
//}
//}

//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeDepartment> getEmployee(@PathVariable Integer id) {
//        EmployeeDepartment employee = employeeService.getEmployeeWithDepartment(id);
//        if (employee != null) {
//            return ResponseEntity.ok(employee);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//  //create a new employee and associate with department
//    @PostMapping
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.createEmployee(employee);
//    }



//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
//        // Retrieve the existing department based on provided details
//        Department department = departmentService.getDepartmentByDetails(
//            employeeRequest.getDepartmentId(),
//            employeeRequest.getDepartmentName(),
//            employeeRequest.getDepartmentManager()
//        );
//
//        if (department == null) {
//            // Return an error response indicating that the department doesn't exist
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        // Create the employee with the retrieved department
//        Employee newEmployee = new Employee(
//            employeeRequest.getEmployeeId(),
//            employeeRequest.getEmployeeName(),
//            employeeRequest.getEmployeeEmail(),
//            department
//        );
//
//        // Save the employee
//        Employee savedEmployee = employeeService.createEmployee(newEmployee);
//
//        // Return a success response with the created employee
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
//    }


//to create multiple employees in an array and associate them with a single department

//    @PostMapping("/create-many")
//    public ResponseEntity<Map<String, Object>> createEmployeesWithDepartment(
//            @RequestBody CreateEmployeesRequest request) {
//        Department department = departmentService.getDepartmentByDetails(
//            request.getDepartmentId(),
//            request.getDepartmentName(),
//            request.getDepartmentManager()
//        );
//
//        if (department == null) {
//            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Department not found"));
//        }
//
//        List<Employee> employees = new ArrayList<>();
//        for (EmployeeRequest employeeRequest : request.getEmployees()) {
//            Employee employee = new Employee(
//                employeeRequest.getEmployeeId(),
//                employeeRequest.getEmployeeName(),
//                employeeRequest.getEmployeeEmail(),
//                department
//            );
//            employees.add(employee);
//        }
//
//        List<Employee> createdEmployees = employeeService.createEmployees(employees);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "Employees created and associated with the department");
//        response.put("employees", createdEmployees);
//
//        return ResponseEntity.ok(response);
//    }
//








