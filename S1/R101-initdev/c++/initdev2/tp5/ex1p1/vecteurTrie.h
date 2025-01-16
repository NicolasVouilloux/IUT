/// TP5 Tris et Complexité
/// 2022-2023
/// fichier vecteurTrie.h

#ifndef VECTEURTRIE_H_INCLUDED
#define VECTEURTRIE_H_INCLUDED

#include <vector>
#include "outils.h"

using namespace std;

class VecteurTrie
{
    vector<int> _v;

public :

    VecteurTrie(){} /// vecteur vide à la création

    /// Initialise le vecteur  en fonction des parametres choisis par l'utilisateur
    void initVecteur(int nbVal, Ordre ordr,  int valMax);

    /// Applique l'algorithme de tri choisi par l'utilisateur.
    /// Compte le nombre d'écritures et de comparaisons dans le vecteur de données.
    void trier(Algo alg, int & cptEcrit, int & cptComp);

    /// Echange deux positions dans un vecteur.
    void echanger(int ind1, int ind2, int & cptEcrit) ;

    /// Affichage d'un vecteur d'entiers.
    void afficher()const;

     /****** TRI BULLE ******/
    void triBulles(int & cptEcrit, int & cptComp) ;
    void triBullesOpt(int & cptEcrit, int & cptComp) ;

    /****** TRI SELECTION ******/
    void triSelection(int & cptEcrit, int & cptComp); /// ordre données : croissant
    void triSelectionInverse(int & cptEcrit, int & cptComp) ; /// ordre données : décroissant
    int selection(int indDebut, int indFin, int & cptEcrit, int & cptComp) ; /// recherche min entre indDebut et indFin
    int selectionMax(int indDebut, int indFin, int & cptEcrit, int & cptComp) ; /// recherche max entre indDebut et indFin

    /****** TRI RAPIDE ******/

    void triRapide(int & cptEcrit, int & cptComp) ;

    /// Partitionne le vecteur et appelle récursivement la procédure triRapideAux sur la partie gauche et la partie droite du vecteur.
    void triRapideAux(int debut, int fin, int & cptEcrit, int & cptComp) ;

    /// Partitionnement du vecteur (éléments inférieurs à un pivot à sa gauche et éléments supérieurs à sa droite).
    /// Retourne l'indice du pivot.
    int partitionner(int debut, int fin, int & cptEcrit,int & cptComp);

};

#endif // VECTEURTRIE_H_INCLUDED
