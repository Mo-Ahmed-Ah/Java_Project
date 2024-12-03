package org.example.dao;

import org.example.model.Employee;
import util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOTmpl implements EmployeeDAO{
    @Override
    public Employee createUser(String name) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return null;
        }
        List<Employee>  employeeList =  new LinkedList<>();
        String query = "SELECT * FROM employee";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = Employee.builder()
                            .id(resultSet.getInt("id"))
                            .name(resultSet.getString("name"))
                            .gender(resultSet.getBoolean("gender"))
                            .birthdate(resultSet.getDate("birth_date"))
                            .salary(resultSet.getDouble("salary"))
                            .build();
                employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return null;
        }
        String query = "SELECT * FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birthdate(resultSet.getDate("birth_date"))
                        .salary(resultSet.getDouble("salary"))
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

    @Override
    public Employee findByName(String name) {
        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return null;
        }
        String query = "SELECT * FROM employee WHERE name=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .birthdate(resultSet.getDate("birth_date"))
                        .salary(resultSet.getDouble("salary"))
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

    @Override
    public Employee findAllBySalary(double salary) {
        return null;
    }

    @Override
    public void create(Employee employee) {
        Connection conn = DBConnection.getConnection();
        if(conn == null){
            return;
        }
        String query = "INSERT INTO employee (name , gender , birth_date , salary) VALUES (?,?,?,?)";
//            java close the preparedStatement after end the try statement
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {


            preparedStatement.setString(1, employee.getName());
            preparedStatement.setBoolean(2, employee.isGender());
            /*
             * Using getSqlDate from my Utils class from my util package.
             * */
            preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthdate()));
            preparedStatement.setDouble(4, employee.getSalary());


            preparedStatement.executeUpdate();

        } catch (SQLException es) {
            es.printStackTrace();
        } finally {
//                close connection object
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void update(Employee employee) {
        Connection conn = DBConnection.getConnection();
        if(conn == null){
            return;
        }
        //update user data if id != 0
        String query = "UPDATE employee SET name=?, gender=?, birth_date=?, salary=? WHERE id=?";
//            java close the preparedStatement after end the try statement
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){


            preparedStatement.setString(1,employee.getName());
            preparedStatement.setBoolean(2,employee.isGender());
            /*
             * Using getSqlDate from my Utils class from my util package.
             * */
            preparedStatement.setDate(3, Utils.getSqlDate(employee.getBirthdate()));
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setDouble(5,employee.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException es) {
            es.printStackTrace();
        }finally {
//                close connection object
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("updated");
        }

    }

    @Override
    public void deleteById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return;
        }
        String query = "DELETE FROM employee WHERE id=?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("True delete anyone");
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                conn.close();
                System.out.println("True conn close");
            }catch (SQLException se){
                se.printStackTrace();
            }
        }

    }

}
