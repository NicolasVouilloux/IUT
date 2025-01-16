// HBM,JL 2023
// gestion d'une equipe de sportives : equipe de France de football feminin 2023
// g++ -std=c++14

#include <iostream>
#include <string>
#include <vector>
#include "vecteurs.h"
using namespace std;

int main( ){
    vector<string> equipe = {"DURAND","BACHA","RENARD","GEYORO","DIANI","SOMMER"};

    string uneJoueuse, nouvJou;
    // variables intermédiaires
    int nbSup;   // nbre de noms à ajouter
    int i,j;
    int trouve ;  // vrai si le nom est présent

    // Question b : on indentifie bien les indices de la premiere et de la
    // derniere case valide du tableau
    cout << "Le premier : " << equipe[0] << " " << equipe.front();
    cout << ", le dernier : "<< equipe[equipe.size()-1] << " " << equipe.back() << endl;

    // Question c : Boucle d'affichage classique
    // Insister sur la fait qu'il faut afficher le tableau apres
    // chaque modification pour verifier son contenu.
    cout << endl << endl << "affichage dans l'ordre " << endl ;
    affichez(equipe);


    // Question d : même chose à l'envers. Attention aux bornes du for
    cout << endl << endl << "affichage dans l'ordre inverse " << endl ;
    for (i=equipe.size()-1 ; i>=0 ; i--)    {
        cout << equipe[i] << endl;
    }

// Question e -------------- ajout de quelques joueuses
// la saisie du nombre de joueuses a ajouter
    cout << "Combien de joueuses voulez vous ajouter ? ";
    cin >> nbSup;
    while( nbSup < 0 )    {
        cout << "Valeur incorrecte"<<endl;
        cout << "Combien de joueuses voulez vous ajouter ? ";
        cin >> nbSup;
    }
    // Puis boucle d'ajout
    for(i=0; i<nbSup; i++)    {
        cout << "entrer une valeur : ";
        cin >> uneJoueuse;   // utiliser getline si nom peut comprendres des espaces.
        // on assure que les noms sont stockés en majuscules ----- ( question h)
        upper(uneJoueuse);
        // ajout a la fin
        equipe.push_back(uneJoueuse);
    }
    cout <<  endl << "--  affichage apres ajout " << endl ;
    affichez(equipe);


// question f -------- recherche ---------
    cout << "quel joueuse rechercher vous ? " ;
    cin >> uneJoueuse ;
    upper(uneJoueuse);
// boucle de recherche

    trouve=recherche(uneJoueuse, equipe);
    if ( trouve<0 )
        cout << endl << uneJoueuse << " n'existe pas dans le tableau" << endl ;
    else {
        cout << endl << uneJoueuse << " existe dans le tableau, a l'indice "
        <<  trouve << " verification " << equipe[trouve] << endl ;

        cout << "quelle est sa remplacante ? " ;
        // question g -------------- remplacement
        cin>> nouvJou;
        upper(nouvJou);
        remplacer(uneJoueuse, equipe, nouvJou);
        cout <<  endl << "--  affichage apres remplacement  " << endl ;
        affichez(equipe);
        }
    return 0;
}
/*test numero 1 valeur classique
Le premier : DURAND DURAND, le dernier : SOMMER SOMMER


affichage dans l'ordre
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER


affichage dans l'ordre inverse
SOMMER
DIANI
GEYORO
RENARD
BACHA
DURAND
Combien de joueuses voulez vous ajouter ? 3
entrer une valeur : bob
entrer une valeur : jack
entrer une valeur : daniel

--  affichage apres ajout
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER
BOB
JACK
DANIEL
quel joueuse rechercher vous ? bOB

BOB existe dans le tableau, a l'indice 6 verification BOB
quelle est sa remplacante ? dAnIEL

--  affichage apres remplacement
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER
DANIEL
JACK
DANIEL

Process returned 0 (0x0)   execution time : 26.742 s
Press any key to continue.
*/
/* test 2 valeur special
Le premier : DURAND DURAND, le dernier : SOMMER SOMMER


affichage dans l'ordre
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER


affichage dans l'ordre inverse
SOMMER
DIANI
GEYORO
RENARD
BACHA
DURAND
Combien de joueuses voulez vous ajouter ? -1
Valeur incorrecte
Combien de joueuses voulez vous ajouter ? 0

--  affichage apres ajout
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER
quel joueuse rechercher vous ? ;

; n'existe pas dans le tableau

Process returned 0 (0x0)   execution time : 14.187 s
Press any key to continue.
*/
/*test 3 entrer de lettre dans le programme
Le premier : DURAND DURAND, le dernier : SOMMER SOMMER


affichage dans l'ordre
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER


affichage dans l'ordre inverse
SOMMER
DIANI
GEYORO
RENARD
BACHA
DURAND
Combien de joueuses voulez vous ajouter ? aa

--  affichage apres ajout
DURAND
BACHA
RENARD
GEYORO
DIANI
SOMMER
quel joueuse rechercher vous ?
 n'existe pas dans le tableau

Process returned 0 (0x0)   execution time : 3.928 s
Press any key to continue.
*/
