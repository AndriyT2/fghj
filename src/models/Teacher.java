package models;

public class Teacher {
    static int counter;
    private int id;
    private String name;

    public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }
    public Teacher () { };
    public Teacher (String name) {
        this.name = name;
    }

    public String getName() { return name;}
}