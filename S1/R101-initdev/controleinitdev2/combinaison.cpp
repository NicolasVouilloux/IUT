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
