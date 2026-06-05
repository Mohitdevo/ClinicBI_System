package com.controller;

import java.io.IOException;
import com.model.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deleteuser")
public class DeleteUser extends HttpServlet{

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        int id=Integer.parseInt(
                request.getParameter("id"));

        UserDao dao=new UserDao();

        if(dao.deleteUser(id))
            response.sendRedirect("viewusers");
        else
            response.sendRedirect("viewusers?msg=failed");
    }
}