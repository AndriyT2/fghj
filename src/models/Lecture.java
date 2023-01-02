package models;

public class Lecture {
    private static int counter;
    private final int id;
    private String name;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;
    int idCourse;

    public int getIdCourse() {
        return idCourse;
    }

    public Lecture () {
        ++counter;
        this.id = counter;
    }

    public Lecture (String name) {
        ++counter;
        this.id = counter;
        this.name = name;
//        System.out.println(name);
    }
    public String getName() { return name;}

    public Lecture (int idCourse) {
        ++counter;
        this.id = counter;
        this.idCourse = idCourse;
    }

         public int getId() {
            return id;
    }

    public static int getCounter() {
        return counter;
    }
}
