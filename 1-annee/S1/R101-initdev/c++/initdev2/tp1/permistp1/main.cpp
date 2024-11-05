#include <string>
#include <iostream>
#include <vector>
#include "permis.h"

using namespace std;


int main() {
    Permis pdef;
    Permis p1("Duck", "Donald", "09/06/1934", "012345", 7);
    Permis p2("riri", "ruru", "2090", "012346", 1);
    Permis p3("lili", "lolo", "2180", "012347", 11);
    Permis p4("kiki", "koko", "2010", "012348", 5);


    cout << endl << "----- Tests manuels de affiche -----------------------------------------" << endl;
    pdef.affiche();
    p1.affiche();
    cout << endl << "----- Tests automatiques de getNbpoints --------------------------------" << endl;
    bool ok = true;
    if (!(p1.getNbpoints() == 7)) {
        ok = false;
    cout << "Erreur : p.getNbpoints() = " << p1.getNbpoints() << " (attendu : 7)" << endl;
    }
    if (ok) cout << "Methode getNbpoints correcte" << endl;

    cout << endl << "----- Tests automatiques de retraitPoints ------------------------------" << endl;
    ok = true;
    p1.retraitPoints(3);
    if (!(p1.getNbpoints() == 4)) {
        ok = false;
    cout << "Erreur : apres avoir retire 3 points a un permis a 7 points, on obtient un permis a " << p1.getNbpoints() << " points (attendu : 4)" << endl;
    }
    p1 = Permis ("Duck", "Donald", "09/06/1934", "012345", 7);
    p1.retraitPoints(0);
    if (!(p1.getNbpoints() == 7)) {
        ok = false;
    cout << "Erreur : apres avoir retire 0 points a un permis a 7 points, on obtient un permis a " << p1.getNbpoints() << " points (attendu : 7)" << endl;
    }
    p1 = Permis ("Duck", "Donald", "09/06/1934", "012345", 7);
    p1.retraitPoints(7);
    if (!(p1.getNbpoints() == 0)) {
        ok = false;
    cout << "Erreur : apres avoir retire 7 points e un permis a 7 points, on obtient un permis a " << p1.getNbpoints() << " points (attendu : 0)" << endl;
    }
    p1 = Permis ("Duck", "Donald", "09/06/1934", "012345", 7);
    p1.retraitPoints(10);
    if (!(p1.getNbpoints() == 0)) {
        ok = false;
    cout << "Erreur : apres avoir retire 10 points a un permis a 7 points, on obtient un permis a " << p1.getNbpoints() << " points (attendu : 0)" << endl;
    }
    p1 = Permis ("Duck", "Donald", "09/06/1934", "012345", 7);
    if (ok) cout << "Methode retraitPoints correcte" << endl;
    cout << endl << "----- Tests personnel -----------------------------------------" << endl;
    p2.affiche();
    p3.affiche();
    //cout<<p2<<endl;  <Test 2.b
    //cout<<p2._nom<<endl;  <Test 2.c
    cout<<p3.getnom()<<endl;

    try{
        p3.incrementePoints();
    }
    catch(const invalid_argument &e){
        cerr<<"Error : " <<e.what()<<endl;
    }
    p3.affiche();
    try{
        p2.decrementesPoints();
    }
    catch(const invalid_argument &e){
        cerr<<"Error : " <<e.what()<<endl;
    }
    p2.affiche();
    p4.affiche();
    ajoutePoints(p4,3);
    p4.affiche();

    return 0;
}
/*1.a
le dossier permis.h contient la declaration des sous programme la creation des classes et la mise en place du createur elle contient egalement les sous prgrammes affiche permis getnbpoint
*/
/*1.b
la commande donne une erreur car la "fonction" affiche sort de la class permis elle ne comprend donc elle ne reconais pas les valeurs nom prenom etc
*/
/*1.c
il contient l'appelle pour chaque fonction et egalement tout les partie d'affichage cout et les commande simpla comme les if et les bool
*/
/*1.d
tout les affichages sont concentrer sur afficher des permis et modifier les points de permis que ce soit en plus ou en moin
*/
/*2.a
les permis s'affiche normalement dans la partie test personnel
*/
/*2.b
les chevront ne savent pas quoi faire avec la classe permis
*/
/*2.c
les chevront comprennent mais n'ont pas acces a cette inventaire
*/
/*2.d
le const permet de dire que la fonction affiche ne peut pas modifier le permis
*/
/*3.a
la methode permet de return getnom il suffit dont de l'afficher
*/
/*3.b/3.c
les sous programme pocede une verification avec catch throw et try
*/
/*4.a
creation du sous programme ajouter qui reutilise les sous programme getnbpoints ey increments points
*/
/*4.b
le code ne peut dont pas modifier le permis a cause du const
*/
