#include "combinaison.h"

Pion Combinaison::getPion(int indice)const{
  return _tab.at(indice);
}
 int Combinaison::getDifficulte()const{
   return _tab.size();
 }

bool Combinaison::compatibles(const Combinaison &c)const{
  return _tab.size() == c._tab.size();
}

void  Combinaison::affiche ()const{
  cout << "Difficulte " << getDifficulte() << endl;
  for(int i=0;i<_tab.size();i++)
    _tab[i].affiche();
}
Combinaison::Combinaison(const int &x){
    for(int i=0;i<x;i++){
        _tab.push_back(Pion (COULEURS[(rand())%5]));
    }
}
bool Combinaison::operator ==(const Combinaison&c1)const{
    bool rep=true;
    if (_tab.size()!= c1._tab.size())
        rep=false;
        return rep;
    for(int i=0;i<_tab.size();i++){
        if (getPion(i)==c1.getPion(i))
            int x=0;//je n'ai pas l'operateur != pour les pion
        else{
            rep=false;
            return rep;
        }
    }
    return rep;
}
Combinaison::modifPion(const int &x,const Pion&p1){
    _tab[x]=p1;
}
