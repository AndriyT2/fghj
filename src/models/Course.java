package models;

public class Course {
    static int counter;
    private String courseName;
    private int id;
    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public String getCourseName() {
    return courseName;
    }
    public Course(){};
    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, String teacher, String student, String lecture) {
        this.courseName = courseName;
        this.teacher = new Teacher(teacher);
        this.student = new Student(student);
        this.lecture = new Lecture(lecture);

    }

    public int getId() {
        ++counter;
        id = counter;
        return id;
    }

    public static int getCounter() {
        return counter;
    }




}
