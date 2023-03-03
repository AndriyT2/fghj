package utility.regex;

import models.Lecture;
import repository.LectureRepository;
import utility.ScannerThis;
import utility.exception.EntityNotFoundException;
import utility.exception.SetParameterException;

import java.time.LocalDateTime;


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

    public static void setDate (int idLecture) {
        final String rule1 = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
        final String rule2 = "^(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)$";
        System.out.println("Введіть дату лекції у наступному форматі: YYYY-MM-dd");
        String lectureDate = ScannerThis.getInstance().nextLine();
        String lectureDateNorm = lectureDate.trim();
        boolean result1 = lectureDateNorm.matches(rule1);
        while (!result1) {

                System.err.println("Ви ввели некоректну дату лекції!");
                System.err.println("Введіть дату лекції знову у правильному форматі!");
                lectureDate = ScannerThis.getInstance().nextLine();
                lectureDateNorm = lectureDate.trim();
                result1 = lectureDateNorm.matches(rule1);

        }
        System.out.println("Введіть час лекції у наступному форматі: HH:mm:ss");
        String lectureTime = ScannerThis.getInstance().nextLine();
        String lectureTimeNorm = lectureTime.trim();
        boolean result2 = lectureTimeNorm.matches(rule2);
        while (!result2) {

            System.err.println("Ви ввели некоректний час лекції!");
            System.err.println("Введіть час лекції знову у правильному форматі!");
            lectureTime = ScannerThis.getInstance().nextLine();
            lectureTimeNorm = lectureTime.trim();
            result2 = lectureTimeNorm.matches(rule2);

        }
        System.out.println("Час даної  лекції:  " + lectureTimeNorm);
        Lecture lecture = LectureRepository.getInstance().getById(idLecture);
        String dataTime = lectureDateNorm + "T" + lectureTimeNorm;
        lecture.setLectureDate(LocalDateTime.parse(dataTime));
    }
}
