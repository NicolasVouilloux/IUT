#include <iostream>
using namespace std;
extern "C" long long factoto (long long a);
int main()
{
	long long a, b, c, n;
	cout << endl << "une valeur a factoriser :";
	cin >> a;
	cout << endl << "resultat :"<<factoto(a);
	return 0;
}