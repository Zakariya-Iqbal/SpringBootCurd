package com.spring.entity;

public class EmployeeDepartment {
    private Integer employeeId;
    private String employeeName;
    private String employeeEmail;
    //  private Department department;
    private Integer  departmentId;
    private String departmentName;
    private String departmentManager;
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
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


    //  public Department getDepartment() {
//			return department;
//		}
//		public void setDepartment(Department department) {
//			this.department = department;
//		}
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
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
    public EmployeeDepartment(Integer employeeId, String employeeName, String employeeEmail, Integer departmentId,
                              String departmentName, String departmentManager)
    //public EmployeeDepartment(Integer employeeId, String employeeName, String employeeEmail, Department department)
    {
        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        //  this.department = department;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
    }
    //		public EmployeeDepartment(int i, String string, String string2, Department department) {
//			super();
//			// TODO Auto-generated constructor stub
//		}
    // Default constructor
    public EmployeeDepartment() {
    }




}
