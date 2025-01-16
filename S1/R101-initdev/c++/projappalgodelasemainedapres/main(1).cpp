#include "fonction.h"
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;
//le code n'aura pas vraiment la version final il y a quelque modification car c'est une version pas terminé car je travaillais directement sur replit
int main() {
  vector<vector<int>> red{{000, 000, 000, 000},
                          {000, 000, 255, 255},
                          {000, 255, 255, 255},
                          {255, 255, 255, 255}};
  vector<vector<int>> blue{{255, 255, 000, 000},
                           {255, 000, 000, 000},
                           {000, 000, 000, 000},
                           {000, 000, 000, 000}};
  vector<vector<int>> green{{000, 000, 255, 255},
                            {000, 255, 255, 255},
                            {255, 255, 255, 000},
                            {255, 255, 000, 000}};
  cout<<"--------------------------------------utilisation du menu--------------------------------------"<<endl;
  try {
    Image I1(red, green, blue);
    I1.menu();
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
  cout<<"--------------------------------------utilisation du menu sur image ppm--------------------------------------"<<endl;
  try {
    Image I1(demandenom());
    I1.menu();
  } catch (invalid_argument &e) {
    cerr << e.what() << endl;
  }
}
