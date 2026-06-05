package com.controller;

import java.io.IOException;

import com.model.InventryDAO;
import com.model.InventryData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int prod_id= Integer.parseInt(req.getParameter("id"));
		String product_name=req.getParameter("product_name");
		String product_category=req.getParameter("product_category");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int price = Integer.parseInt(req.getParameter("price"));
		
		InventryData data=new InventryData();
		data.setProd_id(prod_id);
		data.setProduct_name(product_name);
		data.setProduct_category(product_category);
		data.setQuantity(quantity);
		data.setPrice(price);
		

		InventryDAO invDao =new InventryDAO();
		
          int result=invDao.updateProduct(data,prod_id);
          
          if(result>0) {
        	  
        	  resp.sendRedirect("inventory");
        	  resp.getWriter().println("Updated Sucessfully");
          }
          else {
        	  resp.getWriter().println("Updation Unsucessful");
          }
	}
}
