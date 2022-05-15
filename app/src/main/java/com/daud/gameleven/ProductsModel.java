package com.daud.gameleven;

import java.util.ArrayList;
import java.util.List;

public class ProductsModel {
    private String name;
    private String model;
    private String productid;
    private String category;
    private String oprice;
    private String nprice;
    private int image;
    private String description;
    private String discount;
    private int quantity;
    private int brandimage;

    public ProductsModel() {
    }

    public ProductsModel(String name, String model, String productid, String category, String oprice, String nprice,
                         int image, String description, String discount, int quantity, int brandimage) {
        this.name = name;
        this.model = model;
        this.productid = productid;
        this.category = category;
        this.oprice = oprice;
        this.nprice = nprice;
        this.image = image;
        this.description = description;
        this.discount = discount;
        this.quantity = quantity;
        this.brandimage = brandimage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBrandimage() {
        return brandimage;
    }

    public void setBrandimage(int brandimage) {
        this.brandimage = brandimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOprice() {
        return oprice;
    }

    public void setOprice(String oprice) {
        this.oprice = oprice;
    }

    public String getNprice() {
        return nprice;
    }

    public void setNprice(String nprice) {
        this.nprice = nprice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
