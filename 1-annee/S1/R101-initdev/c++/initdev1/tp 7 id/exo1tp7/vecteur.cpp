#include <iostream>
#include <string>
#include <vector>
#include "vecteurs.h"
using namespace std;

void upper( string & uneJoueuse){
    int l;
    l=uneJoueuse.length();
    for (int j=0 ; j<l; j++)
        uneJoueuse[j]=toupper(uneJoueuse[j]);
}
void affichez (const vector<string> & equipe){
    for (int k=0 ; k<equipe.size() ; k++){
        cout << equipe[k] << endl;
    }
}
int recherche (const string & uneJoueuse , const vector<string> & equipe ){
    int k=0,t=-1;
    while ( k<equipe.size() && t<0 ){
        if(equipe[k] == uneJoueuse){t=k;}
        k++ ;
    }
    return t;
}
void remplacer (const string & uneJoueuse ,  vector<string> & equipe,const string & nouvJou){
    int k=recherche(uneJoueuse, equipe);
    equipe[k] = nouvJou;
}
