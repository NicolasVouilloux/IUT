// HB 2022
/// classes Appartement et Piece
/// Fichier appartement.cpp

#include <vector>
#include <iostream>
#include "piece.h"
#include "appartement.h"
#include <string>

using namespace std;
/// Constructeur vide : permet de construire un objet Appartement sans aucune pièce avec une adresse par défaut
Appartement::Appartement(){
    _adresse=ADRESSE;
}

/// Constructeur : permet de construire un appartement avec une premiere piece passee en parametre
Appartement::Appartement ( const Piece & p, const string& ad){
  _lesPieces.push_back(p);
  _adresse=ad;
 }

/// affichage : affiche les différentes pièces d'un appartement
void Appartement::afficher()const{
  if(_lesPieces.size()==0)
    cout<< "L'appartement est encore en construction... " << endl;
  else{
      cout << "un appartement de " << _lesPieces.size() << " pieces"<<endl;
      for(int i=0; i<_lesPieces.size(); i++)
	_lesPieces[i].afficher();
  }
}

/// ajoutPiece : ajouter une pièce à un appartement
void Appartement::ajoutPiece(const Piece& p){
  _lesPieces.push_back(p);  /// _lesPieces est un vector, ajout en dernière position
}

/// retraitPiece : supprime une pièce à un indice donné
Piece Appartement::retraitPiece(int i){
  //cout << "Appel retraitPiece avec i=" << i ;
  //cout << "   dans un appartement de " << _lesPieces.size() << " pieces" << endl;
  /// pour déclencher l'exception (protéger les bornes) il faut utiliser at et pas []
  Piece resul(_lesPieces.at(i));
  // on remplacee la piece i par la dernière piece, puis on retire la derniere piece
  _lesPieces[i]=_lesPieces.back();
  _lesPieces.pop_back();
  /// On pourrait utiliser les iterateurs (pas étudiés lors du 1er module)
  /// begin : fonction qui retourne un iterateur sur le début du Vector
  /// _lesPieces.erase(_lesPieces.begin()+i)
  return resul;
}

/// surface : retourne la superficie de l'appartement
float Appartement::surface ( ) const{
  float s = 0 ;
  for(int i=0; i<_lesPieces.size(); i++){
    s += _lesPieces[i].surface();
  }
  return s ;
}

/// plusGrandePiece : retourne l'indice de la plus grande pièce,
/// -1 si appartement vide
int Appartement::plusGrandePiece() const{
  int pgp = -1 ;
  if (_lesPieces.size() > 0 ){
    pgp = 0 ;
    for (int i=1; i<_lesPieces.size(); i++)
      if (_lesPieces[i].surface() > _lesPieces.at(pgp).surface())
	pgp = i ;
  }
  return pgp ;
}

/// ------- compare 2 appartements sur leur surface ---
int Appartement::compare(const Appartement& a)const{
  int resul;
  float surf1,surf2;
  surf1=surface();
  surf2=a.surface();
  if (surf1<surf2)resul =  -1;
  else  if (surf1>surf2)resul= 1;
  else resul= 0;
  return resul;
}

// retourne le nombre de pieces d'un appartement
int Appartement::nbPieces()const{
  return _lesPieces.size();
}
int Appartement::recherche(const string & pie)const{
    int debut=0,fin=_lesPieces.size()-1,milieu,ind;
    while (fin>=debut){
        milieu=(debut+fin)/2;
        if (_lesPieces[milieu].nom()==pie){
            ind=milieu;
            return ind;
        }
        else
            if (pie>_lesPieces[milieu].nom())
                debut=debut+1;
            else
                fin=fin-1;
    }
    return -1;
}
int Appartement::rechercheprem(const string & piep)const{
    int debut=0,fin=_lesPieces.size()-1,milieu,ind;
    while (fin>=debut){
        milieu=(debut+fin)/2;
        if (_lesPieces[milieu].nom()==piep && _lesPieces[milieu-1].nom()!=piep){
            ind=milieu;
            return ind;
        }
        else
            if (piep>_lesPieces[milieu].nom())
                debut=debut+1;
            else
                fin=fin-1;
    }
    return -1;
}
//programme pour chaque position le numero de la place pour l'inserer
void rangerapp(){
    for (int i=0;i<_lesPieces.size();i++)
        for (int k=0;k<i;k++)
            if (_lesPieces[i]<_lesPieces[k])
                int valsw=_lesPieces[i];
                for (int h=i;h>i;h--)
                    _lesPieces[h]=_lesPieces[h-1]
                    _lesPieces[k]=valsw
}
// besoin d'un sous programme pour deplacer toute les valeurs du vecteur
