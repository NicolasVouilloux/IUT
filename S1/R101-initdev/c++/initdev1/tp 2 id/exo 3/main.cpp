#include <iostream>

using namespace std;

int main()
{
  double x,y,z;


    cout << "saisir trois nombres";
    cin >> x;
    cin >> y;
    cin >> z;
    if (x>y)
    {
        if (x>z)
        {
            cout<<"le nombre maximum est "<<x <<endl;
            if (y<z)
            {
                cout<<"le nombre minimum est "<<y <<endl;
            }
            else
            {
                cout<<"le nombre minimum est "<<z <<endl;
            }
        }
        else
        {
            cout<<"le nombre maximum est "<<z <<endl;
            if (x<y)
            {
                cout<<"le nombre minimum est "<<x <<endl;
            }
            else
            {
                cout<<"le nombre minimum est "<<y <<endl;
            }
        }
    }
    else
    {

        if (y>z)
        {
            cout<<"le nombre maximum est "<<y <<endl;
            if (x<z)
            {
                cout<<"le nombre minimum est "<<x <<endl;
            }
            else
            {
                cout<<"le nombre minimum est "<<z <<endl;
            }
        }
        else
            cout<<"le nombre maximum est "<<z <<endl;
            if (x<y)
            {
                cout<<"le nombre minimum est "<<x <<endl;
            }
            else
            {
                cout<<"le nombre minimum est "<<y <<endl;
            }
        }


return 0;
    }
    /*
    *teste realiser avec 1 2 3/20 1 50/20 10 1
    */

