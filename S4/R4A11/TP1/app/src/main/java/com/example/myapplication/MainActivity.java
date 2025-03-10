package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<Order> Orders = new ArrayList<>();
    private Button btn_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttons.add(findViewById(R.id.BTN_Napolitaine));
        buttons.add(findViewById(R.id.BTN_Royale));
        buttons.add(findViewById(R.id.BTN_QuatreFromages));
        buttons.add(findViewById(R.id.BTN_Montagnarde));
        buttons.add(findViewById(R.id.BTN_Raclette));
        buttons.add(findViewById(R.id.BTN_Hawai));
        buttons.add(findViewById(R.id.BTN_PannaCota));
        buttons.add(findViewById(R.id.BTN_Tiramisu));

        btn_Reset = findViewById(R.id.BTN_Reset);
        btn_Reset.setOnClickListener(this);

        for (int i = 0;i<8;i++){
            // setting listener for each buttons
            buttons.get(i).setOnClickListener(this);
            // setting all order val at 0 and creating product in classes
            Product product = new Product(buttons.get(i).getText().toString());
            Orders.add(new Order(product,0));
        }

        if (savedInstanceState!= null){
            int[] orderCounts = savedInstanceState.getIntArray("Orders");
            if (orderCounts != null) {
                for (int i = 0; i < Orders.size(); i++) {
                    Orders.get(i).setNb_Order(orderCounts[i]);
                    updateTXT_BTN(i);
                }
            }
        }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save order count as an array
        int[] orderCounts = new int[Orders.size()];
        for (int i = 0; i < Orders.size(); i++) {
            orderCounts[i] = Orders.get(i).getNb_Order();
        }
        outState.putIntArray("Orders", orderCounts);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==btn_Reset.getId()){
            resetOrders();
            for (int i = 0;i<buttons.size();i++){
                updateTXT_BTN(i);
            }
            return;
        }
        for (int i = 0;i<buttons.size();i++){
            if (buttons.get(i).getId() == v.getId()){
                System.out.println(buttons.get(i));
                Orders.get(i).addOrder();
                updateTXT_BTN(i);
                return;
            }
        }
    }

    public void updateTXT_BTN(int idArray){
        String txt = Orders.get(idArray).getProduct().getName()+" : ";
        buttons.get(idArray).setText(txt+=Orders.get(idArray).getNb_Order());
    }
    public void resetOrders(){
        for (Order o : Orders){
            o.setNb_Order(0);
        }
    }
}