// HBM, JL oct. 2023
#ifndef MENU_H_
#define MENU_H_

const int FACT = 1;
const int SOM = 2;
const int DIV = 3;
const int QUIT = 4;

/// fonction choix_valide(choix) retourne bool�en
/// parametres : (D) choix : entier
/// retourne vrai si le choix est valide, faux sinon.
bool	choix_valide(int choix);

/// fonction menu() retourne entier
/// parametres : aucun
/// affiche un menu, saisit le choix de l'utilisateur, le verifie et le retourne
int menu();

#endif
