package com.example.myapplication;

public class Order {
    private Product product;
    private int nb_Order;

    public Order(Product product, int nb_Order){
        this.product= product;
        this.nb_Order = nb_Order;
    }

    public void addOrder(){
        this.nb_Order++;
    }

    public int getNb_Order() { return nb_Order; }
    public void setNb_Order(int nb_Order){ this.nb_Order=nb_Order; }
    public Product getProduct() { return product; }

}
