package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDAO;
import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SolutionsController", urlPatterns = {"/solutions"})
public class SolutionsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Solution> solutionList = SolutionDAO.findAll();
            request.setAttribute("solutions", solutionList);
            getServletContext().getRequestDispatcher("/META-INF/views/solution_list.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
