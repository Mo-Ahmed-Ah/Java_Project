package org.kherko.dao;

import org.kherko.model.People;
import java.util.List;

/**
 * This interface defines the Data Access Object (DAO) for interacting with the "People" table in the database.
 * It includes method signatures for adding, deleting, retrieving, and updating people records.
 */
public interface PeopleDao {

    /**
     * Adds a new person to the database.
     * @param person The person object to be added.
     */
    void addPerson(People person);

    /**
     * Retrieves all people from the database.
     * @return A list of all people.
     */
    List<People> getAll();

    /**
     * Retrieves a person by their unique ID.
     * @param id The ID of the person.
     * @return The person object if found, otherwise null.
     */
    People getById(int id);

    /**
     * Retrieves people by their first name.
     * @param name The name to search for.
     * @return A list of people matching the name.
     */
    List<People> getByName(String name);

    /**
     * Retrieves people by their nickname.
     * @param nickname The nickname to search for.
     * @return A list of people matching the nickname.
     */
    List<People> getByNickname(String nickname);

    /**
     * Retrieves a person by their unique GID.
     * @param gid The GID of the person.
     * @return The person object if found, otherwise null.
     */
    People getByGid(String gid);

    /**
     * Retrieves people by their gender.
     * @param gender The gender to search for ("M" or "F").
     * @return A list of people matching the gender.
     */
    List<People> getByGender(String gender);

    /**
     * Retrieves people by their location (city and street).
     * @param city The city to search for.
     * @param street The street to search for.
     * @return A list of people matching the location.
     */
    List<People> getByLocation(String city, String street);

    /**
     * Retrieves a person by their phone number.
     * @param phone The phone number to search for.
     * @return The person object if found, otherwise null.
     */
    People getByPhone(String phone);

    /**
     * Retrieves people by their status type.
     * @param statusName The status type to search for.
     * @return A list of people matching the status type.
     */
    List<People> getByStatusType(String statusName);

    /**
     * Retrieves people by their join date.
     * @param joinDate The join date to search for.
     * @return A list of people who joined on the specified date.
     */
    List<People> getByJoinDate(String joinDate);

    /**
     * Updates a person's data in the database.
     * @param person The updated person object.
     * @param personId The ID of the person to update.
     */
    void updatePerson(People person, int personId);

    /**
     * Deletes a person from the database by ID.
     * @param id The ID of the person to delete.
     */
    void deletePerson(int id);
}
