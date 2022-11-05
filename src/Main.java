import models.Course;
import models.Lecture;
import service.CourseService;
import service.LectureService;

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
        int idCourse1 = course1.createCourse().findId();
        LectureService lecture6 = new LectureService();
        lecture6.createLecture(idCourse1);
        LectureService lecture7 = new LectureService();
        lecture7.createLecture(idCourse1);
        LectureService lecture8 = new LectureService();
        lecture8.createLecture(idCourse1);
        LectureService lecture9 = new LectureService();
        lecture9.createLecture(idCourse1);
        LectureService lecture10 = new LectureService();
        lecture10.createLecture(idCourse1);
        LectureService lecture11 = new LectureService();
        lecture11.createLecture(idCourse1);

    }
}