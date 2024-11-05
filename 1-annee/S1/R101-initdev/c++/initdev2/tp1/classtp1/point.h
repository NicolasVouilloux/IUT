#ifndef _POINT_
#define _POINT_
#include <iostream>
using namespace std;
class Point {  // Point est un nouveau type
 private :  // les données sont privees et ne peuvent etre manipulee qu'en passant par les fonctions membres
	float _abscisse;
	float _ordonnee;
 public :      // les fonctions sont publiques et peuvent etre utilisees partour
	
	void modifier(float,float); // modifie l'abscisse et l'ordonnee avec les valeurs passees en parametre
	void afficher()const;  // affiche es coordonnees du point cible
	void deplacer(float,float); // déplace le point cible (ajoute les valeurs)
	float distance(const Point& )const;  // retourne la distance entre le point cible et le point en paramè-Tre

	float getAbs()const{return _abscisse;} // accesseurs
       	float getOrd()const;

};


#endif

