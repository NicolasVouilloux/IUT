#include "point.h"
#include <iostream>
using namespace std;

int main(){
 
  
  Point p1;           
  Point p2;
  p1.modifier(3,2);
  p2.modifier(2,5);
  p1.afficher();
  p2.afficher();
 
 return 0;

}
