package service;

import models.Person;
import models.Role;
import repository.PersonRepository;

import java.util.Scanner;

public class PersonService {
    public void addPerson () {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Чи бажаєте створити новий елемент Person? [Y/N]");
            String ask = scanner.nextLine();

            if (ask.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати новий елемент!");
                break;

            } else if (ask.equalsIgnoreCase("y")) {

                PersonRepository personRepository = PersonRepository.getInstance();
                PersonRepository.getInstance().getAll();

                int ask1;

                do {
                    System.out.println("Введіть числове значення для вибору необхідного критерія: \n1 Студент;\n2 Вчитель.");
                    ask1 = scanner.nextInt();
                    scanner.nextLine();
                } while (ask1 < 1 | ask1 > 2);

                if (ask1 == 1) {
                    System.out.println("Ви створили нового студента.");
                    Person personS = new Person(Role.STUDENT);
                    personRepository.add(personS);
                    personRepository.getAll();
                    break;

                } else {
                    System.out.println("Ви створили нового вчителя.");
                    Person personT = new Person(Role.TEACHER);
                    personRepository.add(personT);
                    personRepository.getAll();
                    break;
                }

            } else {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                break;
            }

        }
    }
    public void setPhone (int idPerson) {
        PersonRepository.getInstance().exist(idPerson);
        PersonRepository.getInstance().getAll();
        System.out.println("Введіть номер телефона в наступному форматі: +ххххххххххх.");
        Scanner scannerP = new Scanner(System.in);
        String phone = scannerP.nextLine();
        String phoneNorm = phone.trim();
//       +12343454556;
        boolean result = phoneNorm.matches("(\\+*)\\d{11}");
        while (!result){
            System.out.println("Ви ввели некоректний телефон!\nВведіть новий телефон!");
            phone = scannerP.nextLine();
            phoneNorm = phone.trim();
            result = phoneNorm.matches("(\\+*)\\d{11}");
        }
        System.out.println("Номер телефона:  " + phoneNorm);
        Person person = PersonRepository.getInstance().get(idPerson);
        person.setPhone(phoneNorm);
    }
    public void setFirstname (int idPerson) {
        PersonRepository.getInstance().exist(idPerson);
        PersonRepository.getInstance().getAll();
        System.out.println("Введіть необхідне ім'я!");
        Scanner scannerP = new Scanner(System.in);
        String firstname = scannerP.nextLine();
        String firstnameNorm = firstname.trim();
        boolean result = firstnameNorm.matches("^([A-Za-z][A-Za-z\\-\\']{1,50})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-\\']{1,50})$");
        while (!result){
            System.out.println("Ви ввели некоректне ім'я!\nВведіть ім'я знову!");
            firstname = scannerP.nextLine();
            firstnameNorm = firstname.trim();
            result = firstnameNorm.matches("^([A-Za-z][A-Za-z\\-\\']{1,50})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-\\']{1,50})$");
        }
        System.out.println("Ім'я:  " + firstnameNorm);
        Person person = PersonRepository.getInstance().get(idPerson);
        person.setFirstname(firstnameNorm);
    }

    public void setLastname (int idPerson) {
        PersonRepository.getInstance().exist(idPerson);
        PersonRepository.getInstance().getAll();
        System.out.println("Введіть необхідне прізвище!");
        Scanner scannerP = new Scanner(System.in);
        String lastname = scannerP.nextLine();
        String lastnameNorm = lastname.trim();
        boolean result = lastnameNorm.matches("^([A-Za-z][A-Za-z\\-\\']{1,100})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-\\']{1,100})$");
        while (!result){
            System.out.println("Ви ввели некоректне прізвище!\nВведіть прізвище знову!");
            lastname = scannerP.nextLine();
            lastnameNorm = lastname.trim();
            result = lastnameNorm.matches("^([A-Za-z][A-Za-z\\-\\']{1,100})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-\\']{1,100})$");
        }
        System.out.println("Прізвище:  " + lastnameNorm);
        Person person = PersonRepository.getInstance().get(idPerson);
        person.setLastname(lastnameNorm);
    }

    public void setEmail (int idPerson) {
        PersonRepository.getInstance().exist(idPerson);
        PersonRepository.getInstance().getAll();
        System.out.println("Введіть необхідну поштову скриньку!");
        Scanner scannerP = new Scanner(System.in);
        String email = scannerP.nextLine();
        String emailNorm = email.trim();
        boolean result = emailNorm.matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$");
        while (!result){
            System.out.println("Ви ввели некоректну поштову скриньку!\nВведіть поштову скриньку!");
            email = scannerP.nextLine();
            emailNorm = email.trim();
            result = emailNorm.matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$");
        }
        System.out.println("Поштова скринька:  " + emailNorm);
        Person person = PersonRepository.getInstance().get(idPerson);
        person.setEmail(emailNorm);
    }
}
