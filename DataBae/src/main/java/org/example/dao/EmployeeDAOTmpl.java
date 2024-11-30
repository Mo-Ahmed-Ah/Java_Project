package org.example.dao;

import java.util.List;

public class EmployeeDAOTmpl implements EmployeeDAO{
    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee findAllById(int id) {
        return null;
    }

    @Override
    public Employee findAllByName(String name) {
        return null;
    }

    @Override
    public Employee findAllBySalary(double salary) {
        return null;
    }

    @Override
    public void sava(Employee employee) {

    }

    @Override
    public void deleteById(int id) {

    }
}
