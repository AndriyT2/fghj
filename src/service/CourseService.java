package service;

import models.Course;
import models.ModelsSuper;
import models.Person;
import repository.CourseRepository;
import repository.PersonRepository;

import java.util.Scanner;

public class CourseService {
    public Course createCourse() {
        return new Course();
    }

    public Course createCourse(String courseName) {
        return new Course(courseName);
    }

    public Course createCourse(String courseName, String teacher, String student, String lecture) {
        return new Course(courseName, teacher, student, lecture);
    }



    public Course courseScanner() {
        String answer = askCourseScanner();

        if (answer.contains(String.valueOf('#'))) {

            Scanner courseScanner2 = new Scanner(answer);
            courseScanner2.useDelimiter("#");

            String courseName1 = courseScanner2.next();
            String courseParameterNumber1 = courseScanner2.next();
            String courseParameter1 = courseScanner2.next();

            courseScanner2.close();

            System.out.println("Ви створили курс:" + courseName1);

            if (courseParameterNumber1.equals("1")) {
                return createCourse(courseName1, courseParameter1, "unavailable", "unavailable");
            } else if (courseParameterNumber1.equals("2")) {
                return createCourse(courseName1, "unavailable", courseParameter1, "unavailable");
            } else {
                return createCourse(courseName1, "unavailable", "unavailable", courseParameter1);
            }

        } else {

            System.out.println("Ви створили курс:" + answer);
            return createCourse(answer);
        }
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

//            Course name stay without changes (courseName = courseName;)

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

            System.out.println("""
                    Введіть порядковий номер одного з наступних додаткових параметрів, що бажаєте додати:
                    1 Вчитель;
                    2 Студент;
                    3 Лекція.""");

            int courseParameterNumber = courseScanner.nextInt();
            courseScanner.nextLine();

            System.out.println("Тепер введіть значення для вибраного параметру:");
            String courseParameterValue = courseScanner.nextLine();

            String courseParameter = switch (courseParameterNumber) {
                case 1:
                    System.out.println("Ви вибрали параметр: вчитель. " +
                            "\nЗначення для цього параметру:" + courseParameterValue);
                    yield courseParameterValue;
                case 2:
                    System.out.println("Ви вибрали параметр: студент." +
                            "\nЗначення для цього параметру:" + courseParameterValue);
                    yield courseParameterValue;
                case 3:
                    System.out.println("Ви вибрали параметр: лекція." +
                            "\nЗначення для цього параметру:" + courseParameterValue);
                    yield courseParameterValue;
                default:
                    yield "Error 3";
            };

            if (courseParameter.equals("Error 3")) {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                return "Error 3";
            }

            return courseName + "#" + courseParameterNumber + "#" + courseParameter;

        } else {

            System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");

            return "Error 4";
        }
    }

    public void setCourseName (int idCourse) {
        CourseRepository.getInstance().exist(idCourse);
        CourseRepository.getInstance().getAll();
        System.out.println("Введіть назву курсу!");
        Scanner scannerP = new Scanner(System.in);
        String сourseName = scannerP.nextLine();
        String сourseNameNorm = сourseName.trim();
        boolean result = сourseNameNorm.matches("^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-\\'\\d\\s\\.]{1,200}$");
        while (!result){
            System.out.println("Ви ввели некоректну назву курсу!\nВведіть назва курсу знову!");
            сourseName = scannerP.nextLine();
            сourseNameNorm = сourseName.trim();
            result = сourseNameNorm.matches("^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-\\'\\d\\s\\.]{1,200}$");
        }
        System.out.println("Назва курсу:  " + сourseNameNorm);
        ModelsSuper course = CourseRepository.getInstance().getById(idCourse);
        Course course1 = (Course) course;
        course1.setCourseName(сourseNameNorm);
    }

}




