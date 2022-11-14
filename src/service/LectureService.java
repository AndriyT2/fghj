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
    public String lectureScanner(int idCourse) {
            Scanner lectureScanner = new Scanner(System.in);
            System.out.println("Вітаю вас! Чи бажаєте створити нову лекцію? [Так/Ні]");

            String lectureScannerAsk = lectureScanner.next();

            if (lectureScannerAsk.equals("Ні") | lectureScannerAsk.equals("ні") | lectureScannerAsk.equals("No") | lectureScannerAsk.equals("no")) {

                System.out.println("Ви відмовилися створювати нову лекцію!");

                return "Ви відмовилися створювати нову лекцію!";

            } else if (lectureScannerAsk.equals("Так") | lectureScannerAsk.equals("так") | lectureScannerAsk.equals("Yes") | lectureScannerAsk.equals("yes")) {

                Lecture lecture1H7 = new Lecture(idCourse);
                String lecture1H7Id = String.valueOf(lecture1H7.getIdCourse());
                System.out.println("Створена нова лекція. Значення Id курсу для данної лекуції становить: " + lecture1H7Id + ".");

                return lecture1H7Id;

            } else {

                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");

                return "Ви ввели некоректну відповідь. Почніть з самого початку!";
            }
    }

}

