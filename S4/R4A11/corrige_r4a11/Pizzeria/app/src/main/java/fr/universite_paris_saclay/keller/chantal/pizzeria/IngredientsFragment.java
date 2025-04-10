package fr.universite_paris_saclay.keller.chantal.pizzeria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

// Partie 6 : fragment contenant la liste des ingrédients pour une pizza personnalisée
public class IngredientsFragment extends Fragment implements View.OnClickListener {

    public static final String CLE_INGREDIENTS = "CLE_INGREDIENTS";

    // Cette fois-ci, c'est l'occasion d'utiliser des structures de données un peu plus élaborées
    // plutôt que d'avoir de nombreuses variables
    private final HashMap<Integer, Bouton> boutons = new HashMap<>();

    private MainActivity mainActivity;


    public IngredientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ingredients, container, false);

        mainActivity = (MainActivity) getActivity();

        ajoutBouton(v, R.id.boutonMozzarella, R.string.mozzarella);
        ajoutBouton(v, R.id.boutonGorgonzola, R.string.gorgonzola);
        ajoutBouton(v, R.id.boutonAnchois, R.string.anchois);
        ajoutBouton(v, R.id.boutonCapres, R.string.capres);
        ajoutBouton(v, R.id.boutonOlives, R.string.olives);
        ajoutBouton(v, R.id.boutonArtichauts, R.string.artichauts);
        ajoutBouton(v, R.id.boutonJambonCru, R.string.jambonCru);
        ajoutBouton(v, R.id.boutonJambonCuit, R.string.jambonCuit);

        for (Bouton b : boutons.values()) {
            b.bouton.setOnClickListener(this);
        }

        Button boutonValider = v.findViewById(R.id.boutonValider);
        boutonValider.setOnClickListener(this);

        if (savedInstanceState != null) {
            boolean[] ingredients = savedInstanceState.getBooleanArray(CLE_INGREDIENTS);
            fromIngredients(ingredients);
        }

        for (Bouton b : boutons.values()) {
            b.affichage();
        }

        return v;
    }


    private void ajoutBouton(View v, int id, int s) {
        if (!boutons.containsKey(id)) {
            boutons.put(id, new Bouton(v.findViewById(id), s));
        } else {
            Bouton b = boutons.get(id);
            assert b != null;
            b.bouton = v.findViewById(id);
        }
    }

    // Méthodes pour aller vers et d'un tableau d'entier du nombre de commandes
    private boolean[] toIngredients() {
        ArrayList<Boolean> ingredients = new ArrayList<>();
        for (Bouton b : boutons.values()) {
            ingredients.add(b.active);
        }
        boolean[] ingrs = new boolean[ingredients.size()];
        int i = 0;
        for (Boolean b : ingredients) {
            ingrs[i] = b;
            i++;
        }
        return ingrs;
    }

    private void fromIngredients(boolean[] ingredients) {
        int i = 0;
        for (Bouton b : boutons.values()) {
            b.active = ingredients[i];
            i++;
        }
    }

    // Sauvegarde des ingrédients sélectionnés lors de la rotation de la tablette
    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] ingredients = toIngredients();
        outState.putBooleanArray(CLE_INGREDIENTS, ingredients);
    }


    // Écouteur
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boutonValider) {
            StringBuilder ings = new StringBuilder("50");
            for (Bouton b : boutons.values()) {
                if (b.active) {
                    if (ings.length() != 2) ings.append(" + ");
                    ings.append(b.texte);
                }
            }
            if (ings.length() != 0) {
                mainActivity.sendMessage(ings.toString());
                PizzasFragment pizzasFragment = mainActivity.getPizzasFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, pizzasFragment);
                transaction.commit();
            } else {
                // Idéalement, afficher un DialogFragment
                System.out.println("Veuillez sélectionner au moins un ingrédient");
            }
        } else {
            Bouton b = boutons.get(v.getId());
            assert b != null;
            b.active = !b.active;
            b.affichage();
        }
    }

    // On fait une classe stockant toutes les informations liées aux boutons
    private class Bouton {
        Button bouton;
        Boolean active;
        String texte;

        public Bouton(Button b, int s) {
            bouton = b;
            active = false;
            texte = getString(s);
        }

        public void affichage() {
            String t = active ? "✓  " : "";
            t += texte;
            bouton.setText(t);
        }
    }
}