package repository;

import models.Person;

public class PersonRepository extends  RepositorySuper {

    private static PersonRepository instance;

    private PersonRepository() {
        this.arraySuper = new Person[STANDARD_CAPACITY];
    }

        public static PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }

}
