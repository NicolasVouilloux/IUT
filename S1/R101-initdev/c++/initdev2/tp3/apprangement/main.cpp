#include <vector>
#include <iostream>
#include "piece.h"
#include "appartement.h"
#include <string>

using namespace std;

int main()
{
    cout<<endl<<"----------------initialisation des piece et affichage----------------"<<endl<<endl;
    Piece P0(4,4,"chambre0"),P1(1,1,"chambre1"),P2(10,10,"chambre2"),P3(2,2,"chambre3"),
    P4(6,6,"chambre4"),P5(5,5,"chambre5"),P6(8,8,"chambre6"),
    P7(7,7,"chambre7"),P8(9,9,"chambre7"),P9(11,11,"chambre7"),P10(3,3,"chambre7");
    P0.afficher();
    cout<<endl<<"----------------initialisation appartements et ajout des pieces----------------"<<endl<<endl;
    Appartement r1(P0,"Orsay");
    r1.ajoutPiece(P1);r1.ajoutPiece(P2);r1.ajoutPiece(P3);r1.ajoutPiece(P4);
    r1.ajoutPiece(P5);r1.ajoutPiece(P6);r1.ajoutPiece(P7);r1.ajoutPiece(P8);
    r1.ajoutPiece(P9);r1.ajoutPiece(P10);
    r1.afficher();
    cout<<endl<<"----------------methode recherche vecteur app----------------"<<endl<<endl;
    if (r1.recherche("chambre4")==-1)
        cout<<"la chambre n'est pas presente dans le logement"<<endl;
    else
        cout<<"la chambre est presente a l'indice "<<r1.recherche("chambre4")<<endl;
    if (r1.rechercheprem("chambre7")==-1)
        cout<<"la chambre n'est pas presente dans le logement"<<endl;
    else
        cout<<"la chambre est presente a l'indice "<<r1.recherche("chambre7")<<endl;

}
