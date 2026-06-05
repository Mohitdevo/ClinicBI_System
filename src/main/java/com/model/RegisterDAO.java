package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbcon.DBconnection;

public class RegisterDAO {
	
	RegisterData rd=new RegisterData();
	
	public int insertRegister(RegisterData rd) {
		
		int status=0;
		
		try(Connection con = DBconnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into patient_register(p_name,p_age,p_gender,p_contact,p_discript) values(?,?,?,?,?)");
				) {				
			ps.setString(1,rd.getPatient_name());
			ps.setInt(2, rd.getPatient_age());
			ps.setString(3, rd.getPatient_gender());
			ps.setString(4, rd.getPatient_contact());
			ps.setString(5, rd.getPatient_discript());
			
			 status=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
          return status;
}
	
//	--------------------------------------
	
	public List<RegisterData> getRegisterData() {
		
		List<RegisterData> registerData = new ArrayList<>();
		
		try (Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from patient_register");)
		{
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				RegisterData rData=new RegisterData();
				rData.setPid(rs.getInt("p_id"));
				rData.setPatient_name(rs.getString("p_name"));
				rData.setPatient_age(rs.getInt("p_age"));
				rData.setPatient_contact(rs.getString("p_contact"));
				rData.setPatient_gender(rs.getString("p_gender"));
				rData.setPatient_discript(rs.getString("p_discript"));
				rData.setRegisterTime(rs.getObject("register_date", java.time.LocalDateTime.class));
				
				registerData.add(rData);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return registerData;
	}
	
//	----------------------------------------
	
	public List<RegisterData> searchRegister(String keyword){
		
		List<RegisterData> regData = new ArrayList<>();
		 try(Connection con = DBconnection.getConnection();
				 PreparedStatement ps = con.prepareStatement("Select * from patient_register where p_name Like ?");)
		 {
		ps.setString(1, "%"+ keyword +"%");
		
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {			
			RegisterData rData=new RegisterData();
		
			rData.setPid(rs.getInt("p_id"));
			rData.setPatient_name(rs.getString("p_name"));
			rData.setPatient_age(rs.getInt("p_age"));
			rData.setPatient_contact(rs.getString("p_contact"));
			rData.setPatient_gender(rs.getString("p_gender"));
			rData.setPatient_discript(rs.getString("p_discript"));
			rData.setRegisterTime(rs.getObject("register_date", java.time.LocalDateTime.class));
			
			regData.add(rData);
		
		}
	}
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return regData;
	}
	
//	------------------------------------------
	
	public RegisterData editRegisterData(int id) {

	    RegisterData rData = null;

	    try (Connection con = DBconnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(
	                 "SELECT * FROM patient_register WHERE p_id=?")) {

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            rData = new RegisterData();

	            rData.setPid(rs.getInt("p_id"));
	            rData.setPatient_name(rs.getString("p_name"));
	            rData.setPatient_age(rs.getInt("p_age"));
	            rData.setPatient_contact(rs.getString("p_contact"));
	            rData.setPatient_gender(rs.getString("p_gender"));
	            rData.setPatient_discript(rs.getString("p_discript"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rData;
	}
	
//-------------------------	
	
	public boolean updateRegister(RegisterData rData) {

	    boolean status = false;

	    try (Connection con = DBconnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(
	                 "UPDATE patient_register " +
	                 "SET p_name=?, p_age=?, p_contact=?, p_gender=?, p_discript=? " +
	                 "WHERE p_id=?")) {

	        ps.setString(1, rData.getPatient_name());
	        ps.setInt(2, rData.getPatient_age());
	        ps.setString(3, rData.getPatient_contact());
	        ps.setString(4, rData.getPatient_gender());
	        ps.setString(5, rData.getPatient_discript());
	        ps.setInt(6, rData.getPid());

	        int i = ps.executeUpdate();

	        if (i > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
//	-------------------
	
	public boolean deletePatient(int id) {

	    boolean status = false;

	    try (Connection con = DBconnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(
	                 "DELETE FROM patient_register WHERE p_id=?")) {

	        ps.setInt(1, id);

	        int row = ps.executeUpdate();

	        if (row > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
}
	

