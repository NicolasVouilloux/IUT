#include "cadeau.h"
#include "enfant.h"

Enfant::Enfant(const string &n){
  _nom=n;
}
string Enfant::nom()const{
  return _nom;
}

