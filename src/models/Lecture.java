package models;

public class Lecture {
    public static int counter;
    private int id;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;
    public int idCourse;

    public int findId() {

        ++counter;
        id = counter;
        return id;
    }
}
