package org.kherko.implementation;

import org.kherko.dao.TypeOfHelpingDao;
import org.kherko.model.TypeOfHelping;
import org.kherko.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeOfHelpingImp implements TypeOfHelpingDao {

    @Override
    public void addTypeOfHelping(String name) {
        String sql = "INSERT INTO TypeOfHelping (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTypeOfHelping(int id) {
        String sql = "DELETE FROM TypeOfHelping WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isTrueId(int id) {
        String sql = "SELECT COUNT(*) FROM TypeOfHelping WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TypeOfHelping> getAllType() {
        List<TypeOfHelping> typeList = new ArrayList<>();
        String sql = "SELECT * FROM TypeOfHelping";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TypeOfHelping type = new TypeOfHelping(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                typeList.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeList;
    }
}
