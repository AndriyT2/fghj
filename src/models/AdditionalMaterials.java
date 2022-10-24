package models;

public class AdditionalMaterials {
    static int counter;
    private int id;

    public void printId() {

        ++counter;
        id = counter;
        System.out.println(id);
    }
}
