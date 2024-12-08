package templete;

import database.DBConnection;
import database.StatusDB;
import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatusTemp implements StatusDB {

    @Override
    public void addStatus(Status status) {
        String query = "INSERT INTO status (name, nickname, birthdate, location, phone, gender, gid, notes, joundate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                System.out.println("Failed to connect to the database.");
                return;
            }

            preparedStatement.setString(1, status.getName());
            preparedStatement.setString(2, status.getNickname());
            preparedStatement.setDate(3, new java.sql.Date(status.getBirthdate().getTime()));
            preparedStatement.setString(4, status.getLocation());
            preparedStatement.setString(5, status.getPhone());
            preparedStatement.setBoolean(6, status.getGender().equals("male"));
            preparedStatement.setLong(7, status.getGid());
            preparedStatement.setString(8, status.getNotes());
            preparedStatement.setDate(9, new java.sql.Date(status.getJoundate().getTime()));

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Status added successfully.");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }


    @Override
    public List<Status> getAll() {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM status";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (conn == null) {
                return null;
            }

            while (resultSet.next()) {
                Status status = Status.builder()
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
    public Status getStatusById(int id) {
        String query = "SELECT * FROM status WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Status.builder()
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
    public List<Status> getStatusByName(String name) {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM status WHERE name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.builder()
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
    public Status getStatusByPhone(String phone) {
        String query = "SELECT * FROM status WHERE phone = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Status.builder()
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
    public List<Status> getStatusByNickname(String nickname) {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM status WHERE nickname LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, "%" + nickname + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.builder()
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
    public List<Status> getStatusByLocation(String location) {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM status WHERE location LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setString(1, "%" + location + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.builder()
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
    public List<Status> getStatusByJoundate(Date joundate) {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM status WHERE joundate = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setDate(1, new java.sql.Date(joundate.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.builder()
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
    public List<Status> getStatusByGender(boolean gender) {
        List<Status> statusList = new ArrayList<>();
        String query = "SELECT * FROM status WHERE gender = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setBoolean(1, gender);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Status status = Status.builder()
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
    public Status getStatusByGid(int gid) {

        String query = "SELECT * FROM status WHERE gid = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return null;
            }

            preparedStatement.setInt(1, gid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Status.builder()
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
    public void updateStatus(Status status) {
        String query = "UPDATE status SET name = ?, nickname = ?, birthdate = ?, location = ?, phone = ?, gender = ?, gid = ?, notes = ?, joundate = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return;
            }

            preparedStatement.setString(1, status.getName());
            preparedStatement.setString(2, status.getNickname());
            preparedStatement.setDate(3, new java.sql.Date(status.getBirthdate().getTime()));
            preparedStatement.setString(4, status.getLocation());
            preparedStatement.setString(5, status.getPhone());
            preparedStatement.setBoolean(6, status.getGender().equals("male"));
            preparedStatement.setLong(7, status.getGid());
            preparedStatement.setString(8, status.getNotes());
            preparedStatement.setDate(9, new java.sql.Date(status.getJoundate().getTime()));
            preparedStatement.setInt(10, status.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status updated successfully.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }


    @Override
    public void deleteStatus(int id) {
        String query = "DELETE FROM status WHERE id = ?";
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
