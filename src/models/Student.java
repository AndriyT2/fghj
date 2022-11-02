package models;

public class Student {
    static int counter;
    private int id;

    public int findId() {

        ++counter;
        id = counter;
        return id;
    }
}
