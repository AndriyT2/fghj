package service;
import models.Course;

import java.util.Scanner;

public class CourseService {
    public Course createCourse() {
        return new Course();
    }
    public Course createCourse(String courseName) {return new Course(courseName);}

    public Course courseScanner () {
        String answer = askCourseScanner();
       return createCourse(answer);
    }

    private String askCourseScanner() {

        Scanner courseScanner = new Scanner(System.in);
        System.out.println("Введіть назву курсу:");
        String courseName = courseScanner.nextLine();
        System.out.println("Ви впевнені, що хочете назвати курсу наступним чином: " + courseName + " ?");
        System.out.println("Якщо назва правильна, то введіть \"Так\" або \"Yes\", в противному випадку введіть \"Ні\" або \"No\"!");

        String courseNameAnswer = courseScanner.next();

        if (courseNameAnswer.equals("Ні") | courseNameAnswer.equals("ні") | courseNameAnswer.equals("No") | courseNameAnswer.equals("no")) {

            System.out.println("Введіть нову назву курсу:");
            String courseNameNew = courseScanner.nextLine();
            courseName = courseNameNew;

        } else if (courseNameAnswer.equals("Так") | courseNameAnswer.equals("так") | courseNameAnswer.equals("Yes") | courseNameAnswer.equals("yes")) {
            courseName = courseName;

        } else {
            return "Ви ввели некоректну відповідь. Почніть з самого спочатку!";
        }

        System.out.println("Чи бажаєте додати додаткові параметри для курсу?");
        System.out.println("Якщо бажаєте, то введіть \"Так\" або \"Yes\", в противному випадку введіть \"Ні\" або \"No\"!");

        String courseParametersAnswer = courseScanner.next();

        if (courseParametersAnswer.equals("Ні") | courseParametersAnswer.equals("ні") | courseParametersAnswer.equals("No") | courseParametersAnswer.equals("no")) {
            return courseName;

        } else if (courseParametersAnswer.equals("Так") | courseParametersAnswer.equals("так") | courseParametersAnswer.equals("Yes") | courseParametersAnswer.equals("yes")) {
            System.out.println("Введіть порядковий номер (без крапки!) одного з наступних додаткових параметрів, що бажаєте додати:\n1. Вчитель;\n2. Студент;\n3. Лекція.");
            int courseParameterNumber = courseScanner.nextInt();
            String courseParameter = switch (courseParameterNumber) {
                case 1 -> "teacher";
                case 2 -> "student";
                case 3 -> "lecture";
                default -> "Ви ввели некоректну відповідь. Почніть з самого спочатку!";
            };

            System.out.println("Введіть значення для вибраного параметру.");
            String courseParameterValue = courseScanner.next();
            System.out.println(courseName + courseParameter + courseParameterValue);
            return courseParameter;

        } else {
            return "Ви ввели некоректну відповідь. Почніть з самого спочатку!";
        }

    }

}
