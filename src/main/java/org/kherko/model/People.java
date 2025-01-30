package org.kherko.model;

import java.util.Date;

public class People {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String gid;
    private String city;
    private String street;
    private int statusTypeId;
    private String gender;
    private String phoneNumber;
    private int male;
    private int female;
    private Date joinDate;
    private String notes;

    public People() {
    }

    // Constructor With all data
    public People(int id, String firstName, String lastName, String nickName, String gid, String city, String street,
                  int statusTypeId, String gender, int male, int female, Date joinDate, String notes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName != null ? lastName : "Unknown";
        this.nickName = nickName != null ? nickName : "No Nickname";
        this.gid = gid;
        this.city = city != null ? city : "Unknown";
        this.street = street != null ? street : "Unknown";
        this.statusTypeId = statusTypeId;
        this.gender = gender.equals("Male") ? "M" : gender.equals("Female") ? "F" : null;
        this.male = male;
        this.female = female;
        this.joinDate = joinDate != null ? joinDate : new Date();
        this.notes = notes != null ? notes : null;
    }

    // Constructor Without id
    public People(String firstName, String lastName, String nickName, String gid, String city, String street,
                  int statusTypeId, String gender, int male, int female, Date joinDate, String notes) {
        this.firstName = firstName;
        this.lastName = lastName != null ? lastName : "Unknown";
        this.nickName = nickName != null ? nickName : "No Nickname";
        this.gid = gid;
        this.city = city != null ? city : "Unknown";
        this.street = street != null ? street : "Unknown";
        this.statusTypeId = statusTypeId;
        this.gender = gender.equals("Male") ? "M" : gender.equals("Female") ? "F" : null;
        this.male = male;
        this.female = female;
        this.joinDate = joinDate != null ? joinDate : new Date();
        this.notes = notes != null ? notes : null;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public int getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(int statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
