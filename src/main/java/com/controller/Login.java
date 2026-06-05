package com.controller;

import java.io.IOException;
import com.model.UserDao;
import com.model.UserData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet{

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException{

        String email=request.getParameter("email");
        String password=request.getParameter("password");

        UserDao dao=new UserDao();

        UserData user=dao.loginUser(email,password);

        if(user!=null){

            HttpSession session=request.getSession();

            session.setAttribute("id",user.getUid());
            session.setAttribute("username",
                    user.getUsername());
            session.setAttribute("email",
                    user.getEmail());
            session.setAttribute("role",
                    user.getRole());

            if("ADMIN".equals(user.getRole())) {
                request.setAttribute("role",user.getRole());
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else if ("STAFF".equals(user.getRole()))
                response.sendRedirect("home.jsp");

        }else{
            response.sendRedirect("login.jsp?msg=invalid");
        }
    }
}