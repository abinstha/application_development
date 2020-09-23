/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CategoryDao;
import Dao.ProductDao;
import Domain.Category;
import Domain.Product;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class ProductController extends HttpServlet {

    

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
        String act = request.getParameter("act");
        if (act.equalsIgnoreCase("edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDao proDao = new ProductDao();
            Product product = proDao.getProductById(id);
            CategoryDao catDao = new CategoryDao();
            List<Category> allCategoriesList = catDao.getAllCategories();
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product/edit.jsp");
            request.setAttribute("product", product);
            request.setAttribute("allCategoriesList", allCategoriesList);
            rd.forward(request, response);
        }else if(act.equalsIgnoreCase("list")){
            ProductDao proDao = new ProductDao();
            List<Product> allProductsList = proDao.getAllProducts();
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product/index.jsp");
            request.setAttribute("allProductsList", allProductsList);
            rd.forward(request, response);
        }else if(act.equalsIgnoreCase("delete")){
            int id  = Integer.parseInt(request.getParameter("id"));
            ProductDao proDao = new ProductDao();
            Product pro = new Product();
            pro.setId(id);
            boolean rowsDeleted = proDao.delete(pro);
            if(rowsDeleted){
                List<Product> allProductsList = proDao.getAllProducts();
                RequestDispatcher rd = request.getRequestDispatcher("/admin/product/index.jsp");
                request.setAttribute("allProductsList", allProductsList);
                request.setAttribute("msg", "Product Deleted Successfully!!!");
                rd.forward(request, response);
            }else{
                request.getSession().setAttribute("errorMessage", "Data cannot be deleted!!!");
                response.sendRedirect(request.getHeader("Referer"));
            }
        }else if(act.equalsIgnoreCase("create")){
            CategoryDao catDao = new CategoryDao();
            List<Category> allCategoriesList = catDao.getAllCategories();
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product/create.jsp");
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (act.equalsIgnoreCase("add")) {
            try {
                String m_date_str = request.getParameter("m_date");
                String e_date_str = request.getParameter("e_date");
                
                java.util.Date m_date = sdf.parse(m_date_str);
                java.sql.Date m_date_updated = new java.sql.Date(m_date.getTime());
                
                java.util.Date e_date = sdf.parse(e_date_str);
                java.sql.Date e_date_updated = new java.sql.Date(e_date.getTime());
                
                Product product = new Product();
                
                product.setName(request.getParameter("product_name"));
                product.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
                product.setPrice(Double.parseDouble(request.getParameter("price")));
                product.setStock(Integer.parseInt(request.getParameter("stock")));
                product.setProduct_code(Integer.parseInt(request.getParameter("product_code")));
                product.setDescription(request.getParameter("description"));
                product.setBrand_name(request.getParameter("brand_name"));
                product.setManufacture_date(m_date_updated);
                product.setExpire_date(e_date_updated);
                product.setAmount(Double.parseDouble(request.getParameter("amount")));
                product.setSize(request.getParameter("size"));
                product.setGender(request.getParameter("gender"));
                product.setWeight(Double.parseDouble(request.getParameter("weight")));
                
                ProductDao productDao = new ProductDao();            
                Boolean result = productDao.add(product);
                
                if(result){
                    List<Product> allProductsList = productDao.getAllProducts();
                    RequestDispatcher rd = request.getRequestDispatcher("/admin/product/index.jsp");
                    request.setAttribute("allProductsList", allProductsList);
                    request.setAttribute("msg", "Product Added !");
                    rd.forward(request, response);
                }else{
                    request.getSession().setAttribute("errorMessage", "Data entered is not valid!!!");
                    response.sendRedirect(request.getHeader("Referer"));
                }
            } catch (ParseException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            
        }else if(act.equalsIgnoreCase("update")){
            try {
                Product product = new Product();
                String m_date_str = request.getParameter("m_date");
                String e_date_str = request.getParameter("e_date");
                
                java.util.Date m_date = sdf.parse(m_date_str);
                java.sql.Date m_date_updated = new java.sql.Date(m_date.getTime());
                
                java.util.Date e_date = sdf.parse(e_date_str);
                java.sql.Date e_date_updated = new java.sql.Date(e_date.getTime());
                
                
                product.setId(Integer.parseInt(request.getParameter("id")));
                product.setName(request.getParameter("product_name"));
                product.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
                product.setPrice(Double.parseDouble(request.getParameter("price")));
                product.setStock(Integer.parseInt(request.getParameter("stock")));
                product.setProduct_code(Integer.parseInt(request.getParameter("product_code")));
                product.setDescription(request.getParameter("description"));
                product.setBrand_name(request.getParameter("brand_name"));
                product.setManufacture_date(m_date_updated);
                product.setExpire_date(e_date_updated);
                product.setAmount(Double.parseDouble(request.getParameter("amount")));
                product.setSize(request.getParameter("size"));
                product.setGender(request.getParameter("gender"));
                product.setWeight(Double.parseDouble(request.getParameter("weight")));
                
                ProductDao proDao = new ProductDao();
                boolean result = proDao.update(product);
                System.out.println(result);
                if(result){
                    List<Product> allProductsList = proDao.getAllProducts();
                    RequestDispatcher rd = request.getRequestDispatcher("/admin/product/index.jsp");
                    request.setAttribute("allProductsList", allProductsList);
                    request.setAttribute("msg", "Product Updated!!!!!");
                    rd.forward(request, response);
                }
                else{
                    request.getSession().setAttribute("errorMessage", "Data entered is not valid!!!");
                    response.sendRedirect(request.getHeader("Referer"));
                }
            } catch (ParseException ex) {
                Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
