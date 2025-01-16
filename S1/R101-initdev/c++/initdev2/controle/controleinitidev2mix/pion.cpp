#include "pion.h"

void  Pion::affiche()const{
  cout << "pion de couleur " << _couleur << endl;
}
Pion::Pion(const char &c){
    try {
        if (c!=COULEURS[0]&&c!=COULEURS[1]&&c!=COULEURS[2]&&c!=COULEURS[3]&&c!=COULEURS[4])
            throw invalid_argument("couleur non correcte");
        _couleur=c;

    } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
}
Pion::Pion(){
    _couleur=COULEURS[4];
}
bool Pion::operator==(const Pion &p1) const {
  if (_couleur!=p1._couleur)
    return false;
  return true;
}
