package models;

import java.time.LocalDateTime;

public class Lecture extends ModelsSuper {

    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime lectureDate;
    private Homework[] homeworkArray;

    public int getIdSQL() {
        return IdSQL;
    }

    private int IdSQL;

    public void setName(String name) {
        this.name = name;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private Homework homework;
    private AdditionalMaterials additionalMaterials;
    private int idCourse;
    private int personId;

    public int getAm() {
        return am;
    }

    public int am;



    public int getIdCourse() {
        return idCourse;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    public int getPersonId() {
        return personId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setLectureDate(LocalDateTime lectureDate) {
        this.lectureDate = lectureDate;
    }

    public Lecture() {
        super();
        creationDate = LocalDateTime.now();

    }

    public Lecture(String name) {
        this();
        this.name = name;
        creationDate = LocalDateTime.now();

    }



    public Lecture(int IdSQL, String name, String description, LocalDateTime creationDate, LocalDateTime lectureDate) {
        this.IdSQL = IdSQL;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.lectureDate = lectureDate;
    }

    public String getName() {
        return name;
    }

    public Lecture(int idCourse) {
        this();
        this.idCourse = idCourse;
        creationDate = LocalDateTime.now();

    }

    public Lecture(String name, int idCourse) {
        this();
        this.idCourse = idCourse;
        this.name = name;
        creationDate = LocalDateTime.now();

    }


    public Lecture lectureWithTeacher(int personId) {
        creationDate = LocalDateTime.now();
        Lecture lecture = new Lecture();
        lecture.setPersonId(personId);
        return lecture;
    }


    @Override
    public String toString() {
        return "Lecture{" +
                "ID='" + this.getId() + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", lectureDate=" + lectureDate +
                ", homework=" + homework +
                ", additionalMaterials=" + additionalMaterials +
                ", idCourse=" + idCourse +
                ", personId=" + personId +
                ", am=" +am +

                '}';
    }
}
