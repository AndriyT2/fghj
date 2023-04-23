//package controller;
//
//import config.AppConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.AmySQLForServlet;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import osHibernate.PersonEntity;
//import service11.PersonService;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/person")
//public class PersonController extends HttpServlet {
//
//    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    PersonService ps = ac.getBean(PersonService.class);
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<PersonEntity> personList = ps.personGetAll();
//        req.setAttribute("persons", personList);
//        req.getRequestDispatcher("person.jsp").forward(req, resp);
//    }
//}
