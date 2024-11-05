#ifndef FONCTION_H_INCLUDED
#define FONCTION_H_INCLUDED
#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Piece {
    float _largeur;
    float _longueur;
    string _nom;
public:
    //constructeur vide
    Piece();
    //constructeur de piece
    Piece(float,float,const string&);
    //commande affiche
    void affiche() const;
    //methode saisir
    void saisir();
    //methode surface
    float surface()const;
    //methode plusgrande pour verifier que la piece est plus grande que l'autre
    bool plusGrande(const Piece & p) const;
};
class Appartement {
    string _adrApp;
    vector <Piece>pieceApp;
    int _zone;
public:
    //constructeur vide
    Appartement();
    //appartement avec une piece en parametre et une adresse
    Appartement (const Piece&,const string&,const int& );
    //affiche app
    void afficheApp() const;
    //ajoute une piece a un appartement
    void ajoutepiece(const Piece&);
    //compte le nombre de piece
    int nbpieces()const;
    //calcul la surface de l'appartement
    float surfaceApp()const;
    //comparaison des appartement
    int compApp(const Appartement & p) const;
    //valeur appartement
    float valeurApp()const;


};

#endif // FONCTION_H_INCLUDED
