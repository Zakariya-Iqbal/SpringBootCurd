package com.spring.repository;



import com.spring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDepartmentIdAndDepartmentNameAndDepartmentManager(int departmentId, String departmentName,
                                                                       String departmentManager);

}

