package com.spring.dto;



public class EmployeeRequest {
    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private int departmentId;
    private String departmentName;
    private String departmentManager;
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
    public EmployeeRequest(int employeeId, String employeeName, String employeeEmail, int departmentId,
                           String departmentName, String departmentManager) {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
    }
    public EmployeeRequest() {
        super();
        // TODO Auto-generated constructor stub
    }



}
