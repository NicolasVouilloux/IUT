#include <iostream>
#include <vector>
using namespace std;

void afficher (const vector <vector <bool> >&  amis)
{
    for (int i = 0;i < amis.size();++i){
        cout<<i<<": ";
        for (int j = 0 ; j<amis[i].size();j++){
            if (i !=j && amis[i][j])
                cout<<j<<"  ";
            //else{
            //cout<<amis[i][j]<<"\t";

        }
        cout<<endl;
    }
    return;
}
int main(){
    int n=4;
    vector <vector <bool> >amis(n,vector<bool>(n,0));

    /*for(int i=0;i<amis.size();++i){
        amis[i][i]=true;
    }*/
    amis[0]=vector<bool>{true,false,true,true};
    amis[1]=vector<bool>{false,true,true,false};
    amis[2]=vector<bool>{true,true,true,true};
    amis[3]=vector<bool>{true,false,true,true};
    afficher(amis);
    int k;
    int l;
    bool m;
    char continuer;
    do
    {
        cout<<endl<<"saisir le numero de la personne a changer : ";
        cin>>k;
        while(k<0 || k>=amis.size()){
            cout<<"saisir le numero de la personne a changer : ";
            cin>>k;
        }
        cout<<endl<<"saisir avec qui l'amitie doit changer : ";
        cin>>l;
        while(l<0 || l>=amis.size()){
            cout<<"saisir avec qui l'amitie doit changer : ";
            cin>>l;
        }
        cout<<endl<<"saisir la nouvelle amitie avec 1 pour true ou 0 pour false : ";
        cin>>m;
        amis[k][l]=m;
        amis[l][k]=m;
        cout<<endl;
        afficher(amis);
        cout<<endl<<"voulez vous continuer pour oui pour non : ";
        cin>>continuer;

    }while(continuer!='n');

 /*   for (int i = 0;i < amis.size();++i){
        cout<<i<<": ";
        for (int j = 0 ; j<amis[i].size();j++){
            if (i !=j && amis[i][j])
                cout<<j<<"  ";
            //else{
            //cout<<amis[i][j]<<"\t";

        }
        cout<<endl;
    }*/
    return 0;
}
/*Question 1
0: 0
1: 1
2: 2
3: 3

Process returned 0 (0x0)   execution time : 0.063 s
Press any key to continue.
*/
/*Question 2
0: 0  2  3
1: 1  2
2: 0  1  2  3
3: 0  2  3

Process returned 0 (0x0)   execution time : 0.053 s
Press any key to continue.
*/
/*Question 3
0: 2  3
1: 2
2: 0  1  3
3: 0  2

Process returned 0 (0x0)   execution time : 0.068 s
Press any key to continue.
*/
/*Question 3.5
0: 2  3
1: 2
2: 0  1  3
3: 0  2

Process returned 0 (0x0)   execution time : 0.047 s
Press any key to continue.
*/
/*Question 4 test 1 valeur classique
0: 2  3
1: 2
2: 0  1  3
3: 0  2

saisir le numero de la personne a changer :
<<1

saisir avec qui l'amitie doit changer :
<<3

saisir la nouvelle amitie avec 1 pour true ou 0 pour false :
<<1

0: 2  3
1: 2  3
2: 0  1  3
3: 0  1  2

voulez vous continuer pour oui pour non :
<<o

saisir le numero de la personne a changer :
<<1

saisir avec qui l'amitie doit changer :
<<3

saisir la nouvelle amitie avec 1 pour true ou 0 pour false :
<<0

0: 2  3
1: 2
2: 0  1  3
3: 0  2

voulez vous continuer pour oui pour non :
<<n

Process returned 0 (0x0)   execution time : 29.801 s
Press any key to continue.
*/
/*Test 2
0: 2  3
1: 2
2: 0  1  3
3: 0  2

saisir le numero de la personne a changer :
<<8
saisir le numero de la personne a changer :
<<-8
saisir le numero de la personne a changer :
<<2

saisir avec qui l'amitie doit changer :
<<-7
saisir avec qui l'amitie doit changer :
<<8
saisir avec qui l'amitie doit changer :
<<2

saisir la nouvelle amitie avec 1 pour true ou 0 pour false :
<<0

0: 2  3
1: 2
2: 0  1  3
3: 0  2

voulez vous continuer pour oui pour non :
<<n

Process returned 0 (0x0)   execution time : 62.517 s
Press any key to continue.
*/
