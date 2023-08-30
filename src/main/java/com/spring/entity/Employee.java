package com.spring.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_tab")
@JsonIgnoreProperties({"department"})
public class Employee {


    public Employee() {
        super();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_Id")
    private int employeeId;

    @Column(name = "employee_Name")
    private String employeeName;



    @Column(name = "employee_Email")
    private String employeeEmail;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    //cascade.All
    //@JoinColumns({
    @JoinColumn(name = "department_Id",referencedColumnName = "department_Id")
    //@JoinColumn(name = "fk_dept_manager", referencedColumnName = "department_Manager")
    //})

    private Department department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(int employeeId, String employeeName, String employeeEmail, Department department) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.department = department;
    }

    public Integer getDepartmentId() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getDepartmentName() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getDepartmentEmail() {
        // TODO Auto-generated method stub
        return null;
    }






}
