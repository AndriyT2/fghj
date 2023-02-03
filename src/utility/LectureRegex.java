package utility;

import models.Lecture;
import repository.LectureRepository;

import java.util.Scanner;

public class LectureRegex {
    public static void setDescription (int idLecture) throws EntityNotFoundException {
        final String rule = "^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-'\\d\\s.]{1,400}$";
        LectureRepository.getInstance().getAll();
        System.out.println("Введіть опис лекції!");
        Scanner scannerP = new Scanner(System.in);
        String description = scannerP.nextLine();
        String descriptionNorm = description.trim();
        boolean result = descriptionNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректний опис лекції!");
            } catch (SetParameterException e) {
                System.err.println("Введіть опис лекції знову!");
                description = scannerP.nextLine();
                descriptionNorm = description.trim();
                result = descriptionNorm.matches(rule);
            }
        }
        System.out.println("Опис лекції:  " + descriptionNorm);
        Lecture lecture = LectureRepository.getInstance().getById(idLecture);
        lecture.setDescription(descriptionNorm);
    }

    public static void setName (int idLecture) throws EntityNotFoundException {
        final String rule = "^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-'\\d\\s.]{1,200}$";
        LectureRepository.getInstance().getAll();
        System.out.println("Введіть назву лекції!");
        Scanner scannerP = new Scanner(System.in);
        String lectureName = scannerP.nextLine();
        String lectureNameNorm = lectureName.trim();
        boolean result = lectureNameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректну назву лекції!");
            } catch (SetParameterException e) {
                System.err.println("Введіть назву лекції знову у правильному форматі!");
                lectureName = scannerP.nextLine();
                lectureNameNorm = lectureName.trim();
                result = lectureNameNorm.matches(rule);
            }
        }
        System.out.println("Назва лекції:  " + lectureNameNorm);
        Lecture lecture = LectureRepository.getInstance().getById(idLecture);
        lecture.setName(lectureNameNorm);
    }
}
