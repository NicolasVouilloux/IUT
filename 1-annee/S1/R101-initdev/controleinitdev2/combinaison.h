#include "pion.h"

class Combinaison{
  vector <Pion> _tab;  // liste des pions de la combinaison
 public:
  int getDifficulte()const;  // retourne la difficulté de la combinaison  (c'est à dire le nombre de Pions)
  Pion getPion(int indice)const;  // retourne le Pion à l'indice indice. Exception si indice incorrect
  bool compatibles(const Combinaison &c)const; // vrai si les 2 combinaisons ont la même difficulté
  void affiche ()const;
};

