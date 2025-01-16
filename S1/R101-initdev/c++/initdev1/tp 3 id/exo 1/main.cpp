#include <iostream>

using namespace std;

int main()
{
 int n,k;
 cout<<"saisir n : ";
 cin>>n;
    for (int i=2; i<= n/2;++i)
    {
        if ((n%i)==0)
        {
        k=k+1;
        cout<<i<<" est diviseur de "<<n<<endl;
        }
    }
    cout<<"nombre de diviseur "<<k<<endl;
return 0;
}
