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
  // constructeur
  Image(const string &);
  // fonction affiche
  void affiche() const;
  // trouver un pixel finir
  void getpixel() const;
  // met tout les vecteur autre que le rouge a 0
  Image Composanterouge();
  // Cherche un pixel donné dans l'image et renvoie sa position
  bool detection(int, int, int);
  // Donne une teinte gris à l'image
  Image niveaugris();
  // Change un pixel en noir en fonction d'un seuil mis en paramètre
  Image noirEtBlanc(int seuil);
  // Montre histograme de l'image
  vector<int> histogrammeGris();
  // Augmente la luminisoté de l'image
  Image luminosityUp(float);
  // Diminue la luminisoté de l'image
  Image luminosityDown(float);
  // operator pour comparer deux image
  bool operator==(const Image &) const;
  // Diminue le contraste de l'image
  Image contrasteDown(float);
  // Augmenta le contraste de l'image
  Image contrasteUp(float);
  // ecrit sur un fichier ppm
  void Fichierppm(ofstream &);
  // selection du menu
  void menu();
  // fonction de rotation sense horaire
  Image rotation();
  // fonction de rotation sense anti horaire
  Image rotationGauche();
  // fonction rogner droite
  Image RognerD(int nb);
  // fonction rogner gauche
  Image RognerG(int nb);
  // fonction rogner bas
  Image RognerB(int nb);
  // fonction rogner haut
  Image RognerH(int nb);
  // fonction retourne sur l'axe verticale
  Image retournementH();
  // fonction retourne sur l'axe horizontale
  Image retournementV();
  // fonction aggrandissement de l'image
  Image agrandissement();
  // fonction retrecissement de l'image
  Image retrecissement();

  Image  RognerBv();
  int GetTaile();
  vector<vector<int>> GetB();
  vector<vector<int>> GetG() ;
  vector<vector<int>> GetR() ;
  //le code n'aura pas vraiment la version final il y a quelque modification car c'est une version pas terminé car je travaillais directement sur replit
  Image blanche(int nr,int ng, int nb) ;


};
// fonction de copie des fichier ppm en parametre
void loadPicture(const string &picture, vector<vector<int>> &red,
                 vector<vector<int>> &green, vector<vector<int>> &blue);
// fonction qui demande le nom (pour les fichier ppm)
string demandenom();



class Filtre
{
  vector <vector<float>> _action;
  int _rayon;

public:
  Filtre();
  Filtre( vector <vector<float>> &, int);
  Image application (Image );

};
#endif
