package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserPanelEditController", urlPatterns = {"/userEditSolution"})
public class UserPanelEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {

                Integer solutionId = Integer.parseInt(request.getParameter("solution-id"));
                String description = request.getParameter("description");

                Solution solutionToEdit = SolutionDAO.loadSolutionById(solutionId);
                if (description != null && description != "") solutionToEdit.setDescription(description);
                SolutionDAO.saveToDb(solutionToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/userPanel");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer solutionId = Integer.parseInt(request.getParameter("solution-id"));
            request.setAttribute("solutionId", solutionId);
        getServletContext().getRequestDispatcher("/META-INF/views/user_panel_edit.jsp").forward(request, response);
    }
}
