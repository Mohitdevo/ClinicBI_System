package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbcon.DBconnection;

public class BillingDAO {

	
     int billNo=0;
     
	public int insertBilling(BillingData bData) {
		int statusBill = 0;

		try (Connection con = DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into billing (customer_name,contact,grand_total)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);) {
			
			ps.setString(1, bData.getCustomerName());
			ps.setString(2, bData.getContact());
			ps.setDouble(3, bData.getGrandTotal());			
			statusBill = ps.executeUpdate();
			ResultSet rs =ps.getGeneratedKeys();
			if(rs.next()) {
			billNo=rs.getInt(1);	
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return billNo;
	}

	public int insertBillingItems(BillingData bData) {
		int statusItem = 0;

		try (Connection con = DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"insert into billing_items (bill_id,product_id,product_name,quantity, price,total)values(?,?,?,?,?,?)");) {
			
			ps.setInt(1, billNo);
			ps.setInt(2, bData.getProductId());
			ps.setString(3, bData.getProductName());
			ps.setInt(4, bData.getQuantity());
			ps.setDouble(5, bData.getPrice());
			ps.setDouble(6, bData.getTotal());

			statusItem = ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return statusItem;
	}
	
	public List<BillingData> getBillingData(){
		List<BillingData> list=new ArrayList<BillingData>();
		
		try(Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from billing_items where bill_id=?");)
		{
			ps.setInt(1, billNo);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				BillingData bData=new BillingData();
				bData.setProductName(rs.getString("product_name"));
				bData.setQuantity(rs.getInt("quantity"));
				bData.setPrice(rs.getDouble("price"));
				bData.setTotal(rs.getDouble("total"));
				
				list.add(bData);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
