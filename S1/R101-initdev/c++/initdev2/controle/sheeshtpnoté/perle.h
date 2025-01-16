#ifndef PERLE_H_INCLUDED
#define PERLE_H_INCLUDED

//---- fichier perle.h
#include <iostream>
#include <vector>

using namespace std;
const vector <string> FORMES={"carre", "rond", "fleur","lune"};

class Perle{
  string _forme;
  string _couleur;
 public:
  Perle( const string &c="rouge",const string &f="rond");
  string laForme()const{return _forme;}
  bool operator==(const Perle&)const;
  void afficher();
};

#endif // PERLE_H_INCLUDED
