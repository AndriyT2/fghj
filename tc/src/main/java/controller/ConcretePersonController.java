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
import osHibernate.PersonEntity;
import service11.PersonService;

import java.io.IOException;

@WebServlet(name = "ConcretePerson", urlPatterns = {"/concretePerson"})
public class ConcretePersonController extends HttpServlet {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    PersonService ps = ac.getBean(PersonService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int personId = Integer.parseInt(req.getParameter("personId"));
        PersonEntity person = ps.findById(personId);
        req.setAttribute("conPersons", person);
        req.getRequestDispatcher("concretePerson.jsp").forward(req, resp);
    }
}
