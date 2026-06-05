package com.controller;

import java.io.IOException;
import com.model.UserDao;
import com.model.UserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet{

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        UserData user=new UserData();

        user.setUid(Integer.parseInt(request.getParameter("uid")));
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setContact(request.getParameter("contact"));
        user.setPassword(request.getParameter("password"));
        user.setRole(request.getParameter("role"));

        UserDao dao=new UserDao();

        if(dao.updateUser(user))
            response.sendRedirect("viewusers");
        else
            response.sendRedirect("editUser.jsp?msg=failed");
    }
}