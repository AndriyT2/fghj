package repository;

import models.Person;
import utility.PersonLastnameComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PersonRepository {
    private List<Person> personList;

    private static PersonRepository instance;

    private PersonRepository() {
        this.personList = new ArrayList<>();
    }

        public static PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }


    public List<Person> getPersonList() {
        return personList;
    }
    public void getAll() {
        System.out.println(PersonRepository.getInstance().getPersonList());
    }
    public Person getById(int index) {
        for (Person person : personList){
            if (person.getId() == index) {return person;}
        }
        throw new NoSuchElementException();
    }

    public void personSortByLastname() {
        List<Person> tmp = new ArrayList<>(PersonRepository.getInstance().getPersonList());
        tmp.sort(new PersonLastnameComparator());
        System.out.println(tmp);
    }

}
