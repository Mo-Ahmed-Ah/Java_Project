package org.example.dao;

import util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOTmpl implements EmployeeDAO{
    @Override
    public Employee createUser(String name) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public Employee findAllByName(String name) {
        return null;
    }

    @Override
    public Employee findAllBySalary(double salary) {
        return null;
    }

    @Override
    public void sava(Employee employee) {
        Connection conn = DBConnection.getConnection();
        if(conn == null){
            return;
        }
        if(employee.getId() > 0){//update user data if id != 0

        }else {// create user if id = 0
            String query = "INSERT INTO employee (name , gender , birth_date , salary) VALUES (?,?,?)";
//            java close the preparedStatement after end the try statement
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)){


                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender());
                /*
                * Using getSqlDate from my Utils class from my util package.
                * */
                preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthdate()));
                preparedStatement.setDouble(4,employee.getSalary());

                preparedStatement.executeUpdate();

            } catch (SQLException es) {
                es.printStackTrace();
            }finally {
//                close connection object
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void deleteById(int id) {

    }
}
