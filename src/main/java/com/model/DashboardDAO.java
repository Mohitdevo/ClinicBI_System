package com.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbcon.*;

public class DashboardDAO {
	
	public DashboardData getDashboardData() {
    
		DashboardData data = new DashboardData();
		try (Connection con = DBconnection.getConnection();){
			
			PreparedStatement ps1=con.prepareStatement("select COUNT(*) from patient_register");
			
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				data.setpetientCount(rs1.getInt(1));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
		
	}		

}
