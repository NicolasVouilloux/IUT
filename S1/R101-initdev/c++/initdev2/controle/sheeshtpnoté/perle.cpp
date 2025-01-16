//---- fichier perle.cpp
#include <iostream>
#include <vector>
#include "perle.h"
using namespace std;
Perle::Perle(const string &c,const string &f){
  // les valeurs c et f sont supposées correctes : pas de vérification
   _forme=f;
   _couleur=c;
}
bool Perle::operator==(const Perle&p)const{
    return (_couleur==p._couleur);
}
void Perle::afficher(){
    cout<<_couleur<<" "<<_forme<<endl;
}
