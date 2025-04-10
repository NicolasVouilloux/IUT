package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "MainActivity";
    private String formatTableNumber = "";
    private TextView tableCommande;

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

        tableCommande = findViewById(R.id.TXTB_NumTable);

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
        Intent intent = getIntent();
        int nbTable = intent.getIntExtra(TableCommande.CLE_TABLE,1);
        TextView txtViewName = findViewById(R.id.TXTB_NumTable);
        String actualTxt = txtViewName.getText().toString();
        actualTxt+=nbTable;
        txtViewName.setText(actualTxt);

        if (nbTable<10){
            formatTableNumber = "0"+nbTable;
        }
        else formatTableNumber += nbTable;

        Log.i(TAG, "onCreate() appelé");

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

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
                ClientServ client = new ClientServ(Orders.get(i).getProduct(),this);
                client.start();
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


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() appelé");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() appelé");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() appelé");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() appelé");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() appelé");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() appelé");
    }

    public String getFormatTableNumber() {
        return formatTableNumber;
    }

    public void setFormatTableNumber(String formatTableNumber) {
        this.formatTableNumber = formatTableNumber;
    }

    public TextView getTableCommande() {
        return tableCommande;
    }

    public void setTableCommande(TextView tableCommande) {
        this.tableCommande = tableCommande;
    }
}
