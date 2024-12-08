package model;

import builders.StatusBulder;

import java.util.Date;

public class Status {
    private  int id;
    private  String name;
    private  String nickname;
    private  Date birthdate;
    private  String location;
    private  String phone;
    private  boolean gender;
    private  long gid;
    private  String notes;
    private  Date joundate;

    public Status(){

    }

    public Status(int id , String name , String nickname , Date birthdate , String location , String phone , boolean gender, long gid , String notes ,Date joundate ) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.birthdate = birthdate;
        this.location = location;
        this.phone = phone;
        this.gender = gender;
        this.gid = gid;
        this.notes = notes;
        this.joundate = joundate;
    }

    public String getGender() {
        if(this.gender){
            return "mail";
        }
        return "famil";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public long getGid() {
        return gid;
    }

    public String getNotes() {
        return notes;
    }

    public Date getJoundate() {
        return joundate;
    }


    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthdate=" + birthdate +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", gid=" + gid +
                ", notes='" + notes + '\'' +
                ", joundate=" + joundate +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setJoundate(Date joundate) {
        this.joundate = joundate;
    }

    public void setGender(String s) {
    }

    public static StatusBulder builder(){return new StatusBulder();}
}
