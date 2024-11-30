package org.example.dao;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findAllById(int id);
    Employee findAllByName(String name);
    Employee findAllBySalary(double salary);

    void sava(Employee employee);

    void deleteById(int id);
}
