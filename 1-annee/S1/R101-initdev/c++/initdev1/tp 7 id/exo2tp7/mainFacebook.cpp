#include <iostream>
#include <string>
#include <vector>
#include "fonctionsFacebook.h"

using namespace std;

int main()
{
    int NbMembres;
    cout<<"entrer un nombre de membre : ";
    cin>>NbMembres;
    vector<vector<bool>> amis;
    initialisation(NbMembres,amis);
    afficher(amis);

}
