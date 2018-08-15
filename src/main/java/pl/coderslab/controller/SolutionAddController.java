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
import java.util.List;

@WebServlet(name = "SolutionAddController", urlPatterns = {"/addSolution"})
public class SolutionAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));

        try{
            Solution taskAssigned = new Solution(exerciseId, userId);
            SolutionDAO.saveToDb(taskAssigned);
        }catch  (Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/solutions");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Exercise> exerciseList = ExerciseDAO.findAll();
            request.setAttribute("exercises", exerciseList);
            List<User> usersList = UserDAO.findAll();
            request.setAttribute("users", usersList);
            getServletContext().getRequestDispatcher("/META-INF/views/solution_add.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/solution_add.jsp").forward(request, response);
    }
}
