package com.controller;


import java.io.IOException;

import com.model.RegisterDAO;
import com.model.RegisterData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Register extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	// TODO Auto-generated method stub
	String patient_name=req.getParameter("Pname");
	int patient_age=Integer.parseInt(req.getParameter("P_age"));
	String patient_contact=req.getParameter("Pcontact");
	String patient_gender=req.getParameter("Pgender");
	String patient_discript=req.getParameter("P_discript");
	
	if(patient_contact == null || !patient_contact.matches("\\d{10}")) {
	    resp.getWriter().println("Invalid Contact Number");
	    return;
	}
		
	RegisterData rd= new RegisterData();
	 
	rd.setPatient_name(patient_name);
	rd.setPatient_age(patient_age);
	rd.setPatient_contact(patient_contact);
	rd.setPatient_gender(patient_gender);
	rd.setPatient_discript(patient_discript);
	
	RegisterDAO rDao = new RegisterDAO();
	  int result = rDao.insertRegister(rd);
	
		if (result>0) {
			resp.sendRedirect("patientRegister");
		}
		else {
			System.out.println("Registration Failed");
		}
	
}
}
