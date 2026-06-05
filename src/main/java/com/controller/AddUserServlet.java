package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.UserDao;
import com.model.UserData;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String username =
                request.getParameter("username");

        String email =
                request.getParameter("email");

        String contact =
                request.getParameter("contact");

        String password =
                request.getParameter("password");

        String role =
                request.getParameter("role");

        // Set data in model class
        UserData user = new UserData();

        user.setUsername(username);
        user.setEmail(email);
        user.setContact(contact);
        user.setPassword(password);
        user.setRole(role);

        // Call DAO
        UserDao dao = new UserDao();

        boolean status = dao.addUser(user);

        // Redirect based on result
        if (status) {

            response.sendRedirect(
                    "viewusers?msg=success");

        } else {

            response.sendRedirect(
                    "addUser.jsp?msg=failed");
        }
    }
}