package models;

public class Lecture {
    private static int counter;
    private int id;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;
    int idCourse;

    public int getIdCourse() {
        return idCourse;
    }

    public Lecture () { }
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
