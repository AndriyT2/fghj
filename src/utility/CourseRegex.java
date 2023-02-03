package utility;

import models.Course;
import repository.CourseRepository;

import java.util.Scanner;

public class CourseRegex {
    public static void setCourseName (int idCourse) throws EntityNotFoundException {
        final String rule = "^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-'\\d\\s.]{1,200}$";
        System.out.println(CourseRepository.getInstance().getCourseList());
        System.out.println("Введіть назву курсу!");
        Scanner scannerP = new Scanner(System.in);
        String courseName = scannerP.nextLine();
        String courseNameNorm = courseName.trim();
        boolean result = courseNameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректну назву курсу!");
            } catch (SetParameterException e) {
                System.err.println("Введіть назва курсу знову у правильному форматі!");
                courseName = scannerP.nextLine();
                courseNameNorm = courseName.trim();
                result = courseNameNorm.matches(rule);
            }
        }
        System.out.println("Назва курсу:  " + courseNameNorm);
        Course course = CourseRepository.getInstance().getById(idCourse);
        course.setCourseName(courseNameNorm);
    }
}
