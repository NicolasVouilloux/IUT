#include <iostream>
#include <vector>

using namespace std;

int main()
{
    {/*
        double val;
        double stop;
        cout<<"choisir un valeur pour arreter : ";
        cin>>stop;
        vector <double> tab= {};
        while (val!=stop)
        {
            cout<<"ecrire une valeur a ajouter : ";
            cin>>val;
            if (val!=stop)
            {
                tab.push_back(val);
                cout<<endl;
            }
        }
        for (int i = 0;i<tab.size(); i++)
        {
            cout<<tab[i]<<"\t";
        }
        cout<<endl;
    */
        /*TEST 1
        <<choisir un valeur pour arreter :
        >>1
        <<ecrire une valeur a ajouter :
        >>2
        <<ecrire une valeur a ajouter :
        >>2
        <<ecrire une valeur a ajouter :
        >>2
        <<ecrire une valeur a ajouter :
        >>2
        <<ecrire une valeur a ajouter :
        >>1
        2       2       2       2
        */
        /*TEST 2
        <<choisir un valeur pour arreter :
        >>a
        (boucle infini de repetitiond e la phrase ecrire une valeur a ajouter)
        */
        /*TEST 3
        <<choisir un valeur pour arreter :
        >>0
        <<ecrire une valeur a ajouter :
        >>1.2
        <<ecrire une valeur a ajouter :
        >>0
        <<1.2
        */
    }
    {/*
        //vercteur reel.cpp(question b)
        double valpr=0;
        double moyenne;
        vector <double> tab= {10,15,9};
        for (int i =0;i<tab.size(); i++)
        {
            valpr=valpr+tab[i];
        }
        moyenne=valpr/tab.size();
        cout<<"la valeur moyenne est"<<moyenne<<endl;
        for (int i = 0;i<tab.size(); i++)
        {
            cout<<tab[i]<<"\t";
        }
        cout<<endl;
        /*TEST 1
        la valeur moyenne est11.3333
        10      15      9
        */
        /*TEST 2
        la valeur moyenne est4.8
        0       20.4    -6
        */
        /*TEST 3
        la valeur moyenne estnan
        */

    }
    {
        //indice de valeur(question c)
        double valpr=0;
        double moyenne;
        double val;
        double stop;
        cout<<"Choisir un valeur pour arreter : ";
        cin>>stop;
        vector <double> tab= {};
        while (val!=stop)
        {
            cout<<"Ecrire une valeur a ajouter : ";
            cin>>val;
            if (val!=stop)
            {
                tab.push_back(val);
                cout<<endl;
            }
        }
        for (int i =0;i<tab.size(); i++)
        {
            valpr=valpr+tab[i];
        }
        moyenne=valpr/tab.size();
        cout<<"La valeur moyenne est : "<<moyenne<<endl;
        for (int i = 0;i<tab.size(); i++)
        {
            cout<<tab[i]<<"\t";
        }
        cout<<endl;
        double valprmax;
        int casevalmax;
        if(tab.size()>0)
        {
            valprmax=tab[0];
            casevalmax=0;
        }
        for (int i =1;i<tab.size(); i++)
        {
            if (tab[i]>valprmax)
            {
                valprmax=tab[i];
                casevalmax=i;
            }
        }
        if (tab.size()=0)
        {
            cout<<"Le vecteur est vide kassos"
        }
        else
        {
            cout<<"la val max est "<<valprmax<<" et la case max est "<<casevalmax<<endl;
        }
    }
}

