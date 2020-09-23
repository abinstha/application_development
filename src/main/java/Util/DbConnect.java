/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author acer
 */
public class DbConnect {
    public Connection conn;
    public void dbConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "");
        }catch(Exception ex){
            ex.printStackTrace();
        }        
    }
}
