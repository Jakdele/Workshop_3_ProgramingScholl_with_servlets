package pl.coderslab.controller;

import pl.coderslab.dao.GroupDAO;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupsDetailsController", urlPatterns = {"/groupDetails"})
public class GroupsDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("group.id"));
        try {
            Group group = GroupDAO.loadGroupById(groupId);
            request.setAttribute("group", group);
            getServletContext().getRequestDispatcher("/META-INF/views/user_groups_details.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
