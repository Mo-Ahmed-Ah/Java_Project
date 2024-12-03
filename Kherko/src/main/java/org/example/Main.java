package org.example;

import org.example.dao.Employee;
import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOTmpl;

import java.util.Date;

/*
* Before run code you must run pom.xml file , Because install all resources same database connector etc...
* */
public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOTmpl();
        Employee employee = new Employee(1, "moh", true, new Date(), 3000d);
        employeeDAO.update(employee);
        employeeDAO.findAll().forEach(System.out::println);
    }
}