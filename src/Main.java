import models.Course;
import models.Lecture;
import service.CourseService;

public class Main {
    public static void main(String[] args) {
        Lecture lecture1 = new Lecture();
        lecture1.findId();
        Lecture lecture2 = new Lecture();
        lecture2.findId();
        Lecture lecture3 = new Lecture();
        lecture3.findId();
        Lecture lecture4 = new Lecture();
        lecture4.findId();
        Lecture lecture5 = new Lecture();
        lecture5.findId();

        System.out.println("Лічильник прийме знаачення = " + Lecture.counter);

        System.out.println("================================================================================");

        CourseService course1 = new CourseService();
        course1.createCourse().findId();

    }
}