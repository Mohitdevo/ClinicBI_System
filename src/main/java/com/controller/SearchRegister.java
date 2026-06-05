package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.model.RegisterDAO;
import com.model.RegisterData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchRegister")
public class SearchRegister extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword=req.getParameter("keyword");
		
		RegisterDAO rDao=new RegisterDAO();
		
		List<RegisterData> regData = rDao.searchRegister(keyword);

		System.out.println(regData);
		
		req.setAttribute("patients", regData);
		
		req.getRequestDispatcher("patientRegister.jsp").forward(req, resp);
	}
}
