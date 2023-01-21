package models;

public class Lecture extends ModelsSuper{

    private String name;
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

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

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public Lecture lectureWithTeacher (int personId) {
        Lecture lecture = new Lecture();
        lecture.setPersonId(personId);
        return lecture;
    }
}
