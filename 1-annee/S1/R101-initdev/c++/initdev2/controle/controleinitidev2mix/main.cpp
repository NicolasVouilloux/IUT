#include "pion.h"
#include "combinaison.h"
#include <ctime>
#include <iostream>
using namespace std;

int main(){
  srand(time(NULL));  /// initialisation du tirage aléatoire (pour le constructeur de la classe Combinaison)

    Pion p1('r');
    p1.affiche();
    Pion p2('n');
    p2.affiche();
    Pion p3('r');
    p3.affiche();
    if (p1==p2)
        cout<<"nopçamarchepas"<<endl;
    if (p1==p3)
        cout<<"yep"<<endl;
    Combinaison c1(8);
    cout<<"la difficulter est de "<<c1.getDifficulte()<<endl;
    Combinaison c2(7);
    if (c1==c2)
        cout<<"nop"<<endl;
    else
        cout<<"yes"<<endl;
    c1.modifPion(1,p1);

  return 0;
}
