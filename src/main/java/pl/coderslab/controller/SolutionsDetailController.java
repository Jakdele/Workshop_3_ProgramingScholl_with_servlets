package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SolutionsDetailController", urlPatterns = {"/solutionDetails"})
public class SolutionsDetailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Solution solution = SolutionDAO.loadSolutionById(Integer.parseInt(request.getParameter("solution.id")));
            request.setAttribute("solution", solution);
            getServletContext().getRequestDispatcher("/META-INF/views/solution_details.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
