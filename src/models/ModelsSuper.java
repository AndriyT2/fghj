package models;

public class ModelsSuper {

    private static int counter;

    private final int id;

    public ModelsSuper() {
        ++counter;
        this.id = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }
}
