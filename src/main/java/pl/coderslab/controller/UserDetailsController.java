package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.dao.UserDAO;
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

@WebServlet(name = "UserDetailsController", urlPatterns = {"/userDetails"})
public class UserDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Solution> solutions = new ArrayList<>();
        int userId = Integer.parseInt(request.getParameter("user.id"));
        try {
            solutions = SolutionDAO.loadAllByUserID(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("solutions", solutions);
        try {
            User user = UserDAO.loadUserById(userId);
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/META-INF/views/user_details.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
