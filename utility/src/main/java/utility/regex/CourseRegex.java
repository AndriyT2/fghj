package utility.regex;

import models.Course;
import repository.CourseRepository;
import utility.ScannerThis;
import utility.exception.EntityNotFoundException;
import utility.exception.SetParameterException;
import utility.utilityLog.LogFactory;


public class CourseRegex {
    public static void setCourseName (int idCourse) throws EntityNotFoundException {
        final String rule = "^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-'\\d\\s.]{1,200}$";
        System.out.println(CourseRepository.getInstance().getCourseList());
        System.out.println("Введіть назву курсу!");
        String courseName = ScannerThis.getInstance().nextLine();
        String courseNameNorm = courseName.trim();
        boolean result = courseNameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректну назву курсу!");
            } catch (SetParameterException e) {
                System.err.println("Введіть назва курсу знову у правильному форматі!");
                courseName = ScannerThis.getInstance().nextLine();
                courseNameNorm = courseName.trim();
                result = courseNameNorm.matches(rule);
            }
        }
        System.out.println("Назва курсу:  " + courseNameNorm);
        Course course = CourseRepository.getInstance().getById(idCourse);
        course.setCourseName(courseNameNorm);
    }

    public static String setCourseNameMenu (String courseName){
        LogFactory.debug(Thread.currentThread().getStackTrace()[1].getClassName(), "Run regex course name.");
        final String rule = "^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-'\\d\\s.]{1,200}$";
        String courseNameNorm = courseName.trim();
        boolean result = courseNameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректну назву курсу!");
            } catch (SetParameterException e) {
                LogFactory.warning(Thread.currentThread().getStackTrace()[1].getClassName(), "Run regex course name.", e.getStackTrace());
                System.err.println("Введіть назва курсу знову у правильному форматі!");
                courseName = ScannerThis.getInstance().nextLine();
                courseNameNorm = courseName.trim();
                result = courseNameNorm.matches(rule);
            }
        }
       return courseNameNorm;
    }
}
