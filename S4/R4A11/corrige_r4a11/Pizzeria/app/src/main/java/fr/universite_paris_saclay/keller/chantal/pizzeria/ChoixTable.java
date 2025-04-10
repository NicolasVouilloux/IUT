package fr.universite_paris_saclay.keller.chantal.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Partie 4 : ajout d'une activité d'accueil
public class ChoixTable extends AppCompatActivity implements View.OnClickListener {

    public final static String CLE_NUM_TABLE = "CLE_NUM_TABLE";

    private EditText numTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_table);

        // Partie 4 : on récupère les objets de l'interface et on associe un écouteur au bouton
        numTable = findViewById(R.id.numTable);
        Button valider = findViewById(R.id.boutonValider);
        valider.setOnClickListener(this);

        // Partie 4 : observation du cycle de vie
        Log.i("ChoixTable", "onCreate");
    }

    // Partie 4 : l'écouteur sur le bouton récupère ce que l'utilisateur a entré dans la zone de
    // texte, et le passe à la deuxième activité en la lançant
    @Override
    public void onClick(View v) {
        String num = String.valueOf(numTable.getText());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(CLE_NUM_TABLE, num);
        startActivity(intent);
    }

    // Partie 4 : redéfinition des méthodes Android gérant la vie de l'activité, pour observer le
    // cycle de vie
    // Attention : onCreate est déjà redéfinie
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ChoixTable", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ChoixTable", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ChoixTable", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ChoixTable", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ChoixTable", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ChoixTable", "onDestroy");
    }

}
