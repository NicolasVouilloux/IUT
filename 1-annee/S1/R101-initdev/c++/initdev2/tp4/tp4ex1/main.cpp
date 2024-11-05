#include <cstdlib>
#include <iostream>

#include "rat.h"

using namespace std;

int main(){
    cout << "----- Tests automatiques -----------------------------------------------" << endl;
    if (testConstructeurVideEtGetters()) cout << "Constructeur vide et getters ok" << endl;
    if (testsConstructeurParamEtGetters()) cout << "Constructeur avec parametres et getters ok" << endl;
    cout << "------------------------------------------------------------------------" << endl;

    cout << "----- Programme principal ----------------------------------------------" << endl;
    /*cout << "Veuillez saisir le numerateur et le denominateur" << endl;
    int n, d; cin >> n >> d;
    try {
        Rationnel r(n,d);
        cout << "Voici votre rationnel reduit : "<<r<< endl;
    }catch (const invalid_argument &e) {
        cout << "Erreur : " << e.what() << endl;
    }*/
    cout << "------------------------------------------------------------------------" << endl;
    cout << "----- Programme Produit ----------------------------------------------" << endl;
    try {
        Rationnel r1(3,17),r2(21,15),r3=r1*r2,r4(21,85);
        if (r3==r4){
            cout << "les fonctions operator * and == fonctionne, r3 : "<<r3 << endl;
        }
        else
            cout<< "les fonctons operator * and == ne fonctionne pas"<<endl;

    }catch (const invalid_argument &e) {
    cout << "Erreur : " << e.what() << endl;
    }
    cout << "------------------------------------------------------------------------" << endl;
    cout << "----- Programme -unaire ----------------------------------------------" << endl;
    try {
        Rationnel R1(3,17),RUN(-3,17);
        R1=-R1;
        if (R1==RUN){
            cout << "la foncton -unaire fonctionne, R1 : "<<R1 << endl;
        }
        else
            cout<< "la fonction -unaire ne fonctionne pas"<<endl;

    }catch (const invalid_argument &e) {
    cout << "Erreur : " << e.what() << endl;
    }
    cout << "------------------------------------------------------------------------" << endl;
    cout << "----- Programme somme ----------------------------------------------" << endl;
    try {
        Rationnel R2(1,2),R3(2,4),RSO,RTEST(1,1);
        RSO=R2+R3;
        if (RSO==RTEST){
            cout << "la foncton somme fonctionne, R2 : "<<RSO << endl;
        }
        else
            cout<< "la fonction somme ne fonctionne pas"<<RSO<<endl;

    }catch (const invalid_argument &e) {
    cout << "Erreur : " << e.what() << endl;
    }
    cout << "------------------------------------------------------------------------" << endl;
    cout << "----- Programme superieur inferieur ----------------------------------------------" << endl;
    try {
        Rationnel R1(1,2),R2(89,1000);
        if (R1<R2)
            cout<< "la fonction somme ne fonctionne pas"<<endl;
        else
            cout << "la foncton somme fonctionne " << endl;
    }catch (const invalid_argument &e) {
    cout << "Erreur : " << e.what() << endl;
    }
    cout << "------------------------------------------------------------------------" << endl;
    cout << "----- Programme cin stream ----------------------------------------------" << endl;
    Rationnel R1;
    cin>>R1;
    cout << "------------------------------------------------------------------------" << endl;
    return 0;

    }
