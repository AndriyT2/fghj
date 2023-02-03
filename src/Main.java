import models.ResourceType;
import models.Role;
import repository.CourseRepository;
import repository.PersonRepository;
import service.AdditionalMaterialsService;
import service.CourseService;
import service.PersonService;
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
        amH18T1.createAdditionalMaterialsService("CCCCCCC", 3, ResourceType.VIDEO);
        AdditionalMaterialsService amH18T2 = new AdditionalMaterialsService();
        amH18T2.createAdditionalMaterialsService("AAAAAAA", 1, ResourceType.URL);
        AdditionalMaterialsService amH18T3 = new AdditionalMaterialsService();
        amH18T3.createAdditionalMaterialsService("BBBBBBB", 2, ResourceType.URL);
        AdditionalMaterialsService amH18T4 = new AdditionalMaterialsService();
        amH18T4.createAdditionalMaterialsService("AAAAAAA", 1, ResourceType.BOOK);


        amH18T4.sortByChoose();

    }

}