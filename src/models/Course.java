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

    public void setTeacher (String name) {
        teacher.setName(name);
    }
    public Course(){};
    public Course(String courseName) {
        this.courseName = courseName;
        System.out.println("1");
        System.out.println();
    }

    public Course(String courseName, String teacher, String student, String lecture) {
        this.courseName = courseName;
        this.teacher = new Teacher(teacher);
        this.student = new Student(student);
        this.lecture = new Lecture(lecture);
        System.out.println("2");

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
