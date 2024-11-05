#include "cadeau.h"
#include "enfant.h"
#include "pereNoel.h"

PereNoel::PereNoel(){
    _hotte={};
    for (int i=0;i<JEUX.size();i++)
    _hotte.push_back(JEUX[i]);
}
void PereNoel::affiche()const{
    for (int i=0;i<_hotte.size();i++)
        cout<<_hotte[i]<<endl;
}
bool PereNoel::offreCadeau(const Cadeau & c){
    if (_hotte.size()!=0)
        (_sac.push_back(_hotte[_hotte.size()]))
    else
        return (false);

}

