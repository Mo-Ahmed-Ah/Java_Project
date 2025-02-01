package org.kherko.implementation;

import org.kherko.dao.PeopleDao;
import org.kherko.model.People;
import org.kherko.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleImp implements PeopleDao {

    @Override
    public void addPerson(People person) {
        String sql = "INSERT INTO People (id, firstName, lastName, gid, city, street, maleChild, femaleChild, status, notes, joinDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person.getId());
            pstmt.setString(2, person.getFirstName());
            pstmt.setString(3, person.getLastName());
            pstmt.setString(4, person.getGid());
            pstmt.setString(5, person.getCity());
            pstmt.setString(6, person.getStreet());
            pstmt.setInt(7, person.getMaleChild());
            pstmt.setInt(8, person.getFemaleChild());
            pstmt.setString(9, person.getStatus());
            pstmt.setString(10, person.getNotes());
            pstmt.setDate(11, new java.sql.Date(person.getJoinDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<People> getAll() {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                People person = new People(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("gid"),
                        rs.getString("city"),
                        rs.getString("street"),
                        rs.getInt("maleChild"),
                        rs.getInt("femaleChild"),
                        rs.getString("status"),
                        rs.getString("notes"),
                        rs.getDate("joinDate")
                );
                peopleList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public People getById(int id) {
        String sql = "SELECT * FROM People WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<People> getByName(String name) {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People WHERE firstName LIKE ? OR lastName LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            pstmt.setString(2, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    People person = new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                    peopleList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public List<People> getByNickname(String nickname) {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People WHERE notes LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nickname + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    People person = new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                    peopleList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public People getByGid(String gid) {
        String sql = "SELECT * FROM People WHERE gid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<People> getByGender(String gender) {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People WHERE status LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + gender + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    People person = new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                    peopleList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public List<People> getByLocation(String city, String street) {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People WHERE city = ? AND street = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, city);
            pstmt.setString(2, street);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    People person = new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                    peopleList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public People getByPhone(String phone) {
        // Assuming phone number is stored in the notes field
        String sql = "SELECT * FROM People WHERE notes LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + phone + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<People> getByStatusType(String statusName) {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People WHERE status = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, statusName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    People person = new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                    peopleList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public List<People> getByJoinDate(String joinDate) {
        List<People> peopleList = new ArrayList<>();
        String sql = "SELECT * FROM People WHERE joinDate = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, java.sql.Date.valueOf(joinDate));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    People person = new People(
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("gid"),
                            rs.getString("city"),
                            rs.getString("street"),
                            rs.getInt("maleChild"),
                            rs.getInt("femaleChild"),
                            rs.getString("status"),
                            rs.getString("notes"),
                            rs.getDate("joinDate")
                    );
                    peopleList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    @Override
    public void updatePerson(People person, int personId) {
        String sql = "UPDATE People SET firstName = ?, lastName = ?, gid = ?, city = ?, street = ?, maleChild = ?, femaleChild = ?, status = ?, notes = ?, joinDate = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2, person.getLastName());
            pstmt.setString(3, person.getGid());
            pstmt.setString(4, person.getCity());
            pstmt.setString(5, person.getStreet());
            pstmt.setInt(6, person.getMaleChild());
            pstmt.setInt(7, person.getFemaleChild());
            pstmt.setString(8, person.getStatus());
            pstmt.setString(9, person.getNotes());
            pstmt.setDate(10, new java.sql.Date(person.getJoinDate().getTime()));
            pstmt.setInt(11, personId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int id) {
        String sql = "DELETE FROM People WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getStatusFromStatusColumnInDataBase() {
        List<String> statusList = new ArrayList<>();
        String sql = "SELECT DISTINCT status FROM People";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                statusList.add(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statusList;
    }

}