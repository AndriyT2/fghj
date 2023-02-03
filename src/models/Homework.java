package models;

public class Homework extends ModelsSuper {
 private int lectureId;
 private String task;

    public Homework(){};

    public Homework(int lectureId) {
        this.lectureId = lectureId;
    }

    public Homework(String task) {
        this.task = task;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
