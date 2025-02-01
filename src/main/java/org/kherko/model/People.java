package org.kherko.model;

import java.util.Date;

public class People {
    private int id;
    private String firstName;
    private String lastName;
    private String gid;
    private String city;
    private String street;
    private int maleChild;
    private int femaleChild;
    private String status;
    private String notes;
    private Date joinDate;

    public People() {
    }

    public People(int id, String firstName, String lastName, String gid, String city, String street,
                  int maleChild, int femaleChild, String status, String notes, Date joinDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName != null ? lastName : "Unknown";
        this.gid = gid;
        this.city = city != null ? city : "Unknown";
        this.street = street != null ? street : "Unknown";
        this.maleChild = maleChild;
        this.femaleChild = femaleChild;
        this.status = status != null ? status : "أعزب";
        this.notes = notes;
        this.joinDate = joinDate != null ? joinDate : new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getMaleChild() {
        return maleChild;
    }

    public void setMaleChild(int maleChild) {
        this.maleChild = maleChild;
    }

    public int getFemaleChild() {
        return femaleChild;
    }

    public void setFemaleChild(int femaleChild) {
        this.femaleChild = femaleChild;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
