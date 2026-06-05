package com.controller;

import java.io.IOException;
import java.util.List;

import com.model.InventryDAO;
import com.model.InventryData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inventory")
public class Inventory extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventryDAO invDao = new InventryDAO();
		
		List<InventryData> products =invDao.getInventryData();
	     
		req.setAttribute("products", products);
		
		req.getRequestDispatcher("inventory.jsp").forward(req, resp);
		
	}
}
