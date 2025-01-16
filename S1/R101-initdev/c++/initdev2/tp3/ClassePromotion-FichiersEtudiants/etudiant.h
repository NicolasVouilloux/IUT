/// TP recherche, R101-2 2023-2024
/// etudiant.h

#ifndef ETUDIANT_H_INCLUDED
#define ETUDIANT_H_INCLUDED

#include <iostream>
using namespace std;

/// groupes possibles
/// (fonction verifGroupe retourne vrai si une chaine est un groupe valide)
const string GROUPES_S1[]={"1A", "1B", "1C", "1D","1E", "1F", "1G", "1H", "1I", "1J", "1K", "1L", "1M" };
const int NBGROUPES_S1 = 13;

class Etudiant
{
private :
    string _nom, _prenom;
    int _num;
    string _groupe;

public :
    Etudiant() {}; /// constructeur vide défini inline/// constructeur vide défini inline
    Etudiant(int num, const string & nom, const string & prenom, const string & groupe);
    void afficher()const;
};

/// verifGroupe: vrai si numGroupe est un nom de groupe valide
bool verifGroupe(const string & numGroupe);

#endif /// ETUDIANT_H_INCLUDED
