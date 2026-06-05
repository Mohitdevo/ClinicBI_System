package com.model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/api/inventory")
public class InventryAPI extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventryDAO indao = new InventryDAO();
		List<InventryData> products =indao.getInventryData();
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print("[");
		for (int i = 0; i < products.size(); i++) {
			
			InventryData p=products.get(i);
			
			out.print("{");
			out.print("\"id\":"+p.getProd_id()+",");
			out.print("\"productName\":\""+p.getProduct_name()+"\",");
			out.print("\"productCategory\":\""+p.getProduct_category()+"\",");
			out.print("\"quantity\":"+p.getQuantity()+",");
			out.print("\"price\":"+p.getPrice());
			out.print("}");
			if (i<products.size()-1) {
				out.print(",");
			}
		}
		out.print("]");
	}
}
