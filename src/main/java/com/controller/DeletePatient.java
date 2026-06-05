package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.RegisterDAO;

@WebServlet("/deletepatient")
public class DeletePatient extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("pid"));

        RegisterDAO dao = new RegisterDAO();

        boolean status =
                dao.deletePatient(id);

        if (status) {

            response.sendRedirect(
                    "patientRegister");

        } else {

            response.sendRedirect(
                    "patientRegister?msg=failed");
        }
    }
}