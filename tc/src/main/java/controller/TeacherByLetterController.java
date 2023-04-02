package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;

import java.io.IOException;

@WebServlet("/teacher_by_letter")
public class TeacherByLetterController extends HttpServlet {
    AmySQLForServlet teachers = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("teacher", teachers.teacherByLetter());
        req.getRequestDispatcher("teacherByLetter.jsp").forward(req, resp);
    }
}
