import models.Course;
import models.Lecture;
import service.CourseService;
import service.LectureService;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("=====================  Лекція 5. Git - планування релізів.  =========================================");
        System.out.println();

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

        System.out.println();
        System.out.println("=====================  Лекція 6. Методи.  ===========================================================");
        System.out.println();

        CourseService course1 = new CourseService();
        int idCourse1 = course1.createCourse().findId();

        LectureService lecture1C1 = new LectureService();
        lecture1C1.createLecture(idCourse1);
        int idLecture1C1 = lecture1C1.createLecture(idCourse1).findId();

        LectureService lecture2C1 = new LectureService();
        lecture2C1.createLecture(idCourse1);
        int idLecture2C1 = lecture2C1.createLecture(idCourse1).findId();

        LectureService lecture3C1 = new LectureService();
        lecture3C1.createLecture(idCourse1);
        int idLecture3C1 = lecture3C1.createLecture(idCourse1).findId();

        LectureService lecture4C1 = new LectureService();
        lecture4C1.createLecture(idCourse1);
        int idLecture4C1 = lecture4C1.createLecture(idCourse1).findId();

        LectureService lecture5C1 = new LectureService();
        lecture5C1.createLecture(idCourse1);
        int idLecture5C1 = lecture5C1.createLecture(idCourse1).findId();

        LectureService lecture6C1 = new LectureService();
        lecture6C1.createLecture(idCourse1);
        int idLecture6C1 = lecture5C1.createLecture(idCourse1).findId();

        System.out.println("Id курсу 6-ї лекції приймає значення = " + lecture6C1.createLecture(idCourse1).idCourse);

        LecturesCounter totalLecturesHomework6 = new LecturesCounter();
        int  totalLecturesHomework6Task4 = totalLecturesHomework6.lecturesCounter(lecture1C1, lecture2C1, lecture3C1, lecture4C1, lecture5C1, lecture6C1);
        System.out.println("Загальна кількість створених лекцій = " + totalLecturesHomework6Task4);



    }

    private static class LecturesCounter {
        public int lecturesCounter (LectureService ... lectureName) {
            return lectureName.length;
        }
    }
}