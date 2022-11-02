package models;

public class AdditionalMaterials {
    static int counter;
    private int id;

    public int findId() {

        ++counter;
        id = counter;
        return id;
    }
}
