package repository;

import models.Lecture;
import models.Person;

import java.util.Arrays;

public class LectureRepository extends RepositorySuper<Lecture> {


        private static LectureRepository instance;

        private LectureRepository() {
            this.arraySuper = new Lecture[STANDARD_CAPACITY];
        }

        public static LectureRepository getInstance() {
            if (instance == null) {
                instance = new LectureRepository();
            }
            return instance;
        }

    }








