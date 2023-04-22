package main;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service11.AdditionalMaterialsService;
import service11.LectureService;
import service11.PersonService;

import java.io.IOException;

public class Main11 {


    public static void main(String[] args) throws IOException {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService as = ac.getBean(PersonService.class);
//        System.out.println(as.studentOnCourses(2));
        System.out.println(as.studentOnCourses());


    }

}