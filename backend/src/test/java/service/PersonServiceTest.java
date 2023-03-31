package service;

import models.Person;
import models.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

class PersonServiceTest {


    @Test
    public void countStudentReturnTrueIfTestListIsEmpty() {
        List<Person> people = new ArrayList<>();
        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        try (MockedStatic<PersonRepository> s = Mockito.mockStatic(PersonRepository.class)) {
            s.when(PersonRepository::getInstance).thenReturn(personRepository);
            given(personRepository.getPersonList()).willReturn(people);
            PersonService p = new PersonService();
            int result = p.countStudent();
            Assertions.assertEquals(0, result);
        }
    }

    @Test
    public void countStudentReturnTrueIfTestListsAreEquals() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("A", Role.STUDENT));
        people.add(new Person("B", Role.TEACHER));
        people.add(new Person("C", Role.STUDENT));
        people.add(new Person("D", Role.TEACHER));


        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        try (MockedStatic<PersonRepository> s = Mockito.mockStatic(PersonRepository.class)) {
            s.when(PersonRepository::getInstance).thenReturn(personRepository);
            given(personRepository.getPersonList()).willReturn(people);
            PersonService p = new PersonService();
            int result = p.countStudent();
            Assertions.assertEquals(2, result);
        }
    }

    @Test
    void studentListReturnTrueIfTestListsAreEquals() {
        Person person1 = new Person("A", Role.STUDENT);
        Person person2 = new Person("A", Role.TEACHER);
        Person person3 = new Person("A", Role.STUDENT);
        Person person4 = new Person("A", Role.TEACHER);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);


        List<Person> student = new ArrayList<>();
        student.add(person1);
        student.add(person3);

        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        try (MockedStatic<PersonRepository> s = Mockito.mockStatic(PersonRepository.class)) {
            s.when(PersonRepository::getInstance).thenReturn(personRepository);
            given(personRepository.getPersonList()).willReturn(people);
            PersonService p = new PersonService();
            Assertions.assertEquals(student, p.studentList());
        }
    }

    @Test
    void teacherListReturnTrueIfTestListsAreEquals() {
        Person person1 = new Person("A", Role.STUDENT);
        Person person2 = new Person("A", Role.TEACHER);
        Person person3 = new Person("A", Role.STUDENT);
        Person person4 = new Person("A", Role.TEACHER);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);


        List<Person> teacher = new ArrayList<>();
        teacher.add(person2);
        teacher.add(person4);

        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        try (MockedStatic<PersonRepository> s = Mockito.mockStatic(PersonRepository.class)) {
            s.when(PersonRepository::getInstance).thenReturn(personRepository);
            given(personRepository.getPersonList()).willReturn(people);
            PersonService p = new PersonService();
            Assertions.assertEquals(teacher, p.teacherList());
        }
    }

    @Test
    void teacherListReturnFalseIfTestListsAreNotEqual() {
        Person person1 = new Person("A", Role.STUDENT);
        Person person2 = new Person("A", Role.TEACHER);
        Person person3 = new Person("A", Role.STUDENT);
        Person person4 = new Person("A", Role.TEACHER);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person3);


        List<Person> teacher = new ArrayList<>();
        teacher.add(person2);
        teacher.add(person4);

        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        try (MockedStatic<PersonRepository> s = Mockito.mockStatic(PersonRepository.class)) {
            s.when(PersonRepository::getInstance).thenReturn(personRepository);
            given(personRepository.getPersonList()).willReturn(people);
            PersonService p = new PersonService();
            Assertions.assertNotEquals(teacher, p.teacherList());
        }
    }
}