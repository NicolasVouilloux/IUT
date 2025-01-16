#ifndef _PERENOEL_
#define _PERENOEL_
#include "enfant.h"
#include "cadeau.h"
const vector <string> JEUX= {"train","jeu video","poupee","jeu de societe","ballon","ordinateur","poupee","train","ballon"};  // les cadeaux de la hotte du PereNoel
class PereNoel {
  private:
      vector<string>_hotte;
  public:
      PereNoel();
      void affiche()const;
      bool offreCadeau();

};
#endif
