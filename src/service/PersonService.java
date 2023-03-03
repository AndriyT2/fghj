package service;

import models.Person;
import models.Role;
import repository.PersonRepository;
import utility.IntTrue;
import utility.comparator.PersonLastnameComparator;
import utility.ScannerThis;
import utility.utilityLog.LogFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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


}
