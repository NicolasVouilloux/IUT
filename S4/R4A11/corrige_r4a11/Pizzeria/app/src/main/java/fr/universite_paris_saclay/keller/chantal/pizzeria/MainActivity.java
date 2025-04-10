package fr.universite_paris_saclay.keller.chantal.pizzeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Activité principale de l'application : sélection des pizzas
public class MainActivity extends AppCompatActivity {

    // Partie 4
    private TextView numTable;
    private String numeroTable;

    // Partie 6
    // On conserve le fragment des pizzas si possible pour éviter de le regénérer
    private PizzasFragment pizzasFragment;
    protected PizzasFragment getPizzasFragment() {
        return pizzasFragment;
    }
    public final static String CLE_FRAGMENT = "CLE_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Partie 4
        // On récupère le numéro de table dans l'intention qui nous a lancée et on l'affiche
        Intent intent = getIntent();
        numeroTable = intent.getStringExtra(ChoixTable.CLE_NUM_TABLE);
        numTable = findViewById(R.id.numTable);
        numTable.setText(getString(R.string.commande, numeroTable));

        // Partie 6
        // Affichage du fragment au premier lancement de l'activité
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (f == null) {
            pizzasFragment = new PizzasFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment, pizzasFragment);
            transaction.commit();
        } else {
            if (f instanceof PizzasFragment) {
                pizzasFragment = (PizzasFragment) f;
            }
        }

        // Partie 6
        // On récupère le fragment des pizzas sauvegardé même s'il n'est pas attaché
        // Non demandé pour le projet
        if (savedInstanceState != null) {
            pizzasFragment = (PizzasFragment) getSupportFragmentManager().getFragment(savedInstanceState, CLE_FRAGMENT);
        }

        // Partie 4 : observation du cycle de vie
        Log.i("MainActivity", "onCreate");
    }

    // Partie 6
    // On fait en sorte que le fragment des pizzas soit sauvegardé même s'il n'est pas attaché
    // Non demandé pour le projet
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, CLE_FRAGMENT, pizzasFragment);
    }

    // Partie 6 : méthode communiquant avec le serveur, qui peut être appelée dans un fragment
    protected void sendMessage(String m) {
        new CallServerPizzeria(m).start();
    }

    // Partie 5 : classe communiquant avec le serveur
    private class CallServerPizzeria extends Thread {
        private final String pizzaDessert;
        private final Handler handler = new Handler() ;

        public CallServerPizzeria(String m) {
            pizzaDessert = m;
        }

        @Override
        public void run () {
            try {
                Socket socket = new Socket("giraudot.com", 9874);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                String message = numeroTable;
                if (message.length() == 1) message = "0"+message;
                message += pizzaDessert;
                writer.println(message);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Log.d("Serveur", "Début des réponses");
                String reponse1 = reader.readLine();
                Log.d("Réponse 1", reponse1);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        numTable.setText(reponse1);
                    }
                });
                String reponse2 = reader.readLine();
                Log.d("Réponse 2", reponse2);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        numTable.setText(reponse2);
                    }
                });
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Partie 7 : menu permettant d'ouvrir les préférences
    // Création du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // Écouteur sur le menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // L’item sur lequel l’utilisateur a cliqué
        int id = item.getItemId();
        // Action choisie selon l’item
        if (id == R.id.settings) {
        // Attachement du fragment de préférences
            SettingsFragment settingsFragment = new SettingsFragment();
            getSupportFragmentManager().beginTransaction().addToBackStack("pref")
                    .replace(R.id.fragment, settingsFragment).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Partie 4 : redéfinition des méthodes Android gérant la vie de l'activité, pour observer le
    // cycle de vie
    // Attention : onCreate est déjà redéfinie
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }
}
