package repository;

import models.Course;
import models.Lecture;

public class CourseRepository extends RepositorySuper {


    private static CourseRepository instance;

    private CourseRepository() {
        this.arraySuper = new Course[STANDARD_CAPACITY];
    }

    public static CourseRepository getInstance() {
        if (instance == null) {
            instance = new CourseRepository();
        }
        return instance;
    }

}