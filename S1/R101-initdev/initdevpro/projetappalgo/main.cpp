#include "fonction.h"
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  // initialisation des vecteurs de base
  vector<vector<int>> red{{000, 000, 000, 000},
                          {000, 000, 255, 255},
                          {000, 255, 255, 255},
                          {255, 255, 255, 255}};
  vector<vector<int>> blue{{000, 000, 000, 000},
                           {000, 255, 255, 255},
                           {255, 255, 255, 000},
                           {255, 255, 000, 000}};
  vector<vector<int>> green{{255, 255, 000, 000},
                            {255, 000, 000, 000},
                            {000, 000, 000, 000},
                            {000, 000, 000, 000}};
  cout << "----------------affichage et initialisation de la grille de couleur "
          "vide----------------"
       << endl;
  Image tahcvideouquoi;
  cout << "----------------affichage de la grille de couleur "
          "pleine----------------"
       << endl;
  try {
    Image I1(red, green, blue);
    I1.affiche();
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction getpixel----------------"
       << endl;
  try {
    Image I1(red, green, blue);
    // I1.getpixel();
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction "
          "ComposanteRouge----------------"
       << endl;
  try {
    vector<vector<int>> rougered{{000, 000, 000, 000},
                                 {000, 000, 255, 255},
                                 {000, 255, 255, 255},
                                 {255, 255, 255, 255}};
    vector<vector<int>> rougeblue{{000, 000, 000, 000},
                                  {000, 000, 000, 000},
                                  {000, 000, 000, 000},
                                  {000, 000, 000, 000}};
    vector<vector<int>> rougegreen{{000, 000, 000, 000},
                                   {000, 000, 000, 000},
                                   {000, 000, 000, 000},
                                   {000, 000, 000, 000}};
    Image I1(red, blue, green), IR(rougered, rougegreen, rougeblue);
    if (I1.Composanterouge() == IR)
      cout << "La fonction composanterouge marche bien" << endl;
    else
      cout << "La fonction composanterouge marche pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction "
          "Detection----------------"
       << endl;
  try {
    Image I1(red, blue, green);
    if (I1.detection(000, 000, 255) == true)
      cout << "la fonction detection fonctionne" << endl;
    else
      cout << "non la fonction " << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction niveau "
          "gris----------------"
       << endl;
  try {
    vector<vector<int>> grisred{{85, 85, 000, 000},
                                {85, 85, 170, 170},
                                {85, 170, 170, 85},
                                {170, 170, 85, 85}};
    vector<vector<int>> grisblue{{85, 85, 000, 000},
                                 {85, 85, 170, 170},
                                 {85, 170, 170, 85},
                                 {170, 170, 85, 85}};
    vector<vector<int>> grisgreen{{85, 85, 000, 000},
                                  {85, 85, 170, 170},
                                  {85, 170, 170, 85},
                                  {170, 170, 85, 85}};
    Image I1(red, blue, green), IG(grisred, grisgreen, grisblue);
    if (I1.niveaugris() == IG)
      cout << "La fonction niveaugris marche bien" << endl;
    else
      cout << "La fonction niveaugris marche pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction noir et blanc" << endl;
  try {
    vector<vector<int>> NBred{{000, 000, 000, 000},
                              {000, 000, 255, 255},
                              {000, 255, 255, 000},
                              {255, 255, 000, 000}};
    vector<vector<int>> NBblue{{000, 000, 000, 000},
                               {000, 000, 255, 255},
                               {000, 255, 255, 000},
                               {255, 255, 000, 000}};
    vector<vector<int>> NBgreen{{000, 000, 000, 000},
                                {000, 000, 255, 255},
                                {000, 255, 255, 000},
                                {255, 255, 000, 000}};
    Image I1(red, blue, green), INB(NBred, NBgreen, NBblue);
    if (I1.noirEtBlanc(127) == INB)
      cout << "La fonction noirblanc marche bien" << endl;
    else
      cout << "La fonction noirblanc marche pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  //---------------------------------------------application de l'image dans les
  // vecteur red blue green
  cout<<"----------------------------------utilisation de la fonction load image"<<endl<<endl;
  try {
    loadPicture("Garen_3.ppm", red, green, blue);
    Image IGAREN(red, green, blue);
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  //-----------------------------------------------utilisation du menu des fonction
  //-----------------------------------------------de l'image
  cout<<"-----------------------------------utilisation du menu de l'image generer"<<endl<<endl;
  try {
    Image IGAREN(demandenom());
    IGAREN.affiche();
    IGAREN.menu();
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
}
