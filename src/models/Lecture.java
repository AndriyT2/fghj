package models;

public class Lecture {
    private static int counter;
    private int id;
    private String name;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;
    int idCourse;

    public int getIdCourse() {
        return idCourse;
    }

    public Lecture () { }

    public Lecture (String name) {
        this.name = name;
//        System.out.println(name);
    }
    public String getName() { return name;}

    public Lecture (int idCourse) {

        this.idCourse = idCourse;
    }

         public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}
