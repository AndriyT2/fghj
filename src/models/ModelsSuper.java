package models;

public abstract class ModelsSuper <E> {

    private static int counter;

    private final int id;

    public <E> ModelsSuper() {
        ++counter;
        this.id = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "id=" + id +
                '}';
    }
}
