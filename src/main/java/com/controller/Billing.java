package com.controller;

import java.io.IOException;
import java.util.List;

import com.model.BillingDAO;
import com.model.BillingData;
import com.model.InventryDAO;
import com.model.InventryData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/billing")
public class Billing extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		String customer = req.getParameter("customer");
		String contact = req.getParameter("contact");
		double grandTotal = Double.parseDouble(req.getParameter("grandTotal"));

		String productName = "";
		int qty = 0;
		double price = 0.0;
		double total = 0.0;

		int st2=0;
		
		BillingData bData=new BillingData();
		BillingDAO bDao=new BillingDAO();
		InventryDAO indao = new InventryDAO();
		
		bData.setCustomerName(customer);
		bData.setContact(contact);
		bData.setGrandTotal(grandTotal);
		
		int billId=bDao.insertBilling(bData);
		
		int i = 0;

		while (req.getParameter("product_" + i) != null) {
			
			productName = req.getParameter("product_" + i);
			qty = Integer.parseInt(req.getParameter("qty_" + i));
			price = Double.parseDouble(req.getParameter("price_" + i));
			total = Double.parseDouble(req.getParameter("total_" + i));
			
			
			List<InventryData> products=indao.searchProduct(productName);
			int productId =products.get(0).getProd_id();
			
		    bData.setProductId(productId);		    
		    bData.setProductName(productName);
			bData.setQuantity(qty);
			bData.setPrice(price);
			bData.setTotal(total);		    
			
		   st2=bDao.insertBillingItems(bData);
		   
		   indao.reduceStock(productId, qty);
		   
		   i++;
			
		}

		if (billId>0 && st2>0) {
			System.out.println("Inserted in billing");
		
		
		String billNo=String.format("#%03d", billId);
		
		req.setAttribute("billId", billNo);
		req.setAttribute("customer",customer);
		req.setAttribute("contact", contact);
		req.setAttribute("grandTotal", grandTotal);
		req.setAttribute("items",bDao.getBillingData());
		
		req.getRequestDispatcher("invoice.jsp").forward(req, resp);
		}
	}
}
