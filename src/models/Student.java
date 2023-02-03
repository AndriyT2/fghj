package models;

public class Student extends ModelsSuper{

    private String name;

    public Student() { super();};

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name;}

  }
