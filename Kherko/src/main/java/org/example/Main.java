package org.example;

import org.example.model.Employee;
import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOTmpl;

import java.util.Date;

/*
* Before run code you must run pom.xml file , Because install all resources same database connector etc...
* */
public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOTmpl();
        Employee employee = Employee.builder()
            .name("Ahmed")
            .gender(true)
            .birthdate(new Date())
            .salary(2020d)
            .build();
        employeeDAO.create(employee);
    }
}