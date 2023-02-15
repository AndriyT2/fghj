package utility.regex;

import models.Lecture;
import repository.LectureRepository;
import utility.ScannerThis;
import utility.exception.EntityNotFoundException;
import utility.exception.SetParameterException;


public class LectureRegex {
    public static void setDescription (int idLecture) throws EntityNotFoundException {
        final String rule = "^[A-Za-zА-ЯIЇҐЄа-яіїґє\\-'\\d\\s.]{1,400}$";
        LectureRepository.getInstance().getAll();
        System.out.println("Введіть опис лекції!");
        String description = ScannerThis.getInstance().nextLine();
        String descriptionNorm = description.trim();
        boolean result = descriptionNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректний опис лекції!");
            } catch (SetParameterException e) {
                System.err.println("Введіть опис лекції знову!");
                description = ScannerThis.getInstance().nextLine();
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
        String lectureName = ScannerThis.getInstance().nextLine();
        String lectureNameNorm = lectureName.trim();
        boolean result = lectureNameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректну назву лекції!");
            } catch (SetParameterException e) {
                System.err.println("Введіть назву лекції знову у правильному форматі!");
                lectureName = ScannerThis.getInstance().nextLine();
                lectureNameNorm = lectureName.trim();
                result = lectureNameNorm.matches(rule);
            }
        }
        System.out.println("Назва лекції:  " + lectureNameNorm);
        Lecture lecture = LectureRepository.getInstance().getById(idLecture);
        lecture.setName(lectureNameNorm);
    }
}
