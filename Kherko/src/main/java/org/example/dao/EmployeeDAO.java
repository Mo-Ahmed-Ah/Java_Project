package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee createUser(String name);
    Employee findById(int id);
    Employee findAllByName(String name);
    Employee findAllBySalary(double salary);

    void create(Employee employee);
    void update(Employee employee);

//    return any employee name with id
    void deleteById(int id);
}
