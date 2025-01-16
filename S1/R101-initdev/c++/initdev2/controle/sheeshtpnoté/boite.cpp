//---- fichier boite.cpp
#include "perle.h"
#include "boite.h"
#include <string>
using namespace std;

bool Boite::prendrePerle(Perle &laPerle){
  bool res;
  if(_p.size() !=0) {
    laPerle=_p.back();  // récupère la dernière perle
    _p.pop_back();  // et la retire de la Boite
    res=true;
  }
  else res=false;
  return res; /// retourne vrai si la boite contenait au moins une perle, faux sinon
}
Boite::Boite(const string &c,const int &n){
   _couleur=c;
   for (int i=0;i<n;i++){
        _p.push_back(Perle(_couleur,FORMES[rand()%FORMES.size()]));
   }
}
Boite::Boite(){
    _couleur="rouge";
}
void Boite::afficher(){
    cout<<_couleur<<endl;
    for (int i=0;i<_p.size();i++){
        _p[i].afficher();
    }
}
int Boite::nbperle(){
    return _p.size();
}
ostream& operator<<(ostream&o,const boite &b){
   o<<"la boite de "<<b.nbperle()<< ;
   return i;
}
