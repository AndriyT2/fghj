package service;
import models.Lecture;

public class LectureService {
    public Lecture createLecture() {
        return new Lecture();
    }

    public Lecture createLecture(String ... nameLecture) {
        for (int i = 0; i < nameLecture.length; i++) {
            Lecture nameLecture = new Lecture();
        }
        return nameLecture;

    }
}
