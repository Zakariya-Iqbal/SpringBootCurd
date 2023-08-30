package com.spring.services;



import java.util.ArrayList;
import java.util.List;
import com.spring.entity.Department;
import com.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }
//    public Department createDepartment(Department department) {
//        return departmentRepository.save(department);
//    }

    public Department createDepartment(Department department) {
        if (department.getDepartmentName() == null || department.getDepartmentName().isEmpty() ||
                department.getDepartmentManager() == null || department.getDepartmentManager().isEmpty()) {
            // Return an error response indicating that department details are incomplete
            throw new IllegalArgumentException("Department name and manager are required.");
        }
        return departmentRepository.save(department);
    }


    public Department getDepartmentByDetails(int departmentId, String departmentName, String departmentManager) {
        return departmentRepository.findByDepartmentIdAndDepartmentNameAndDepartmentManager(
                departmentId, departmentName, departmentManager
        );
    }


    public Department updateDepartment(Integer id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setDepartmentName(department.getDepartmentName());
            existingDepartment.setDepartmentManager(department.getDepartmentManager());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }


//	public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
//		  Department department = departmentRepository.findById(departmentId).orElse(null);
//	        if (department != null) {
//	            return department.getEmployeeList();
//	        }
//	        return new ArrayList<>();
//	}


}

