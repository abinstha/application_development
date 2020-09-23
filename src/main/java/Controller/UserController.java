/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class UserController extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        
        User user = new User();
        
        user.setUsername(req.getParameter("username"));
        user.setFirst_name(req.getParameter("firstName"));
        user.setLast_name(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setMob_number(req.getParameter("mobNo"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        
        int result = userDao.add(user);
        if(result == 1){
            response.sendRedirect("login.jsp");
        }else{
            response.sendRedirect("register.jsp");
        }
    }

}
