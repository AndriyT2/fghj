package models;

public class Student {
    static int counter;
    private int id;

    public void printId() {

        ++counter;
        id = counter;
        System.out.println(id);
    }
}
