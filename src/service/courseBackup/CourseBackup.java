package service.courseBackup;

import models.*;
import repository.*;
import utility.IntTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseBackup implements Serializable {
    Course course;
    int f = 45;  //Працює та поверне 45 а не null !!!!!!!!!!!!!!!!!

    int courseId;

    List<Lecture> lectureList = new ArrayList<>();
    List<Homework> homeworkList = new ArrayList<>();
    List<AdditionalMaterials> additionalMaterialsList = new ArrayList<>();
    List<Person> teacherList = new ArrayList<>();
    List<Person> studentList = new ArrayList<>();


    public CourseBackup() {
        System.out.println("Введіть значення ID для курсу:");
        this.courseId = new IntTrue().intTrue();
        this.course = CourseRepository.getInstance().getById(courseId);
        for (Lecture lecture : LectureRepository.getInstance().getLecturesList()){

            if (lecture.getIdCourse() == courseId){
                lectureList.add(lecture);

                for (Homework homework : HomeworkRepository.getInstance().getHomeworkList()){
                    if (homework.getLectureId() == lecture.getId()){homeworkList.add(homework);}}

                for (AdditionalMaterials additionalMaterials : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()){
                    if (additionalMaterials.getLectureId() == lecture.getId()){additionalMaterialsList.add(additionalMaterials);}

                }
            }
        }

        for (Person person : PersonRepository.getInstance().getPersonList()) {
            if (person.getCourseId() == courseId) {
                if (person.getRole().equals(Role.TEACHER)){
                    teacherList.add(person);
                } else {
                    studentList.add(person);
                }
            }
        }

    }

    @Override
    public String toString() {
        return "CourseBackup{" +
                "course=" + course +
                ", f=" + f +
                ", courseId=" + courseId +
                ", lectureList=" + lectureList +
                ", homeworkList=" + homeworkList +
                ", additionalMaterialsList=" + additionalMaterialsList +
                ", teacherList=" + teacherList +
                ", studentList=" + studentList +
                '}';
    }
}
