package repository;

import models.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    }

    public Course getById(int index) {
        for (Course course : courseList){
            if (course.getId() == index) {return course;}
        }
        throw new NoSuchElementException();
    }

}