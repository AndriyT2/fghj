package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;

import java.io.IOException;
@WebServlet("/lecture_before_2023")
public class LectureBefore2023Controller extends HttpServlet {
    AmySQLForServlet l = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(l.lectureBefore2023());
        req.setAttribute("lectures", l.lectureBefore2023());
        req.getRequestDispatcher("/lectureBefore2023.jsp").forward(req, resp);
    }
}
