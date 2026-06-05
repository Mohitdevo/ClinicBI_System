package com.controller;

import java.io.IOException;
import java.util.List;

import com.model.RegisterDAO;
import com.model.RegisterData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/patientRegister")
public class PatientRegister extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDAO regDao = new RegisterDAO();
		System.out.println("Servlet called");
		
		List<RegisterData> patient = regDao.getRegisterData();
		
		req.setAttribute("patients", patient);
		req.getRequestDispatcher("patientRegister.jsp").forward(req, resp);
		
	}
}
