package service;

import models.Person;
import models.Role;
import repository.PersonRepository;
import utility.IntTrue;
import utility.comparator.PersonLastnameComparator;
import utility.ScannerThis;
import utility.utilityLog.LogFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PersonService implements Serializable {

    public void addPerson(String lastname, String firstname, Role role) {
        LogFactory.debug(this.getClass().getName(), "Create new person");
        PersonRepository.getInstance().getPersonList().add(new Person(lastname, firstname, role));
    }
    public void addPerson () {

        while (true) {

            System.out.println("Чи бажаєте створити новий елемент Person? [Y/N]");
            String ask = ScannerThis.getInstance().nextLine();

            if (ask.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати новий елемент!");
                break;

            } else if (ask.equalsIgnoreCase("y")) {

                PersonRepository personRepository = PersonRepository.getInstance();
                System.out.println(PersonRepository.getInstance().getPersonList());

                int ask1;

                do {
                    System.out.println("Введіть числове значення для вибору необхідного критерія: \n1 Студент;\n2 Вчитель.");
                    ask1 = ScannerThis.getInstance().nextInt();
                    ScannerThis.getInstance().nextLine();
                } while (ask1 < 1 | ask1 > 2);

                if (ask1 == 1) {
                    System.out.println("Ви створили нового студента.");
                    Person personS = new Person(Role.STUDENT);
                    personRepository.getPersonList().add(personS);
                    System.out.println(PersonRepository.getInstance().getPersonList());

                } else {
                    System.out.println("Ви створили нового вчителя.");
                    Person personT = new Person(Role.TEACHER);
                    personRepository.getPersonList().add(personT);
                    System.out.println(PersonRepository.getInstance().getPersonList());
                }

            } else {
                throw new IllegalArgumentException();
            }

        }
    }


    public void addPersonMenu () {

                int ask1;

                do {
                    System.out.println("Введіть числове значення для вибору необхідного критерія: \n1 Студент;\n2 Вчитель.");
                    ask1 = new IntTrue().intTrue();
                } while (ask1 < 1 | ask1 > 2);

                if (ask1 == 1) {
                    System.out.println("Ви створили нового студента.");
                    Person personS = new Person(Role.STUDENT);
                    PersonRepository.getInstance().getPersonList().add(personS);

                } else {
                    System.out.println("Ви створили нового вчителя.");
                    Person personT = new Person(Role.TEACHER);
                    PersonRepository.getInstance().getPersonList().add(personT);
                }
    }

    public void personSortByLastname() {
        List<Person> tmp = new ArrayList<>(PersonRepository.getInstance().getPersonList());
        tmp.sort(new PersonLastnameComparator());
        System.out.println(tmp);
    }

    public int countStudent() {
        int counter = 0;
        for (Person person: PersonRepository.getInstance().getPersonList()) {
          if (person.getRole() == Role.STUDENT) {++counter;}
        }
        return counter;
    }

    public List<Person> studentList() {
        List<Person> student = new ArrayList<>();
        for (Person person : PersonRepository.getInstance().getPersonList()) {
            if (person.getRole() == Role.STUDENT) {
                student.add(person);
            }
        }
        return student;
    }

    public List<Person> teacherList() {
        List<Person> teacher = new ArrayList<>();
        for (Person person : PersonRepository.getInstance().getPersonList()) {
            if (person.getRole() == Role.TEACHER) {
                teacher.add(person);
            }
        }
        LogFactory.debug(this.getClass().getName(), "Create teacher list");
        return teacher;
    }


    public void getTeacherBeforeLetter(String letter){
        List<Person> teacher = teacherList().stream()
                .filter(person -> person.getLastname().substring(0, 1)
                        .compareTo(letter) < 0 )
                .toList();
        System.out.println(teacher);
        LogFactory.info(this.getClass().getName(), "Display teacher list before letter");


    }

    public void firstAndLastNameAndEmail(){
        System.out.println("Поштова скринька - Ім'я Фамілія");
       Map<String, String> person = PersonRepository.getInstance().getPersonList().stream()
               .filter(person1 -> person1.getEmail() != null )
               .collect(Collectors.toMap(Person::getEmail, p1 ->(p1.getFirstname()+ " " + p1.getLastname())));
       person.forEach((k,v) -> System.out.println(k + " - " + v));
       LogFactory.info(this.getClass().getName(), "Display Firstname And LastName And Email");
    }

    public void emailStudentToFile() throws IOException {

        final String FILE = "Student_Email.txt";


        Writer writer = new OutputStreamWriter(new FileOutputStream(FILE), StandardCharsets.UTF_8);
        writer.write(

                PersonRepository.getInstance().getPersonList().stream()
                .filter(p -> p.getRole() == Role.STUDENT)
                .filter(p -> p.getEmail() != null)
                .map(Person::getEmail)
                .sorted(Comparator.naturalOrder()).toList().toString());

        writer.close();
        LogFactory.info(this.getClass().getName(), "Create new version of students e-mail");
    }


}
