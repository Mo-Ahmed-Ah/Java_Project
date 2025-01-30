package org.kherko.implementation;

import org.kherko.dao.PeopleDao;
import org.kherko.model.People;
import org.kherko.util.DatabaseConnection;
import org.kherko.util.SpecialFunctions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeopleImp implements PeopleDao {
    private static final Logger logger = Logger.getLogger(PeopleImp.class.getName());

    @Override
    public void addPerson(People person) {
        String insertPersonQuery = "INSERT INTO People (fname, lname, nickname, city, street, phone, gender, gid, notes, joindate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String insertPeopleStatusQuery = "INSERT INTO People_Status (people_ID, stat_ID) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {

            // بداية المعاملة
            conn.setAutoCommit(false);

            // إضافة الشخص إلى جدول People
            try (PreparedStatement peopleStmt = conn.prepareStatement(insertPersonQuery, Statement.RETURN_GENERATED_KEYS)) {
                peopleStmt.setString(1, person.getFirstName());
                peopleStmt.setString(2, person.getLastName());
                peopleStmt.setString(3, person.getNickName());
                peopleStmt.setString(4, person.getCity());
                peopleStmt.setString(5, person.getStreet());
                peopleStmt.setString(6, person.getPhoneNumber());
                peopleStmt.setString(7, person.getGender());
                peopleStmt.setString(8, person.getGid());
                peopleStmt.setString(9, person.getNotes());
                peopleStmt.setDate(10, new java.sql.Date(person.getJoinDate().getTime()));

                int affectedRows = peopleStmt.executeUpdate();

                if (affectedRows > 0) {
                    ResultSet generatedKeys = peopleStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int personId = generatedKeys.getInt(1);  // الحصول على ID للشخص الذي تم إضافته

                        // ربط الشخص بحالة موجودة في جدول People_Status باستخدام stat_ID
                        try (PreparedStatement peopleStatusStmt = conn.prepareStatement(insertPeopleStatusQuery)) {
                            // ربط الشخص بالحالة باستخدام معرف الحالة (ID)
                            int statusId = person.getStatusTypeId(); // استخدام الـ ID الخاص بالحالة
                            peopleStatusStmt.setInt(1, personId);
                            peopleStatusStmt.setInt(2, statusId); // تحديد المعرف هنا

                            peopleStatusStmt.executeUpdate();  // تنفيذ الربط بين الشخص والحالة
                        }
                    }
                }

                // إنهاء المعاملة
                conn.commit();
            } catch (SQLException se) {
                // في حالة حدوث خطأ، التراجع عن المعاملة
                conn.rollback();
                logger.log(Level.SEVERE, "Error while adding person: " + se.getMessage(), se);
            }

        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Error while connecting to the database: " + se.getMessage(), se);
        }
    }


    @Override
    public List<People> getAll() {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT people.id, people.fname, people.lname, people.nickname, people.city, people.street, people.phone, people.gender, people.gid, people.notes, people.joindate, status.stat_name " +
                "FROM People people " +
                "LEFT JOIN People_Status ps ON people.id = ps.people_ID " +
                "LEFT JOIN Status status ON ps.stat_ID = status.id";

        try (Connection conn = DatabaseConnection.getConnection();  // الحصول على الاتصال
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();  // تنفيذ الاستعلام

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),  // تعديل هنا لقراءة "gid" كـ String
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),  // تعديل هنا لقراءة "stat_name" كـ String
                        resultSet.getString("gender"),
                        0,  // إزالة قيم male و female إذا لم تكن موجودة في الاستعلام
                        0,  // إزالة قيم male و female
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);  // إضافة الشخص إلى القائمة
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch all people data: " + se.getMessage(), se);
        }

        return peopleList;  // إرجاع قائمة الأشخاص
    }



    @Override
    public People getById(int id) {
        People people = null;
        if (id != 0) {
            String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                    "FROM People p " +
                    "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                    "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                    "WHERE p.id = ?;";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(query)) {

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    people = new People(
                            resultSet.getInt("id"),
                            resultSet.getString("fname"),
                            resultSet.getString("lname"),
                            resultSet.getString("nickname"),
                            resultSet.getString("gid"),
                            resultSet.getString("city"),
                            resultSet.getString("street"),
                            resultSet.getInt("stat_name"),  // الحالة المرتبطة
                            resultSet.getString("gender"),
                            resultSet.getInt("male"),
                            resultSet.getInt("female"),
                            resultSet.getDate("joindate"),
                            resultSet.getString("notes")
                    );
                }
            } catch (SQLException se) {
                logger.log(Level.SEVERE, "Failed to fetch person data: " + se.getMessage(), se);
            }
        }
        return people;
    }


    @Override
    public List<People> getByName(String name) {
        List<People> peopleList = new ArrayList<>();  // قائمة لتخزين الأشخاص الذين يطابقون الاسم
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.fname LIKE ? OR p.lname LIKE ?;";  // استعلام للبحث باستخدام LIKE

        try (Connection conn = DatabaseConnection.getConnection();  // الحصول على الاتصال
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            // إضافة "العلامة المئوية" للبحث الجزئي
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();  // تنفيذ الاستعلام

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),  // الحالة المرتبطة
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);  // إضافة الشخص إلى القائمة
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch people by name: " + se.getMessage(), se);
        }

        return peopleList;  // إرجاع قائمة الأشخاص الذين يطابقون الاسم
    }


    @Override
    public List<People> getByNickname(String nickname) {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.nickname LIKE ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + nickname + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch people by nickname: " + se.getMessage(), se);
        }

        return peopleList;
    }

    @Override
    public People getByGid(String gid) {
        People person = null;
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.gid = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, gid);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch person by GID: " + se.getMessage(), se);
        }

        return person;
    }

    @Override
    public List<People> getByGender(String gender) {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.gender = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, gender);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch people by gender: " + se.getMessage(), se);
        }

        return peopleList;
    }

    @Override
    public List<People> getByLocation(String city, String street) {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.city LIKE ? AND p.street LIKE ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + city + "%");
            preparedStatement.setString(2, "%" + street + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch people by location: " + se.getMessage(), se);
        }

        return peopleList;
    }

    @Override
    public People getByPhone(String phone) {
        People person = null;
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.phone = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, phone);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch person by phone: " + se.getMessage(), se);
        }

        return person;
    }

    @Override
    public List<People> getByStatusType(String statusName) {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE s.stat_name = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, statusName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch people by status: " + se.getMessage(), se);
        }

        return peopleList;
    }

    @Override
    public List<People> getByJoinDate(String joinDate) {
        List<People> peopleList = new ArrayList<>();
        String query = "SELECT p.id, p.fname, p.lname, p.nickname, p.city, p.street, p.phone, p.gender, p.gid, p.notes, p.joindate, s.stat_name " +
                "FROM People p " +
                "LEFT JOIN People_Status ps ON p.id = ps.people_ID " +
                "LEFT JOIN Status s ON ps.stat_ID = s.id " +
                "WHERE p.joindate = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, joinDate);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People person = new People(
                        resultSet.getInt("id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("nickname"),
                        resultSet.getString("gid"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("stat_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("male"),
                        resultSet.getInt("female"),
                        resultSet.getDate("joindate"),
                        resultSet.getString("notes")
                );

                peopleList.add(person);
            }
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to fetch people by join date: " + se.getMessage(), se);
        }

        return peopleList;
    }

    @Override
    public void updatePerson(People person, int personId) {
        String query = "UPDATE People SET fname = ?, lname = ?, nickname = ?, city = ?, street = ?, phone = ?, gender = ?, notes = ?, joindate = ? WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getNickName());
            preparedStatement.setString(4, person.getCity());
            preparedStatement.setString(5, person.getStreet());
            preparedStatement.setString(6, person.getPhoneNumber());
            preparedStatement.setString(7, person.getGender());
            preparedStatement.setString(8, person.getNotes());
            preparedStatement.setDate(9, new java.sql.Date(person.getJoinDate().getTime()));
            preparedStatement.setInt(10, personId);

            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to update person: " + se.getMessage(), se);
        }
    }

    @Override
    public void deletePerson(int id) {
        String query = "DELETE FROM People WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            logger.log(Level.SEVERE, "Failed to delete person: " + se.getMessage(), se);
        }
    }

}
