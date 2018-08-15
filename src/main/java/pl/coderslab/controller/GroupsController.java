package pl.coderslab.controller;

import pl.coderslab.dao.GroupDAO;
import pl.coderslab.dao.SolutionDAO;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupsController", urlPatterns = {"/userGroups"})
public class GroupsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Group> groupList = GroupDAO.findAll();
            request.setAttribute("groups", groupList);
            getServletContext().getRequestDispatcher("/META-INF/views/user_groups_list.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
