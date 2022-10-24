package models;

public class Lecture {
    public static int counter;
    private int id;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;

    public void printId() {

        ++counter;
        id = counter;
        System.out.println("ID = " + id);
    }
}
