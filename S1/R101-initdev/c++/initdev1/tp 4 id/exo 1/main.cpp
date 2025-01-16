// HBM,JL 2023
// gestion d'une equipe de sportives : equipe de France de football feminin 2023
// g++ -std=c++14
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main( )
{
    int nombrejoueuse;
    string nomjoueuse;
    int trouve= false;
    vector<string> equipe = {"DURAND","BACHA","RENARD","GEYORO","DIANI","SOMMER"}; //question a b c d
    cout<<equipe.front()<<" ; " <<equipe.back()<<endl;
    for (unsigned int i = 0;i<equipe.size(); i++)
    {
        cout<<equipe[i]<<"\t";
    }
    cout<<endl;
    for (unsigned int i = (equipe.size()-1);i< INT_MAX/2; i--)
    {
        cout<<equipe[i]<<"\t";
    }
    cout<<endl;
    cout<<"ecrire le nombre de joueuse : ";//question e
    cin>>nombrejoueuse;
    cout<<endl;
    for (int i=0;i<nombrejoueuse;i++)
    {
        cout<<"ecrire le nom d'une joueuse : ";
        cin>>nomjoueuse;
        equipe.push_back(nomjoueuse);
        cout<<endl;
    }
    for (unsigned int i = 0;i<equipe.size(); i++)
    {
        cout<<equipe[i]<<"\t";
    }
    cout<<endl;
    cout<<"chercher un Nom de joueuse : ";//question f g
    cin>>nomjoueuse;
    {
        int i=0;
        while(i<equipe.size() && !trouve)
        {
            trouve=equipe[i]==nomjoueuse;
            i++;
        }
        if (trouve)
        {
            cout<< "la case ou la joueuse est presente est la case "<<i<<endl;
            cout<< "ecrivez son nouveau Nom : ";
            cin>>nomjoueuse;
            equipe[i-1]=nomjoueuse;
            for (unsigned int j = 0;j<equipe.size(); j++)
            {
                cout<<equipe[j]<<"\t";
            }
            cout<<endl;
        }
        else
        {
            cout<< "joueuse inconnue"<<endl;
        }
    }
    trouve = false;//question numero h
    cout<<"chercher un Nom de joueuse : ";
    cin>>nomjoueuse;
    {
        int i=0;
        while(i<equipe.size() && !trouve)
        {
            trouve=equipe[i]==nomjoueuse;
            i++;
        }
        if (trouve)
        {
            cout<< "la case ou la joueuse est presente est la case "<<i<<endl;
            cout<< "ecrivez son nouveau Nom : ";
            cin>>nomjoueuse;
            for (int j=0;j<nomjoueuse.length();j++)
            {
                nomjoueuse[j]=toupper(nomjoueuse[j]);
            }
            equipe[i-1]=nomjoueuse;
            for (unsigned int j = 0;j<equipe.size(); j++)
            {
                cout<<equipe[j]<<"\t";
            }
            cout<<endl;
        }
        else
        {
            cout<< "joueuse inconnue"<<endl;
        }
    }
}
/*TEST 1
<<DURAND ; SOMMER
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER
<<SOMMER  DIANI   GEYORO  RENARD  BACHA   DURAND
<<ecrire le nombre de joueuse :
>>3
<<ecrire le nom d'une joueuse :
>>flaquedecouleur
<<ecrire le nom d'une joueuse :
>>benladono
<<ecrire le nom d'une joueuse :
>>smashlesalut
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER  flaquedecouleur benladono       smashlesalut
<<chercher un Nom de joueuse :
>>flaquedecouleur
<<la case ou la joueuse est presente est la case 7
<<ecrivez son nouveau Nom :
>>xenogenrerenard
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER  xenogenrerenard benladono       smashlesalut
<<chercher un Nom de joueuse :
>>xenogenrerenard
<<la case ou la joueuse est presente est la case 7
<<ecrivez son nouveau Nom :
>>flaquedecouleur
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER  FLAQUEDECOULEUR benladono       smashlesalut
*/
/*TEST 2
<<DURAND ; SOMMER
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER
<<SOMMER  DIANI   GEYORO  RENARD  BACHA   DURAND
<<ecrire le nombre de joueuse :
>>A
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER
<<chercher un Nom de joueuse : joueuse inconnue
<<chercher un Nom de joueuse : joueuse inconnue
*/
/*TEST 3
<<DURAND ; SOMMER
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER
<<SOMMER  DIANI   GEYORO  RENARD  BACHA   DURAND
<<ecrire le nombre de joueuse :
>>-8
<<DURAND  BACHA   RENARD  GEYORO  DIANI   SOMMER
<<chercher un Nom de joueuse :
><GEYORO
<<la case ou la joueuse est presente est la case 4
<<ecrivez son nouveau Nom :
>>bob
<<DURAND  BACHA   RENARD  bob     DIANI   SOMMER
<<chercher un Nom de joueuse :
>>bob
<<la case ou la joueuse est presente est la case 4
<<ecrivez son nouveau Nom :
>>bob
<<DURAND  BACHA   RENARD  BOB     DIANI   SOMMER
*/
