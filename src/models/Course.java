package models;

public class Course {
    static int counter;
    private int id;
    private Teacher teacher;
    private Student student;
    private Lecture lecture;


    public void printId() {

        ++counter;
        id = counter;
        System.out.println(id);
    }
}
