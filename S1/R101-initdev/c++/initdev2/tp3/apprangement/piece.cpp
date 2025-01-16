/// HB novembre 2022
/// classes Appartement et Piece
/// Fichier piece.cpp

#include "piece.h"
#include <iostream>

using namespace std;
/// Constructeur : permet de construire un objet Piece à partir de 2 reels
/// et une chaine en s'assurant que la longueur est superieure a la largeur.
// formate le nom de la piece (en minuscules)
/// Lance une exception si les deux dimensions ne sont pas strictement positives
void Piece::normalise(){
     if ( _larg > _long ){  // inverser longueur et largeur si necessaire
     float tmp ;
     tmp = _long ;
     _long= _larg ;
     _larg = tmp ;
   }
  for(int i=0; i<_nom.length();i++)  // passer en minuscules
    _nom[i]=tolower(_nom[i]);
}
void Piece::verifEtNormalise(){
   if ( _long < 0 )  throw ( string("La longueur est incorrecte " + to_string(_long) ));
   if ( _larg < 0 )  throw (  string("La largeur est incorrecte " + to_string(_larg) ) );
   normalise();
}
Piece::Piece (float lo, float la, const string &nom )
{ 
  _long=lo;
  _larg=la;
  _nom=nom;
  verifEtNormalise();
}

/// afficher : affiche les informations relatives à une pièce
void Piece::afficher () const
{
    cout<<"Piece  \""<< _nom << "\" : dimension : "
        << _larg << " x "<< _long <<endl;
}

/// saisir : permet à l'utilisateur de saisir les données d'une pièce
// on fait les memes verifications que dans le constructeur
// mais on peut redemander les valeurs _largeur et _longueur si elles ne sont pas correctes
void Piece::saisir (){
    float tmp ;
    cout << "Entrez le nom de la piece : " ;
    cin >> _nom ;
    cout << "puis la longueur et la largeur : " ;
    cin >> _long >> _larg ; 
    while(_long <=0 || _larg<=0){
       cout << "les 2 valeurs doivent etre >0, recommencer " ;
       cin >> _long >> _larg ;
    }
    normalise();  // nom en minuscules et larg et long dans le bon ordre
}

/// surface : calcule la surface de la pièce
float Piece::surface ( ) const{
    return _long * _larg ;
}

/// plusGrande : retrourne vrai si la pièce cible est plus grande que
/// la pièce passée en paramètre faux sinon
bool Piece::plusGrande ( const Piece & arg ) const{
    return ( surface( ) >= arg.surface ( ) ) ;
}

/// Compare 2 pièces sur leur surface.
/// retourne -1 si la Cible est plus petite que p,
/// 0 si même surface
/// 1 si Cible plus grande que p
int Piece::compare (const Piece &p)const{
  int resul;
  float surf1,surf2;
  surf1=surface();
  surf2=p.surface();
  if (surf1<surf2)resul= -1;
  else  if (surf1>surf2)resul= 1;
  else resul= 0;
  return resul;
}
// surface en externe --> pas d'opérateur de portée ::
float surface(const Piece&p){
  // fonction externe : on doit utiliser les fonctions membres car données privées
  return p.surface(); // ou return p.largeur()*p.longueur(); si elles sont définies
}
