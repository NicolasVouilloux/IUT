/// HB novembre 2022
/// TP2 
/// Fichier piece.h

#ifndef _PIECE_
#define _PIECE_

#include <string>
using namespace std;

class Piece
{
    float _long , _larg ;
    string _nom ;
    void normalise();// _larg la plus petite et _long la plus grande et _nom en minuscules
    void verifEtNormalise();  // exception si valeurs attributs incorrectes puis normalisation
 public:
    Piece(){_long=4; _larg=3;_nom="piecevide";}
    Piece (float, float , const string &) ; 
    
    //---------------  methodes de consultation  : objet cible non modifie => fonction const
    void afficher ( ) const ;
    float largeur()const{return _larg;}  // ces 3 methodes qu'on appelle "accesseurs" ne sont pas indispensables ici
    float longueur()const{return _long;} // 
    string nom()const{return _nom;}     // 
    float surface ( ) const ;  // surface de la piece
    bool plusGrande ( const Piece & ) const ;  // vrai si la piece cible est plus grande que la piece en parametre
    int compare (const Piece &p)const;  // compare 2 pieces -1 si cible plus petite, 0 si 間ales, 1 si cible plus grande.
    //------------ methodes de modifications : objet cible modifie
    void saisir( ); 
};
float surface(const Piece&p);  // surface en externe
#endif

