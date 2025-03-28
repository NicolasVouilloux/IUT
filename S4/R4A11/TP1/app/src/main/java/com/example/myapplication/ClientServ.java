package com.example.myapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientServ extends Thread{

    private Product product;
    private MainActivity mainActivity;
    private Order order;
    private TableCommande tableCommande;

    public ClientServ(Product product, MainActivity mainActivity){
        this.product = product;
        this.mainActivity = mainActivity;
    }

    public void run() {
        try {
            Socket socket = new Socket("giraudot.com", 9874);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String sent = mainActivity.getFormatTableNumber() + product.getCodeProduct();
            writer.println(sent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TableCommande getTableCommande() {
        return tableCommande;
    }

    public void setTableCommande(TableCommande tableCommande) {
        this.tableCommande = tableCommande;
    }
}
