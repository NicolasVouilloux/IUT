#include <iostream>
using namespace std;
void minmax3int(int a, int b, int c, int * min, int * max)
{
    if (a>b && a>c){
        *max=a;
        if (b<c) *min=b; else *min=c;
    }
    else if (b>c){
        *max=b;
        if (a<c) *min=a; else *min=c;
    }
    else{
        *max=c;
        if (a<b) *min=a; else *min=b;
    }
}
int main ()
{
    int val1, val2, val3, mini, maxi;
    cout<<"Entrez 3 entiers : ";
    cin>>val1>>val2>>val3;
    minmax3int (val1, val2, val3, &mini, &maxi);
    cout<<"Minimum="<<mini<<endl<<"Maximum="<<maxi<<endl;
    return 0;
}
