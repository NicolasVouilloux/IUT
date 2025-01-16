/// TP recherche, R101-2 2023-2024
/// etudiant.cpp

#include "etudiant.h"

/// Constructeur avec 4 parametres
Etudiant::Etudiant(int num, const string & nom, const string & prenom, const string & groupe)
{
    if (!verifGroupe(groupe))
        throw invalid_argument("groupe invalide : " + groupe);

    _nom = nom;
    _prenom = prenom;
    _num = num;  /// on suppose que les numéros d'étudiant sont valides.
    _groupe = groupe;
}

/// Affichage d'un étudiant
void Etudiant::afficher () const
{
    cout << _num << " "<< _groupe  << " " << _nom << " "<< _prenom << endl;
}

/// verifGroupe : vrai si numGroupe est un nom de groupe valide
bool verifGroupe(const string & numGroupe)
{
    bool trouve = false;
    int i = 0;
    while (!trouve && i < NBGROUPES_S1)
    {
        trouve=numGroupe==GROUPES_S1[i];
        i++;
    }
    return(trouve);
}

