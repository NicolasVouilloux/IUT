#include <iostream>

using namespace std;

int main()
{
    int val;
    int mult;
    int essais = 0;
    cout<<"donne moi un nombre positif plus petit que 10 : ";
    cin>>val;
    while(val>=10 || val<0){
        cout<<"donne moi un nombre POSITIF plus PETIT que 10 : ";
        cin>>val;;
    }
    do{
        cout<<"donne moi un multiplicateur de "<<val<<" : ";
        cin>>mult;
        essais = essais +1;
        cout<<"tu est a l'essaie numero "<<essais<<endl;
    }while(essais != 4 && mult%val!=0);
    if(mult%val==0){
        cout<<"bravo tu as trouve un multiple de "<<val<<" en "<<essais<<" essais.";
    }
    else{
        cout<<"Dommage, tu n'a pas trouver de multiple de "<<val<<" n'hesite pas a recommencer plus tard.";
    }
}

