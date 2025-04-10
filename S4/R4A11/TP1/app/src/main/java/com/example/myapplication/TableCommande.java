package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TableCommande extends AppCompatActivity implements View.OnClickListener{

    private Button btnValidate;
    private TextView txtBox;
    public final static String CLE_TABLE = "CLE_TABLE";
    private static final String TAG = "TableCommande";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_table_commande);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnValidate = findViewById(R.id.BTN_Validate);
        btnValidate.setOnClickListener(this);
        txtBox = findViewById(R.id.textInputEditText);
        Log.i(TAG, "onCreate() appelé");
    }


    @Override
    public void onClick(View view) {
        if(view.getId()== btnValidate.getId()){
          Intent intent = new Intent(this, MainActivity.class);
          String userInput = txtBox.getText().toString().trim();
            if (!userInput.isEmpty()) {
                int number = Integer.parseInt(userInput);
                intent.putExtra(CLE_TABLE,number);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            }
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
}