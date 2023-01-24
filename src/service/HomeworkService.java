package service;

import models.Homework;

public class HomeworkService {

    public Homework createHomework() {
        return new Homework();
    }
    public Homework createHomeworkWithLectureId(int lectureId) {
        return new Homework(lectureId);
    }

    public Homework createHomeworkWithTask (String task) {
        return new Homework(task);
    }

}
