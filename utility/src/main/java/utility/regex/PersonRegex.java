package utility.regex;

import models.Person;
import repository.PersonRepository;
import utility.ScannerThis;
import utility.exception.SetParameterException;
import utility.utilityLog.LogFactory;


public class PersonRegex {
    public static void setPhone(int idPerson) {
        final String rule = "(\\+*)\\d{12}";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть номер телефона в наступному форматі: +хххххххххххx.");
        String phone = ScannerThis.getInstance().nextLine();
        String phoneNorm = phone.trim();
        boolean result = phoneNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректний телефон!");
            } catch (SetParameterException e) {
                System.err.println("Введіть телефон знову у правильному форматі!");
                phone = ScannerThis.getInstance().nextLine();
                phoneNorm = phone.trim();
                result = phoneNorm.matches(rule);
            }
        }
        System.out.println("Номер телефона:  " + phoneNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setPhone(phoneNorm);
    }

    public static void setFirstname(int idPerson) {
        final String rule = "^([A-Za-z][A-Za-z\\-']{1,50})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-']{1,50})$";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть необхідне ім'я!");
        String firstname = ScannerThis.getInstance().nextLine();
        String firstnameNorm = firstname.trim();
        boolean result = firstnameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректне ім'я!");
            } catch (SetParameterException e) {
                System.err.println("Введіть ім'я знову в правильному форматі!");
                firstname = ScannerThis.getInstance().nextLine();
                firstnameNorm = firstname.trim();
                result = firstnameNorm.matches(rule);
            }
        }
        System.out.println("Ім'я:  " + firstnameNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setFirstname(firstnameNorm);
    }

    public static void setLastname(int idPerson) {
        final String rule = "^([A-Za-z][A-Za-z\\-']{1,100})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-']{1,100})$";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть необхідне прізвище!");
        String lastname = ScannerThis.getInstance().nextLine();
        String lastnameNorm = lastname.trim();
        boolean result = lastnameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректне прізвище!");
            } catch (SetParameterException e) {
                System.err.println("Введіть прізвище знову в правильеому форматі!");
                lastname = ScannerThis.getInstance().nextLine();
                lastnameNorm = lastname.trim();
                result = lastnameNorm.matches(rule);
            }
        }
        System.out.println("Прізвище:  " + lastnameNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setLastname(lastnameNorm);
    }

    public static String setEmail() {
        final String rule = "^([a-z0-9_.-]+)@([\\da-z.-]+)\\.([a-z.]{2,6})$";
        System.out.println("Введіть необхідну поштову скриньку!");
        String email = ScannerThis.getInstance().nextLine();
        String emailNorm = email.trim();
        boolean result = emailNorm.matches(rule);

        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректну поштову скриньку!");
            } catch (SetParameterException e) {
                LogFactory.warning(Thread.currentThread().getStackTrace()[1].getClassName(), "Uncorrected e-mail format", e.getStackTrace());
                System.err.println("Введіть поштову скриньку в правильному форматі!");
                email = ScannerThis.getInstance().nextLine();
                emailNorm = email.trim();
                result = emailNorm.matches(rule);
            }
        }
        return emailNorm;
    }
}
