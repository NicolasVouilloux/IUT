#include <string>
#include <vector>
#include <iostream>
#include <stdexcept>
#include "fonction.h"

using namespace std;

Piece::Piece(){
    _largeur = 3;
    _longueur = 4;
    _nom = "piecevide";
}
void Piece::affiche() const{
    cout<<"La piece nommee "<<_nom<<" fait "<<_largeur<<"M de large sur "<<_longueur<<"M de long"<<endl;
}
Piece::Piece(float largeur,float longueur,const string& nom){
    //throw catch invlid argument en fonction de la longueur largeur si <0
    if(largeur<=0 || longueur <=0)
        throw invalid_argument("piece non conforme");
    _largeur = largeur;
    _longueur = longueur;
    _nom = nom;
    //mettre le nom de la piece en minuscule
    for (int i=0;i<_nom.size();i++){
        _nom[i]=tolower(_nom[i]);
    }
    //inverser longueur largeur en fonction de la taille
    if (_longueur < _largeur){
            _longueur = _longueur + _largeur;
            _largeur = _longueur - _largeur;
            _longueur = _longueur - _largeur;
            cout<<"les valeurs on ete inverse dans la "<<_nom<<endl;
    }
}
void Piece::saisir(){
    cout<<"Entrer le nom"<<endl;
    cin>>_nom;
    cout<<"Entrer la largeur"<<endl;
    cin>>_largeur;
    cout<<"Entrer la longueur"<<endl;
    cin>>_longueur;
}
float Piece::surface()const{
    return _largeur*_longueur;
}
bool Piece::plusGrande(const Piece& piecepr)const{
     return (surface()> piecepr.surface());
}
Appartement::Appartement(){
    _adrApp="9 Rue chezbibimonreuftkt 91340";
}
Appartement::Appartement(const Piece&p,const string&adr,const int&zone){
    _adrApp=adr;
    pieceApp.push_back(p);
    _zone=zone;
}
void Appartement::afficheApp()const{
    cout<<_adrApp<<endl;
    cout<<"la zone de l'appartement est "<<_zone<<endl;
    for (int i=0;i<pieceApp.size();i++)
        pieceApp[i].affiche();
}
void Appartement::ajoutepiece(const Piece&p){
    pieceApp.push_back(p);
}
int Appartement::nbpieces()const{
    int k=0;
    for (int i=0;i<pieceApp.size();i++)
        k++;
return k;
}
float Appartement::surfaceApp()const{
    float k=0;
    for (int i=0;i<pieceApp.size();i++)
        k=k+pieceApp[i].surface();
return k;
}
int Appartement::compApp(const Appartement & p)const{
    int k=0;
    if (surfaceApp()>p.surfaceApp())
        k=1;
    else
        if(surfaceApp()<p.surfaceApp())
            k=-1;
return k;
}
float Appartement::valeurApp()const{
    int valeur=0;
    if (_zone==0)
        valeur = 2500;
        else if (_zone==1)
            valeur = 3100;
            else if (_zone == 2)
                valeur = 3500;
                else if (_zone ==3)
                    valeur =4150;
    return (surfaceApp()*valeur);
}


