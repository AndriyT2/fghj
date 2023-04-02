package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;

import java.io.IOException;

@WebServlet("/student_by_lastname")
public class StudentByLastnameController extends HttpServlet {
    AmySQLForServlet s = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", s.studentByLastname());
        req.getRequestDispatcher("/studentByLastname.jsp").forward(req, resp);
    }
}
