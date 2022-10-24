import models.Course;
import models.Teacher;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.printId();
        Course course2 = new Course();
        course2.printId();
        Course course3 = new Course();
        course3.printId();
        System.out.println();

        Teacher teacher1 = new Teacher();
        teacher1.printId();
        Teacher teacher2 = new Teacher();
        teacher2.printId();
    }
}