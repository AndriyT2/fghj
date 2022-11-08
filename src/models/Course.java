package models;

public class Course {
    static int counter;
    private int id;
    private Teacher teacher;
    private Student student;
    private Lecture lecture;


    public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}
