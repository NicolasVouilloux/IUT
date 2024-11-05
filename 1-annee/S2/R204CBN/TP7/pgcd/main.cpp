#include <iostream>
using namespace std;
extern "C" int pgcd(int a,int b);
int main()
{
	int a, b;
	cout << endl << "pgcd a et b:";
	cin >> a;
	cin >> b;
	cout << endl << "resultat :" << pgcd(a,b);
	return 0;
}
