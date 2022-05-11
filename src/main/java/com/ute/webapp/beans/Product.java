package com.ute.webapp.beans;

public class Product {
    private int ProID;
    private String ProName;
    private int  Price , Type;
    private String Trademark, Color ;
    private int Quantity;
    private String TinyDes ,FullDes;


    public Product() {
    }

    public Product(int proID, String proName, int price, int type, String trademark, String color, int quantity, String tinyDes, String fullDes) {
        ProID = proID;
        ProName = proName;
        Price = price;
        Type = type;
        Trademark = trademark;
        Color = color;
        Quantity = quantity;
        TinyDes = tinyDes;
        FullDes = fullDes;
    }

    public Product(String proName, int price, int type, String trademark, String color, int quantity, String tinyDes, String fullDes) {
        ProID = -1;
        ProName = proName;
        Price = price;
        Type = type;
        Trademark = trademark;
        Color = color;
        Quantity = quantity;
        TinyDes = tinyDes;
        FullDes = fullDes;
    }

    public int getProID() {
        return ProID;
    }

    public String getProName() {
        return ProName;
    }

    public int getPrice() {
        return Price;
    }

    public int getType() {
        return Type;
    }

    public String getTrademark() {
        return Trademark;
    }

    public String getColor() {
        return Color;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getTinyDes() {
        return TinyDes;
    }

    public String getFullDes() {
        return FullDes;
    }
}
