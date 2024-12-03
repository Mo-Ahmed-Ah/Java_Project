package org.example.model;

import java.util.Date;

public class EmpolyeeBuilder {
    private int id ;
    private String name ;
    private boolean gender ;
    private Date birthdate ;
    private double salary ;

    public EmpolyeeBuilder id(int id){
        this.id = id;
        return this;
    }public EmpolyeeBuilder name(String name){
        this.name = name;
        return this;
    }public EmpolyeeBuilder gender(boolean gender){
        this.gender = gender;
        return this;
    }public EmpolyeeBuilder birthdate(Date birthdate){
        this.birthdate = birthdate;
        return this;
    }public EmpolyeeBuilder salary(double salary){
        this.salary = salary;
        return this;
    }

    public Employee build(){
        return new Employee(id,name,gender,birthdate,salary);
    }
}
