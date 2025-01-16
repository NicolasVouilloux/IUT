/// HB novembre 2022
/// TP2
/// Fichier appartement.h

#ifndef _APPART_
#define _APPART_

#include <string>
#include <vector>
#include "piece.h"

#include <stdexcept> /// pour l'exception out_of_range

const string ADRESSE = "1 rue Joliot-Curie 91400 Orsay";
const vector<int>ZONES={2500,3100,3500,4150,4500};
using namespace std;

//----------------------------------

class Appartement
{
    vector<Piece> _lesPieces;
    string _adresse;

public:
    //---------------  constructeurs
    Appartement(); /// appartement vide au départ
    Appartement ( const Piece & arg, const string&) ;  // un appartement avec une piece et une adresse

    //---------------  methodes de consultation  : objet cible non modifie => fonction const
    void afficher()const;  // affiche l'adressee et les pièces de l'appartement
    int plusGrandePiece() const ;// retourne l'indice de la plus grande piece de l'appartement, -1 si appartement vide
    float surface() const ;  // retourne surface totale de l'appartement
    int nbPieces()const; // retourne nombre de Pieces de l'appartement
    // compare 2 appartements sur leur surface
    // 0 s'ils ont meme surface
    // -1 si l'appartement cible est plus petit que celui passe en parametre
    // 1 si l'appartement cible est plus grand que celui passe en parametre
    int compare(const Appartement& a)const;


    //------------ methodes de modifications : objet cible modifie
    void ajoutPiece(const Piece&);  // ajoute une piece dans l'appartement
    Piece retraitPiece(int i) ;// retire la piece dont l'indice est fourni en parametre. Si incorrect : déclenche exception out_of_range

    //--------methode recherche vecteur cible----------
    int recherche(const string &)const;
    //--------methode recherchepremier vecteur cible----------
    int rechercheprem(const string &)const;
    void rangerapp();
  };
#endif
