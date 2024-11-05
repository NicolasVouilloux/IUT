#ifndef CHOCO_H_INCLUDED
#define CHOCO_H_INCLUDED

using namespace std;

const float POIDS=30; // poids par défaut (en gramme)
const string NOIR = "noir";
const int CNOIR = 0;
const string BLANC = "blanc";
const int CBLANC = 1;
const string LAIT = "lait";
const int CLAIT = 2;

class Chocolat{
    int _nature; // 0 noir, 1 blanc, 2 lait
    int _poids; // poids du chocolat
    string _natureVersString(int n)const;// retourne la String équivalente à la nature
    int _stringVersNature(string)const;// retourne la nature équivalente à la string
public:
    Chocolat();
    Chocolat(string,int);
    Chocolat(int);
    Chocolat(string);

};

#endif // CHOCO_H_INCLUDED
