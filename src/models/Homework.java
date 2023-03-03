package models;

import repository.LectureRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Homework extends ModelsSuper {
 private int lectureId;
 private String task;

 private String deadLine;

    public Homework(){
        if(lectureId != 0) {
            if (LectureRepository.getInstance().getById(lectureId).getLectureDate() != null) {
                LocalDate deadLineData = LectureRepository.getInstance().getById(lectureId).getLectureDate().toLocalDate().plusDays(1);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, 12:00");
                deadLine = dtf.format(deadLineData);
            }
        }
    }

    public Homework(int lectureId) {
        this.lectureId = lectureId;
        if(lectureId != 0) {
            if (LectureRepository.getInstance().getById(lectureId).getLectureDate() != null) {
                LocalDate deadLineData = LectureRepository.getInstance().getById(lectureId).getLectureDate().toLocalDate().plusDays(1);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, 12:00");
                deadLine = dtf.format(deadLineData);
            }
        }
    }

    public Homework(int lectureId, String task) {
        this.lectureId = lectureId;
        this.task = task;
        if(lectureId != 0) {
            if (LectureRepository.getInstance().getById(lectureId).getLectureDate() != null) {
                LocalDate deadLineData = LectureRepository.getInstance().getById(lectureId).getLectureDate().toLocalDate().plusDays(1);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, 12:00");
                deadLine = dtf.format(deadLineData);
            }
        }

    }

    public Homework(String task) {
        this.task = task;
        if(lectureId != 0) {
            if (LectureRepository.getInstance().getById(lectureId).getLectureDate() != null) {
                LocalDate deadLineData = LectureRepository.getInstance().getById(lectureId).getLectureDate().toLocalDate().plusDays(1);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, 12:00");
                deadLine = dtf.format(deadLineData);
            }
        }
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getDeadLine() {
        return deadLine;
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
