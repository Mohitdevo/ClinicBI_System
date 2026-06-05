package com.controller;

import java.io.IOException;

import com.model.InventryDAO;
import com.model.InventryData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editProduct")
public class EditProd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id =Integer.parseInt(req.getParameter("id"));

		InventryDAO indao = new InventryDAO();

		InventryData ind = indao.editProduct(id);

		if (ind.getProd_id() == id) {
			req.setAttribute("product", ind);
			req.getRequestDispatcher("editProduct.jsp").forward(req, resp);
			}
	}
}
