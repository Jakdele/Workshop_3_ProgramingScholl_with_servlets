package pl.coderslab.controller;

import pl.coderslab.dao.GroupDAO;
import pl.coderslab.dao.UserDAO;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserEditController", urlPatterns = {"/editUser"})
public class UserEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Edit")) {
            try {
                Integer userId = Integer.parseInt(request.getParameter("user-id"));
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Integer groupId = Integer.parseInt(request.getParameter("group-id"));


                User userToEdit = UserDAO.loadUserById(userId);
                if (username != null && username != "") userToEdit.setUsername(username);
                if (email != null && email != "") userToEdit.setUsername(email);
                if (password != null && password != "") userToEdit.setPassword(password);
                userToEdit.setUser_group_id(groupId);

                UserDAO.saveToDb(userToEdit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = new ArrayList<>();
        try {
            groups = GroupDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer idToEdit = Integer.parseInt(request.getParameter("user.id"));
        request.setAttribute("id", idToEdit);
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/META-INF/views/user_edit.jsp").forward(request, response);
    }
}
