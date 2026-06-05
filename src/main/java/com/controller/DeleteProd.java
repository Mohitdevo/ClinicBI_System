package com.controller;

import java.io.IOException;

import com.model.InventryDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteProduct")
public class DeleteProd extends HttpServlet {

 	@Override
 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 		// TODO Auto-generated method stub
 		int id=Integer.parseInt(req.getParameter("id"));
 		
 		InventryDAO invDao = new InventryDAO();
 		
 		invDao.deleteProduct(id);
 		
 		resp.sendRedirect("inventory");
 		
 		
 	}
}
