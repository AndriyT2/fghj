package models;

public class Course extends ModelsSuper<Course> {
    private String courseName;
    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
    return courseName;
    }

    public Course() {
        super();
}
    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, String teacher, String student, String lecture) {
        this.courseName = courseName;
        this.teacher = new Teacher(teacher);
        this.student = new Student(student);
        this.lecture = new Lecture(lecture);
    }






}
