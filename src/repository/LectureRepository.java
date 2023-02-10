package repository;

import models.Lecture;
import utilityLog.LogFactory;

import java.util.ArrayList;
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
        LogFactory.info(this.getClass().getName(), "Display LectureRepository");

    }

    public Lecture getById(int index) {
            for (Lecture lecture : lecturesList){
                if (lecture.getId() == index) {return lecture;}
            }
            throw new NoSuchElementException();
       }
}








