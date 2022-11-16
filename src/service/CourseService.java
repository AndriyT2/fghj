package service;
import models.Course;

import java.util.Scanner;

public class CourseService {
    public Course createCourse() {
        return new Course();
    }
    public Course createCourse(String courseName) {return new Course(courseName);}
    public Course createCourse(String courseName, String teacher, String student, String lecture) {
        return new Course(courseName, teacher, student, lecture);
    }

    public int getCourseIdScanner() {
        return courseScanner().getId();
    }

    public Course courseScanner () {
        String answer = askCourseScanner();
       return createCourse(answer);
    }

    private String askCourseScanner() {

        Scanner courseScanner = new Scanner(System.in);
        System.out.println("Введіть назву курсу:");
        String courseName = courseScanner.nextLine();
        System.out.println("Ви впевнені, що хочете назвати курсу наступним чином: " + courseName + " ?");
        System.out.println("Якщо назва правильна, то введіть \"Так\" або \"Yes\", " +
                           "в противному випадку введіть \"Ні\" або \"No\"!");

        String courseNameAnswer = courseScanner.nextLine();

        if (courseNameAnswer.equals("Ні") | courseNameAnswer.equals("ні") |
                courseNameAnswer.equals("No") | courseNameAnswer.equals("no")) {

            System.out.println("Введіть нову назву курсу:");
            courseName = courseScanner.nextLine();

        } else if (courseNameAnswer.equals("Так") | courseNameAnswer.equals("так") |
                courseNameAnswer.equals("Yes") | courseNameAnswer.equals("yes")) {

            courseName = courseName;

        } else {

            System.out.println("Ви ввели некоректну відповідь. Почніть з самого спочатку!");

            return "Error 1";
        }

        System.out.println("Чи бажаєте додати додаткові параметри для курсу?");
        System.out.println("Якщо бажаєте, то введіть \"Так\" або \"Yes\", " +
                            "в противному випадку введіть \"Ні\" або \"No\"!");

        String courseParametersAnswer = courseScanner.nextLine();

        if (courseParametersAnswer.equals("Ні") | courseParametersAnswer.equals("ні") |
                courseParametersAnswer.equals("No") | courseParametersAnswer.equals("no")) {

            return courseName;

        } else if (courseParametersAnswer.equals("Так") | courseParametersAnswer.equals("так") |
                courseParametersAnswer.equals("Yes") | courseParametersAnswer.equals("yes")) {

            System.out.println("Введіть порядковий номер одного з наступних додаткових параметрів, що бажаєте додати:" +
                    "\n1 Вчитель;" +
                    "\n2 Студент;" +
                    "\n3 Лекція.");

            int courseParameterNumber = courseScanner.nextInt();
            courseScanner.close();

            System.out.println("Тепер введіть значення для вибраного параметру:");
            Scanner courseScanner1 = new Scanner(System.in);
            String courseParameterValue = courseScanner1.nextLine();

            String courseParameter = switch (courseParameterNumber) {
                case 1:
                    System.out.println("Ви вибрали параметр: вчитель. " +
                            "\nЗначення для цього параметру:" + courseParameterValue);
                    yield courseParameterValue + ", null, null";
                case 2:
                    System.out.println("Ви вибрали параметр: студент." +
                            "\nЗначення для цього параметру:" + courseParameterValue);
                    yield "null, " + courseParameterValue + ", null";
                case 3:
                    System.out.println("Ви вибрали параметр: лекція." +
                            "\nЗначення для цього параметру:" + courseParameterValue);
                    yield "null, null, " + courseParameterValue;
                default:
                    yield  "Error 3";
            };

            if (courseParameter.equals("Error 3")) {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                return "Error 3";
            }

            return courseName + ", " +courseParameter;

        } else {

            System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");

            return "Error 3";
        }

    }

}
