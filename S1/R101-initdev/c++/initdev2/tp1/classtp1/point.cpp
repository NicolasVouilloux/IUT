#include "point.h"
#include <cmath>
#include <iostream>
using namespace std;



// affecte des valeurs à l'abscisse et à l'ordonnée du point cible
void Point::modifier(float x,float y) {
	_abscisse = x;
	_ordonnee = y; 
}
// deplace le point cible p
void Point::deplacer(float dx,float dy) {
	_abscisse+=dx; 
	_ordonnee+=dy; 
}

// affiche les coordonnees du point cible
void  Point::afficher()const {
  cout << "Point d'abscisse " << _abscisse << " et d'ordonnee " << _ordonnee << endl;
}

//retourne la distance entre le point cible et le point passÃ© en paramÃ¨tre
float Point::distance(const Point &p )const {
  return(sqrt(
	      (_abscisse-p._abscisse)*(_abscisse-p._abscisse) +
              (_ordonnee-p._ordonnee)* (_ordonnee-p._ordonnee)
	      )
	 );
}




