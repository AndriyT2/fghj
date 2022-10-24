package models;

public class Course {
    static int counter = 1;
    private int id = counter;

    public void printId() {

        ++counter;
        System.out.println(id);
    }
}
