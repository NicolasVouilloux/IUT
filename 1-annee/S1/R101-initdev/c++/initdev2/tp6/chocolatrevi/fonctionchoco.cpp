#include <iostream>
#include "choco.h"


string Chocolat::_natureVersString(int n)const {  // retourne la String équivalente à la nature
 if(n !=0 && n !=1 && n!=2) throw string ("nature incorrecte");
 string s;
 switch(n){
   case 0: s="noir";break;
   case 1: s="blanc";break;
   case 2: s="lait";break;
 }
 return s;
}
int Chocolat::_stringVersNature(string n)const{ // retourne la nature équivalente à la string
    if(n != NOIR && n != BLANC && n != LAIT) throw string ("nature incorrecte");
    int nature;
    if(n==NOIR) nature = CNOIR;
    else if(n==BLANC) nature = CBLANC;
        else nature = CLAIT;
return nature;
}
Chocolat::Chocolat(){
    _poids=30
    _nature=CNOIR
}
Chocolat::Chocolat(int n){
    _poids=n
    _nature=
}
 return s;
}
