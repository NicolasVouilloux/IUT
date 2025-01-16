/// TP5 Tris et Complexité
/// 2022-2023
/// fichier outils.h

#ifndef OUTILS_H_INCLUDED
#define OUTILS_H_INCLUDED

#include <vector>

using namespace std;

/// les quatres algorithmes de tri possibles
/// un Algo est un int qui n'a que 4 valeurs possibles
enum Algo {SELECTION, BULLE, BULLE_OPT, RAPIDE};

/// les trois valeurs possibles pour l'ordre des valeurs
/// un Ordre est un int qui n'a que 3 valeurs possibles
enum Ordre {ALEA, CROISSANT, DECROISSANT};

/// Saisit et retourne un entier positif entré par l'utilisateur.
int saisirEntier();

/// Saisit et retourne l'information concernant l'ordre initial du tableau à trier.
Ordre saisirOrdre();

/// Saisit et retourne le choix concernant l'algorithme de tri.
Algo saisirAlgo();

/// Saisit les différents paramètres nécessaires au tri :
/// nombre de valeurs, valeur maximale, nombre d'exécutions, ordre initial, algorithme de tri.
void paramTri(int & nbElts, int & valMax, int & nbExec, Ordre & monOrdre, Algo & monAlgo);


/// Création d'un vecteur contenant nbVal entiers de valeurs aléatoires comprises entre min et max.
void vecteurAlea(vector<int> &v, int nbVal, int min, int max);

/// demande à l'utilisateur si elle veut recommencer le traitement
bool recommencer();

#endif // OUTILS_H_INCLUDED
