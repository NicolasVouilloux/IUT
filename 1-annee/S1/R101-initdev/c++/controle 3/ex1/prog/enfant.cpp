#include "cadeau.h"
#include "enfant.h"
using namespace std;
Enfant::Enfant(const string &n){
  _nom=n;
}
string Enfant::nom()const{
  return _nom;
}
void Enfant::affiche()const{
    cout<<"Le nom de l'enfant est "<<_nom<<endl;
    if (_sac.size()==0)
        cout<<"l'enfant n'a pas encore de cadeau"<<endl;
    else{
        cout<<"Sa liste de cadeau est : "<<endl;
        for (int i=0;i<_sac.size();i++)
            cout<<_sac[i]<<endl;
    }
}
void Enfant::recoitCadeau(const Cadeau&c){
    //_sac.push_back();
    _sac.push_back(c.getDesc());
}
bool Enfant::possede(const Cadeau& c){
    int k=0;
    for (int i=0;i<_sac.size();i++){
        if (_sac[i]==c.getDesc())
            k=1;
    }
    return (k==1);
}

