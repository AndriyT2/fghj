package service;
import models.*;
import repository.CourseRepository;
import repository.LectureRepository;
import repository.PersonRepository;

import java.util.Arrays;
import java.util.Scanner;

public class LectureService {

    public Lecture createLecture() {
        return new Lecture();
    }

    public Lecture createLecture(int idCourse) {
        return new Lecture();

    }

    public Lecture createLectureWithTeacher(int idPerson) {
        return new Lecture().lectureWithTeacher(idPerson);

    }

    public Lecture createLecture(int idCourse, int idTeacher) {
        return new Lecture(idCourse, idTeacher);

    }
    public void lectureScanner(int idCourse) {
        int totalLectures = 0;
        Scanner lectureScanner = new Scanner(System.in);
        System.out.println("Чи бажаєте створити нову лекцію? [Так/Ні]");

        String lectureScannerAsk1 = lectureScanner.nextLine();

        if (lectureScannerAsk1.equals("Ні") | lectureScannerAsk1.equals("ні") | lectureScannerAsk1.equals("No") | lectureScannerAsk1.equals("no")) {

            System.out.println("Ви відмовилися створювати нову лекцію!");

        } else if (lectureScannerAsk1.equals("Так") | lectureScannerAsk1.equals("так") | lectureScannerAsk1.equals("Yes") | lectureScannerAsk1.equals("yes")) {

            Lecture lecture1H7 = new Lecture(idCourse);
            String lecture1H7Id = String.valueOf(lecture1H7.getIdCourse());
            totalLectures++;

            System.out.println("Створена нова лекція. Значення Id курсу для даної лекції становить: " + lecture1H7Id + ".");

            System.out.println("Чи бажаєте створити додаткову лекцію? [Так/Ні]");
            String lectureScannerAsk2 = lectureScanner.nextLine();

            if (lectureScannerAsk2.equals("Ні") | lectureScannerAsk2.equals("ні") | lectureScannerAsk2.equals("No") | lectureScannerAsk2.equals("no")) {

                System.out.println("Ви відмовилися створювати додаткову лекцію!");

            } else if (lectureScannerAsk2.equals("Так") | lectureScannerAsk2.equals("так") | lectureScannerAsk2.equals("Yes") | lectureScannerAsk2.equals("yes")) {

                Lecture lecture2H7 = new Lecture(idCourse);
                int lecture2H7Id = lecture2H7.getIdCourse();
                totalLectures++;

                System.out.println("Створена додаткова лекція. Значення Id курсу для даної лекції становить: " + lecture2H7Id + ".");
            } else {

                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
            }

        } else {

            System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
        }

        System.out.println("Загальна кількість створених лекцій складає - " + totalLectures + " штук(и).");
    }

    public void lectureScannerLoop() {

        int totalLecturesLoop = 0;
        int IdCourseLoop = -1;
        int maxValueLectures = 8;
        int maxValueIdCourse = 3;
        int minValueIdCourse = 1;

        while (true){

            Scanner lectureScannerLoop = new Scanner(System.in);
            System.out.println("Чи бажаєте створити нову лекцію? [Y/N]");
            String lectureScannerLoopAsk1 = lectureScannerLoop.nextLine();

            if (lectureScannerLoopAsk1.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати нову лекцію!");
                break;

            } else if (lectureScannerLoopAsk1.equalsIgnoreCase("y")) {

                do {
                    System.out.println("Введіть значення Id курсу для майбутньої лекції тільки в наступних межах від " + minValueIdCourse + " до " + maxValueIdCourse + "!");
                    IdCourseLoop = lectureScannerLoop.nextInt();
                    lectureScannerLoop.nextLine();

                } while (IdCourseLoop < minValueIdCourse || IdCourseLoop > maxValueIdCourse);

                totalLecturesLoop++;

                if (totalLecturesLoop > maxValueLectures) {

                    System.out.println("Ви перевищили ліміт на максимальну кількість створених лекцій, який становить - " + maxValueLectures + " штук!");
                    break;
                }

                System.out.println("Ви створили " + totalLecturesLoop +"-у лекцію з Id курсу = " + IdCourseLoop);

            } else {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
            }

        }

    }

    public void lecturesArrayShove(Lecture[] lectures) {
        for (Lecture lecture : lectures) {
            if (lecture == null) continue;
            System.out.println("Значення ID для лекції " + lecture + " буде приймати значення " + lecture.getId());
        }
    }

    public void lecturesArrayCreator () {

        CourseRepository courseRepository2 = CourseRepository.getInstance();
        courseRepository2.getAll();

        LectureRepository lectureRepository2 = LectureRepository.getInstance();
        System.out.println(Arrays.toString(lectureRepository2.getArraySuper()));

        CourseService course = new CourseService();
        Course course1H9 = course.createCourse();
        courseRepository2.add(course1H9);
        courseRepository2.getAll();

        int idCourse1H9 = course1H9.getId();
        System.out.println("Значення ID для курсу - " + idCourse1H9);

        Lecture lecture1H9 = createLecture(idCourse1H9);

        Lecture lecture2H9 = createLecture(idCourse1H9);

        lectureRepository2.add(lecture1H9);
        lectureRepository2.getAll();

        lectureRepository2.add(lecture2H9);
        lectureRepository2.getAll();

        while (true) {

                Scanner modelsSuper1 = new Scanner(System.in);
                System.out.println("Чи бажаєте створити новий елемент? [Y/N]");
                String modelSuperAsk2 = modelsSuper1.nextLine();

                if (modelSuperAsk2.equalsIgnoreCase("n")) {
                    System.out.println("Ви відмовилися створювати новий елемент!");
                    break;

                } else if (modelSuperAsk2.equalsIgnoreCase("y")) {

                    lectureRepository2.add(new Lecture(idCourse1H9));
                    lectureRepository2.getAll();
                } else {
                    System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                    break;
                }

            }
        lectureRepository2.getAll();
    }

    public void lecturesCreatorWithTeacher () {

        Scanner modelsSuper1 = new Scanner(System.in);

        while (true) {

            System.out.println("Чи бажаєте створити нову лекцію? [Y/N]");
            String modelSuperAsk2 = modelsSuper1.nextLine();

            if (modelSuperAsk2.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися створювати нову лекцію!");
                break;

            } else if (modelSuperAsk2.equalsIgnoreCase("y")) {

                    System.out.println("Чи бажаєте додати вчителя з наступного списку? [Y/N]");

                    int maxTeacherId = 0;
                    int totalTeacher = 0;
                    for (ModelsSuper person: PersonRepository.getInstance().getArraySuper()) {
                        Person p = (Person) person;
                        if (p == null) { break;
                        } else if (p.getRole().equals(Role.TEACHER)) {
                            ++totalTeacher;
                            System.out.print(person);
                            System.out.println(" - маэ значкння ID = " + p.getId());
                            if (maxTeacherId < p.getId()) {maxTeacherId = p.getId();}
                        }
                    }

                if (totalTeacher == 0) {
                    System.out.println("Жодний вчитель ще не був доданий до списку!\nВставити код з пропозицією створення нового вчителя чи лекції без вчителя!");
                }

                    String modelSuperAsk3 = modelsSuper1.nextLine();

                    if (modelSuperAsk3.equalsIgnoreCase("n")) {

                        System.out.println("Чи бажаєте додати нового вчителя? [Y/N]");

                        String modelSuperAsk4 = modelsSuper1.nextLine();

                        if (modelSuperAsk4.equalsIgnoreCase("n")) {
                            System.out.println("Ви створили лекцію без вчителя!");
                            LectureRepository.getInstance().getAll();
                            LectureRepository.getInstance().add(new Lecture());
                            LectureRepository.getInstance().getAll();

                        } else if (modelSuperAsk4.equalsIgnoreCase("y")) {
                            System.out.println("Створена лекція з новим вчителем!");
                            PersonRepository.getInstance().getAll();
                            Person teacherH11 = new Person(Role.TEACHER);
                            PersonRepository.getInstance().add(teacherH11);
                            PersonRepository.getInstance().getAll();
                            LectureRepository.getInstance().getAll();
                            Lecture lectureH11 = new LectureService().createLectureWithTeacher(teacherH11.getId());
                            LectureRepository.getInstance().add(lectureH11);
                            LectureRepository.getInstance().getAll();




                        } else {
                            System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                            break;
                        }


                     } else if (modelSuperAsk3.equalsIgnoreCase("y")) {

                       int ask5;
                        do {
                            System.out.println("Введіть значення ID з представленного списку для вибраного вчителя!");
                            int modelSuperAsk5 = modelsSuper1.nextInt();
                            modelsSuper1.nextLine();
                            ask5 = modelSuperAsk5;
                        } while (ask5<0 || ask5>maxTeacherId);

                        LectureRepository.getInstance().getAll();
                        Lecture lectureH11 = new LectureService().createLectureWithTeacher(ask5);
                        LectureRepository.getInstance().add(lectureH11);
                        LectureRepository.getInstance().getAll();
                        System.out.println("ID створенної лекції - " + lectureH11.getId());

                    } else {
                        System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                        break;
                    }


            } else {
                System.out.println("Ви ввели некоректну відповідь. Почніть з самого початку!");
                break;
            }

        }
    }

    public void getAllInfoLecture () {
        Scanner getAllInfoLecture = new Scanner(System.in);

        int search = -1;
        Lecture lectureFromTask = null;
        do {
            System.out.println("Введіть існуюче значення ID лекції");
            int idLectureFromTask = getAllInfoLecture.nextInt();
            getAllInfoLecture.nextLine();
            for (ModelsSuper lecture :
                    LectureRepository.getInstance().getArraySuper()) {
                if (lecture == null) {
                    continue;
                }
                if (lecture.getId() == idLectureFromTask) {
                    search = 1;
                    lectureFromTask = (Lecture) lecture;
                }
            }
        } while (search<0);

        System.out.println("Значення ID для заданної лекції - " + lectureFromTask.getId());
        System.out.println("Значення IDCourse для заданної лекції - " + lectureFromTask.getIdCourse());
        System.out.println("Значення PersonId для заданної лекції - " + lectureFromTask.getPersonId());
        System.out.println("Значення Name для заданної лекції - " + lectureFromTask.getName());
    }

    public void setDescription (int idLecture) {
        LectureRepository.getInstance().exist(idLecture);
        LectureRepository.getInstance().getAll();
        System.out.println("Введіть опис лекції!");
        Scanner scannerP = new Scanner(System.in);
        String description = scannerP.nextLine();
        String descriptionNorm = description.trim();
        boolean result = descriptionNorm.matches("^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-\\'\\d\\s\\.]{1,400}$");
        while (!result){
            System.out.println("Ви ввели некоректний опис лекції!\nВведіть опис лекції знову!");
            description = scannerP.nextLine();
            descriptionNorm = description.trim();
            result = descriptionNorm.matches("^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-\\'\\d\\s\\.]{1,400}$");
        }
        System.out.println("Опис лекції:  " + descriptionNorm);
        ModelsSuper lecture = LectureRepository.getInstance().get(idLecture);
        Lecture lecture1 = (Lecture) lecture;
        lecture1.setDescription(descriptionNorm);
    }

    public void setName (int idLecture) {
        LectureRepository.getInstance().exist(idLecture);
        LectureRepository.getInstance().getAll();
        System.out.println("Введіть назву лекції!");
        Scanner scannerP = new Scanner(System.in);
        String lectureName = scannerP.nextLine();
        String lectureNameNorm = lectureName.trim();
        boolean result = lectureNameNorm.matches("^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-\\'\\d\\s\\.]{1,200}$");
        while (!result){
            System.out.println("Ви ввели некоректну назву лекції!\nВведіть назву лекції знову!");
            lectureName = scannerP.nextLine();
            lectureNameNorm = lectureName.trim();
            result = lectureNameNorm.matches("^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-\\'\\d\\s\\.]{1,200}$");
        }
        System.out.println("Назва лекції:  " + lectureNameNorm);
        Lecture lecture = LectureRepository.getInstance().get(idLecture);
        lecture.setName(lectureNameNorm);
    }
}
