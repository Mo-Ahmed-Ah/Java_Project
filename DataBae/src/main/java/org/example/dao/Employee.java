package org.example.dao;

import java.util.Date;

public class Employee {
    private int id ;
    private String name ;
    private boolean gender ;
    private Date birthdate ;
    private double salary ;

    public Employee() {
    }

    public Employee(int id, String name, boolean gender, Date birthdate, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", gender = " + gender +
                ", birthdate = " + birthdate +
                ", salary = " + salary +
                '}';
    }
}
