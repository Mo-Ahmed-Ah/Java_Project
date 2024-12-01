package org.example;


import org.example.dao.Employee;
import org.example.dao.EmployeeDAO;
import org.example.dao.EmployeeDAOTmpl;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOTmpl();
        Employee employee = new Employee(2, "mohamed", true, new Date(2004  , 9 , 12), 3000d);


        employeeDAO.sava(employee);
    }
}