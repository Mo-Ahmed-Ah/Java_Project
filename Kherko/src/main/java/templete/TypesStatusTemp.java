package templete;

import database.DBConnection;
import database.TypesStatusDB;
import model.TypesStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TypesStatusTemp implements TypesStatusDB {@Override
    public void addstatus(String statustitle) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            System.out.println("Failed to connect to the database.");
            return;
        }
        String query = "INSERT INTO types_status (statustitle) VALUES (?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, statustitle);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Status added successfully.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public List<TypesStatus> getall() {
        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return null;
        }
        List<TypesStatus>  typesStatusList =  new LinkedList<>();
        String query = "SELECT * FROM types_status";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                model.TypesStatus status = TypesStatus.builder()
                        .id(resultSet.getInt("id"))
                        .statustitle(resultSet.getString("statustitle"))
                        .build();
                typesStatusList.add(status);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return typesStatusList;
    }

    @Override
    public TypesStatus getStatusByTitle(String statustitle) {
        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return null;
        }
        String query = "SELECT * FROM types_status WHERE statustitle = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setString(1,statustitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return TypesStatus.builder()
                        .id(resultSet.getInt("id"))
                        .statustitle(resultSet.getString("statustitle"))
                        .build();
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return  null;
    }
}
