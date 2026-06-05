package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dbcon.DBconnection;

public class InventryDAO {

	public List<InventryData> getInventryData() {
		List<InventryData> products = new ArrayList<>();

		try (Connection con = DBconnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from inventry;");) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				InventryData ind = new InventryData();

				ind.setProd_id(rs.getInt("id"));
				ind.setProduct_name(rs.getString("product_name"));
				ind.setProduct_category(rs.getString("product_category"));
				ind.setQuantity(rs.getInt("quantity"));
				ind.setPrice(rs.getInt("price"));

				products.add(ind);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return products;
	}

	// for search from inventory

	public List<InventryData> searchProduct(String keyword) {

		List<InventryData> products = new ArrayList<>();

		String sql = "SELECT * FROM inventry WHERE product_name LIKE ?";

		try (Connection con = DBconnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, "%" + keyword + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				InventryData ind = new InventryData();

				ind.setProd_id(rs.getInt("id"));
				ind.setProduct_name(rs.getString("product_name"));
				ind.setProduct_category(rs.getString("product_category"));
				ind.setQuantity(rs.getInt("quantity"));
				ind.setPrice(rs.getInt("price"));

				products.add(ind);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	public InventryData editProduct(int id) {
		InventryData ind = new InventryData();

		String sql = "SELECT * FROM inventry WHERE id = ?";

		try (Connection con = DBconnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				ind.setProd_id(rs.getInt("id"));
				ind.setProduct_name(rs.getString("product_name"));
				ind.setProduct_category(rs.getString("product_category"));
				ind.setQuantity(rs.getInt("quantity"));
				ind.setPrice(rs.getInt("price"));

			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ind;
	}
	
	public int updateProduct(InventryData ind,int id) {
		int status =0;

		String sql = "UPDATE inventry SET id=? ,product_name=?, product_category=?,quantity=?,price=? WHERE id=?";

		try (Connection con = DBconnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, ind.getProd_id());
			ps.setString(2,ind.getProduct_name());
			ps.setString(3, ind.getProduct_category());
			ps.setInt(4, ind.getQuantity());
			ps.setInt(5,ind.getPrice());
			ps.setInt(6, id);

			status = ps.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	

	public int deleteProduct(int id) {

		String sql = "DELETE FROM inventry WHERE id = ?";
		
		int status=0;
		try (Connection con = DBconnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);

			status= ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	public int reduceStock(int ProdId,int qty) {
		int status=0;
		try (Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement("UPDATE inventry SET quantity=quantity-? WHERE id=? ");)
		{
			ps.setInt(1, qty);
			ps.setInt(2, ProdId);
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
}
