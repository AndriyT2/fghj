package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;

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

        AmySQLForServlet createPerson = new AmySQLForServlet();
        createPerson.addPersonSQLJSP(lastname, firstname, phone, email, role);
        resp.sendRedirect(req.getContextPath() + "/person");
    }
}
