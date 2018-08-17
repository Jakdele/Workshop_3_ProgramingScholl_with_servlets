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
import java.util.List;

@WebServlet(name = "UserPanelController", urlPatterns = {"/userPanel"})
public class UserPanelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Integer userId = Integer.parseInt(request.getParameter("user-id"));
            User user = UserDAO.loadUserById(userId);
            if (user != null) {
                request.getSession().setAttribute("user-id", userId);
                doGet(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = (Integer)(request.getSession().getAttribute("user-id"));
        request.setAttribute("user-id", userId);
        try {
            List<Solution> allUserSolutions = SolutionDAO.loadAllByUserID(userId);
            List<Solution> unsolved = SolutionDAO.loadAllNotDone(userId);
            request.setAttribute("allUserSolutions", allUserSolutions);
            request.setAttribute("unsolved", unsolved);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/META-INF/views/user_panel.jsp").forward(request, response);
    }
}
