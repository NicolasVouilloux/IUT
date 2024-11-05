/// TP5 Tris et Complexité
/// 2022-2023
/// fichier main.cpp

#include <cstdlib>
#include <ctime>
#include <stdexcept>
#include <iostream>
#include "vecteurTrie.h"
#include "outils.h"

/// NOTE: mettre les 2 affichages de vecteur en commentaires pour executer les gros tris
/// et/ou pour l'execution d'un grand nombre de tris.

int main()
{
    VecteurTrie mesDonnees;         /// le vecteur de données
    Algo monAlgo;                   /// l'algorithme de tri
    Ordre monOrdre;                 /// l'ordre des données lors de l'initialisation du vecteur
    int nbElts, nbExec, valMax;     /// les paramètres du tri
    int cptEcrit, cptComp;          /// les compteurs de comparaisons et d'écritures
    int cptEcritTotal, cptCompTotal;

    do
    {
        cptEcritTotal=0, cptCompTotal=0;

        /// définition des paramètres du tri
        srand(time(NULL));              /// initialisation de rand
        paramTri(nbElts, valMax, nbExec, monOrdre, monAlgo);

        try
        {
            /// exécuter nbExec fois le tri souhaité
            for(int i = 0; i<nbExec; i++)
            {
                cout<<"************************************************************"<<endl;
                /// les compteurs sont remis à 0 pour chaque exécution
                cptEcrit=0;
                cptComp=0;

                /// initialiser le vecteur selon les choix de l'utilisateur
                mesDonnees.initVecteur(nbElts, monOrdre, valMax);
                cout << "Vecteur avant le tri :" << endl;
                mesDonnees.afficher();

                /// trier le vecteur
                mesDonnees.trier(monAlgo, cptEcrit, cptComp);
                cout << "\nVecteur apres le tri :" << endl;
                mesDonnees.afficher();
                cout <<"\nNombre d'ecritures: " << cptEcrit << endl
                     <<"Nombre de comparaisons: " << cptComp << endl;

                /// mise à jour du nombre total d'écritures et de comparaison
                cptEcritTotal = cptEcritTotal + cptEcrit;
                cptCompTotal = cptCompTotal + cptComp;
            }
            cout<<"************************************************************"<<endl;

            ///Calcul et affichage des valeurs moyennes des 2 compteurs
            cout <<"\nNombre moyen d'ecritures: "<<(float)cptEcritTotal/nbExec<<endl
                 <<"Nombre moyen de comparaisons: "<<(float)cptCompTotal/nbExec<<endl;
        }
        catch (string mesg)
        {
            cout << mesg << endl;
        }
        catch(out_of_range e)
        {
            cerr << "ERREUR : " << e.what() << endl;
        }
    } while (recommencer());  /// laisse l'utilisateur recommencer si elle le souhaite

    return 0;
}
