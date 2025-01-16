#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

/*int main()
{
    string nomFic;
    ifstream entree;

    vector<int> tab(0);

    try {
        cout << "Nom du fichier à lire ?"; cin >> nomFic;
        entree.open(nomFic);
        if(!(entree.is_open())) throw(nomFic);
        int nbInt;
        if (!entree.eof())
            entree >> nbInt;
        for (int i = 0; i < nbInt && !entree.eof(); i++) {
            int val;
            entree >> val;
            tab.push_back(val);
        }
        entree.close();
        cout << "Nous avons lu :";
        for (int i = 0; i < tab.size(); i++) {
            cout << " " << tab[i];
        }
        cout << endl;
    } catch (const string & s) {
        cerr<< "pb ouverture du fichier : " << s;
    }

    return 0;
}*/
int main()
{
    string nomFic;
    ofstream sortie;

    vector<int> tab = {1,2,40,5,7,8,10};

    try {
        cout << "Nom du fichier à créer ?"; cin >> nomFic;
        sortie.open(nomFic);
        if(!(sortie.is_open())) throw(nomFic);
        sortie << tab.size() << endl;
        for(int i=0; i<tab.size(); i++)
            sortie << tab[i] << ' ' ; // penser à mettre un séparateur
        sortie << endl;
        sortie.close();
    } catch (const string &s) {
        cerr<< "pb ouverture du fichier : " << s << endl;
    }

    return 0;
}
