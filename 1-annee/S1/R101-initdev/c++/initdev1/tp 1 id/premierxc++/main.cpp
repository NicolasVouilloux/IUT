#include <iostream>

using namespace std;
const int TROIS=3;
int main()
{
    int nombre,tripleNombre;
    cout <<"entrez un nombre:";
    cin >> nombre;
    tripleNombre = nombre*TROIS;
    cout<<"Le triple de " <<nombre <<"est";
    cout<<tripleNombre<<endl;
    return 0;

}
