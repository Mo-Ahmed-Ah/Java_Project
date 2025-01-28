package org.kherko.implementation;

import org.kherko.dao.TypeOfHelpingDao;
import org.kherko.model.TypeOfHelping;
import org.kherko.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TypeOfHelpingImp implements TypeOfHelpingDao {
    private static final Logger logger = Logger.getLogger(StatusImp.class.getName());

    @Override
    public void addTypeOfHelping(String name) {
        String query = "INSERT INTO Type_of_helping (helping_name) VALUES (?);";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to insert status: " + se.getMessage(), se);
        }
    }

    @Override
    public void deleteTypeOfHelping(int id) {
        String query = "DELETE FROM Type_of_helping WHERE id=?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to delete status: " + se.getMessage(), se);
        }
    }

    @Override
    public boolean isTrueId(int id) {
        String query = "SELECT 1 FROM Type_of_helping WHERE id = ?;";
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

    @Override
    public List<TypeOfHelping> getAllType() {
        List<TypeOfHelping> statuses = new ArrayList<>();
        String query = "SELECT id, helping_name FROM Type_of_helping;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                statuses.add(new TypeOfHelping(resultSet.getInt("id"), resultSet.getString("helping_name")));
            }

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to retrieve statuses: " + se.getMessage(), se);
        }
        return statuses;
    }
}
