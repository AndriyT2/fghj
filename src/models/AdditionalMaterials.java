package models;

public class AdditionalMaterials {
    static int counter;
    private int id;

    public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }
}
