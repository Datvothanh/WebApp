package com.ute.webapp.controllers;

import com.ute.webapp.beans.Category;
import com.ute.webapp.beans.Product;
import com.ute.webapp.models.CategoryModel;
import com.ute.webapp.models.ProductModel;
import com.ute.webapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductFEServlet", value = "/Product/*")
public class ProductFEServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/ByType":
                int type = Integer.parseInt(request.getParameter("id"));
                List<Product> list = ProductModel.findByType(type);
                request.setAttribute("products", list);
                ServletUtils.forward("/views/vwProduct/ByType.jsp", request, response);
                break;
            case "/Detail":
                int proId = Integer.parseInt(request.getParameter("id"));
                Product product = ProductModel.findById(proId);
                if (product == null) {
                    ServletUtils.redirect("/Home", request, response);
                } else {
                    request.setAttribute("product", product);
                    ServletUtils.forward("/views/vwProduct/Detail.jsp", request, response);
                }
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
