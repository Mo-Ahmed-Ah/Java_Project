package database;

import model.Statue;

import java.util.List;

public interface Statuesmodel {
    List<Statue> getAllStatues();
    void addStatue(int peopleID , int statusID);
    void  removeStatue(int statusID);
    List<Statue> getPeopleStatue(int peopleID);
    List<Statue> getStatuePeople(int StatueID);

}
