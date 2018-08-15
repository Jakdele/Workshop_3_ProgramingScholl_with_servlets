package pl.coderslab.controller;

import pl.coderslab.dao.GroupDAO;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupEditController", urlPatterns = {"/editGroup"})
public class GroupsEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {

                Integer groupId = Integer.parseInt(request.getParameter("group-id"));
                String name = request.getParameter("name");

                Group groupToEdit = GroupDAO.loadGroupById(groupId);
                if (name != null && name != "") groupToEdit.setName(name);
                GroupDAO.saveToDb(groupToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/userGroups");
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idTodelete = Integer.parseInt(request.getParameter("group.id"));
        request.setAttribute("id", idTodelete);
        getServletContext().getRequestDispatcher("/META-INF/views/user_groups_edit.jsp").forward(request, response);
    }
}

