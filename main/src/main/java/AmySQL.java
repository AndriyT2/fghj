import models.Role;
import utility.IntTrue;
import utility.utilityLog.LogFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class AmySQL {

    private static final String BD_URL = "jdbc:mysql://localhost/online_school";
    private static final String USER = "A";
    private static final String PASSWORD = "ssss";


    public void addPersonSQL(String lastname, String firstname, Role role) {
        LogFactory.debug(this.getClass().getName(), "Create new person SQL");

        String addPerson = "INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `role`) VALUES ('" + lastname + "', '" + firstname + "', '" + role + "')";
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(addPerson);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void addPersonMenuSQL() {

        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            int ask1;

            do {
                System.out.println("Введіть числове значення для вибору необхідного критерія: \n1 Студент;\n2 Вчитель.");
                ask1 = new IntTrue().intTrue();
            } while (ask1 < 1 | ask1 > 2);

            if (ask1 == 1) {
                System.out.println("Ви створили нового студента.");
                String addPerson = "INSERT INTO `online_school`.`person` (`role`) VALUES ('student')";
                statement.executeUpdate(addPerson);

            } else {
                System.out.println("Ви створили нового вчителя.");
                String addPerson = "INSERT INTO `online_school`.`person` (`role`) VALUES ('teacher')";
                statement.executeUpdate(addPerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void personSortByLastnameSQL() {
        String personSortByLastnameSQL = "SELECT * FROM online_school.person order by lastname";
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(personSortByLastnameSQL);
            while (result.next()) {
                int id = result.getInt("person_id");
                String lastname = result.getString("lastname");
                String firstname = result.getString("firstname");
                String phone = result.getString("phone");
                String email = result.getString("email");
                String role = result.getString("role");
                System.out.println(id + " " + lastname + " " + firstname + " " + phone + " " + email + " " + role);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int countStudent() {
        String countStudent = "SELECT COUNT(role) as role_count FROM online_school.person WHERE role = 'student'";
        int studentTotal = 0;
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = statement.executeQuery(countStudent);
            result.absolute(1);
            studentTotal = result.getInt("role_count");
            System.out.println("Загальна кількість студентів - " + studentTotal);
            result.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentTotal;

    }

    public void emailStudentToFile() {

        final String FILE = "Student_Email.txt";

        String emailStudentToFile = "SELECT email FROM online_school.person WHERE role = 'student'";
        try (Connection connection = DriverManager.getConnection(BD_URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(emailStudentToFile);

            Writer writer = new OutputStreamWriter(new FileOutputStream(FILE), StandardCharsets.UTF_8);

            while (result.next()) {
                writer.write(result.getString("email"));
            }

            writer.close();
            result.close();
            LogFactory.info(this.getClass().getName(), "Create new version of students e-mail");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AmySQL a = new AmySQL();
        a.addPersonSQL("AteacherH43", "AtH43", Role.TEACHER);
        a.addPersonMenuSQL();
        a.personSortByLastnameSQL();
        a.countStudent();
        a.emailStudentToFile();
    }
}
