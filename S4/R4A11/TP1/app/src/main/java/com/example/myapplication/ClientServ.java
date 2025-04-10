package com.example.myapplication;

import android.os.Handler;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientServ extends Thread{

    private Product product;
    private MainActivity mainActivity;
    private Order order;
    private TableCommande tableCommande;
    private TextView txtBox;
    private final Handler handler = new Handler();
    private String txt;
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

                Runnable posterAffichage = new Runnable()
                {
                    public void run()
                    {
                        mainActivity.getTableCommande().setText(txt);
                    }
                };

                // Initialize BufferedReader correctly
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                txt  = bufferedReader.readLine();
                handler.post(posterAffichage);

                txt  = bufferedReader.readLine();
                handler.post(posterAffichage);


                // Close resources
                bufferedReader.close();
                writer.close();
                socket.close();

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
