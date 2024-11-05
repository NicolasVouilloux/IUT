#include <iostream>

using namespace std;
int main()
{
    int a;
    cout << "saisir temperature";
    cin >> a;
    if (a>25)
    {
        cout <<"il fait trop chaud";
    }
    else
    {
        if (a<15)
        {
            cout <<"il fait trop froid";
        }
        else
        {
            cout <<"Cette temperature me convient";
        }
    }

    return 0;

}
/*
*Essaie produit avec temperature 1,90,17
*/
