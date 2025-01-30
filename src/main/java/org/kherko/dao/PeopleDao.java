package org.kherko.dao;

import org.kherko.model.People;

import java.util.List;

/*
 * 1 - This file represents a Data Access Object (DAO) interface for interacting with the "People" table in the database.
 * 2 - This file contains method signatures that will be implemented by a class that implements this interface.
 * 3 - These methods include adding a person, deleting a person, retrieving all people, retrieving a person by ID, retrieving people by name,
 *     retrieving people by nickname, retrieving a person by GID, retrieving people by gender, retrieving people by location, retrieving a person by phone,
 *     retrieving people by status type, retrieving people by join date, and updating a person's data.
 *
 * 4 - Explanation of methods:
 *       1 - addPerson: Takes a person's data and adds it to the "People" table.
 *       2 - deletePerson: Deletes a person's data from the "People" table, "People Status Type" table, and "Assistant" table.
 *       3 - getAll: Retrieves a list of all people in the "People" table.
 *       4 - getById: Retrieves a specific person based on the provided ID.
 *       5 - getByName: Retrieves a list of people whose names match the provided name.
 *       6 - getByNickname: Retrieves a list of people whose nicknames match the provided nickname.
 *       7 - getByGid: Retrieves a specific person based on the provided GID.
 *       8 - getByGender: Retrieves a list of people whose gender matches the provided gender.
 *       9 - getByLocation: Retrieves a list of people whose location matches the provided city and street.
 *       10 - getByPhone: Retrieves a specific person based on the provided phone number.
 *       11 - getByStatusType: Retrieves a list of people whose status type matches the provided status name.
 *       12 - getByJoinDate: Retrieves a list of people whose join date matches the provided date.
 *       13 - updatePerson: Updates a specific person's data based on the provided ID.
 *       14 - deletePerson: Deletes a specific person based on the provided ID.
 */

public interface PeopleDao {

    void addPerson(People person); // Add a new person

    List<People> getAll();  // Retrieve all people

    People getById(int id); // Retrieve a person by ID

    List<People> getByName(String name); // Retrieve people by name

    List<People> getByNickname(String nickname); // Retrieve people by nickname

    People getByGid(String gid); // Retrieve a person by GID

    List<People> getByGender(String gender); // Retrieve people by gender

    List<People> getByLocation(String city, String street); // Retrieve people by location

    People getByPhone(String phone); // Retrieve a person by phone number

    List<People> getByStatusType(String statusName); // Retrieve people by status type

    List<People> getByJoinDate(String joinDate); // Retrieve people by join date

    void updatePerson(People person, int personId); // Update a person's data

    void deletePerson(int id); // Delete a person by ID

}