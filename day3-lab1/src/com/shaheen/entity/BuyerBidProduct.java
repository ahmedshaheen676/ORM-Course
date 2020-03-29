package com.shaheen.entity;
// Generated Mar 28, 2020 1:32:00 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * BuyerBidProduct generated by hbm2java
 */
public class BuyerBidProduct  implements java.io.Serializable {


     private BuyerBidProductId id;
     private Buyer buyer;
     private Product product;
     private Date date;
     private float amount;
     private int quantity;

    public BuyerBidProduct() {
    }

    public BuyerBidProduct(BuyerBidProductId id, Buyer buyer, Product product, Date date, float amount, int quantity) {
       this.id = id;
       this.buyer = buyer;
       this.product = product;
       this.date = date;
       this.amount = amount;
       this.quantity = quantity;
    }
   
    public BuyerBidProductId getId() {
        return this.id;
    }
    
    public void setId(BuyerBidProductId id) {
        this.id = id;
    }
    public Buyer getBuyer() {
        return this.buyer;
    }
    
    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public float getAmount() {
        return this.amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}


