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
//import service11.PersonService;
//
//import java.io.IOException;
//
//@WebServlet("/student_by_lastname")
//public class StudentByLastnameController extends HttpServlet {
//    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    PersonService ps = ac.getBean(PersonService.class);
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("students", ps.studentByLastname());
//        req.getRequestDispatcher("/studentByLastname.jsp").forward(req, resp);
//    }
//}
