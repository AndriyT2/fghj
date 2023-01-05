package models;

public class Teacher {

    private String name;

    public Teacher () {super(); };

    public Teacher (String name) {
        this.name = name;
    }
    public void setName (String name) {
        this.name = name;
    }

    public String getName() { return name;}
}