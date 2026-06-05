package com.controller;

import java.io.IOException;

import com.model.AddProdDAO;
import com.model.AddProdData;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addprod")
public class AddProd extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int prod_id= Integer.parseInt(req.getParameter("id"));
		String product_name=req.getParameter("product_name");
		String product_category=req.getParameter("product_category");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int price = Integer.parseInt(req.getParameter("price"));
		
		
		AddProdData prodData = new AddProdData();
		
		prodData.setProd_id(prod_id);
		prodData.setProduct_name(product_name);
		prodData.setProduct_category(product_category);
		prodData.setPrice(price);
		prodData.setQuantity(quantity);
		
		AddProdDAO dao=new AddProdDAO();
		
		int result=dao.insertProdData(prodData);
		
		if(result>0) {
		     resp.sendRedirect("inventory");
			 resp.getWriter().println("Inserted Successfully");
		}
		else {
			  resp.getWriter().println("Insertion Failed");
		}
	}
}
