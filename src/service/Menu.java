package service;

import models.AdditionalMaterials;
import models.Course;
import models.Lecture;
import models.ModelsSuper;
import repository.*;
import service.ControlWork.ControlWork14;
import utility.IntTrue;
import utility.ScannerThis;
import utility.regex.CourseRegex;
import utility.utilityLog.LogFactory;
import utility.utilityLog.LogReader;
import utility.utilityLog.LogWriter;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import static utility.regex.LectureRegex.DateLectureRegex;


public class Menu {
public void menu() {
    LogFactory.debug(this.getClass().getName(), "CREATE NEW MENU");
    boolean exit = false;
    int answer;
    while (!exit){
        do{
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
            8 - Завершення роботи з програмою.""");

    answer = new IntTrue().intTrue();

        }while (answer<1 || answer>8);

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
                ControlWork14 controlWork  = new ControlWork14();
                controlWork.runControlWork();
                LogFactory.debug(this.getClass().getName(), "Create new Control Work");


            }
            case 8 -> {
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
        CourseService courseService = new CourseService();
        LogFactory.debug(this.getClass().getName(), "Create new courseMenu");

        boolean exit = false;
        int answer;
        while (!exit){
            do{
                LogFactory.debug(this.getClass().getName(), "courseMenu.List with options");
                System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Вивести список існуючих курсів;
            2 - Створити курс;
            3 - Відкрити курс по його ID;
            4 - Backup курсу по його ID;
            5 - Вивести на екран вміст backup;
            6 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            }while (answer<1 || answer>6);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих курсів:");
                    CourseRepository.getInstance().getAll();
                }
                case 2 -> {

                    System.out.println("Введіть назву нового курсу:");
                    String courseName = ScannerThis.getInstance().nextLine();
                    String afterRegex = CourseRegex.setCourseNameMenu(courseName);
                    courseService.courseScanner(afterRegex);
                }
                case 3 -> {
                    System.out.println("Введіть значення ID для курсу:");
                    int courseId = new  IntTrue().intTrue();
                    Course course = CourseRepository.getInstance().getById(courseId);
                    System.out.println(course);
                }

                case 4 -> {
                    service.courseBackup.CourseBackup backup = new service.courseBackup.CourseBackup();
                    try {
                        new service.courseBackup.WriteBackup(backup);
                    } catch (FileNotFoundException e) {
                        LogFactory.error(this.getClass().getName(), "Course Backup menu", e.getStackTrace());
                    }
                }
                case 5 -> {
                    System.out.println("Вміст файлу backup:");
                    service.courseBackup.ReadBackup readBackup = new service.courseBackup.ReadBackup();
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
        LectureService lectureService = new LectureService();
        boolean exit = false;
        int answer;
        while (!exit){
            do{
                LogFactory.debug(this.getClass().getName(), "lectureMenu.List with options");
                System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Вивести список існуючих лекції;
            2 - Створити нову лекцію;
            3 - Відкрити домашнє завдання та додаткові матеріали для лекції по її ID;
            4 - Додати дату проведення лекції до існуючої лекції;
            5 - Сортувати лекції за датою;
            6 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            }while (answer<1 || answer>6);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих лекцій:");
                    LectureRepository.getInstance().getAll();
                }
                case 2 -> {

                    lectureService.createLecture();
                    System.out.println("Була створена нова лекція.");

                }
                case 3 -> {
                    System.out.println("Введіть значення ID для лекції:");
                    int lectureId = new  IntTrue().intTrue();
                    lectureService.lectureWithHomeworkAndAMById(lectureId);
                }
                case 4 -> {
                    System.out.println("Введіть значення ID для лекції:");
                    int lectureId = new  IntTrue().intTrue();
                    lectureService.setDate(lectureId);
                }
                case 5 -> {
                    lectureDateSortMenu();
                }


                case 6 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close lectureMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

        private void lectureDateSortMenu() {
            LogFactory.debug(this.getClass().getName(), "Create new lectureDateSortMenu");
            LectureService lectureService = new LectureService();
            boolean exit = false;
            int answer;

            while (!exit){
//                boolean rule = false;
//                for(Lecture lecture : LectureRepository.getInstance().getLecturesList()){
//                    if (lecture.getLectureDate() != null) {
//                        rule = true;
//                        break;
//                    }
//                }
//                if (!rule){
//                    System.out.println("\nЖодній лекції не було задано значення дати!\n");
//                    exit = true;
//                }

                do{
                    LogFactory.debug(this.getClass().getName(), "lectureDateSortMenu.List with options");
                    System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Сортувати лекції з вказаної дати;
            2 - Сортувати лекції до вказаної дати;
            3 - Сортувати лекції між вказаними дати;
            4 - Повернутися в головне меню.""");



                    answer = new IntTrue().intTrue();

                }while (answer<1 || answer>4);

                switch (answer) {
                    case 1 -> {
                        LocalDateTime data1 = DateLectureRegex();
                        lectureService.sortByDate(localDateTime -> localDateTime.isAfter(data1));
                        LogFactory.debug(this.getClass().getName(), "Lectures after date");
                    }
                    case 2 -> {
                        LocalDateTime data1 = DateLectureRegex();
                        lectureService.sortByDate(localDateTime -> localDateTime.isBefore(data1));
                        LogFactory.debug(this.getClass().getName(), "Lectures before date");
                    }
                    case 3 -> {
                        LocalDateTime data1 = DateLectureRegex();
                        System.out.println("Друга дата.");
                        LocalDateTime data2 = DateLectureRegex();
                        if (data1.isBefore(data2)) {
                            lectureService.sortByDate(localDateTime -> localDateTime.isAfter(data1)&&localDateTime.isBefore(data2));
                        }else {
                            lectureService.sortByDate(localDateTime -> localDateTime.isAfter(data2)&&localDateTime.isBefore(data1));
                        }
                        LogFactory.debug(this.getClass().getName(), "Lectures between date");

                    }

                    case 4 -> {
                        exit = true;
                        LogFactory.debug(this.getClass().getName(), "Close lectureDateSortMenu");
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + answer);
                }

            }
        }






    private void homeworkMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new homeworkMenu");
        HomeworkService homeworkService = new HomeworkService();
        boolean exit = false;
        int answer;
        while (!exit){
            do{
                LogFactory.debug(this.getClass().getName(), "homeworkMenu.List with options");
                System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Вивести список існуючих домашных завдань;
            2 - Створити домашнє завдання;
            3 - Видалити домашнє завдання;
            4 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            }while (answer<1 || answer>4);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих домашных завдань:");
                    System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
                }
                case 2 -> {

                    System.out.println("Список існуючих лекцій:");
                    LectureRepository.getInstance().getAll();
                    System.out.println("Введіть ID лекції для нового домашнього завдання:");
                    int lectureId = new IntTrue().intTrue();
                    homeworkService.createHomeworkWithLectureId(lectureId);
                    System.out.println("Була створена нова домашня робота.");

                }
                case 3 -> {
                    System.out.println("Список існуючих домашніх завдань:");
                    System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
                    System.out.println("Введіть значення ID для лекції:");
//                    System.out.println("Enter a lectureId to remove Homework:");
                    int lectureId = new IntTrue().intTrue();
                    homeworkService.homeworkRemoveMenu(lectureId);
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
        AdditionalMaterialsService additionalMaterialsService = new AdditionalMaterialsService();
        boolean exit = false;
        int answer;
        while (!exit){
            do{
                LogFactory.debug(this.getClass().getName(), "additionalMaterialsMenu.List with options");
                System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Вивести список існуючих додаткових матеріалів;
            2 - Створити додаткові матеріали;
            3 - Видалити додаткові матеріали;
            4 - Вивести всі додаткові матеріали, згруповані за лекціями;
            5 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            }while (answer<1 || answer>5);

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
                    int lectureId = new IntTrue().intTrue();
                    additionalMaterialsService.createAdditionalMaterialsService(name, lectureId);
                    System.out.println("Були створены новы домашні матеріали.");

                }
                case 3 -> {
                    System.out.println("Список існуючих домашніх завдань:");
                    System.out.println(HomeworkRepository.getInstance().homeworkTreeMap());
                    System.out.println("Введіть значення ID для лекції:");
//                    System.out.println("Enter a lectureId to remove AdditionalMaterials:");
                    int lectureId = new IntTrue().intTrue();
                    additionalMaterialsService.removeAdditionalMaterialsMenu(lectureId);
                    System.out.println("Додаткові матеріали для лекції з " + lectureId + " видалено!");
                }
                case 4 -> {
                    additionalMaterialsService.allAdditionalMaterialsSortedBySMT(
                            LectureRepository.getInstance().getLecturesList(),
                            AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList(),
                            System.out::println, System.out::println, ModelsSuper::getId, AdditionalMaterials::getLectureId);

                }

                case 5 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close additionalMaterialsMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

    private void personMenu() {
        LogFactory.debug(this.getClass().getName(), "Create new  personMenu");
        PersonService personService = new PersonService();
        boolean exit = false;
        int answer;
        while (!exit){
            do{
                LogFactory.debug(this.getClass().getName(), "personMenu.List with options");
                System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Вивести список існуючих осіб;
            2 - Створити особу;
            3 - Відсортувати осіб по фамілії;
            4 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            }while (answer<1 || answer>4);

            switch (answer) {
                case 1 -> {
                    System.out.println("Список існуючих осіб:");
                    System.out.println(PersonRepository.getInstance().getPersonList());
                }
                case 2 -> {
                    personService.addPersonMenu();
                }
                case 3 -> {
                    System.out.println("Список існуючих осіб до сортування:");
                    PersonRepository.getInstance().getAll();
                    System.out.println("Список існуючих осіб після сортування:");
                    personService.personSortByLastname();
                }

                case 4 -> {
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
        while (!exit){
            do{
                LogFactory.debug(this.getClass().getName(), "logFileMenu.List with options");
                System.out.println("""
            Виберіть числове значення бажаної дії для подальшої роботи:
            1 - Вивести вміст LogFile;
            2 - Змінити рівень логування;
            3 - Повернутися в головне меню.""");

                answer = new IntTrue().intTrue();

            }while (answer<1 || answer>3);

            switch (answer) {
                case 1 -> {
                    System.out.println("Вміст LogFile:");
                    LogReader logReader = new LogReader();
                    logReader.readDataFromFile();
                }
                case 2 -> {
                    LogWriter log = new LogWriter();
                    log.levelChange();
                }

                case 3 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close logFileMenu");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }

        }
    }

}