package model;

import models.Person;
import models.Role;
import utility.IntTrue;
import utility.utilityLog.LogFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmySQLForServlet {

    private static final String BD_URL = "jdbc:mysql://localhost/online_school";
    private static final String USER = "A";
    private static final String PASSWORD = "ssss";


    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(BD_URL, USER, PASSWORD);
    }

    public void addPersonSQL(String lastname, String firstname, Role role) {
        // LogFactory.debug(this.getClass().getName(), "Create new person SQL");

        String addPerson = "INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `role`) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(addPerson);
            statement.setString(1, lastname);
            statement.setString(2, firstname);
            statement.setString(3, String.valueOf(role));
            statement.executeUpdate();
        } catch (SQLException e) {
            LogFactory.warning(this.getClass().getName(), "SQLPS", e.getStackTrace());
        }

    }


    public void addPersonMenuSQL() {

        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            int ask1;
            String addPerson = "INSERT INTO `online_school`.`person` (`role`) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(addPerson);
            do {
                System.out.println("Введіть числове значення для вибору необхідного критерія: \n1 Студент;\n2 Вчитель.");
                ask1 = new IntTrue().intTrue();
            } while (ask1 < 1 | ask1 > 2);

            if (ask1 == 1) {
                System.out.println("Ви створили нового студента.");
                statement.setString(1, "student");
                statement.executeUpdate();

            } else {
                System.out.println("Ви створили нового вчителя.");
                statement.setString(1, "teacher");
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            LogFactory.warning(this.getClass().getName(), "SQLPS", e.getStackTrace());
        }
    }

    public List<Person> personGetAll() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String getAll = "{call get_data_from_table (?) }";
            CallableStatement statement = connection.prepareCall(getAll);
            statement.setString(1, "person");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int idSQL = result.getInt("person_id");
                String lastname = result.getString("lastname");
                String firstname = result.getString("firstname");
                String phone = result.getString("phone");
                String email = result.getString("email");
                String role = result.getString("role");
                Person person = new Person(firstname, lastname, phone, email, idSQL, Role.valueOf(role.toUpperCase()));
                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogFactory.warning(this.getClass().getName(), "JSP", e.getStackTrace());
        }

        return personList;
    }


    public Person personById(int IdFromDB) {
        String person = "SELECT * FROM online_school.person where person_id = " + IdFromDB;
        Person person1 = null;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(person);
            ResultSet result = statement.executeQuery(person);
            while (result.next()) {
                int idSQL = result.getInt("person_id");
                String lastname = result.getString("lastname");
                String firstname = result.getString("firstname");
                String phone = result.getString("phone");
                String email = result.getString("email");
                String role = result.getString("role");
                person1 = new Person(firstname, lastname, phone, email, idSQL, Role.valueOf(role.toUpperCase()));
                System.out.println(person1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogFactory.warning(this.getClass().getName(), "JSP", e.getStackTrace());
        }
        return person1;
    }


    public int countStudent() {
        String countStudent = "SELECT COUNT(role) as role_count FROM online_school.person WHERE role = 'student'";
        int studentTotal = 0;
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(countStudent);
            ResultSet result = statement.executeQuery(countStudent);
            result.next();
            studentTotal = result.getInt("role_count");
            System.out.println("Загальна кількість студентів - " + studentTotal);
            result.close();

        } catch (SQLException e) {
            LogFactory.warning(this.getClass().getName(), "SQLPS", e.getStackTrace());
        }
        return studentTotal;

    }

    public void emailStudentToFile() {

        final String FILE = "Student_Email.txt";

        String emailStudentToFile = "SELECT email FROM online_school.person WHERE role = 'student'";
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(emailStudentToFile);
            ResultSet result = statement.executeQuery(emailStudentToFile);

            Writer writer = new OutputStreamWriter(new FileOutputStream(FILE), StandardCharsets.UTF_8);

            while (result.next()) {
                writer.write(result.getString("email"));
            }

            writer.close();
            result.close();
            LogFactory.info(this.getClass().getName(), "Create new version of students e-mail");

        } catch (SQLException | IOException e) {
            LogFactory.warning(this.getClass().getName(), "SQLPS", e.getStackTrace());
        }
    }

//    public static void main(String[] args) {
//        AmySQLForServlet q = new AmySQLForServlet();
//        q.personById(5);
//    }

}
