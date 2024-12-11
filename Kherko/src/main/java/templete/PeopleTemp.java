package templete;

import database.DBConnection;
import database.PeopleDB;
import model.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleTemp implements PeopleDB {

    @Override
    public void addPeople(People People) {
        String query = "INSERT INTO people (name, nickname, birthdate, location, phone, gender, gid, notes, joundate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                System.out.println("Failed to connect to the database.");
                return;
            }

            preparedStatement.setString(1, People.getName());
            preparedStatement.setString(2, People.getNickname());
            preparedStatement.setDate(3, new java.sql.Date(People.getBirthdate().getTime()));
            preparedStatement.setString(4, People.getLocation());
            preparedStatement.setString(5, People.getPhone());
            preparedStatement.setBoolean(6, People.getGender().equals("male"));
            preparedStatement.setLong(7, People.getGid());
            preparedStatement.setString(8, People.getNotes());
            preparedStatement.setDate(9, new java.sql.Date(People.getJoundate().getTime()));

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Status added successfully.");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }


    @Override
    public List<People> getAll() {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT * FROM people";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (conn == null) {
                return null;
            }

            while (resultSet.next()) {
                People people = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
                peopleList.add(people);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return peopleList;
    }


    @Override
    public People getPeopleById(int id) {
        String query = "SELECT * FROM people WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }


    @Override
    public List<People> getPeoplesByName(String name) {
        List<People> statusList = new ArrayList<>();
        String query = "SELECT * FROM people WHERE name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                People people = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
                statusList.add(people);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return statusList;
    }


    @Override
    public People getPeoplesByPhone(String phone) {
        String query = "SELECT * FROM people WHERE phone = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }


    @Override
    public List<People> getPeoplesByNickname(String nickname) {
        List<People> peoplesList = new ArrayList<>();
        String query = "SELECT * FROM people WHERE nickname LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, "%" + nickname + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                People people = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
                peoplesList.add(people);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return peoplesList;
    }


    @Override
    public List<People> getPeoplesByLocation(String location) {
        List<People> statusList = new ArrayList<>();
        String query = "SELECT * FROM people WHERE location LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, "%" + location + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                People status = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
                statusList.add(status);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return statusList;
    }

    @Override
    public List<People> getPeoplesByJoundate(Date joundate) {
        List<People> peoplesList = new ArrayList<>();
        String query = "SELECT * FROM people WHERE joundate = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setDate(1, new java.sql.Date(joundate.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                People people = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
                peoplesList.add(people);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return peoplesList;
    }

    @Override
    public List<People> getPeoplesByGender(boolean gender) {
        List<People> peoplesList = new ArrayList<>();
        String query = "SELECT * FROM people WHERE gender = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setBoolean(1, gender);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                People people = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
                peoplesList.add(people);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return peoplesList;
    }

    @Override
    public People getPeopleByGid(int gid) {

        String query = "SELECT * FROM people WHERE gid = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setInt(1, gid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .nickname(resultSet.getString("nickname"))
                        .birthdate(resultSet.getDate("birthdate"))
                        .location(resultSet.getString("location"))
                        .phone(resultSet.getString("phone"))
                        .gender(resultSet.getBoolean("gender"))
                        .gid(resultSet.getInt("gid"))
                        .notes(resultSet.getString("notes"))
                        .joundate(resultSet.getDate("joundate"))
                        .build();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }


    @Override
    public void updatePeople(People people) {
        String query = "UPDATE status SET name = ?, nickname = ?, birthdate = ?, location = ?, phone = ?, gender = ?, gid = ?, notes = ?, joundate = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return;
            }

            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getNickname());
            preparedStatement.setDate(3, new java.sql.Date(people.getBirthdate().getTime()));
            preparedStatement.setString(4, people.getLocation());
            preparedStatement.setString(5, people.getPhone());
            preparedStatement.setBoolean(6, people.getGender().equals("male"));
            preparedStatement.setLong(7, people.getGid());
            preparedStatement.setString(8, people.getNotes());
            preparedStatement.setDate(9, new java.sql.Date(people.getJoundate().getTime()));
            preparedStatement.setInt(10, people.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status updated successfully.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }


    @Override
    public void deletePeople(int id) {
        String query = "DELETE FROM people WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return;
            }

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Status deleted successfully.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
