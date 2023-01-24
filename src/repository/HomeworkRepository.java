package repository;

import models.Homework;

public class HomeworkRepository extends RepositorySuper<Homework> {

        private static repository.HomeworkRepository instance;

        private HomeworkRepository() {
            this.arraySuper = new Homework[STANDARD_CAPACITY];
        }

        public static repository.HomeworkRepository getInstance() {
            if (instance == null) {
                instance = new repository.HomeworkRepository();
            }
            return instance;
        }


    }

