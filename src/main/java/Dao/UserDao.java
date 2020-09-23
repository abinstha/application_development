/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.User;
import Util.DbConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author acer
 */
public class UserDao {
    DbConnect dbConn = new DbConnect();
    public UserDao(){
        dbConn.dbConnection();
    }
    public int add(User user){
        int rowsInserted = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now(); 
        try{
            PreparedStatement pstmt = dbConn.conn.prepareStatement("Insert into user(first_name, last_name, email, address, mob_number, username, password, created_at) values(?,?,?,?,?,?,MD5(?),?)");
            pstmt.setString(1, user.getFirst_name());
            pstmt.setString(2, user.getLast_name());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getMob_number());
            pstmt.setString(6, user.getUsername());
            pstmt.setString(7, user.getPassword());
            pstmt.setString(8, dtf.format(now));
            rowsInserted = pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return rowsInserted;
    }
    public boolean checkLogin(User user){
        boolean result = false;
        try{
            PreparedStatement pstmt = dbConn.conn.prepareStatement("Select username, password from user where username= ? and password = MD5(?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                return true;
        }catch(SQLException ex){
            System.out.println(ex);            
        }
        return result;
    }
}
