package models;

public class Teacher {
    static int counter;
    private int id;

    public int findId() {

        ++counter;
        id = counter;
        return id;
    }
}
