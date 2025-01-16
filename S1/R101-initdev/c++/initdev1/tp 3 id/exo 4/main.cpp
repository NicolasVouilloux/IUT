#include <iostream>

using namespace std;

int main()
{
    int maxInt;
    int minInt;
    cout << "entrer une val MAX : " ;
    cin >> maxInt ;
    while (maxInt<0)
    {
        cout << " entrer une valeur strictement positive : ";
        cin >> maxInt ;
    }
    cout <<"entrer une valeur MIN : ";
    cin >> minInt ;
    while (minInt<0 || minInt>=maxInt)
    {
        cout << "entrer une valeur strictement positive et inferieur a val MAX : ";
        cin >> minInt ;
    }
    int y=minInt;
    while (y %7 !=0){++y;}
    int i=y;
    while (i<=maxInt)
    {
        for(int k=1; k<=10 ; ++k)
        {
            if ( i<=maxInt)
            {
                cout<<i <<" ";
                i=i+7;
            }
        }
        cout<<endl;
    }
}
/*
* Test num 1
* >> 120 7
* << 7 14 21 28 35 42 49 56 63 70
* << 77 84 91 98 105 112 119
* Test num 2
* >> -6 120 -7 149 7
* << 7 14 21 28 35 42 49 56 63 70
* << 77 84 91 98 105 112 119
* Test num 3
* >> a
* << boucle infinie repetition "entrer une valeur strictement positive"
*/

