package org.kherko.dao;

import org.kherko.model.People;

import java.util.List;

public interface PeopleDao {

    List<People> getAll();  // Return all people

    People getById(int id); // Return person by ID

    People getByGid(String gid); // Return person by GID

    List<People> getByName(String name); // Return people by Name

    List<People> getByNickname(String nickname); // Return people by Nickname

    List<People> getByLocation(String location); // Return people by Location

    People getByPhone(String phone); // Return person by Phone

    List<People> getByGender(char gender); //  Return people by Gender

    List<People> getByJoinDate(String joinDate); // Return person by Join Date

    void addPerson(People person); // Add New person

    void updatePerson(People person); // Update Person Data

    void deletePerson(int id); // Delete person by ID

}
