package fr.universite_paris_saclay.keller.chantal.pizzeria;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// Partie 6 : fragment contenant la liste des pizzas
public class PizzasFragment extends Fragment implements View.OnClickListener {

    // Partie 6 : activité contenant le fragment
    private MainActivity mainActivity;

    // Partie 3 (animation)
    // Stockage des boutons
    // Remarque : on peut utiliser des structures de données plus évoluées (comme une HashMap qui
    // associe à chaque id son bouton) pour éviter de répéter 8 fois le même code partout, mais ce
    // n'est pas demandé
    Button boutonNapolitaine;
    Button boutonRoyale;
    Button boutonQuatreFromage;
    Button boutonMontagnarde;
    Button boutonRaclette;
    Button boutonHawai;
    Button boutonPannaCotta;
    Button boutonTiramisu;

    // Partie 3 (animation)
    // On stocke le nombre de pizzas commandées par pizza. C'est important de le stocker pour bien
    // séparer les données de la vue
    int nbNapolitaine = 0;
    int nbRoyale = 0;
    int nbQuatreFromages = 0;
    int nbMontagnarde = 0;
    int nbRaclette = 0;
    int nbHawai = 0;
    int nbPannaCotta = 0;
    int nbTiramisu = 0;

    // Partie 3 (persistance courte)
    // Clés utilisées pour sauvegarder temporairement le nombre de chaque pizza
    public final static String CLE_NAPOLITAINE = "CLE_NAPOLITAINE";
    public final static String CLE_ROYALE = "CLE_ROYALE";
    public final static String CLE_QUATRE_FROMAGES = "CLE_QUATRE_FROMAGES";
    public final static String CLE_MONTAGNARDE = "CLE_MONTAGNARDE";
    public final static String CLE_RACLETTE = "CLE_RACLETTE";
    public final static String CLE_HAWAI = "CLE_HAWAI";
    public final static String CLE_PANNA_COTTA = "CLE_PANNA_COTTA";
    public final static String CLE_TIRAMISU = "CLE_TIRAMISU";
    public final static String CLE_PERSONNALISEE = "CLE_PERSONNALISEE";

    // Partie 6 : bouton d'accès aux pizzas personnalisées, et nombre de commandes associé
    private Button boutonPersonnalisee;
    private int nbPersonnalisee = 0;

    public PizzasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pizzas, container, false);

        mainActivity = (MainActivity) getActivity();

        // Partie 3 (animation)
        // On récupère les objets de l'interface *après* avoir lancé l'interface, et on leur associe
        // l'écouteur, implanté dans la classe courante
        boutonNapolitaine = v.findViewById(R.id.boutonNapolitaine);
        boutonRoyale = v.findViewById(R.id.boutonRoyale);
        boutonQuatreFromage = v.findViewById(R.id.boutonQuatreFromages);
        boutonMontagnarde = v.findViewById(R.id.boutonMontagnarde);
        boutonRaclette = v.findViewById(R.id.boutonRaclette);
        boutonHawai = v.findViewById(R.id.boutonHawai);
        boutonPannaCotta = v.findViewById(R.id.boutonPannaCotta);
        boutonTiramisu = v.findViewById(R.id.boutonTiramisu);

        boutonNapolitaine.setOnClickListener(this);
        boutonRoyale.setOnClickListener(this);
        boutonQuatreFromage.setOnClickListener(this);
        boutonMontagnarde.setOnClickListener(this);
        boutonRaclette.setOnClickListener(this);
        boutonHawai.setOnClickListener(this);
        boutonPannaCotta.setOnClickListener(this);
        boutonTiramisu.setOnClickListener(this);

        // Partie 6 : bouton des pizzas personnalisées
        boutonPersonnalisee = v.findViewById(R.id.boutonPersonalisee);
        boutonPersonnalisee.setOnClickListener(this);


        // Partie 3 (persistance courte)
        // Si le bundle n'est pas vide, on récupère les valeurs et on les affiche
        if (savedInstanceState != null) {
            nbNapolitaine = savedInstanceState.getInt(CLE_NAPOLITAINE);
            nbRoyale = savedInstanceState.getInt(CLE_ROYALE);
            nbQuatreFromages = savedInstanceState.getInt(CLE_QUATRE_FROMAGES);
            nbMontagnarde = savedInstanceState.getInt(CLE_MONTAGNARDE);
            nbRaclette = savedInstanceState.getInt(CLE_RACLETTE);
            nbHawai = savedInstanceState.getInt(CLE_HAWAI);
            nbPannaCotta = savedInstanceState.getInt(CLE_PANNA_COTTA);
            nbTiramisu = savedInstanceState.getInt(CLE_TIRAMISU);
            nbPersonnalisee = savedInstanceState.getInt(CLE_PERSONNALISEE);
        }

        majAffichage();

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        // Partie 6
        // Cas particulier d'une commande de pizza personnalisée
        if (id == R.id.boutonPersonalisee) {
            nbPersonnalisee++;
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.addToBackStack("pizzas");
            transaction.replace(R.id.fragment, ingredientsFragment);
            transaction.commit();
        } else if (id == R.id.boutonNapolitaine) {
            nbNapolitaine++;
            // Partie 5 : envoi du message au serveur
            mainActivity.sendMessage("11");
        } else if (id == R.id.boutonRoyale) {
            nbRoyale++;
            mainActivity.sendMessage("05");
        } else if (id == R.id.boutonQuatreFromages) {
            nbQuatreFromages++;
            mainActivity.sendMessage("14");
        } else if (id == R.id.boutonMontagnarde) {
            nbMontagnarde++;
            mainActivity.sendMessage("18");
        } else if (id == R.id.boutonRaclette) {
            nbRaclette++;
            mainActivity.sendMessage("20");
        } else if (id == R.id.boutonHawai) {
            nbHawai++;
            mainActivity.sendMessage("06");
        } else if (id == R.id.boutonPannaCotta) {
            nbPannaCotta++;
            mainActivity.sendMessage("94");
        } else if (id == R.id.boutonTiramisu) {
            nbTiramisu++;
            mainActivity.sendMessage("91");
        }
        majAffichage();
    }

    // Partie 3 (animation)
    // C'est mieux de faire des fonctions, car on va utiliser le même code à plusieurs endroits.
    // Insister sur l'importance de factoriser le code.
    // On utilise le fichier "strings.xml" pour gérer le fait d'avoir plusieurs langues.
    private void majAffichageBouton(int s, int nb, Button b) {
        String texte = getString(s);
        if (nb > 0) {
            texte += " : " + nb;
        }
        b.setText(texte);
    }
    private void majAffichage() {
        majAffichageBouton(R.string.napolitaine, nbNapolitaine, boutonNapolitaine);
        majAffichageBouton(R.string.royale, nbRoyale, boutonRoyale);
        majAffichageBouton(R.string.quatreFromages, nbQuatreFromages, boutonQuatreFromage);
        majAffichageBouton(R.string.montagnarde, nbMontagnarde, boutonMontagnarde);
        majAffichageBouton(R.string.raclette, nbRaclette, boutonRaclette);
        majAffichageBouton(R.string.hawai, nbHawai, boutonHawai);
        majAffichageBouton(R.string.pannaCotta, nbPannaCotta, boutonPannaCotta);
        majAffichageBouton(R.string.tiramisu, nbTiramisu, boutonTiramisu);
        majAffichageBouton(R.string.personnalisee, nbPersonnalisee, boutonPersonnalisee);
    }

    // Partie 3 (persistance courte)
    // On sauvegarde les données (nombre de commandes de chaque pizza) avant rotation de la tablette
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(CLE_NAPOLITAINE, nbNapolitaine);
        outState.putInt(CLE_ROYALE, nbRoyale);
        outState.putInt(CLE_QUATRE_FROMAGES, nbQuatreFromages);
        outState.putInt(CLE_MONTAGNARDE, nbMontagnarde);
        outState.putInt(CLE_RACLETTE, nbRaclette);
        outState.putInt(CLE_HAWAI, nbHawai);
        outState.putInt(CLE_PANNA_COTTA, nbPannaCotta);
        outState.putInt(CLE_TIRAMISU, nbTiramisu);
        outState.putInt(CLE_PERSONNALISEE, nbPersonnalisee);
        super.onSaveInstanceState(outState);
    }

    // Partie 7
    // Application des préférences
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String couleur = sharedPreferences.getString("COULEUR_BOUTONS", "violet");
        int color = R.color.violet;
        if (couleur.equals("rouge")) {
            color = R.color.rouge;
        } else if (couleur.equals("vert")) {
            color = R.color.vert;
        } else if (couleur.equals("bleu")) {
            color = R.color.bleu;
        }
        buttonsSetColor(getActivity().getColor(color));
    }

    private void buttonsSetColor(int color) {
        boutonNapolitaine.setBackgroundColor(color);
        boutonRoyale.setBackgroundColor(color);
        boutonQuatreFromage.setBackgroundColor(color);
        boutonMontagnarde.setBackgroundColor(color);
        boutonRaclette.setBackgroundColor(color);
        boutonHawai.setBackgroundColor(color);
        boutonPannaCotta.setBackgroundColor(color);
        boutonTiramisu.setBackgroundColor(color);
        boutonPersonnalisee.setBackgroundColor(color);
    }
}