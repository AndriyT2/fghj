package service;
import models.Course;
import models.Lecture;
import repository.LectureRepository;

import java.util.Arrays;
import java.util.Scanner;

public class LectureService {

    public Lecture createLecture() {
        return new Lecture();
    }

    public Lecture createLecture(int idCourse) {
        return new Lecture(idCourse);

    }

    public void lectureScanner(int idCourse) {
        int totalLectures = 0;
        Scanner lectureScanner = new Scanner(System.in);
        System.out.println("Чи бажаєте створити нову лекцію? [Так/Ні]");

        String lectureScannerAsk1 = lectureScanner.nextLine();

        if (lectureScannerAsk1.equals("Ні") | lectureScannerAsk1.equals("ні") | lectureScannerAsk1.equals("No") | lectureScannerAsk1.equals("no")) {

            System.out.println("Ви відмовилися створювати нову лекцію!");

        } else if (lectureScannerAsk1.equals("Так") | lectureScannerAsk1.equals("так") | lectureScannerAsk1.equals("Yes") | lectureScannerAsk1.equals("yes")) {

            Lecture lecture1H7 = new Lecture(idCourse);
            String lecture1H7Id = String.valueOf(lecture1H7.getIdCourse());
            totalLectures++;

            System.out.println("Створена нова лекція. Значення Id курсу для даної лекції становить: " + lecture1H7Id + ".");

            System.out.println("Чи бажаєте створити додаткову лекцію? [Так/Ні]");
            String lectureScannerAsk2 = lectureScanner.nextLine();

            if (lectureScannerAsk2.equals("Ні") | lectureScannerAsk2.equals("ні") | lectureScannerAsk2.equals("No") | lectureScannerAsk2.equals("no")) {

                System.out.println("Ви відмовилися створювати додаткову лекцію!");

            } else if (lectureScannerAsk2.equals("Так") | lectureScannerAsk2.equals("так") | lectureScannerAsk2.equals("Yes") | lectureScannerAsk2.equals("yes")) {

                Lecture lecture2H7 = new Lecture(idCourse);
                int lecture2H7Id = lecture2H7.getIdCourse();
                totalLectures++;

                System.out.println("Створена додаткова лекція. Значення Id курсу для даної лекції становить: " + lecture2H7Id + ".");
            } else {

                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
            }

        } else {

            System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
        }

        System.out.println("Загальна кількість створених лекцій складає - " + totalLectures + " штук(и).");
    }

    public void lectureScannerLoop() {

        int totalLecturesLoop = 0;
        int IdCourseLoop = -1;
        int maxValueLectures = 8;
        int maxValueIdCourse = 3;
        int minValueIdCourse = 1;

        for (int i = 0; true; i++) {

            Scanner lectureScannerLoop = new Scanner(System.in);
            System.out.println("Чи бажаєте створити нову лекцію? [Y/N]");
            String lectureScannerLoopAsk1 = lectureScannerLoop.nextLine();

            if (lectureScannerLoopAsk1.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати нову лекцію!");
                break;

            } else if (lectureScannerLoopAsk1.equalsIgnoreCase("y")) {

                do {
                    System.out.println("Введіть значення Id курсу для майбутньої лекції тільки в наступних межах від " + minValueIdCourse + " до " + maxValueIdCourse + "!");
                    IdCourseLoop = lectureScannerLoop.nextInt();
                    lectureScannerLoop.nextLine();

                } while (IdCourseLoop < minValueIdCourse || IdCourseLoop > maxValueIdCourse);

                totalLecturesLoop++;

                if (totalLecturesLoop > maxValueLectures) {

                    System.out.println("Ви перевищили ліміт на максимальну кількість створених лекцій, який становить - " + maxValueLectures + " штук!");
                    break;
                }

                System.out.println("Ви створили " + totalLecturesLoop +"-у лекцію з Id курсу = " + IdCourseLoop);

            } else {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
            }

        }

    }

    public void lecturesArrayShove(Lecture[] lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) continue;
//        for (int i = 0; i < lectures.length; i++) {
//            if (lectures[i].equals(null)) continue;
            System.out.println("Значення ID для лекції " + lecture + " буде приймати значення " + lecture.getId());
        }
    }

    public void lecturesArrayCreator () {

        LectureRepository lectureRepository2 = new LectureRepository(3);
        System.out.println(Arrays.toString(lectureRepository2.getLecturesArray()));

        CourseService course = new CourseService();
        Course course1H9 = course.createCourse();
        int idCourse1H9 = course1H9.getId();
        System.out.println("Значення ID для курсу - " + idCourse1H9);

        Lecture lecture1H9 = createLecture(idCourse1H9);

        Lecture lecture2H9 = createLecture(idCourse1H9);

        lectureRepository2.addLecture(lectureRepository2.getLecturesArray(), lecture1H9);
        System.out.println(Arrays.toString(lectureRepository2.getLecturesArray()));

        lectureRepository2.addLecture(lectureRepository2.getLecturesArray(), lecture2H9);
        System.out.println(Arrays.toString(lectureRepository2.getLecturesArray()));


        while (true) {

            Scanner lectureScannerLoop = new Scanner(System.in);
            System.out.println("Чи бажаєте створити нову лекцію? [Y/N]");
            String lectureScannerLoopAsk1 = lectureScannerLoop.nextLine();

            if (lectureScannerLoopAsk1.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати нову лекцію!");
                break;

            } else if (lectureScannerLoopAsk1.equalsIgnoreCase("y")) {
                lectureRepository2.addLecture(lectureRepository2.getLecturesArray(), createLecture(idCourse1H9));
                System.out.println(Arrays.toString(lectureRepository2.getLecturesArray()));

            } else {
            System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
            break;}

        }

        lecturesArrayShove(lectureRepository2.getLecturesArray());
    }
}
