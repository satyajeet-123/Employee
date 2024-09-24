package com.example.dao;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
}
