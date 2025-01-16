#include <iostream>
#include <string>
#include <vector>
#include "gestionNotes.h"

using namespace std;
const int NBETUD = 20 ;
const int AFFICHENOTES = 1 ;
const int MOY = 2 ;
const int MAJOR = 3 ;
const int QUIT = 0;
unsigned int i,j,imax,choix;
void calcMoyenne(vector<vector<int>> notes,vector<float> moyennes){
    for(int i=0; i<NBETUD ; i++){
        for(j=0; j< notes[i].size(); j++)
            moyennes[i]+=notes[i][j];
        moyennes[i]=moyennes[i]/notes[i].size();
    }
}

bool invalide(int & choix){
while (choix!=AFFICHENOTES  && choix!=MOY && choix!=MAJOR &&choix!=QUIT){
            cout << "Choix invalide"<<endl;
            cin>> choix;
        }
}
int affichagemenu(){
cout<< "\n Que voulez-vous faire  ?" << endl;
        cout << AFFICHENOTES<<"  pour afficher toutes les notes de chaque etudiant."<< endl;
        cout <<MOY<<"  pour afficher toutes les moyennes de chaque etudiant."<< endl;
        cout << MAJOR<<"  pour afficher l'etudiant ayant la meilleure moyenne."<< endl;
        cout << QUIT <<"  pour quitter le programme."<< endl;
}
