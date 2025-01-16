#include <iostream>
using namespace std;
extern "C" double polynome2int(double a, double b, double c, double x);
int main()
{
	double a, b, c, x;
	cout << endl << "Ce programme sert a calculer la valeur d'un polynome entier de second degre a * n ^ 2 + b * x + c" << endl << endl;
		cout << "Entrez une valeur entiere pour a : "; cin >> a;
	cout << "Entrez une valeur entiere pour b : "; cin >> b;
	cout << "Entrez une valeur entiere pour c : "; cin >> c;
	cout << "Entrez une valeur entiere pour n : "; cin >> x;
	cout << endl << "Pour x = " << x << " : " << a << "*x^2 + " << b << "*x + " << c
		<< " = " << polynome2int(a, b, c, x) << endl;
	return 0;
}