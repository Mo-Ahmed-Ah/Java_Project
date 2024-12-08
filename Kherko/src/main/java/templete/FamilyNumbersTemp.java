package templete;

import database.DBConnection;
import database.FemailNumbersDB;
import model.FamilyNumbers;
import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FamilyNumbersTemp implements FemailNumbersDB {
    @Override
    public void addingMail(int mailnumber , int id ) {


    }

    @Override
    public void addingFemail(int femailnumbers , int id ) {
        String query = "INSERT INTO family_numbers ('status_id' , 'fmail') VALUES ('" + femailnumbers + "');";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return;
            }

            preparedStatement.setInt(1, id);

            preparedStatement.executeQuery();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return;
    }

    @Override
    public void updateMail(int newmailnumbers , int id ) {

    }

    @Override
    public void updateFemail(int newfemailnumbers , int id ) {

    }

    @Override
    public int getMailNumbers(int id) {
        String query = "SELECT mail FROM family_numbers WHERE status_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            if (conn == null) {
                return 0;
            }

            preparedStatement.setInt(1, id);

            return preparedStatement.executeQuery().getInt("mail");
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getFemailNumbers(int id) {
        return 0;
    }

    @Override
    public FamilyNumbers getBoth(int id) {
        return null;
    }
}
