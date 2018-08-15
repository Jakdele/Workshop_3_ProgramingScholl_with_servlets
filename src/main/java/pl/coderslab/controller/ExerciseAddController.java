package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDAO;
import pl.coderslab.dao.UserDAO;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseAddController", urlPatterns = {"/addExercise"})
public class ExerciseAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                Exercise newExercise = new Exercise(title, description);
                ExerciseDAO.saveToDb(newExercise);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/exercises");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/exercise_add.jsp").forward(request, response);
    }
}
