package models;

public class Homeworks {
    static int counter;
    private int id;

    public int findId() {

        ++counter;
        id = counter;
        return id;
    }
}
