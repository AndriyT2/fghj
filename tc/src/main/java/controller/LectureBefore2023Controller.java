package controller;

import config.AppConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service11.AdditionalMaterialsService;
import service11.PersonService;

import java.io.IOException;
@WebServlet("/lecture_before_2023")
public class LectureBefore2023Controller extends HttpServlet {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AdditionalMaterialsService am = ac.getBean(AdditionalMaterialsService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lectures", am.lectureBefore2023());
        req.getRequestDispatcher("/lectureBefore2023.jsp").forward(req, resp);
    }
}
