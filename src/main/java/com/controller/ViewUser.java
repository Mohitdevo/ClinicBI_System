package com.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.UserDao;
import com.model.UserData;

@WebServlet("/viewusers")
public class ViewUser
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        UserDao dao = new UserDao();

        List<UserData> userList =
                dao.getAllUsers();

        // Send data to JSP
        request.setAttribute(
                "users", userList);

        request.getRequestDispatcher(
                "users.jsp")
                .forward(request, response);
    }
}