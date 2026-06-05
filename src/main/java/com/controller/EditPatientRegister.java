package com.controller;

import java.io.IOException;

import com.model.RegisterDAO;
import com.model.RegisterData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editRegister")
public class EditPatientRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id =Integer.parseInt(req.getParameter("pid"));
		RegisterDAO  rDao=new RegisterDAO();
		RegisterData rData = rDao.editRegisterData(id);
		req.setAttribute("patient", rData);
		req.getRequestDispatcher("editRegister.jsp").forward(req, resp);
	}
}
