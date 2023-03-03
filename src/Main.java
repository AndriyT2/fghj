import models.ResourceType;
import models.Role;
import service.*;
import utility.exception.EntityNotFoundException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws EntityNotFoundException, IOException {





        CourseService courseH18T1 = new CourseService();
        courseH18T1.createCourse("CCCCCCCCC");
        CourseService courseH18T2 = new CourseService();
        courseH18T2.createCourse("AAAAAAAA");
        CourseService courseH18T3 = new CourseService();
        courseH18T3.createCourse("BBBBBBBBB");




        PersonService personH18T1 = new PersonService();
        personH18T1.addPerson("CCCCCCCC", "BBBBBB", Role.TEACHER);
        PersonService personH18T2 = new PersonService();
        personH18T2.addPerson("AAAAAAA", "BBBBB", Role.TEACHER);
        PersonService personH18T3 = new PersonService();
        personH18T3.addPerson("AAAAAAA", "aaaaaa", Role.TEACHER);
        PersonService personH18T4 = new PersonService();
        personH18T4.addPerson("BBBBBBBBB", "BBBBBB", Role.TEACHER);




        AdditionalMaterialsService amH18T1 = new AdditionalMaterialsService();
        amH18T1.createAdditionalMaterialsService("CCCCCCC", 12, ResourceType.VIDEO);
        AdditionalMaterialsService amH18T2 = new AdditionalMaterialsService();
        amH18T2.createAdditionalMaterialsService("AAAAAAA", 13, ResourceType.URL);
        AdditionalMaterialsService amH18T3 = new AdditionalMaterialsService();
        amH18T3.createAdditionalMaterialsService("BBBBBBB", 14, ResourceType.URL);
        AdditionalMaterialsService amH18T4 = new AdditionalMaterialsService();
        amH18T4.createAdditionalMaterialsService("AAAAAAA", 15, ResourceType.BOOK);




        LectureService lectureH19T1 = new LectureService();
        lectureH19T1.createLecture(1);
        lectureH19T1.createLecture(2);
        lectureH19T1.createLecture(3);
        lectureH19T1.createLecture();



        HomeworkService homeworkH19T1 = new HomeworkService();
        homeworkH19T1.createHomeworkWithLectureId(12);
        homeworkH19T1.createHomeworkWithLectureId(13);
        homeworkH19T1.createHomeworkWithLectureId(14);


        System.out.println("\n=====================  Menu  ===========================================================\n");
        Menu menu = new Menu();
        menu.menu();



    }

}