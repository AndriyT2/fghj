package service;

import models.Course;
import repository.CourseRepository;
import utility.ScannerThis;


public class CourseService {
    public Course createCourse() {
        return new Course();
    }

    public Course createCourse(String courseName) {
       Course course = new Course(courseName);
     CourseRepository.getInstance().getCourseList().add(course);
     int index = CourseRepository.getInstance().getCourseList().indexOf(course);
     return CourseRepository.getInstance().getCourseList().get(index);
    }

    public Course createCourse(String courseName, String teacher, String student, String lecture) {
        return new Course(courseName, teacher, student, lecture);
    }



    public Course courseScanner() {
        String answer = askCourseScanner();

        if (answer.contains(String.valueOf('#'))) {

            ScannerThis.getInstance().useDelimiter("#");

            String courseName1 = ScannerThis.getInstance().next();
            String courseParameterNumber1 = ScannerThis.getInstance().next();
            String courseParameter1 = ScannerThis.getInstance().next();

            ScannerThis.getInstance().close();

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

        System.out.println("Введіть назву курсу:");
        String courseName = ScannerThis.getInstance().nextLine();
        System.out.println("Ви впевнені, що хочете назвати курсу наступним чином: " + courseName + " ?");
        System.out.println("Якщо назва правильна, то введіть \"Так\" або \"Yes\", " +
                "в противному випадку введіть \"Ні\" або \"No\"!");

        String courseNameAnswer = ScannerThis.getInstance().nextLine();

        if (courseNameAnswer.equals("Ні") | courseNameAnswer.equals("ні") |
                courseNameAnswer.equals("No") | courseNameAnswer.equals("no")) {

            System.out.println("Введіть нову назву курсу:");
            courseName = ScannerThis.getInstance().nextLine();

        } else if (courseNameAnswer.equals("Так") | courseNameAnswer.equals("так") |
                courseNameAnswer.equals("Yes") | courseNameAnswer.equals("yes")) {

//            Course name stay without changes (courseName = courseName;)

        } else {
            throw new RuntimeException("Ви ввели некоректну відповідь. Почніть з самого початку!");
        }

        System.out.println("Чи бажаєте додати додаткові параметри для курсу?");
        System.out.println("Якщо бажаєте, то введіть \"Так\" або \"Yes\", " +
                "в противному випадку введіть \"Ні\" або \"No\"!");

        String courseParametersAnswer = ScannerThis.getInstance().nextLine();

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

            int courseParameterNumber = ScannerThis.getInstance().nextInt();
            ScannerThis.getInstance().nextLine();

            System.out.println("Тепер введіть значення для вибраного параметру:");
            String courseParameterValue = ScannerThis.getInstance().nextLine();

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
                    yield "Ви ввели некоректну відповідь. Почніть з самого спочатку!";
            };


            return courseName + "#" + courseParameterNumber + "#" + courseParameter;

        } else {
            throw new IllegalArgumentException();
        }
    }

}




