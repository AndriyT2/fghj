package repository;

import models.Lecture;

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








