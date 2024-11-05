#include <iostream>
#include "calcul.h"
#include "menu.h"

using namespace std;

int main()
{
    int a;
    cout<<"entrer une valeur lolilol : ";
    cin>>a;
    while (!estPositif(a)){
        cout<<"la valeur est negative"<<endl<<"entrer de nouveau la valeur : ";
        cin>>a;
    }
    cout<<"la valeur est positive"<<endl;
    menu();
    int c=-1;
    while (c!=QUIT)
        c=menu();
        int v;
        if(c==1){
            cout<<"entrer une valeur : ";
            cin>>v;
            somme(v);
        }
        if(c==2){
            cout<<"entrer une valeur : ";
            cin>>v;
            int f=fact(v);
            cout<<f;
        }
        if(c==3){
            cout<<"enter une valeur : ";
            cin>>v;
            int d=div(v);
            cout<<d;
        }
}
