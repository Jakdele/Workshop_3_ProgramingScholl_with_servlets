package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDAO;
import pl.coderslab.dao.GroupDAO;
import pl.coderslab.dao.UserDAO;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExerciseEditController", urlPatterns = {"/editExercise"})
public class ExerciseEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {

                Integer exerciseId = Integer.parseInt(request.getParameter("exercise-id"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");

                Exercise exerciseToEdit = ExerciseDAO.loadExerciseById(exerciseId);
                if (title != null && title != "") exerciseToEdit.setTitle(title);
                if (description != null && description != "") exerciseToEdit.setDescription(description);

                ExerciseDAO.saveToDb(exerciseToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/exercises");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idToEdit = Integer.parseInt(request.getParameter("exercise.id"));
        request.setAttribute("id", idToEdit);
        getServletContext().getRequestDispatcher("/META-INF/views/exercise_edit.jsp").forward(request, response);
    }
}

