package service;
import models.Lecture;

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

}

