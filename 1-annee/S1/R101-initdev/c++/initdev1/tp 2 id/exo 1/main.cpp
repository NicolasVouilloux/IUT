#include <iostream>

using namespace std;
double a,b;
int main()
{
    cout <<"saisir deux valeurs reelles a et b";
    cin  >> a;
    cin  >> b;
    if (a<=b)
    {
        cout <<"ordre croissant";
    }
    else
    {
        cout <<"ordre decroissant";
    }
    return 0;
}
/*
*Tester sur a=1 b=1, a=1 b=2
*a=2.5 b=1.5
*/
