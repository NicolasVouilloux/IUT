#include <iostream>

using namespace std;

int main()
{
    int n,k;
    char y;
    cout<<"saisi le charactere a repeter en rectangle : ";
    cin>>y;
    cout<<"saisir un nombre d'etoile a afficher : ";
    cin>>n;
    while (n<=0)
    {
        cout<<"t'abuse la maintenant saisi un nombre strictement positif : ";
        cin>>n;
    }
    cout<<"saisir un nombre de ligne a afficher : ";
    cin>>k;
    while (k<=0)
    {
        cout<<"t'abuse la maintenant saisi un nombre de ligne strictement positif : ";
        cin>>k;
    }
    for (int a=1; a<=k;a++)
    {
        for(int i=1; i<=n;i++)
        {
            cout<<y;
        }
        cout<<endl;
    }
    return 0;
}
/* petit 3
* test 1 :
>  6 6
<  ******
*  ******
*  ******
*  ******
*  ******
*  ******
* test  2 :
>  -4
< t'abuse la maintenant saisi un nombre strictement positif :
> 4 , -2
< t'abuse la maintenant saisi un nombre strictement positif :
> 2
<  ****
*  ****
* test 3 :
>  m
*  boucle infinie message boucle while repeter
* petit 4
* test 1 :
> & 2 2
< &&
* &&
* test 2 :
> 44 1
< 4444
*/





