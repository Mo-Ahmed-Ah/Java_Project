package database;

import model.People;


import java.util.Date;
import java.util.List;

public interface PeopleDB {
    List<People> getAll();
    People getPeopleById(int id);
    List<People> getPeoplesByName(String name);
    People getPeoplesByPhone(String phone);
    List<People> getPeoplesByNickname(String nickname);
    List<People> getPeoplesByLocation(String location);
    List<People> getPeoplesByJoundate(Date joundate);
    List<People> getPeoplesByGender(boolean gender);
    People getPeopleByGid(int gid);
    void addPeople(People People);
    void updatePeople(People People);
    void deletePeople(int id);

}
