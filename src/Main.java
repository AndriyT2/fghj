import models.Lecture;
import repository.LectureRepository;
import service.CourseService;
import service.LectureService;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("=====================  Лекція 5. Git - планування релізів.  =========================================");
        System.out.println();

        Lecture lecture1 = new Lecture();
        lecture1.getId();
        Lecture lecture2 = new Lecture();
        lecture2.getId();
        Lecture lecture3 = new Lecture();
        lecture3.getId();
        Lecture lecture4 = new Lecture();
        lecture4.getId();
        Lecture lecture5 = new Lecture();
        lecture5.getId();

        System.out.println("Лічильник прийме знаачення = " + Lecture.getCounter());

        System.out.println();
        System.out.println("=====================  Лекція 6. Методи.  ===========================================================");
        System.out.println();

        CourseService course1 = new CourseService();
        int idCourse1 = course1.createCourse().getId();
        System.out.println(idCourse1);

        LectureService lecture1C1 = new LectureService();
        lecture1C1.createLecture(idCourse1);
        int idLecture1C1 = lecture1C1.createLecture(idCourse1).getId();

        LectureService lecture2C1 = new LectureService();
        lecture2C1.createLecture(idCourse1);
        int idLecture2C1 = lecture2C1.createLecture(idCourse1).getId();

        LectureService lecture3C1 = new LectureService();
        lecture3C1.createLecture(idCourse1);
        int idLecture3C1 = lecture3C1.createLecture(idCourse1).getId();

        LectureService lecture4C1 = new LectureService();
        lecture4C1.createLecture(idCourse1);
        int idLecture4C1 = lecture4C1.createLecture(idCourse1).getId();

        LectureService lecture5C1 = new LectureService();
        lecture5C1.createLecture(idCourse1);
        int idLecture5C1 = lecture5C1.createLecture(idCourse1).getId();

        LectureService lecture6C1 = new LectureService();
        lecture6C1.createLecture(idCourse1);
        int idLecture6C1 = lecture5C1.createLecture(idCourse1).getId();

        System.out.println("Id курсу 6-ї лекції приймає значення = " + lecture6C1.createLecture(idCourse1).getIdCourse());

        LecturesCounter totalLecturesHomework6 = new LecturesCounter();
        int  totalLecturesHomework6Task4 = totalLecturesHomework6.lecturesCounter(lecture1C1, lecture2C1, lecture3C1, lecture4C1, lecture5C1, lecture6C1);
        System.out.println("Загальна кількість створених лекцій = " + totalLecturesHomework6Task4);


        System.out.println("\n=====================  Лекція 7. Розгалуження.  ===========================================================\n");


        CourseService course2 = new CourseService();
        int courseScannerId = course2.courseScanner().getId();

         System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        LectureService lecture1H7 = new LectureService();
        lecture1H7.lectureScanner(courseScannerId);


        System.out.println("\n=====================  Лекція 8. Цикли.  ===========================================================\n");

        LectureService lecture1H8 = new LectureService();
        lecture1H8.lectureScannerLoop();

        System.out.println("\n=====================  Лекція 9. Масиви.  ===========================================================\n");

        LectureService homework9 = new LectureService();
        homework9.lecturesArrayCreator();
    }



        //=====================  Лекція 6. Методи.  ===========================================================


    private static class LecturesCounter {
         int lecturesCounter (LectureService ... lectureName) {
            return lectureName.length;
        }
    }




}