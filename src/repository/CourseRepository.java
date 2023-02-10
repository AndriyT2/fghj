package repository;

import models.Course;
import utilityLog.LogFactory;

import java.util.*;

public class CourseRepository {

    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    private static CourseRepository instance;

    private CourseRepository() {
        this.courseList = new ArrayList<>();
    }

    public static CourseRepository getInstance() {
        if (instance == null) {
            instance = new CourseRepository();
        }
        return instance;
    }

    public void getAll() {
        System.out.println(CourseRepository.getInstance().getCourseList());
        LogFactory.info(this.getClass().getName(), "Display CourseRepository");

    }

    public Course getById(int index) {
        for (Course course : courseList) {
            if (course.getId() == index) {
                LogFactory.debug(this.getClass().getName(), "Display course by input Id");
                return course;
            }
        }
        NoSuchElementException e = new NoSuchElementException();
        LogFactory.error(this.getClass().getName(), "Course with such Id doesn't exist", e.getStackTrace());
        throw e;
    }

    public void courseSortByName() {
        Set<Course> courseTreeSet = new TreeSet<>(CourseRepository.getInstance().getCourseList());
        System.out.println(courseTreeSet);

    }
}