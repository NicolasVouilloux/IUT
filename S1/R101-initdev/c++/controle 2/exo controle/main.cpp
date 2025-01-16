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

int main() {
    vector<vector<int>> notes (NBETUD );
    vector<float> moyennes (NBETUD,0.0);
    vector<string> etudiants={"Robert","Johnson","Lucy","Emily","Sean","Clarence","Max",
                            "Vladymmir","Franck","Shaun","Thesee","Carla","Eli","Olga",
                            "Freeman","Benjamin","Baxter","Philipps","Taylor","Kewani"};
    /* g�n�ration des notes des �tudiants
            NE PAS MODIFIER !
    */
    int C = 314 ;
    int n =  C%117 + 53;
    for(unsigned int i=0; i<NBETUD; i++ ){
        int nbnotes = 12 + (C*(i+7))%53;
        for(int  j=0; j< nbnotes ; j++ ){
            notes[i].push_back(n%21);
            n= (17*n +31)% 367;
        }
    }
    /* FIN de la g�n�ration des notes*/

    unsigned int i,j,imax,choix;

    //remplissage du vecteur des moyennes
    /*for(i=0; i<NBETUD ; i++){
        for(j=0; j< notes[i].size(); j++)
            moyennes[i]+=notes[i][j];
        moyennes[i]=moyennes[i]/notes[i].size();
    }*/
    calcMoyenne(notes,moyennes);

    // boucle principale qui se relance tant que l'utilisateur ne choisit pas de QUITter
    do{
        // affichage du menu
        /*cout<< "\n Que voulez-vous faire  ?" << endl;
        cout << AFFICHENOTES<<"  pour afficher toutes les notes de chaque etudiant."<< endl;
        cout <<MOY<<"  pour afficher toutes les moyennes de chaque etudiant."<< endl;
        cout << MAJOR<<"  pour afficher l'etudiant ayant la meilleure moyenne."<< endl;
        cout << QUIT <<"  pour quitter le programme."<< endl;
        */
        affichagemenu;
        //choix de l'utilisateur
        cin >> choix;
        /*while (choix!=AFFICHENOTES  && choix!=MOY && choix!=MAJOR &&choix!=QUIT){
            cout << "Choix invalide"<<endl;
            cin>> choix;
        }*/
        invalide(choix);

        // r�alisation du traitement choisi par l'utilisateur
        switch(choix){
            case(AFFICHENOTES ) :
                    // affichage des notes
                    for(i=0; i< NBETUD ; i++){
                        cout<<"Les "<<notes[i].size() <<" notes de "<<etudiants[i]<<" :"<<endl;
                        for(j=0; j<notes[i].size(); j++){
                            cout << notes[i][j]<<" ";}
                    cout << endl << endl;
                    }
                    break;
            case(MOY) :
                    //affichage des moyennes
                    for(i=0; i< NBETUD ; i++){
                        cout<<"La moyenne de "<<etudiants[i]<<":\t";
                        cout << moyennes[i]<<endl;
                    }
                    break;

            case(MAJOR) :
                    //calcul de l'indice du meilleur etudiant
                    imax=0;
                    for(i=1;i<NBETUD; i++)
                        imax = moyennes[imax]< moyennes[i] ? i : imax;

                    //affichage du meilleur �tudiant
                    cout<<"Le major de promo est \t";
                    cout << etudiants[imax]<<endl;
                    break;

        case(QUIT) : cout << " Au revoir !" <<endl; break;
        default : cout << " Entr�e non reconnue " << endl;
        }

    }while(choix!=QUIT);

    return 0;
}
