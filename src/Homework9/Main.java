package homework9;

import models.Course;
import models.Lecture;
import repository.LectureRepository;
import service.CourseService;
import service.LectureService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LectureRepository lectureRepository1 = new LectureRepository(1);

        CourseService course = new CourseService();
        Course course1H9 = course.createCourse();
        int idCourse1H9 = course1H9.getId();
        System.out.println("Значення ID для курсу - " + idCourse1H9);

        LectureService lecture1 = new LectureService();
        Lecture lecture1H9 = lecture1.createLecture(idCourse1H9);


        LectureService lecture2 = new LectureService();
        Lecture lecture2H9 = lecture2.createLecture(idCourse1H9);


        lectureRepository1.addLecture(lectureRepository1.getLecturesArray(), lecture1H9);
        System.out.println(Arrays.toString(lectureRepository1.getLecturesArray()));

        lectureRepository1.addLecture(lectureRepository1.getLecturesArray(), lecture2H9);
        System.out.println(Arrays.toString(lectureRepository1.getLecturesArray()));

        LectureService lectureArraysListID = new LectureService();
        lectureArraysListID.lecturesArrayShove(lectureRepository1.getLecturesArray());

    }

}
