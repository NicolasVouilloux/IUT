#include <iostream>
#include "calcul.h"

using namespace std;

int main()
{
    int b=1.4;
    int c=0;
    int d=-1;
    if (estPositif(b))
        cout<<"la valeur b est positive"<<endl;
    else
        cout<<"la valeur b est negative"<<endl;
    if (estPositif(c))
        cout<<"la valeur c est positive"<<endl;
    else
        cout<<"la valeur c est negative"<<endl;
    if (estPositif(d))
        cout<<"la valeur d est positive"<<endl;
    else
        cout<<"la valeur d est negative"<<endl;
}
