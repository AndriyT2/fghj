package models;

import repository.LectureRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Lecture extends ModelsSuper {

    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalDateTime lectureDate;
    private Homework[] homeworkArray;

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


    public int getIdCourse() {
        return idCourse;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    public int getPersonId() {
        return personId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setLectureDate(LocalDateTime lectureDate) {
        this.lectureDate = lectureDate;
    }

    public Lecture () {
        super();
        creationDate = LocalDate.now();

    }

    public Lecture (String name) {
        this();
        this.name = name;
        creationDate = LocalDate.now();

    }

    public String getName() { return name;}

    public Lecture (int idCourse) {
        this();
        this.idCourse = idCourse;
        creationDate = LocalDate.now();

    }

    public Lecture(String name, int idCourse) {
        this();
        this.idCourse = idCourse;
        this.name = name;
        creationDate = LocalDate.now();

    }


    public Lecture lectureWithTeacher (int personId) {
        creationDate = LocalDate.now();
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
                '}';
    }
}
