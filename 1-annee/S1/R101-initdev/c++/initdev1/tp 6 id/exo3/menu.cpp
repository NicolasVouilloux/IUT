#include <iostream>
// HBM,JL oct. 2023
#include "menu.h"

using namespace std;



bool	choix_valide(int choix) {
  return (choix >= FACT && choix <= QUIT);
}

int 	menu() {
  int	choix;
    cout << "Tapez" << endl;
    cout << FACT << " pour calculer la factorielle " << endl;
    cout << SOM << " pour calculer la somme  " << endl;
    cout << DIV << " pour afficher les diviseurs" << endl;
    cout << QUIT << " pour quitter le programme" << endl;

    cin >> choix;

    while (!choix_valide(choix)){
        cout << choix << " n'est pas pris en charge." << endl;
        cout << "Veuillez saisir une autre valeur." << endl;
        cin >> choix;
    }

  return choix;
}
