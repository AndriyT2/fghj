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
import service11.PersonService;

import java.io.IOException;

@WebServlet("/createPerson")
public class CreatePersonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/createPerson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService ps = ac.getBean(PersonService.class);

        ps.addPerson(lastname, firstname, phone, email, role);
        resp.sendRedirect(req.getContextPath() + "/person");
    }
}
