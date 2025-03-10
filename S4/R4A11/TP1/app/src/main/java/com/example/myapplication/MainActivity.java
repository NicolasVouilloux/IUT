package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<Order> Orders = new ArrayList<>();

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

        for (int i = 0;i<8;i++){
            // setting listener for each buttons
            buttons.get(i).setOnClickListener(this);
            // setting all order val at 0 and creating product in classes
            Product product = new Product(buttons.get(i).getText().toString());
            Orders.add(new Order(product,0));
        }

    }

    @Override
    public void onClick(View v) {
        int idArray =-1;
        for (int i = 0;i<buttons.size();i++){
            if (buttons.get(i).getId() == v.getId()){
                idArray = i;
                break;
            }
        }
        Orders.get(idArray).addOrder();
        if (Orders.get(idArray).getNb_Order()==0){
            String txt = Orders.get(idArray).getProduct().getName()+" : ";
            buttons.get(idArray).setText(txt+=Orders.get(idArray).getNb_Order());
        }

    }
}