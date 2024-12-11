package builders;

import model.People;

import java.util.Date;

public class PeopleBulder {
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

    public PeopleBulder id(int id) {
        this.id = id;
        return this;
    }
    public PeopleBulder name(String name) {
        this.name = name;
        return this;
    }
    public PeopleBulder nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    public PeopleBulder birthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }
    public PeopleBulder location(String location) {
        this.location = location;
        return this;
    }
    public PeopleBulder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public PeopleBulder gender(boolean gender) {
        this.gender = gender;
        return this;
    }
    public PeopleBulder gid(long gid) {
        this.gid = gid;
        return this;
    }
    public PeopleBulder notes(String notes) {
        this.notes = notes;
        return this;
    }
    public PeopleBulder joundate(Date joundate) {
        this.joundate = joundate;
        return this;
    }

    public People build() {
        return new People(
                id,
                name,
                nickname,
                birthdate,
                location,
                phone,
                gender,
                gid,
                notes,
                joundate
        );
    }



}
