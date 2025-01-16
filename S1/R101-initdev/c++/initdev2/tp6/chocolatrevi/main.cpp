#include <iostream>
#include "choco.h"

using namespace std;

int main()
{
    Chocolat c1("blanc",20);    // chocolat blanc de 20g
    Chocolat c2;  // chocolat noir de 30g
    Chocolat c3(10);  // chocolat de 10g, nature tirée au sort
    Chocolat c4("blanc") ; // chocolat blanc de 30g
    return 0;
}
