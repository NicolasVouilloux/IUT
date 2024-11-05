#ifndef BOITE_H_INCLUDED
#define BOITE_H_INCLUDED

//---- fichier boite.h
#include "perle.h"
#include <iostream>
#include <vector>
using namespace std;

class Boite{
  vector <Perle> _p;
  string _couleur; /// couleur de la boite
 public:
  Boite( const string &,const int&);
  Boite();
  string couleur()const{return _couleur;}  /// retourne la couleur de la boite
  bool prendrePerle(Perle &laPerle); /// prend une perle et la retourne via le paramètre laPerle
     void afficher()const;/// retourne vrai si la boite n'était pas vide, faux sinon
     int nbperle()const;
};

#endif // BOITE_H_INCLUDED
