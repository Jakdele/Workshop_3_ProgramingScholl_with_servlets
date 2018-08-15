package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDAO;
import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.dao.UserDAO;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Solution;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExerciseDetailController", urlPatterns = {"/exerciseDetails"})
public class ExerciseDetailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exercise.id"));
        try {
            Exercise exercise = ExerciseDAO.loadExerciseById(exerciseId);
            request.setAttribute("exercise", exercise);
            getServletContext().getRequestDispatcher("/META-INF/views/exercise_details.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
