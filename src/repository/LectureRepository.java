package repository;

import models.Lecture;
import utility.EntityNotFoundException;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LectureRepository {
    private List<Lecture> lecturesList;


        private static LectureRepository instance;

        private LectureRepository() {
            this.lecturesList = new ArrayList<>();
        }

        public static LectureRepository getInstance() {
            if (instance == null) {
                instance = new LectureRepository();
            }
            return instance;
        }

    public List<Lecture> getLecturesList() {
        return lecturesList;
    }

    public void getAll() {
        System.out.println(LectureRepository.getInstance().getLecturesList());
    }

    public Lecture getById(int index) {
            for (Lecture lecture : lecturesList){
                if (lecture.getId() == index) {return lecture;}
            }
            throw new NoSuchElementException();
       }
}








