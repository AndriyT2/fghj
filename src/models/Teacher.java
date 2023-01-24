package models;

public class Teacher extends ModelsSuper<Teacher> {

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