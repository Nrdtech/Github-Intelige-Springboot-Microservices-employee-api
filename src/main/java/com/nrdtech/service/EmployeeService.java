package com.nrdtech.service;

import com.nrdtech.model.Employee;

import java.util.List;


public interface EmployeeService {

    public Employee saveEmployeeDetails(Employee emp);
    public List<Employee> getEmployees();
    public Employee getEmployeesById(int id);
}
