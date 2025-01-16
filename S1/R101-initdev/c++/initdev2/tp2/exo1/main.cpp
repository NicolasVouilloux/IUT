#include <iostream>
#include <vector>
#include <string>
#include "fonction.h"

using namespace std;

int main()
{
    Piece testgamingdoublemix;
    testgamingdoublemix.affiche();
    try {
        Piece P1 (1,3,"ChAmbrE");
        P1.affiche();
    }
    catch (invalid_argument &e){
        cerr<<e.what()<<endl;
    }
    Piece P2;
    P2.saisir();
    P2.affiche();
    cout<<"la surface de la piece fait "<<P2.surface()<<"M2"<<endl;
    Piece P1 (2,4,"salon");
    Piece P3 (3,4,"cuisine");
    if(P1.plusGrande(P3)){
        cout<<"oui p1 est plus grande que p2"<<endl;
    } else{
        cout<<"non p1 n'est pas plus grande que p2"<<endl;
    }
    cout<<endl<<endl;
    Piece P4(8,8,"Sejour");
    Piece P5(1,1,"Le chiotte");
    Appartement CHEZMOI(P4,"7 rued la racaille double mix",1);
    CHEZMOI.afficheApp();
    CHEZMOI.ajoutepiece(P5);
    CHEZMOI.afficheApp();
    cout<<"il y a "<<CHEZMOI.nbpieces()<<" pieces dans l'appartement"<<endl;
    cout<<"la surface de l'appartement est de "<<CHEZMOI.surfaceApp()<<"M2"<<endl;
    Piece P6(2,2,"tah la cave");
    Piece P7(1,7,"tah les comble ou quoi");
    Appartement PASCHEZMOI(P6,"8 rue du mek trop gentil",3);
    PASCHEZMOI.ajoutepiece(P7);
    PASCHEZMOI.afficheApp();
    cout<<"la surface de l'appartement est de "<<PASCHEZMOI.surfaceApp()<<"M2"<<endl;
    if(CHEZMOI.compApp(PASCHEZMOI)==1)
        cout<<"l'appartement est plus grand"<<endl;
    else{
        if(CHEZMOI.compApp(PASCHEZMOI)==-1)
            cout<<"l'appartement est plus petit"<<endl;
        else
            cout<<"l'appartement fait la meme surface"<<endl;
    }
    cout<<"la valeur de l'appartement chezmoi est de "<<CHEZMOI.valeurApp()<<"euro"<<endl;
}
