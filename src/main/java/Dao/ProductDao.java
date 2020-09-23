/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Product;
import Util.DbConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author acer
 */
public class ProductDao {
    DbConnect dbCon = new DbConnect();
    public ProductDao(){
        dbCon.dbConnection();
    }
    
    public Boolean add(Product product){
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("Insert into products(name, price, description, stock, product_code, category_id,"
                    + "brand_name, manufacture_date, expire_date, amount, size, gender, weight) values(?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?)");
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setString(3, product.getDescription());
            pstmt.setInt(4, product.getStock());
            pstmt.setInt(5, product.getProduct_code());
            pstmt.setInt(6, product.getCategory_id());
            pstmt.setString(7, product.getBrand_name());
            pstmt.setDate(8, product.getManufacture_date());
            pstmt.setDate(9, product.getExpire_date());
            pstmt.setDouble(10, product.getAmount());
            pstmt.setString(11, product.getSize());
            pstmt.setString(12, product.getGender());
            pstmt.setDouble(13, product.getWeight());
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted==1){
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public List<Product> getAllProducts(){
        List<Product> allProductsList = new ArrayList();
        try{
            Statement stmt = dbCon.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from products");
            while(rs.next()){
                Product pro = new Product();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setDescription(rs.getString("description"));
                pro.setStock(rs.getInt("stock"));
                pro.setCategory_id(rs.getInt("category_id"));
                pro.setProduct_code(rs.getInt("product_code"));
                pro.setPrice(rs.getDouble("price"));
                pro.setBrand_name(rs.getString("brand_name"));
                pro.setManufacture_date(rs.getDate("manufacture_date"));
                pro.setExpire_date(rs.getDate("expire_date"));
                pro.setAmount(rs.getDouble("amount"));
                pro.setSize(rs.getString("size"));
                pro.setGender(rs.getString("gender"));
                pro.setWeight(rs.getDouble("weight"));
                
                allProductsList.add(pro);
            }   
            
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return allProductsList;
    }
    
    public Boolean delete(Product product){
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("delete from products where id=?");
            pstmt.setInt(1, product.getId());
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
    
    public Boolean update(Product product){
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("update products set "
                    + "name=?, category_id=?, description=?, stock=?, product_code=?, price=?, brand_name=?,"
                    + "manufacture_date=?, expire_date=?, amount=?, size=?, gender=?, weight=? where id=?");
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getCategory_id());
            pstmt.setString(3, product.getDescription());
            pstmt.setInt(4, product.getStock());
            pstmt.setInt(5, product.getProduct_code());
            pstmt.setDouble(6, product.getPrice());
            pstmt.setString(7, product.getBrand_name());
            pstmt.setDate(8, product.getManufacture_date());
            pstmt.setDate(9, product.getExpire_date());
            pstmt.setDouble(10, product.getAmount());
            pstmt.setString(11, product.getSize());
            pstmt.setString(12, product.getGender());
            pstmt.setDouble(13, product.getWeight());
            pstmt.setInt(14, product.getId());
            System.out.println(pstmt);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated);
            if (rowsUpdated == 1)
                return true;                   
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public Product getProductById(int id){
        Product pro = new Product();
        try{
            PreparedStatement pstmt = dbCon.conn.prepareStatement("select * from products where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setDescription(rs.getString("description"));
                pro.setStock(rs.getInt("stock"));
                pro.setCategory_id(rs.getInt("category_id"));
                pro.setProduct_code(rs.getInt("product_code"));
                pro.setPrice(rs.getDouble("price"));
                pro.setBrand_name(rs.getString("brand_name"));
                pro.setManufacture_date(rs.getDate("manufacture_date"));
                pro.setExpire_date(rs.getDate("expire_date"));
                pro.setAmount(rs.getDouble("amount"));
                pro.setSize(rs.getString("size"));
                pro.setGender(rs.getString("gender"));
                pro.setWeight(rs.getDouble("weight"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(Exception e){
            System.out.println(e);
        }
        return pro;
    }
}
