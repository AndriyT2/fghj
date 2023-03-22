package models;

import java.util.Objects;

public class Course extends ModelsSuper implements Comparable<Course> {
    private String courseName;
    private Person teacher;
    private Person student;
    private Lecture lecture;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course() {
        super();
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, String teacher, String student, String lecture) {
        this.courseName = courseName;
        this.teacher = new Person(teacher, Role.TEACHER);
        this.student = new Person(student, Role.STUDENT);
        this.lecture = new Lecture(lecture);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", teacher=" + teacher +
                ", student=" + student +
                ", lecture=" + lecture +
                ", Id" + getId() +
                '}';
    }

    @Override
    public int compareTo(Course name) {
        return this.courseName.compareTo(name.getCourseName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) && Objects.equals(teacher, course.teacher) && Objects.equals(student, course.student) && Objects.equals(lecture, course.lecture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, teacher, student, lecture);
    }
}
