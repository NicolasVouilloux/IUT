#include "pion.h"

class Combinaison{
  vector <Pion> _tab;  // liste des pions de la combinaison
 public:
  int getDifficulte()const;  // retourne la difficult� de la combinaison  (c'est � dire le nombre de Pions)
  Pion getPion(int indice)const;  // retourne le Pion � l'indice indice. Exception si indice incorrect
  bool compatibles(const Combinaison &c)const; // vrai si les 2 combinaisons ont la m�me difficult�
  void affiche ()const;
  Combinaison(const int&);
  bool operator ==(const Combinaison&c1)const;
  modifPion(const int &indice,const Pion&);
};

