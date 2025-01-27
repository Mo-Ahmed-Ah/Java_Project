package org.kherko.model;


import java.util.Date;

public class People {
    private int id;
    private String name;
    private String nickname;
    private Date birthdate;
    private String location;
    private String phone;
    private String gender;
    private String gid;
    private String notes;
    private Date joindate;
    private int familynumbers;
    private String statustitle;

    public People() {
    }

    public People(int id ,String name, String nickname, Date birthdate, String location, String phone, String gender, String gid, String notes, Date joindate , int familynumbers , String statustitle) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.birthdate = birthdate;
        this.location = location;
        this.phone = phone;
        this.gender = gender;
        this.gid = gid;
        this.notes = notes;
        this.joindate = joindate;
        this.familynumbers = familynumbers;
        this.statustitle = statustitle;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public int getFamilynumbers() {
        return familynumbers;
    }

    public void setFamilynumbers(int familynumbers) {
        this.familynumbers = familynumbers;
    }

    public String getStatustitle() {
        return statustitle;
    }

    public void setStatustitle(String statustitle) {
        this.statustitle = statustitle;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthdate=" + birthdate +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", gid='" + gid + '\'' +
                ", notes='" + notes + '\'' +
                ", joindate=" + joindate +
                ", familynumbers=" + familynumbers +
                ", statustitle='" + statustitle + '\'' +
                '}';
    }


}
