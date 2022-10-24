package models;

public class Homeworks {
    static int counter;
    private int id;

    public void printId() {

        ++counter;
        id = counter;
        System.out.println(id);
    }
}
