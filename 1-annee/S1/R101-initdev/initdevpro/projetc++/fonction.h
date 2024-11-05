#ifndef FONCTION_H_INCLUDED
#define FONCTION_H_INCLUDED
#include <iostream>
#include <string>
#include <vector>


using namespace std;

class Image {
  vector<vector<int>> _red;
  vector<vector<int>> _blue;
  vector<vector<int>> _green;
  int _largeur;
  int _longueur;

public:
  // constructeur vide
  Image();

  // constructeur
  Image(const vector<vector<int>> &, const vector<vector<int>> &,
        const vector<vector<int>> &);

  // fonction affiche
  void affiche() const;

  // trouver un pixel finir
  void getpixel() const;

  // met tout les vecteur autre que le rouge a 0
  Image Composanterouge();

  // Cherche un pixel donné dans l'image et renvoie sa position
  bool detection(int , int , int );

  //Donne une teinte gris à l'image
  Image niveaugris ();

  //Change un pixel en noir en fonction d'un seuil mis en paramètre
  Image noirEtBlanc (int seuil);

  //Montre histograme de l'image
  vector <int> histogrammeGris ();

  //Augmente la luminisoté de l'image
  Image luminosityUp ();

  //Diminue la luminisoté de l'image
  Image lluminosityDown ();
  //operator pour comparer deux image
  bool operator == (const Image &)const;
  //Diminue le contraste de l'image
  Image contrasteDown ();
  //Augmenta le contraste de l'image
  Image contrasteUp ();
};
void loadPicture(const string &picture, vector<vector<int>> &red,
                                        vector<vector<int>> &green,
                                        vector<vector<int>>  &blue);
string demandenom();

#endif
