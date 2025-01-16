#include "fonction.h"
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  vector<vector<int>> red{{000, 000, 000, 000},
                          {000, 000, 255, 255},
                          {000, 255, 255, 255},
                          {255, 255, 255, 255}};
  vector<vector<int>> blue{{255, 255, 000, 000},
                           {255, 000, 000, 000},
                           {000, 000, 000, 000},
                           {000, 000, 000, 000}};
  vector<vector<int>> green{{000, 000, 255, 255},
                            {000, 255, 255, 255},
                            {255, 255, 255, 000},
                            {255, 255, 000, 000}};
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
    (I1.Composanterouge()).affiche();
    if (I1.Composanterouge() == IR)
      cout << "La fonction composanterouge fonctionne" << endl;
    else
      cout << "La fonction composanterouge ne fonctionne pas" << endl;
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
      cout << "non la fonction ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction niveau "
          "gris----------------"
       << endl;
  try {
    vector<vector<int>> grisred{{85, 85, 85, 85},
                                {85, 85, 170, 170},
                                {85, 170, 170, 85},
                                {170, 170, 85, 85}};
    vector<vector<int>> grisblue{{85, 85, 85, 85},
                                 {85, 85, 170, 170},
                                 {85, 170, 170, 85},
                                 {170, 170, 85, 85}};
    vector<vector<int>> grisgreen{{85, 85, 85, 85},
                                  {85, 85, 170, 170},
                                  {85, 170, 170, 85},
                                  {170, 170, 85, 85}};
    Image I1(red, blue, green), IG(grisred, grisgreen, grisblue);
    (I1.niveaugris()).affiche();
    if (I1.niveaugris() == IG)
      cout << "La fonction niveaugris fonctionne" << endl;
    else
      cout << "La fonction niveaugris ne fonctionne pas" << endl;
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
    (I1.noirEtBlanc(127)).affiche();
    if (I1.noirEtBlanc(127) == INB)
      cout << "La fonction noirblanc fonctionne" << endl;
    else
      cout << "La fonction noirblanc ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  augmenter la luminosite "
          "de l'image"
       << endl;
  try {
    vector<vector<int>> ILUred{{000, 000, 000, 000},
                               {000, 000, 255, 255},
                               {000, 255, 255, 255},
                               {255, 255, 255, 255}};
    vector<vector<int>> ILUblue{{255, 255, 000, 000},
                                {255, 000, 000, 000},
                                {000, 000, 000, 000},
                                {000, 000, 000, 000}};
    vector<vector<int>> ILUgreen{{000, 000, 255, 255},
                                 {000, 255, 255, 255},
                                 {255, 255, 255, 000},
                                 {255, 255, 000, 000}};
    Image I1(red, green, blue), ILU(ILUred, ILUgreen, ILUblue);
    (I1.luminosityUp(1.5)).affiche();
    if ((I1.luminosityUp(1.5)) == ILU)
      cout << "La fonction Luminosityup fonctionne" << endl;
    else
      cout << "La fonctionLuminosityup ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  reduire la luminosite "
          "de l'image"
       << endl;
  try {
    vector<vector<int>> ILDred{{000, 000, 000, 000},
                               {000, 000, 127, 127},
                               {000, 127, 127, 127},
                               {127, 127, 127, 127}};
    vector<vector<int>> ILDblue{{127, 127, 000, 000},
                                {127, 000, 000, 000},
                                {000, 000, 000, 000},
                                {000, 000, 000, 000}};
    vector<vector<int>> ILDgreen{{000, 000, 127, 127},
                                 {000, 127, 127, 127},
                                 {127, 127, 127, 000},
                                 {127, 127, 000, 000}};
    Image I1(red, green, blue), ILD(ILDred, ILDgreen, ILDblue);
    (I1.luminosityDown(0.5)).affiche();
    if ((I1.luminosityDown(0.5)) == ILD)
      cout << "La fonction Luminositydown fonctionne " << endl;
    else
      cout << "La fonctionLuminositydown ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  tourner l'image en sens "
          "horaire"
       << endl;
  try {
    vector<vector<int>> IRHred{{255, 000, 000, 000},
                               {255, 255, 000, 000},
                               {255, 255, 255, 000},
                               {255, 255, 255, 000}};
    vector<vector<int>> IRHblue{{000, 000, 255, 255},
                                {000, 000, 000, 255},
                                {000, 000, 000, 000},
                                {000, 000, 000, 000}};
    vector<vector<int>> IRHgreen{{255, 255, 000, 000},
                                 {255, 255, 255, 000},
                                 {000, 255, 255, 255},
                                 {000, 000, 255, 255}};
    Image I1(red, green, blue), IRH(IRHred, IRHgreen, IRHblue);
    (I1.rotation()).affiche();
    if ((I1.rotation()) == IRH)
      cout << "La fonction Rotation fonctionne" << endl;
    else
      cout << "La fonction rotation ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  tourner l'image en sens "
          "Anti horaire"
       << endl;
  try {
    vector<vector<int>> IRAred{{000, 255, 255, 255},
                               {000, 255, 255, 255},
                               {000, 000, 255, 255},
                               {000, 000, 000, 255}};
    vector<vector<int>> IRAblue{{000, 000, 000, 000},
                                {000, 000, 000, 000},
                                {255, 000, 000, 000},
                                {255, 255, 000, 000}};
    vector<vector<int>> IRAgreen{{255, 255, 000, 000},
                                 {255, 255, 255, 000},
                                 {000, 255, 255, 255},
                                 {000, 000, 255, 255}};
    Image I1(red, green, blue), IRA(IRAred, IRAgreen, IRAblue);
    (I1.rotationGauche()).affiche();
    if ((I1.rotationGauche()) == IRA)
      cout << "La fonction Rotation Gauche fonctionne" << endl;
    else
      cout << "La fonction rotation Gauche ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  rogner Droite" << endl;
  try {
    vector<vector<int>> RDred{
        {000, 000, 000}, {000, 000, 255}, {000, 255, 255}, {255, 255, 255}};
    vector<vector<int>> RDblue{
        {255, 255, 000}, {255, 000, 000}, {000, 000, 000}, {000, 000, 000}};
    vector<vector<int>> RDgreen{
        {000, 000, 255}, {000, 255, 255}, {255, 255, 255}, {255, 255, 000}};
    Image I1(red, green, blue), RD(RDred, RDgreen, RDblue);
    (I1.RognerD(1)).affiche();
    if ((I1.RognerD(1)) == RD)
      cout << "La fonction Rogner droite fonctionne" << endl;
    else
      cout << "La fonction Rogner droite ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  rogner Gauche" << endl;
  try {
    vector<vector<int>> RGred{
        {000, 000, 000}, {000, 255, 255}, {255, 255, 255}, {255, 255, 255}};
    vector<vector<int>> RGblue{
        {255, 000, 000}, {000, 000, 000}, {000, 000, 000}, {000, 000, 000}};
    vector<vector<int>> RGgreen{
        {000, 255, 255}, {255, 255, 255}, {255, 255, 000}, {255, 000, 000}};
    Image I1(red, green, blue), RG(RGred, RGgreen, RGblue);
    (I1.RognerG(1)).affiche();
    if ((I1.RognerG(1)) == RG)
      cout << "La fonction Rogner Gauche fonctionne" << endl;
    else
      cout << "La fonction Rogner Gauche ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  rogner Bas" << endl;
  try {
    vector<vector<int>> RBred{
        {000, 000, 000, 000}, {000, 000, 255, 255}, {000, 255, 255, 255}};
    vector<vector<int>> RBblue{
        {255, 255, 000, 000}, {255, 000, 000, 000}, {000, 000, 000, 000}};
    vector<vector<int>> RBgreen{
        {000, 000, 255, 255}, {000, 255, 255, 255}, {255, 255, 255, 000}};
    Image I1(red, green, blue), RB(RBred, RBgreen, RBblue);
    (I1.RognerB(1)).affiche();
    if ((I1.RognerB(1)) == RB)
      cout << "La fonction Rogner Bas fonctionne" << endl;
    else
      cout << "La fonction Rogner Bas ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  rogner Haut" << endl;
  try {
    vector<vector<int>> RHred{
        {000, 000, 255, 255}, {000, 255, 255, 255}, {255, 255, 255, 255}};
    vector<vector<int>> RHblue{
        {255, 000, 000, 000}, {000, 000, 000, 000}, {000, 000, 000, 000}};
    vector<vector<int>> RHgreen{
        {000, 255, 255, 255}, {255, 255, 255, 000}, {255, 255, 000, 000}};
    Image I1(red, green, blue), RH(RHred, RHgreen, RHblue);
    (I1.RognerH(1)).affiche();
    if ((I1.RognerH(1)) == RH)
      cout << "La fonction Rogner Haut fonctionne" << endl;
    else
      cout << "La fonction Rogner Haut ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  Retournement axe "
          "horizontale"
       << endl;
  try {
    vector<vector<int>> RHred{{255, 255, 255, 255},
                              {000, 255, 255, 255},
                              {000, 000, 255, 255},
                              {000, 000, 000, 000}};
    vector<vector<int>> RHblue{{000, 000, 000, 000},
                               {000, 000, 000, 000},
                               {255, 000, 000, 000},
                               {255, 255, 000, 000}};
    vector<vector<int>> RHgreen{{255, 255, 000, 000},
                                {255, 255, 255, 000},
                                {000, 255, 255, 255},
                                {000, 000, 255, 255}};
    Image I1(red, green, blue), RH(RHred, RHgreen, RHblue);
    (I1.retournementV()).affiche();
    if ((I1.retournementV()) == RH)
      cout << "La fonction Retournement axe horizontale fonctionne" << endl;
    else
      cout << "La fonction Retournement axe horizontale ne fonctionne pas"
           << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction  Retournement axe "
          "verticale"
       << endl;
  try {
    vector<vector<int>> RVred{{000, 000, 000, 000},
                              {255, 255, 000, 000},
                              {255, 255, 255, 000},
                              {255, 255, 255, 255}};
    vector<vector<int>> RVblue{{000, 000, 255, 255},
                               {000, 000, 000, 255},
                               {000, 000, 000, 000},
                               {000, 000, 000, 000}};
    vector<vector<int>> RVgreen{{255, 255, 000, 000},
                                {255, 255, 255, 000},
                                {000, 255, 255, 255},
                                {000, 000, 255, 255}};
    Image I1(red, green, blue), RV(RVred, RVgreen, RVblue);
    (I1.retournementH()).affiche();
    if ((I1.retournementH()) == RV)
      cout << "La fonction Retournement axe verticale fonctionne" << endl;
    else
      cout << "La fonction Retournement axe verticale ne fonctionne pas"
           << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction aggrandissement   "
       << endl;
  try {
    vector<vector<int>> AGred{{000, 000, 000, 000, 000, 000, 000, 000},
                              {000, 000, 000, 000, 000, 000, 000, 000},
                              {000, 000, 000, 000, 255, 255, 255, 255},
                              {000, 000, 000, 000, 255, 255, 255, 255},
                              {000, 000, 255, 255, 255, 255, 255, 255},
                              {000, 000, 255, 255, 255, 255, 255, 255},
                              {255, 255, 255, 255, 255, 255, 255, 255},
                              {255, 255, 255, 255, 255, 255, 255, 255}};
    vector<vector<int>> AGblue{{255, 255, 255, 255, 000, 000, 000, 000},
                               {255, 255, 255, 255, 000, 000, 000, 000},
                               {255, 255, 000, 000, 000, 000, 000, 000},
                               {255, 255, 000, 000, 000, 000, 000, 000},
                               {000, 000, 000, 000, 000, 000, 000, 000},
                               {000, 000, 000, 000, 000, 000, 000, 000},
                               {000, 000, 000, 000, 000, 000, 000, 000},
                               {000, 000, 000, 000, 000, 000, 000, 000}};
    vector<vector<int>> AGgreen{{000, 000, 000, 000, 255, 255, 255, 255},
                                {000, 000, 000, 000, 255, 255, 255, 255},
                                {000, 000, 255, 255, 255, 255, 255, 255},
                                {000, 000, 255, 255, 255, 255, 255, 255},
                                {255, 255, 255, 255, 255, 255, 000, 000},
                                {255, 255, 255, 255, 255, 255, 000, 000},
                                {255, 255, 255, 255, 000, 000, 000, 000},
                                {255, 255, 255, 255, 000, 000, 000, 000}};
    Image I1(red, green, blue), AG(AGred, AGgreen, AGblue);
    (I1.agrandissement()).affiche();
    if ((I1.agrandissement()) == AG)
      cout << "La fonction agrandissement fonctionne" << endl;
    else
      cout << "La fonction agrandissement ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la fonction retrecissement  " << endl;
  try {
    vector<vector<int>> RTred{{
                                  000,
                                  000,
                              },
                              {
                                  000,
                                  255,
                              }};
    vector<vector<int>> RTblue{{
                                   255,
                                   000,
                               },
                               {
                                   000,
                                   000,
                               }};
    vector<vector<int>> RTgreen{{
                                    000,
                                    255,
                                },
                                {
                                    255,
                                    255,
                                }};
    Image I1(red, green, blue), RT(RTred, RTgreen, RTblue);
    (I1.retrecissement()).affiche();
    if ((I1.retrecissement()) == RT)
      cout << "La fonction retrecissement fonctionne" << endl;
    else
      cout << "La fonction retrecissement ne fonctionne pas" << endl;
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout << "----------------utilisation de la flou de l'image " << endl;
  vector<vector<float>> f1 = {{1.0 / 16, 1.0 / 8, 1.0 / 16},
                              {1.0 / 8, 1.0 / 4, 1.0 / 8},
                              {1.0 / 16, 1.0 / 8, 1.0 / 16}};
  Filtre Filtreflou(f1, 1);
  Image I1(red, green, blue);
}
