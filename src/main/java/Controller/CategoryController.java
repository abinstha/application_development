/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CategoryDao;
import Domain.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class CategoryController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            CategoryDao catDao = new CategoryDao();
            Category user = new Category();
            user.setId(id);
            boolean rowsDeleted = catDao.delete(user);
            if (rowsDeleted) {
                List<Category> allCategoriesList = catDao.getAllCategories();
                RequestDispatcher rd = request.getRequestDispatcher("/admin/product_category/index.jsp");
                request.setAttribute("allCategoriesList", allCategoriesList);
                request.setAttribute("msg", "User Deleted !");
                rd.forward(request, response);
            } else {
                request.getSession().setAttribute("errorMessage", "Data cannot be deleted!!!");
                response.sendRedirect(request.getHeader("Referer"));
            }
        }else if (act.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            CategoryDao catDao = new CategoryDao();
            Category category = catDao.getCategoryById(id);
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product_category/edit.jsp");
            request.setAttribute("category", category);
            rd.forward(request, response);

        }else if(act.equalsIgnoreCase("add")) {
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product_category/create.jsp");
            rd.forward(request, response);
        }else if(act.equalsIgnoreCase("list")){
            CategoryDao catDao = new CategoryDao();
            List<Category> allCategoriesList = catDao.getAllCategories();
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product_category/index.jsp");
            request.setAttribute("allCategoriesList", allCategoriesList);
            rd.forward(request, response);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act.equalsIgnoreCase("add")) {
            Category cat = new Category();
            cat.setCategory(request.getParameter("category"));
            cat.setDescription(request.getParameter("description"));
            CategoryDao catDao = new CategoryDao();
            boolean rowsAdded = catDao.add(cat);
            if(rowsAdded){
                List<Category> allCategoriesList = catDao.getAllCategories();
                RequestDispatcher rd = request.getRequestDispatcher("/admin/product_category/index.jsp");
                request.setAttribute("allCategoriesList", allCategoriesList);
                request.setAttribute("msg", "User Added !");
                rd.forward(request, response);
            }
            else{
                request.getSession().setAttribute("msg", "Data entered is not valid!!!");
                response.sendRedirect(request.getHeader("Referer"));
            }
        } else if (act.equalsIgnoreCase("update")) {
            Category cat = new Category();
            cat.setId(Integer.parseInt(request.getParameter("id")));
            cat.setCategory(request.getParameter("category"));
            cat.setDescription(request.getParameter("description"));
            CategoryDao catDao = new CategoryDao();
            boolean rowsAdded = catDao.update(cat);
            if(rowsAdded){
                List<Category> allCategoriesList = catDao.getAllCategories();
                RequestDispatcher rd = request.getRequestDispatcher("/admin/product_category/index.jsp");
                request.setAttribute("allCategoriesList", allCategoriesList);
                request.setAttribute("msg", "Category Updated !");
                rd.forward(request, response);
            }
            else{
                request.getSession().setAttribute("errorMessage", "Data entered is not valid!!!");
                response.sendRedirect(request.getHeader("Referer"));
            }
        }
    }


}
