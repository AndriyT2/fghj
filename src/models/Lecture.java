package models;

public class Lecture extends ModelsSuper{

    private String name;
    private Homeworks homeworks;
    private AdditionalMaterials additionalMaterials;
    private int idCourse;
    private int personId;

    private int idTeacher;

    public int getIdCourse() {
        return idCourse;
    }

    public int getPersonId() {
        return personId;
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

    public Lecture (int idCourse, int idTeacher) {
        this();
        this.idCourse = idCourse;
        this.idTeacher = idTeacher;
    }
}
