package com.ute.webapp.models;

import com.ute.webapp.beans.Product;
import com.ute.webapp.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class ProductModel {
    public static List<Product> findAll() {
        final String query = "select * from products";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Product.class);
        }
    }

    public static Product findById(int id) {
        final String query = "select * from products where ProID = :ProID";
        try (Connection con = DbUtils.getConnection()) {
            List<Product> list = con.createQuery(query)
                    .addParameter("ProID", id)
                    .executeAndFetch(Product.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }



    public static void add(Product p) {
        String Sql = "insert into products (ProName, Price, Type, Trademark, Color, Quantity, TinyDes, FullDes) value (:ProName,:Price,:Type,:Trademark,:Color,:Quantity,:TinyDes,:FullDes)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(Sql)
                    .addParameter("ProName",p.getProName() )
                    .addParameter("Price", p.getPrice())
                    .addParameter("Type", p.getType() )
                    .addParameter("Trademark", p.getTrademark())
                    .addParameter("Color", p.getColor())
                    .addParameter("Quantity", p.getQuantity())
                    .addParameter("TinyDes", p.getTinyDes())
                    .addParameter("FullDes", p.getFullDes())
                    .executeUpdate();
        }
    }



    public static void update(Product p) {
        String sql = "UPDATE products SET   ProName = :ProName, Price = :Price, Type = :Type, Trademark = :Trademark, Color = :Color, Quantity = :Quantity, TinyDes = :TinyDes, FullDes = :FullDes WHERE ProID = :ProID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("ProID", p.getProID())
                    .addParameter("ProName", p.getProName())
                    .addParameter("Price", p.getPrice())
                    .addParameter("Type", p.getType() )
                    .addParameter("Trademark", p.getTrademark())
                    .addParameter("Color", p.getColor())
                    .addParameter("Quantity", p.getQuantity())
                    .addParameter("TinyDes", p.getTinyDes())
                    .addParameter("FullDes", p.getFullDes())
                    .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from products where ProID = :ProID";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("ProID", id)
                    .executeUpdate();
        }
    }
}