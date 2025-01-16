#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main() {
    srand(time(0));
    int nombreADeviner = rand() % 100 + 1;

    int essai;
    int nombreEssaisRestants = 10;

    cout << "Bienvenue dans le jeu ! Vous devez trouver un nombre entre 1 et 100." << endl;

    while (nombreEssaisRestants > 0)
    {
        cout << "Il vous reste " << nombreEssaisRestants << " essais." << endl;
        cout << "Entrez votre proposition : ";
        cin >> essai;

        if (essai < 1 || essai > 100)
        {
            cout << "Veuillez entrer un nombre entre 1 et 100." << endl;
            continue;
        }

        nombreEssaisRestants--;

        if (essai == nombreADeviner)
            {
            cout << "Bravo ! Vous avez trouvé le nombre " << nombreADeviner << " en " << 10 - nombreEssaisRestants << " essais." << endl;
            break;
            }
        else
            if (essai % nombreADeviner == 0)
            {
                    cout << "Le nombre propose est un multiple du nombre a deviner." << endl;
            }
            else
                if (nombreADeviner % essai == 0)
                {
                    cout << "Le nombre propose est un diviseur du nombre a deviner." << endl;
                }
                else
                {
                    cout << "Le nombre propose n'a rien a voir avec le nombre a deviner." << endl;
                }
    }
    if (nombreEssaisRestants == 0)
    {
        cout << "Desole, vous avez epuise tous vos essais. Le nombre a deviner etait " << nombreADeviner << "." << endl;
    }

    return 0;
}
/* test num 1 fait avec
*  2 4 12 16 24 32 78 19 2 2
*  "Le nombre propose est un multiple du nombre a deviner."/10 fois entre chaque test environ
*  "Le nombre propose est un diviseur du nombre a deviner." et
*  "Le nombre propose n'a rien a voir avec le nombre a deviner." en fonction du resultat demander
*  le resulat etait donc 92
*/
/* test num 2 fait avec
* 2 -2 -2 -2 -2 2 2 2 ...
* le code affiche et demande de rentrer une valeur entre 1 et 100 dans les condition ou le chiffre n'est pas entre 1 et 100
*puis le resultat s'affiche quand on fini le code avec de bonne valeur
*/
/* test num 1 fait avec
* a
* boucle infinis de repetition de la phrases
*"Veuillez entrer un nombre entre 1 et 100."
*/
