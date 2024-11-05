#include <iostream>
#include <string>
#include <vector>
#include "fonctionsFacebook.h"

using namespace std;

void initialisation (const int n, vector<vector<bool> > & amis){
    amis=vector<vector <bool> >(n,vector<bool>(n,true));
}

void afficher (const vector <vector <bool> >&  amis)
{
    for (int i = 0;i < amis.size();++i){
        cout<<i<<": ";
        for (int j = 0 ; j<amis[i].size();j++){
            if (i !=j && amis[i][j])
                cout<<j<<"  ";
        }
        cout<<endl;
    }
}
