package models;

public class Student {
    static int counter;
    private int id;
    private String name;

    public Student() { };

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name;}

    public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}
