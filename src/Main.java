import models.ResourceType;
import models.Role;
import repository.AdditionalMaterialsRepository;
import repository.CourseRepository;
import repository.LectureRepository;
import repository.PersonRepository;
import service.*;
import utility.EntityNotFoundException;

public class Main {
    public static void main(String[] args) throws EntityNotFoundException {




        System.out.println("\n=====================  Лекція 18. Collection. Set.  ===========================================================\n");

        CourseService courseH18T1 = new CourseService();
        courseH18T1.createCourse("CCCCCCCCC");
        CourseService courseH18T2 = new CourseService();
        courseH18T2.createCourse("AAAAAAAA");
        CourseService courseH18T3 = new CourseService();
        courseH18T3.createCourse("BBBBBBBBB");


        CourseRepository.getInstance().courseSortByName();


        PersonService personH18T1 = new PersonService();
        personH18T1.addPerson("CCCCCCCC", "BBBBBB", Role.TEACHER);
        PersonService personH18T2 = new PersonService();
        personH18T2.addPerson("AAAAAAA", "BBBBB", Role.TEACHER);
        PersonService personH18T3 = new PersonService();
        personH18T3.addPerson("AAAAAAA", "aaaaaa", Role.TEACHER);
        PersonService personH18T4 = new PersonService();
        personH18T4.addPerson("BBBBBBBBB", "BBBBBB", Role.TEACHER);


        PersonRepository.getInstance().personSortByLastname();


        AdditionalMaterialsService amH18T1 = new AdditionalMaterialsService();
        amH18T1.createAdditionalMaterialsService("CCCCCCC", 12, ResourceType.VIDEO);
        AdditionalMaterialsService amH18T2 = new AdditionalMaterialsService();
        amH18T2.createAdditionalMaterialsService("AAAAAAA", 13, ResourceType.URL);
        AdditionalMaterialsService amH18T3 = new AdditionalMaterialsService();
        amH18T3.createAdditionalMaterialsService("BBBBBBB", 14, ResourceType.URL);
        AdditionalMaterialsService amH18T4 = new AdditionalMaterialsService();
        amH18T4.createAdditionalMaterialsService("AAAAAAA", 15, ResourceType.BOOK);



        System.out.println("\n=====================  Лекція 19. Map.  ===========================================================\n");

        LectureService lectureH19T1 = new LectureService();
        lectureH19T1.createLecture();
        lectureH19T1.createLecture();
        lectureH19T1.createLecture();
        lectureH19T1.createLecture();

        LectureRepository.getInstance().getAll();
        System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());


        lectureH19T1.lectureWithHomeworkAndAMById(14);

        System.out.println("++++++++++++++++++++++++++++++++++");

        AdditionalMaterialsService additionalMaterialH19T1 = new AdditionalMaterialsService();
        additionalMaterialH19T1.shoveAdditionalMaterialsTreeMapWithOptions();


        System.out.println("++++++++++++++++++++++++++++++++++");


        HomeworkService homeworkH19T1 = new HomeworkService();
        homeworkH19T1.createHomeworkWithLectureId(12);
        homeworkH19T1.createHomeworkWithLectureId(13);
        homeworkH19T1.createHomeworkWithLectureId(14);
        homeworkH19T1.shoveHomeworkTreeMapWithOptions();


    }

}