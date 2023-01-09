package service;

import models.ModelsSuper;
import models.Person;
import models.Role;
import repository.PersonRepository;

import java.util.Scanner;

public class PersonService {
    public void addPerson () {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Чи бажаєте створити новий елемент? [Y/N]");
            String ask = scanner.nextLine();

            if (ask.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати новий елемент!");
                break;

            } else if (ask.equalsIgnoreCase("y")) {

                PersonRepository personRepository = new PersonRepository();

                int ask1;

                do {
                    System.out.println("Введіть числове значення для вибору необхідного критерія: \n1 Студент;\n2 Вчитель.");
                    ask1 = scanner.nextInt();
                    scanner.nextLine();
                } while (ask1 < 1 | ask1 > 2);

                switch (ask1) {

                    case 1:
                        System.out.println("Ви створили нового студента.");
                        Person personS = new Person(Role.STUDENT);
                        personRepository.add(personS);
                        break;

                    case 2:
                        System.out.println("Ви створили нового вчителя.");
                        Person personT = new Person(Role.TEACHER);
                        personRepository.add(personT);
                        break;

                }

            } else {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                break;
            }

        }
    }
}
