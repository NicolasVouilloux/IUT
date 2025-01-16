/// TP recherche, R101-2 2023-2024
/// promotion.cpp

#include <iostream>
#include <vector>
#include <fstream>
#include "etudiant.h"
#include "promotion.h"

using namespace std;

/// Affichage d'une promotion complète.
void Promotion::afficher()const
{
    int nbEtudiants = _promo.size();
    cout << "\nPromo " << _nom << " de " << nbEtudiants << " etudiants : " << endl;
    for (int i=0 ; i<nbEtudiants ; i++)
    {
        cout << "("<< i << ")  ";
        _promo[i].afficher();
    }
    cout << endl;
}

/// Affiche la promo entre indices déb et fin.
/// Propage exception déclenchée par at() si indice invalide.
void Promotion::afficherBornes(int deb, int fin)const
{
    for (int i=deb ; i<= fin ; i++)
    {
        cout << "("<< i << ")  ";
        _promo.at(i).afficher(); /// at(i) lance exception si indice invalide
    }
    cout << endl;
}

/// Retourne l'étudiant en position ind du vecteur.
/// Propage exception déclenchée par at() si indice invalide.
Etudiant Promotion::getEtud(int ind) const
{
    return(_promo.at(ind)); /// at(i) lance exception si indice invalide
}

/// Initialisation d'une promotion par lecture d'un fichier.
/// Déclenche exception chaine si erreur fichier.
/// Contenu fichier : 1ère info = nom promo, puis nom, prénom, groupe, num de chaque étudiant.
void Promotion::init(const string & ficEtudiants)
{
    /// les infos dans le fichier
    string nom;
    string prenom;
    string groupe;
    int num;

    /// parcours du fichier
    ifstream ific(ficEtudiants.c_str(), ios::in); /// ouvrir le fichier en lecture
    if(!ific.is_open())   /// si pb ouverture
        throw string ("l'ouverture du fichier a echoue : " + ficEtudiants);
    ific >> _nom; /// 1ère info lue est le nom de la promo, par ex. S1
    while(!ific.eof()) /// tant qu'on n'a pas atteint la  fin du fichier
    {
        /// lire les infos pour chaque étudiant
        ific >> nom;
        ific >> prenom;
        ific >> groupe;
        ific >> num;
        /// créer l'étudiant et l'ajouter à la fin du vector
        _promo.push_back(Etudiant(num, nom, prenom, groupe));
    }
    ific.close(); /// fermer le fichier
}
