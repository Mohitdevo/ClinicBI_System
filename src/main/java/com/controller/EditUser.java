package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.UserDao;
import com.model.UserData;

@WebServlet("/edituser")
public class EditUser extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            UserDao dao = new UserDao();

            UserData user =
                    dao.editUser(id);

            request.setAttribute(
                    "user", user);

            request.getRequestDispatcher(
                    "editUser.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "viewusers?msg=error");
        }
    }
}