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

@WebServlet(name = "SolutionDeleteController", urlPatterns = {"/solutionDelete"})
public class SolutionDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Yes")) {
            try {
                SolutionDAO.delete(Integer.parseInt(request.getParameter("solution.id")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/solutions");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer idTodelete = Integer.parseInt(request.getParameter("solution.id"));
            request.setAttribute("id", idTodelete);
            getServletContext().getRequestDispatcher("/META-INF/views/solution_delete.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
