package com.controller;

import java.io.IOException;

import com.model.DashboardDAO;
import com.model.DashboardData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DashboardDAO dao=new DashboardDAO();
		DashboardData data=dao.getDashboardData();
//		int patientCount =data.getpetientCount();
//		System.out.println(patientCount);
		
		req.setAttribute("dashboardData",data);
		
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}