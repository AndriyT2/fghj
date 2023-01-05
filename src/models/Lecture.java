package models;

public class Lecture extends ModelsSuper{

    private String name;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;
    int idCourse;

    public int getIdCourse() {
        return idCourse;
    }

    public Lecture () {
        super();
    }

    public Lecture (String name) {
        this();
        this.name = name;
    }

    public String getName() { return name;}

    public Lecture (int idCourse) {
        this();
        this.idCourse = idCourse;
    }

}
