package com.ute.webapp.controllers;

import com.ute.webapp.beans.Product;
import com.ute.webapp.models.ProductModel;
import com.ute.webapp.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductServlet", value = "/Admin/Product/*")
public class AdminProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                List<Product> list = ProductModel.findAll();
                request.setAttribute("products", list);
                ServletUtils.forward("/views/vwAdmin/IndexProduct.jsp", request, response);
                break;

             case "/Add":
               ServletUtils.forward("/views/vwAdmin/AddProduct.jsp", request, response);
               break;

             case "/Edit":
               int id = 0;
               try {
                 id = Integer.parseInt(request.getParameter("id"));
               } catch (NumberFormatException e) {
               }

               Product c = ProductModel.findById(id);
               if (c != null) {
                 request.setAttribute("product", c);
                 ServletUtils.forward("/views/vwAdmin/EditProduct.jsp", request, response);
               } else {
                 ServletUtils.redirect("/Admin/Product", request, response);
                 // ServletUtils.forward("/views/204.jsp", request, response);
               }
               break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String path = request.getPathInfo();
         switch (path) {
           case "/Add":
             addProduct(request, response);
             break;

           case "/Delete":
             deleteProduct(request, response);
             break;

           case "/Update":
             updateProduct(request, response);
             break;

           default:
             ServletUtils.forward("/views/404.jsp", request, response);
             break;
         }
    }

     private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String proName = request.getParameter("ProName");
       String trademark = request.getParameter("Trademark");
       String color = request.getParameter("Color");
       int quantity = Integer.parseInt(request.getParameter("Quantity"));
       int price = Integer.parseInt(request.getParameter("Price"));
       int type = Integer.parseInt(request.getParameter("Type"));
       String tinyDes = request.getParameter("TinyDes");
       String fullDes = request.getParameter("FullDes");
       Product c = new Product(proName, price,type,trademark, color,quantity, tinyDes, fullDes);
       ProductModel.add(c);
       ServletUtils.forward("/views/vwAdmin/AddProduct.jsp", request, response);
     }

     private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String proName = request.getParameter("ProName");
         String trademark = request.getParameter("Trademark");
         String color = request.getParameter("Color");
         int quantity = Integer.parseInt(request.getParameter("Quantity"));
         int price = Integer.parseInt(request.getParameter("Price"));
         int type = Integer.parseInt(request.getParameter("Type"));
         int proID = Integer.parseInt(request.getParameter("ProID"));
         String tinyDes = request.getParameter("TinyDes");
         String fullDes = request.getParameter("FullDes");
         Product c = new Product(proID,proName, price,type,trademark, color,quantity, tinyDes, fullDes);
       ProductModel.update(c);
       ServletUtils.redirect("/Admin/Product", request, response);
     }

     private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("ProID"));
       ProductModel.delete(id);
       ServletUtils.redirect("/Admin/Product", request, response);
     }
}
