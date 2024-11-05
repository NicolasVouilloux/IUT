 /** Classe Rationnel
 * HB
 *
 * Classe permettant de representer des nombres rationnels
 * L'encapsulation garantit que :
 *   - le denominateur est toujours un entier scrictement positif
 *   - la fraction est toujours reduite.
 * Ainsi, la représentation des rationnels est unique.
 */


#ifndef _RAT_H_
#define _RAT_H_

#include <iostream>
#include <cstdlib>

using namespace std;

class Rationnel {
 private:

  int _num; // Numérateur, positif ou négatif
  int _den; // dénominateur, strictement
  // réduction d'une fraction: _num / _den devient irréductible
  void _reduire();

 public:
  // Constructeur avec numérateur et dénominateur
  // vérification et mise sous forme irreductible
    Rationnel(int=0, int=1);
  //  Méthode d'affichage, par exemple 1/2
    void afficher() const;
  //Renvoie le numérateur
    int getNum() const;
  // Renvoie le dénominateur
    int getDen() const;
    //multiplication de rationnel
    Rationnel operator*(const Rationnel&)const;
    //si deux rationnel sont egaux
    bool operator==(const Rationnel&)const;
    //somme de rationnel
    Rationnel operator+(const Rationnel&)const;
    //comparaison inferieur ou non
    bool operator<(const Rationnel&)const;
    void saisir(istream & );
};
ostream& operator<<(ostream& ,const Rationnel&);
/// Calcul du pgcd de deux entiers quelconques
int pgcd(int a, int b);
// Calcul du pgcd de deux entiers a et b tels que a >= b >= 0
int pgcdRecursif(int a, int b);
//rendre l'inverse d'un rationnel
Rationnel operator-(const Rationnel&);
istream& operator>>(istream & , Rationnel&);
// Fonctions de test
bool testConstructeurVideEtGetters();
bool testConstructeurParamEtGetters(int n, int d, int nres, int dres, bool exc);
bool testsConstructeurParamEtGetters();

#endif
