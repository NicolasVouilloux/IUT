#include "cadeau.h"
#include "enfant.h"

#include <iostream>
#include <vector>
using namespace std;


int main(){
  vector<Enfant>lesEnfants; // les enfants qui attendent leurs cadeaux
  cout << "o o o Bonjour les enfants o o o " << endl;
  /// --------- Vous pouvez d�clarer de nouvelles variables
  /// --------- appeler les m�thodes �crites, et faire des affichages
  /// ------- ceci ne sera pas �valu�


  
  /// --------------- ins�rer ici les instructions de la question 5
  /// Obligatoire : tests automatiques de la m�thode *possede* de la classe Enfant)
  
  
  ///---------------  Question 9 : ajouter 4 enfants au vector lesEnfants


  /// --------------- Question  10
  /// Compl�ter les instructions ci-dessous pour la distribution des cadeaux
  int i=0;
  bool encoreDesCadeaux; // le pere Noel a-t-il encore des cadeaux dans sa hotte ?

  // �crire  l'instruction d'amor�age  :
  // - le pere No�l offre un cadeau au 1er enfant : lesEnfants[0]
  // - le booleen encoreDesCadeaux est initialis�.
  
  while (encoreDesCadeaux){  /// tant qu'il a des cadeaux 
    i++;
    if(i==lesEnfants.size())i=0;  // recommence au 1er enfant
  // �crire l'instruction de relance :
  // - le pere No�l offre un cadeau � l'enfant num�ro i
  // - le booleen encoreDesCadeaux est mis � jour
   
  }

  /// --------------- Question 11 ----------
  /// trouver l'enfant qui a le plus de cadeaux et afficher ses cadeaux
  return 0;
}

