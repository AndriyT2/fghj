package models;

public class Course {
    static int counter;
    private String courseName;
    private int id;
    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public String getCourseName() {
    return courseName;
    }
    public Course(){};
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }




}
