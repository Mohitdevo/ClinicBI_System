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

@WebServlet("/searchInventory")
public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String keyword = request.getParameter("keyword");

		InventryDAO dao = new InventryDAO();

		List<InventryData> products = dao.searchProduct(keyword);

		request.setAttribute("products", products);

		request.getRequestDispatcher("inventory.jsp").forward(request, response);
	}
}
