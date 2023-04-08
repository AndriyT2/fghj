package service;


import main.Main11;
import models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.*;
import service.controlWork.ControlWork14;
import service.courseBackup.WriteBackup;
import utility.IntTrue;
import utility.ScannerThis;
import utility.regex.CourseRegex;
import utility.regex.LectureRegex;
import utility.regex.PersonRegex;
import utility.server.ClientSocket;
import utility.server.SelectorServer;
import utility.utilityLog.LogFactory;
import utility.utilityLog.LogReader;
import utility.utilityLog.LogWriter;

import java.io.IOException;
import java.time.LocalDateTime;


public class Menu {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Main11.class);


    public void menu() throws IOException {


        ctx.getBean(CourseService.class).createCourse("CCCCCCCCC");
        ctx.getBean(CourseService.class).createCourse("AAAAAAAA");
        ctx.getBean(CourseService.class).createCourse("BBBBBBBBB");


        ctx.getBean(PersonService.class).addPerson("CCCCCCCC", "BBBBBB", Role.TEACHER);
        ctx.getBean(PersonService.class).addPerson("AAAAAAA", "BBBBB", Role.TEACHER);
        ctx.getBean(PersonService.class).addPerson("AAAA", "aaaaaa", Role.TEACHER);
        ctx.getBean(PersonService.class).addPerson("BBBBBBBBB", "BBBBBB", Role.TEACHER);
        ctx.getBean(PersonService.class).addPerson("nnnnnnnn", "mmmmmmmm", Role.STUDENT);

        ctx.getBean(AdditionalMaterialsService.class).createAdditionalMaterialsService("CCCCCCC", 12, ResourceType.VIDEO);
        ctx.getBean(AdditionalMaterialsService.class).createAdditionalMaterialsService("AAAAAAA", 13, ResourceType.URL);
        ctx.getBean(AdditionalMaterialsService.class).createAdditionalMaterialsService("BBBBBBB", 14, ResourceType.URL);
        ctx.getBean(AdditionalMaterialsService.class).createAdditionalMaterialsService("AAAAAAA", 12, ResourceType.BOOK);


        ctx.getBean(LectureService.class).createLecture(2);
        ctx.getBean(LectureService.class).createLecture(3);
        ctx.getBean(LectureService.class).createLecture(4);
        ctx.getBean(LectureService.class).createLectureWithTeacher(5);
        ctx.getBean(LectureService.class).createLectureWithTeacher(6);
        ctx.getBean(LectureService.class).createLectureWithTeacher(7);
        ctx.getBean(LectureService.class).createLectureWithTeacher(8);


        ctx.getBean(HomeworkService.class).createHomeworkWithLectureId(16);
        ctx.getBean(HomeworkService.class).createHomeworkWithLectureId(14);
        ctx.getBean(HomeworkService.class).createHomeworkWithLectureId(15);


        LogFactory.debug(this.getClass().getName(), "CREATE NEW MENU");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "Menu.List with options");
                System.out.println("""
                        Виберіть числове значення категорії для подальшої роботи:
                        1 - Курс;
                        2 - Лекція;
                        3 - Домашня робота;
                        4 - Додаткові матеріали;
                        5 - Особа;
                        6 - LogFile;
                        7 - Контрольна робота;
                        8 - Server;
                        9 - Завершення роботи з програмою.""");

                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 9);

            switch (answer) {
                case 1 -> {
                    System.out.println("Ви вибрали категорію - Курс.");
                    courseMenu();
                }
                case 2 -> {
                    System.out.println("Ви вибрали категорію - Лекція.");
                    lectureMenu();
                }
                case 3 -> {
                    System.out.println("Ви вибрали категорію - Домашня робота.");
                    homeworkMenu();
                }
                case 4 -> {
                    System.out.println("Ви вибрали категорію - Додаткові матеріали.");
                    additionalMaterialsMenu();
                }
                case 5 -> {
                    System.out.println("Ви вибрали категорію - Особа.");
                    personMenu();
                }
                case 6 -> {
                    System.out.println("Ви вибрали категорію - LogFile.");
                    logFileMenu();

                }
                case 7 -> {
                    ControlWork14 controlWork = new ControlWork14();
                    controlWork.runControlWork();
                    LogFactory.debug(this.getClass().getName(), "Create new Control Work");
                }
                case 8 -> {
                    System.out.println("\nВи вибрали категорію - Server.");
                    serverMenu();
                }
                case 9 -> {
                    System.out.println("Ви вибрали категорію - Завершення роботи з програмою.");
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "CLOSE MENU");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }

        ScannerThis.getInstance().close();
    }

    private void courseMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new courseMenu");

        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "courseMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести список існуючих курсів;
                        2 - Створити курс;
                        3 - Відкрити курс по його ID;
                        4 - Backup курсу по його ID;
                        5 - Вивести на екран вміст backup;
                        6 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 6);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих курсів:");
                    CourseRepository.getInstance().getAll();
                }
                case 2 -> {

                    System.out.println("Введіть назву нового курсу:");
                    String courseName = ScannerThis.getInstance().nextLine();
                    String afterRegex = CourseRegex.setCourseNameMenu(courseName);
                    ctx.getBean(CourseService.class).courseScanner(afterRegex);
                }
                case 3 -> {
                    System.out.println("Введіть значення ID для курсу:");
                    int courseId = ctx.getBean(IntTrue.class).intTrue();
                    Course course = CourseRepository.getInstance().getById(courseId);
                    System.out.println(course);
                }

                case 4 -> {
                    ctx.getBean(WriteBackup.class);
                }
                case 5 -> {
                    System.out.println("Вміст файлу backup:");
                    new service.courseBackup.ReadBackup();
                }

                case 6 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close courseMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void lectureMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new lectureMenu");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "lectureMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести список існуючих лекції;
                        2 - Створити нову лекцію;
                        3 - Відкрити домашнє завдання та додаткові матеріали для лекції по її ID;
                        4 - Додати дату проведення лекції до існуючої лекції;
                        5 - Сортувати лекції за датою;
                        6 - Вивести на екран лекції, згруповані за вчителем;
                        7 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 7);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих лекцій:");
                    LectureRepository.getInstance().getAll();
                }
                case 2 -> {

                    ctx.getBean(LectureService.class).createLecture();
                    System.out.println("Була створена нова лекція.");

                }
                case 3 -> {
                    System.out.println("Введіть значення ID для лекції:");
                    int lectureId = ctx.getBean(IntTrue.class).intTrue();
                    ctx.getBean(LectureService.class).lectureWithHomeworkAndAMById(lectureId);
                }
                case 4 -> {
                    System.out.println("Введіть значення ID для лекції:");
                    int lectureId = ctx.getBean(IntTrue.class).intTrue();
                    ctx.getBean(LectureService.class).setDate(lectureId);
                }
                case 5 -> {
                    lectureDateSortMenu();
                }
                case 6 -> {
                    ctx.getBean(LectureService.class).lecturesSortedByTeacher();
                }

                case 7 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close lectureMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void lectureDateSortMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new lectureDateSortMenu");
        boolean exit = false;
        int answer;

        while (!exit) {


            do {
                LogFactory.debug(this.getClass().getName(), "lectureDateSortMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести на екран лекції з вказаної дати;
                        2 - Вивести на екран лекції до вказаної дати;
                        3 - Вивести на екран лекції між вказаними дати;
                        4 - Вивести на екран лекцію, яка створена раніше за всіх та має найбільшу кількість додаткових матеріалів;
                        5 - Повернутися в головне меню.""");


                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 5);

            switch (answer) {
                case 1 -> {
                    LocalDateTime data1 = LectureRegex.DateLectureRegex();
                    ctx.getBean(LectureService.class).sortByDate(localDateTime -> localDateTime.isAfter(data1));
                    LogFactory.debug(this.getClass().getName(), "Lectures after date");
                }
                case 2 -> {
                    LocalDateTime data1 = LectureRegex.DateLectureRegex();
                    ctx.getBean(LectureService.class).sortByDate(localDateTime -> localDateTime.isBefore(data1));
                    LogFactory.debug(this.getClass().getName(), "Lectures before date");
                }
                case 3 -> {
                    LocalDateTime data1 = LectureRegex.DateLectureRegex();
                    System.out.println("Друга дата.");
                    LocalDateTime data2 = LectureRegex.DateLectureRegex();
                    if (data1.isBefore(data2)) {
                        ctx.getBean(LectureService.class).sortByDate(localDateTime -> localDateTime.isAfter(data1) && localDateTime.isBefore(data2));
                    } else {
                        ctx.getBean(LectureService.class).sortByDate(localDateTime -> localDateTime.isAfter(data2) && localDateTime.isBefore(data1));
                    }
                    LogFactory.debug(this.getClass().getName(), "Lectures between date");

                }
                case 4 -> {
                    ctx.getBean(LectureService.class).findOldestLecture();

                }

                case 5 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close lectureDateSortMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }


    private void homeworkMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new homeworkMenu");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "homeworkMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести список існуючих домашных завдань;
                        2 - Створити домашнє завдання;
                        3 - Видалити домашнє завдання;
                        4 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 4);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих домашных завдань:");
                    System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
                }
                case 2 -> {

                    System.out.println("Список існуючих лекцій:");
                    LectureRepository.getInstance().getAll();
                    System.out.println("Введіть ID лекції для нового домашнього завдання:");
                    int lectureId = ctx.getBean(IntTrue.class).intTrue();
                    ctx.getBean(HomeworkService.class).createHomeworkWithLectureId(lectureId);
                    System.out.println("Була створена нова домашня робота.");

                }
                case 3 -> {
                    System.out.println("Список існуючих домашніх завдань:");
                    System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
                    System.out.println("Введіть значення ID для лекції:");
//                    System.out.println("Enter a lectureId to remove Homework:");
                    int lectureId = ctx.getBean(IntTrue.class).intTrue();
                    ctx.getBean(HomeworkService.class).homeworkRemoveMenu(lectureId);
                    System.out.println("Домашнє завдання для лекції з " + lectureId + " видалено!");


                }


                case 4 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close homeworkMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void additionalMaterialsMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new additionalMaterialsMenu");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "additionalMaterialsMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести список існуючих додаткових матеріалів;
                        2 - Створити додаткові матеріали;
                        3 - Видалити додаткові матеріали;
                        4 - Вивести всі додаткові матеріали, згруповані за лекціями;
                        5 - Вивести всі додаткові матеріали, згруповані за ID лекції;
                        6 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 6);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих додаткових матеріалів:");
                    System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());
                }
                case 2 -> {

                    System.out.println("Список існуючих лекцій:");
                    LectureRepository.getInstance().getAll();
                    System.out.println("Введіть назву для нових додаткових матеріалів:");
                    String name = ScannerThis.getInstance().nextLine();
                    System.out.println("Введіть ID лекції для нових додаткових матеріалів:");
                    int lectureId = ctx.getBean(IntTrue.class).intTrue();
                    ctx.getBean(AdditionalMaterialsService.class).createAdditionalMaterialsService(name, lectureId);
                    System.out.println("Були створены новы домашні матеріали.");

                }
                case 3 -> {
                    System.out.println("Список існуючих домашніх завдань:");
                    System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
                    System.out.println("Введіть значення ID для лекції:");
//                    System.out.println("Enter a lectureId to remove AdditionalMaterials:");
                    int lectureId = ctx.getBean(IntTrue.class).intTrue();
                    ctx.getBean(AdditionalMaterialsService.class).removeAdditionalMaterialsMenu(lectureId);
                    System.out.println("Додаткові матеріали для лекції з " + lectureId + " видалено!");
                }
                case 4 -> {
                    ctx.getBean(AdditionalMaterialsService.class).allAdditionalMaterialsSortedBySMT(
                            LectureRepository.getInstance().getLecturesList(),
                            AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList(),
                            System.out::println, System.out::println, ModelsSuper::getId, AdditionalMaterials::getLectureId);

                }
                case 5 -> {
                    ctx.getBean(AdditionalMaterialsService.class).additionalMaterialsSortedByLectureId();

                }

                case 6 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close additionalMaterialsMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void personMenu() throws IOException {
        LogFactory.debug(this.getClass().getName(), "Create new  personMenu");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "personMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести список існуючих осіб;
                        2 - Створити особу;
                        3 - Відсортувати осіб по фамілії;
                        4 - Вивести список вчителів прізвища яких починаються з літер, які стоять до певної літери;
                        5 - Додати поштову скриньку;
                        6 - Вивести на екран поштову скриньку, ім'я, фамілію;
                        7 - Записати в файл поштові скриньки студентів, відсортовані в натуральному порядку;
                        8 - Повернутися в головне меню.""");


                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 8);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих осіб:");
                    System.out.println(PersonRepository.getInstance().getPersonList());
                }
                case 2 -> {
                    ctx.getBean(PersonService.class).addPersonMenu();
                }
                case 3 -> {
                    System.out.println("Список існуючих осіб до сортування:");
                    PersonRepository.getInstance().getAll();
                    System.out.println("Список існуючих осіб після сортування:");
                    ctx.getBean(PersonService.class).personSortByLastname();
                }
                case 4 -> {
                    System.out.println("Введіть значення букви:");
                    String letter = ScannerThis.getInstance().nextLine().toUpperCase().trim().substring(0, 1);
                    ctx.getBean(PersonService.class).getTeacherBeforeLetter(letter);

                }
                case 5 -> {
                    System.out.println("Введіть значення ID особи для додавання поштової скриньки:");
                    int personId = ctx.getBean(IntTrue.class).intTrue();

                    String finalEmailNorm = PersonRegex.setEmail();

                    if (PersonRepository.getInstance().getPersonList().stream().
                            filter(person -> person.getEmail() != null).
                            anyMatch(person -> person.getEmail().equalsIgnoreCase(finalEmailNorm))) {
                        System.out.println("Така поштова скринька вже існує!\nВведіть іншу поштову скриньку.");
                    } else {
                        Person person = PersonRepository.getInstance().getById(personId);
                        person.setEmail(finalEmailNorm);
                        LogFactory.debug(this.getClass().getName(), "Add new e-mail to person");
                    }
                }
                case 6 -> {
                    ctx.getBean(PersonService.class).firstAndLastNameAndEmail();
                }
                case 7 -> {
                    ctx.getBean(PersonService.class).emailStudentToFile();
                }

                case 8 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close personMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void logFileMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new  logFileMenu");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "logFileMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Вивести вміст LogFile;
                        2 - Змінити рівень логування;
                        3 - Вивести повідомлення з LogFile;
                        4 - Вивести кількість логів з рівнем INFO починаючи з середини файлу;            
                        5 - Повернутися в головне меню.""");

                answer = ctx.getBean(IntTrue.class).intTrue();

            } while (answer < 1 || answer > 5);

            switch (answer) {
                case 1 -> {
                    System.out.println("Вміст LogFile:");
                    ctx.getBean(LogReader.class).readDataFromFile();
                }
                case 2 -> {
                    ctx.getBean(LogWriter.class).levelChange();
                }
                case 3 -> {
                    ctx.getBean(LogReader.class).readMessageFromFile();
                }

                case 4 -> {
                    ctx.getBean(LogReader.class).logInfoCounter();
                }

                case 5 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close logFileMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void serverMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new  serverMenu");
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "serverMenu.List with options");
                System.out.println("""
                        \nВиберіть числове значення бажаної дії для подальшої роботи:
                        1 - Запустити SelectorServer;
                        2 - Запустити ClientSocket;                    
                        3 - Повернутися в головне меню.""");

                answer = ctx.getBean(IntTrue.class).intTrue();

            } while (answer < 1 || answer > 3);

            switch (answer) {
                case 1 -> {
                    new SelectorServer();
                }
                case 2 -> {
                    new ClientSocket();
                }

                case 3 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close serverMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

}
