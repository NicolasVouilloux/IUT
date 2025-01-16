#include "cadeau.h"
#include "enfant.h"
#include "pereNoel.h"
#include <iostream>
#include <vector>
using namespace std;


int main(){
  vector<Enfant>lesEnfants; // les enfants qui attendent leurs cadeaux
  cout << "o o o Bonjour les enfants o o o " << endl;
  /// --------- Vous pouvez d�clarer de nouvelles variables
  /// --------- appeler les m�thodes �crites, et faire des affichages
  /// ------- ceci ne sera pas �valu�
    cout<<"-------------creation et affichage cadeau-------------"<<endl;
    Cadeau c1;
    Cadeau c2("patate");
    if (c1.memeCadeau(c2)==true)
        cout<<"memeCadeau ne fonctionne pas"<<endl;
    else
        cout<<"memeCadeau Fonctionne"<<endl;
    cout<<"-------------creation et affichage enfant-------------"<<endl;
    Enfant e1;
    e1.affiche();
    cout<<"-------------ajout cadeau liste-------------"<<endl;
    e1.recoitCadeau(c1);
    e1.affiche();
     cout<<"-------------affichage hotte pere noel-------------"<<endl;
     PereNoel p1;
     p1.affiche();


  /// --------------- ins�rer ici les instructions de la question 5
  /// Obligatoire : tests automatiques de la m�thode *possede* de la classe Enfant)
    cout<<"-------------methode possede dans liste enfant-------------"<<endl;
    if (e1.possede(c1)==true)
        cout<<"possede fonctionne"<<endl;
    else
        cout<<"possede ne fonctionne pas"<<endl;

  ///---------------  Question 9 : ajouter 4 enfants au vector lesEnfants
    Enfant enfant1("Asterix");
    Enfant enfant2("Boul");
    Enfant enfant3("Bill");
    Enfant enfant4("Kirikou");

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

