package com.model;

import com.controller.AddProd;
import com.dbcon.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProdDAO extends AddProd{
	
	AddProd  prod=new AddProd();
	AddProdData prodData = new AddProdData();
	public int insertProdData (AddProdData apd) {
		int status=0;
		
	try (Connection con = DBconnection.getConnection(); 
		
		PreparedStatement ps = con.prepareStatement("insert into inventry (id,product_name,product_category,quantity,price) values(?,?,?,?,?)");
			){
		
		ps.setInt(1,apd.getProdId() );
		ps.setString(2, apd.getProduct_name());
		ps.setString(3, apd.getProduct_category());
		ps.setInt(4, apd.getQuantity());
		ps.setInt(5, apd.getPrice());
		
		status=ps.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return status;
	}

}
