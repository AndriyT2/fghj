package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AmySQLForServlet;

import java.io.IOException;

@WebServlet("/student_on_course")
public class StudentOnCourseController extends HttpServlet {
    AmySQLForServlet st = new AmySQLForServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseCount = Integer.parseInt(req.getParameter("course_count"));
        req.setAttribute("students", st.studentOnCourse(courseCount));
        req.setAttribute("cc", courseCount);
        req.getRequestDispatcher("studentOnCourse.jsp").forward(req, resp);
    }
}
