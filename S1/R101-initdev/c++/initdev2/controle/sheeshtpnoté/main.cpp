#include <iostream>
//----- fichier main.cpp
#include "perle.h"
#include "boite.h"
#include <string>
#include <ctime>
using namespace std;

int main(){
  Boite b1("jaune",10);  // boite de 10 couleur jaune
  //Boite b2("jaune"); // boite vide de couleur jaune
    b1.afficher();
  Boite b3;
  b3.afficher();  // boite vide de couleur rouge
  Boite b4("rouge",20); // boite de 20 perles couleur rouge
    b4.afficher();
  vector <Perle> collier;  // un vecteur de Perles pour faire un collier
  srand(time(NULL)); /// initialisation du générateur aléatoire

    Perle p1("bleu","doublemix"),p2("bleu","carré"),p3("jaune","doublemix");
    if (p1==p2)
        cout<<"oui le prog fonctionne"<<endl;
    if (p1==p3)
        cout<<"non le prog ne fonctionne pas"<<endl;
    else cout<<"oui le prog fonctionne"<<endl;
    cout<<"le nombre de perle de la boite b1 est "<<b1.nbperle()<<endl;
  return 0;
}
istream& operator>>(istream & , Rationnel&);//.h

istream& operator>>(istream&i, Rationnel &p){//.cpp
   p.saisir(i);
   return i;
}
