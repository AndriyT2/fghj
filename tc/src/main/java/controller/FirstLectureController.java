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
//import service11.LectureService;
//import service11.PersonService;
//
//import java.io.IOException;
//
//@WebServlet("/first_lecture")
//public class FirstLectureController extends HttpServlet {
//    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    LectureService l = ac.getBean(LectureService.class);
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("lecture", l.firstLecture());
//        req.getRequestDispatcher("/firsLecture.jsp").forward(req, resp);
//    }
//}
