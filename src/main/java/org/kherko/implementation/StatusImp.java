package org.kherko.implementation;

import org.kherko.dao.StatusDao;
import org.kherko.model.Status;
import org.kherko.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatusImp implements StatusDao {
    private static final Logger logger = Logger.getLogger(StatusImp.class.getName());

    @Override
    public void addStatus(String sta_name) {
        String query = "INSERT INTO Status (stat_name) VALUES (?);";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, sta_name);
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to insert status: " + se.getMessage(), se);
        }
    }

    @Override
    public void deleteStatus(int id) {
        String query = "DELETE FROM Status WHERE id=?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to delete status: " + se.getMessage(), se);
        }
    }

    @Override
    public List<Status> getAll() {
        List<Status> statuses = new ArrayList<>();
        String query = "SELECT id, stat_name FROM Status;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                statuses.add(new Status(resultSet.getInt("id"), resultSet.getString("stat_name")));
            }

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to retrieve statuses: " + se.getMessage(), se);
        }
        return statuses;
    }

    @Override
    public String getNameByID(int id) {
        String query = "SELECT stat_name FROM Status WHERE id=?;";
        String name = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    name = resultSet.getString("stat_name");
                }
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to retrieve status name: " + se.getMessage(), se);
        }

        return name;
    }

    @Override
    public boolean isTrueID(int id) {
        String query = "SELECT 1 FROM Status WHERE id = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to check status ID: " + se.getMessage(), se);
        }

        return false;
    }
}
