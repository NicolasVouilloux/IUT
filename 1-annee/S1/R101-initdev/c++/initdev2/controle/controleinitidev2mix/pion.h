#ifndef _PION_H
#define _PION_H
#include <iostream>
#include <vector>
using namespace std;

// Classe Pion


const vector<char> COULEURS = {'r','v','b','n','j'};  // liste des couleurs possibles
class Pion{
  char _couleur; // la couleur du pion

 public :
     Pion (const char &);
     Pion ();
     bool operator ==(const Pion&)const;
  void affiche()const;

};
#endif

