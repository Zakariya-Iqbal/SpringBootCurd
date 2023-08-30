package com.spring.dto;



import java.util.List;

public class CreateEmployeesRequest {
    private int departmentId;
    private String departmentName;
    private String departmentManager;
    private List<EmployeeRequest> employees;
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentManager() {
        return departmentManager;
    }
    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
    }
    public List<EmployeeRequest> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmployeeRequest> employees) {
        this.employees = employees;
    }
    public CreateEmployeesRequest(int departmentId, String departmentName, String departmentManager,
                                  List<EmployeeRequest> employees) {
        super();
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
        this.employees = employees;
    }
    public CreateEmployeesRequest() {
        super();
        // TODO Auto-generated constructor stub
    }



}




















