package templete;

import database.DBConnection;
import database.FemailNumbersDB;
import model.FamilyNumbers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FamilyNumbersTemp implements FemailNumbersDB {

    @Override
    public void addingMailAndFemail(int mailnumber, int femailnumber, int id) {
        String query = "INSERT INTO family_numbers (status_id, fmail, mail) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                System.out.println("Connection failed.");
                return;
            }

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, femailnumber);
            preparedStatement.setInt(3, mailnumber);

            preparedStatement.executeUpdate(); // Use executeUpdate for INSERT/UPDATE

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void updateMail(int newmailnumbers, int id) {
        String query = "UPDATE family_numbers SET mail = ? WHERE status_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, newmailnumbers);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void updateFemail(int newfemailnumbers, int id) {
        String query = "UPDATE family_numbers SET fmail = ? WHERE status_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, newfemailnumbers);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public int getMailNumbers(int id) {
        String query = "SELECT mail FROM family_numbers WHERE status_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("mail");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0; // Return 0 if no data is found
    }

    @Override
    public int getFemailNumbers(int id) {
        String query = "SELECT fmail FROM family_numbers WHERE status_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("fmail");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0; // Return 0 if no data is found
    }

    @Override
    public FamilyNumbers getBoth(int id) {
        String query = "SELECT fmail, mail FROM family_numbers WHERE status_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int mail = resultSet.getInt("mail");
                    int fmail = resultSet.getInt("fmail");
                    return new FamilyNumbers(id, fmail, mail);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null; // Return null if no data is found
    }
}
