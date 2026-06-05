package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.dbcon.DBconnection;

public class UserDao {

    public boolean addUser(UserData user) {

        boolean status = false;

        try (
            Connection con = DBconnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username,email,contact,password,role) VALUES(?,?,?,?,?)"
            );
        ) {

            // Encrypt password
            String hashedPassword =
                    BCrypt.hashpw(user.getPassword(),
                    BCrypt.gensalt());

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getContact());
            ps.setString(4, hashedPassword);
            ps.setString(5, user.getRole());

            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    
//    ----------------------
    public List<UserData> getAllUsers() {

        List<UserData> users = new ArrayList<>();

        try (Connection con = DBconnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                UserData user = new UserData();
                user.setUid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setContact(rs.getString("contact"));
                user.setRole(rs.getString("role"));

                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public UserData editUser(int id) {
        UserData user = null;
        try (Connection con = DBconnection.getConnection();

             PreparedStatement ps = con.prepareStatement(
             "SELECT * FROM users WHERE id=?")) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new UserData();

                user.setUid(rs.getInt("id"));;
                user.setUsername(
                        rs.getString("username"));

                user.setEmail(
                        rs.getString("email"));

                user.setContact(
                        rs.getString("contact"));
                
                user.setPassword(rs.getString("password"));

                user.setRole(
                        rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
//    --------------------------
    public boolean updateUser(UserData user){

        boolean status=false;

        try(Connection con=DBconnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
            "UPDATE users SET username=?,email=?,contact=?,password=?,role=? WHERE id=?")){

            String hash=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());

            ps.setString(1,user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getContact());
            ps.setString(4,hash);
            ps.setString(5,user.getRole());
            ps.setInt(6,user.getUid());

            status=ps.executeUpdate()>0;

        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    
    public boolean deleteUser(int id){

        boolean status=false;

        try(Connection con=DBconnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
            "DELETE FROM users WHERE id=?")){

            ps.setInt(1,id);

            status=ps.executeUpdate()>0;

        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    
//    ------------LOGIN----------------
    
    public UserData loginUser(String email,String password){

        UserData user=null;

        try(Connection con=DBconnection.getConnection();
            PreparedStatement ps=con.prepareStatement(
            "SELECT * FROM users WHERE email=?")){

            ps.setString(1,email);

            ResultSet rs=ps.executeQuery();

            if(rs.next() && BCrypt.checkpw(
                    password,rs.getString("password"))){

                user=new UserData();

                user.setUid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
            }

        }catch(Exception e){e.printStackTrace();}

        return user;
    }
}