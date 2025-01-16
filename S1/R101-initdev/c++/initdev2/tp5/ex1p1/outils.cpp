/// TP5 Tris et Complexité
/// 2022-2023
/// fichier outils.cpp

#include <iostream>
#include "vecteurTrie.h"
#include "outils.h"

/// Saisit et retourne un entier positif entré par l'utilisateur
int saisirEntier()
{
    int entier;
    cin >> entier ;
    while(entier <= 0)
    {
        cout << "Un nombre positif svp : ";
        cin >> entier ;
    }
    return entier;
}

/// Saisit et retourne l'information concernant l'ordre initial du vecteur à trier
Ordre saisirOrdre()
{
    Ordre lordre;
    int number;
    do
    {
        cout<<"\nChoisissez le rangement initial de vos valeurs :" << endl;
        cout<<"  1 aleatoire" << endl;
        cout<<"  2 ordre croissant" << endl;
        cout<<"  3 ordre decroissant" << endl;
        cin >> number;
    } while(number< 1 || number > 3);

    switch(number)
    {
    case 1: lordre=ALEA; break;
    case 2: lordre=CROISSANT; break;
    case 3: lordre=DECROISSANT; break;
    default: break;
    }
    return lordre;
}

/// Saisit et retourne le choix concernant l'algorithme de tri
Algo saisirAlgo()
{
    Algo algo;
    int number;
    do
    {
        cout<<"\nChoisissez l'algorithme de tri : " << endl;
        cout<<"  1 pour tri_bulles" << endl;
        cout<<"  2 pour tri_bulles optimise " << endl;
        cout<<"  3 pour tri_selection " << endl;
        cout<<"  4 pour tri_rapide " << endl;
        cin >> number ;
    } while(number < 1 || number > 4);

    switch(number)
    {
    case 1: algo=BULLE; break;
    case 2: algo=BULLE_OPT; break;
    case 3: algo=SELECTION; break;
    case 4: algo=RAPIDE; break;
    default: break;
    }
    return algo;
}

/// Saisit les différents paramètres nécessaires au tri :
/// nombre de valeurs, valeur maximale, nombre d'exécutions, ordre initial, algorithme de tri.
void paramTri(int & nbElts,int & valMax, int & nbExec, Ordre & monOrdre, Algo & monAlgo)
{
    cout<<"Combien d'entiers a trier ? ";
    nbElts=saisirEntier();
    cout<<"\nValeur maximale des entiers ? ";
    valMax=saisirEntier();
    cout<<"\nCombien d'executions ? ";
    nbExec=saisirEntier();
    monOrdre=saisirOrdre();
    monAlgo=saisirAlgo();
}

/// Création d'un vecteur contenant nbVal entiers de valeurs aléatoires comprises entre min et max
void vecteurAlea(vector<int> &v, int nbVal, int min, int max)
{
    if (max < min) /// permuter
    {
        int temp = max;
        max=min;
        min=temp;
    }
    for (int i=0; i<nbVal ; i++)
    {
        v.push_back(min + rand()%(max-min+1)); /// nombre aléa entre min et max inclus
    }
}

/// demande à l'utilisateur si elle veut recommencer le traitement
bool recommencer()
{
    char rep;
    cout << "\nOn recommence ? (o/n)" ;
    cin >> rep;
    return (rep == 'o');
}
