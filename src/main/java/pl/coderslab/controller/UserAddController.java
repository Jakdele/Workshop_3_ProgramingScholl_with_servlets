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

@WebServlet(name = "UserAddController", urlPatterns = {"/addUser"})
public class UserAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String confirmation = request.getParameter("confirm");
        if (confirmation.equals("Add")) {
            try {
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Integer groupId = Integer.parseInt(request.getParameter("group-id"));


                User newUser = new User(username, email, password, groupId);

                UserDAO.saveToDb(newUser);

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
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/META-INF/views/user_add.jsp").forward(request, response);
    }
}
