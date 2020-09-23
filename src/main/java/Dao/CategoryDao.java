/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Category;
import Util.DbConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class CategoryDao {
    DbConnect dbCon = new DbConnect();
    public CategoryDao(){
        dbCon.dbConnection();
    }
    
    public List<Category> getAllCategories(){
        List<Category> allCategoriesList = new ArrayList();
        try{
            Statement stmt = dbCon.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from categories");
            while(rs.next()){
                Category cat = new Category();
                cat.setId(rs.getInt("id"));
                cat.setCategory(rs.getString("category"));
                cat.setDescription(rs.getString("description"));
                cat.setCreated_at(rs.getString("created_at"));
                allCategoriesList.add(cat);
            }   
            
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return allCategoriesList;
    }
    public Boolean add(Category cat){
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");  
            LocalDateTime now = LocalDateTime.now(); 
            PreparedStatement pstmt = dbCon.conn.prepareStatement("Insert into categories(category, description, created_at) values(?, ?, ?)");
            pstmt.setString(1, cat.getCategory());
            pstmt.setString(2, cat.getDescription());
            pstmt.setString(3, dtf.format(now));
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted == 1)
                return true;
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public Boolean delete(Category cat){
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("delete from categories where id=?");
            pstmt.setInt(1, cat.getId());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 1)
                return true;
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public Boolean update(Category cat){
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("update categories set category=?, description=? where id=?");
            pstmt.setString(1, cat.getCategory());
            pstmt.setString(2, cat.getDescription());
            pstmt.setInt(3, cat.getId());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 1)
                return true;                   
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public Category getCategoryById(int id){
        Category cat = new Category();
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("select * from categories where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                cat.setId(rs.getInt("id"));
                cat.setCategory(rs.getString("category"));
                cat.setDescription(rs.getString("description"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return cat;
    }
    
    
}
