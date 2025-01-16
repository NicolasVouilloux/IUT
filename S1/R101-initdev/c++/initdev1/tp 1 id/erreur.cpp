#include <iostream>
using namespace std;
const float PI=3.14;
int main(){
    float rayon;
    cout << "quel est le rayon du cercle en cm  ?";
    cin>>rayon;
    float surface=PI*rayon*rayon;
    cout<<"voici la surface de votre cercle:" <<surface
    << endl;
    return 0;
}

