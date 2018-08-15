package pl.coderslab.controller;

import pl.coderslab.dao.GroupDAO;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupsAddController", urlPatterns = {"/addGroup"})
public class GroupsAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {
                String name = request.getParameter("name");
                Group newGroup = new Group(name);
                GroupDAO.saveToDb(newGroup);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/userGroups");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/META-INF/views/user_groups_add.jsp").forward(request, response);
    }
}
