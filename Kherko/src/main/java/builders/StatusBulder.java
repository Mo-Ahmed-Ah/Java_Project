package builders;

import model.Status;

import java.util.Date;

public class StatusBulder {
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

    public StatusBulder id(int id) {
        this.id = id;
        return this;
    }
    public StatusBulder name(String name) {
        this.name = name;
        return this;
    }
    public StatusBulder nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    public StatusBulder birthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }
    public StatusBulder location(String location) {
        this.location = location;
        return this;
    }
    public StatusBulder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public StatusBulder gender(boolean gender) {
        this.gender = gender;
        return this;
    }
    public StatusBulder gid(long gid) {
        this.gid = gid;
        return this;
    }
    public StatusBulder notes(String notes) {
        this.notes = notes;
        return this;
    }
    public StatusBulder joundate(Date joundate) {
        this.joundate = joundate;
        return this;
    }

    public Status build() {
        return new Status(
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
