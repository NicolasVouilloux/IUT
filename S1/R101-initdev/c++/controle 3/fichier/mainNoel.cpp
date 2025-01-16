#include "cadeau.h"
#include "enfant.h"

#include <iostream>
#include <vector>
using namespace std;


int main(){
  vector<Enfant>lesEnfants; // les enfants qui attendent leurs cadeaux
  cout << "o o o Bonjour les enfants o o o " << endl;
  /// --------- Vous pouvez déclarer de nouvelles variables
  /// --------- appeler les méthodes écrites, et faire des affichages
  /// ------- ceci ne sera pas évalué


  
  /// --------------- insérer ici les instructions de la question 5
  /// Obligatoire : tests automatiques de la méthode *possede* de la classe Enfant)
  
  
  ///---------------  Question 9 : ajouter 4 enfants au vector lesEnfants


  /// --------------- Question  10
  /// Compléter les instructions ci-dessous pour la distribution des cadeaux
  int i=0;
  bool encoreDesCadeaux; // le pere Noel a-t-il encore des cadeaux dans sa hotte ?

  // écrire  l'instruction d'amorçage  :
  // - le pere Noël offre un cadeau au 1er enfant : lesEnfants[0]
  // - le booleen encoreDesCadeaux est initialisé.
  
  while (encoreDesCadeaux){  /// tant qu'il a des cadeaux 
    i++;
    if(i==lesEnfants.size())i=0;  // recommence au 1er enfant
  // écrire l'instruction de relance :
  // - le pere Noël offre un cadeau à l'enfant numéro i
  // - le booleen encoreDesCadeaux est mis à jour
   
  }

  /// --------------- Question 11 ----------
  /// trouver l'enfant qui a le plus de cadeaux et afficher ses cadeaux
  return 0;
}

