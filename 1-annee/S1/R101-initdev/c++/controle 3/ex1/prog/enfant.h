#ifndef _ENFANT_
#define _ENFANT_

class Enfant {
   private:
    vector<string>_sac;
    string _nom;

 public:
    Enfant(const string & n="toto");
    string nom()const;
    //affiche l'enfant et sa liste de cadeau
    void affiche()const;
    //recoit un cadeau dans son vecteur _sac
    void recoitCadeau(const Cadeau& c);
    //methode pour verifier si un enfant a un cadeau
    bool possede(const Cadeau& c);
};

#endif
