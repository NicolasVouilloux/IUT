#include "fonction.h"
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

Image::Image() {
  _red = {};
  _blue = {};
  _green = {};
  _longueur = 0;
  _largeur = 0;
}
Image::Image(const vector<vector<int>> &R, const vector<vector<int>> &G,
             const vector<vector<int>> &B) {
  if ((R.size() != B.size() && B.size() != G.size()) &&
      R[0].size() != B[0].size() && B[0].size() != G[0].size()) {
    throw invalid_argument("attention a la taille");
  }
  _red = R;
  _blue = B;
  _green = G;
  _longueur = _red.size();
  _largeur = _red[0].size();
}
//-------------------------------------------------fonction affichage
void Image::affiche() const {
  int i, j;
  cout << "Red" << endl;
  for (i = 0; i < _longueur; ++i) {
    for (j = 0; j < _largeur; ++j) {
      cout << _red[i][j] << "\t";
    }
    cout << endl;
  }
  cout << "Blue" << endl;
  for (i = 0; i < _longueur; ++i) {
    for (j = 0; j < _largeur; ++j) {
      cout << _blue[i][j] << "\t";
    }
    cout << endl;
  }
  cout << "Green" << endl;
  for (i = 0; i < _longueur; ++i) {
    for (j = 0; j < _largeur; ++j) {
      cout << _green[i][j] << "\t";
    }
    cout << endl;
  }
  cout << "la longueur est " << _longueur << " et la largeur est " << _largeur
       << endl;
}
//-----------------------------------------------fonction pour trouver un pixel
void Image::getpixel() const {
  int x, y;
  cout << "donner la coordonée de votre pixel en x : ";
  cin >> x;
  while (x > (_longueur - 1) || x < 0) {
    cout << "donner une coordonée existante de votre pixel en x : ";
    cin >> x;
  }
  cout << "donner les coordonée de votre pixel en y : ";
  cin >> y;
  while (y > (_largeur - 1) || y < 0) {
    cout << "donner une coordonée existante de votre pixel en y : ";
    cin >> y;
  }
  cout << "le pixel en couleur rouge est : " << _red[x][y] << endl;
  cout << "le pixel en couleur bleue est : " << _blue[x][y] << endl;
  cout << "le pixel en couleur vert est : " << _green[x][y] << endl;
}
//---------------------------------------------------------------fonction
// composante rouge
Image Image::Composanterouge() {
  Image I1;
  I1._longueur = _red.size();
  I1._largeur = _red[0].size();
  for (int i = 0; i < _longueur; ++i) {
    I1._red.push_back(vector<int>{});
    I1._blue.push_back(vector<int>{});
    I1._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      I1._red[i].push_back(_red[i][j]);
      I1._blue[i].push_back(0);
      I1._green[i].push_back(0);
    }
  }
  cout << endl;
  return I1;
}
//--------------------------------------------------fonction detection bool
bool Image::detection(int r, int g, int b) {
  for (int i = 0; i < _longueur; ++i) {
    for (int j = 0; j < _largeur; ++j) {
      if (_red[i][j] == r && _blue[i][j] == b && _green[i][j] == g)
        return true;
    }
  }
  return false;
}
//---------------------------------------fonction niveau gris
Image Image::niveaugris() {
  int n = 0;
  Image I2;
  I2._longueur = _red.size();
  I2._largeur = _red[0].size();
  for (int i = 0; i < _longueur; ++i) {
    I2._red.push_back(vector<int>{});
    I2._blue.push_back(vector<int>{});
    I2._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      n = _red[i][j] + _blue[i][j] + _green[i][j];
      (I2._red[i]).push_back(n / 3);
      (I2._blue[i]).push_back(n / 3);
      (I2._green[i]).push_back(n / 3);
    }
  }
  cout << endl;
  return I2;
}
//-------------------------------------fonction noir et blanc de l'image
Image Image::noirEtBlanc(int seuil) {
  Image IG = this->niveaugris();
  Image I3;
  I3._longueur = _red.size();
  I3._largeur = _red[0].size();
  for (int i = 0; i < _longueur; ++i) {
    I3._red.push_back(vector<int>{});
    I3._blue.push_back(vector<int>{});
    I3._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      if (IG._red[i][j] > seuil) {
        I3._red[i].push_back(255);
        I3._blue[i].push_back(255);
        I3._green[i].push_back(255);
      } else {
        I3._red[i].push_back(0);
        I3._blue[i].push_back(0);
        I3._green[i].push_back(0);
      }
    }
  }
  cout << endl;
  return I3;
}
//--------------------------------------------fonction histogrammeGris
vector<int> Image::histogrammeGris() {
  Image Gris = this->niveaugris();
  vector<int> v;
  int c = 0, s;
  while (c != 255) {
    s = 0;
    for (int i = 0; i < _longueur; ++i) {
      for (int n = 0; n < _largeur; ++n) {
        if (_red[i][n] == c) {
          ++s;
        }
      }
    }
    v.push_back(s);
    ++c;
  }
  return v;
}
//----------------------------------------------fonction luminosity Up
Image Image::luminosityUp() {
  float niv;
  cout << "Un nombre superieure  1 ";
  cin >> niv;
  Image I4;
  I4._longueur = _red.size();
  I4._largeur = _red[0].size();
  while (niv < 1) {
    cout << "Un nombre superieure  1 ";
    cin >> niv;
  }
  for (int i = 0; i < _longueur; ++i) {
    I4._red.push_back(vector<int>{});
    I4._blue.push_back(vector<int>{});
    I4._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      if (niv * _green[i][j] > 255 || niv * _red[i][j] > 255 ||
          niv * _blue[i][j] > 255) {
        I4._red[i].push_back(255);
        I4._blue[i].push_back(255);
        I4._green[i].push_back(255);
      } else {
        I4._red[i].push_back(niv * _red[i][j]);
        I4._blue[i].push_back(niv * _blue[i][j]);
        I4._green[i].push_back(niv * _green[i][j]);
      }
    }
  }
  return I4;
}
//----------------------------------------------fonction luminosity Down
Image Image::luminosityDown() {
  float niv;
  cout << "Un nombre inferrieur à 1 ";
  cin >> niv;
  Image I4;
  I4._longueur = _red.size();
  I4._largeur = _red[0].size();
  while (niv > 1) {
    cout << "Un nombre inferrieur à 1 ";
    cin >> niv;
  }
  for (int i = 0; i < _longueur; ++i) {
    I4._red.push_back(vector<int>{});
    I4._blue.push_back(vector<int>{});
    I4._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      I4._red[i].push_back(niv * _red[i][j]);
      I4._blue[i].push_back(niv * _blue[i][j]);
      I4._green[i].push_back(niv * _green[i][j]);
    }
  }
  return I4;
}
// -----------------------------------------------operateur pour comparer deux
// images
bool Image::operator==(const Image &I1) const {
  if (_longueur != I1._longueur || _largeur != I1._largeur)
    return false;
  for (int i = 0; i < _longueur; ++i) {
    for (int j = 0; j < _largeur; ++j) {
      if (_red[i][j] != I1._red[i][j] || _blue[i][j] != I1._blue[i][j] ||
          _green[i][j] != I1._green[i][j])
        return false;
    }
  }
  return true;
}
// -----------------------------------------------------Augmente contraste
Image Image::contrasteUp() {
  float niv;
  cout << "Un nombre superieur à 1 ";
  cin >> niv;
  Image I4;
  I4._longueur = _red.size();
  I4._largeur = _red[0].size();
  while (niv > 1) {
    cout << "Un nombre superieur à 1 ";
    cin >> niv;
  }
  for (int i = 0; i < _longueur; ++i) {
    I4._red.push_back(vector<int>{});
    I4._blue.push_back(vector<int>{});
    I4._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      I4._red[i].push_back((_red[i][j] - 128) * niv + 128);
      if (I4._red[i][j] > 255) {
        I4._red[i][j] = 255;
      }
      if (I4._red[i][j] < 0) {
        I4._red[i][j] = 0;
      }
      I4._blue[i].push_back((_blue[i][j] - 128) * niv + 128);
      if (I4._blue[i][j] > 255) {
        I4._blue[i][j] = 255;
      }
      if (I4._blue[i][j] < 0) {
        I4._blue[i][j] = 0;
      }
      I4._green[i].push_back((_green[i][j] - 128) * niv + 128);
      if (I4._green[i][j] > 255) {
        I4._green[i][j] = 255;
      }
      if (I4._green[i][j] < 0) {
        I4._green[i][j] = 0;
      }
    }
  }
  return I4;
}
//----------------------------------------------------------------- Dimiuner
// contrast
Image Image::contrasteDown() {
  float niv;
  cout << "Un nombre superieur à 1 ";
  cin >> niv;
  Image I4;
  I4._longueur = _red.size();
  I4._largeur = _red[0].size();
  while (niv < 1) {
    cout << "Un nombre superieur à 1 ";
    cin >> niv;
  }
  for (int i = 0; i < _longueur; ++i) {
    I4._red.push_back(vector<int>{});
    I4._blue.push_back(vector<int>{});
    I4._green.push_back(vector<int>{});
    for (int j = 0; j < _largeur; ++j) {
      I4._red[i].push_back((_red[i][j] - 128) * niv + 128);
      I4._blue[i].push_back((_blue[i][j] - 128) * niv + 128);
      I4._green[i].push_back((_green[i][j] - 128) * niv + 128);
    }
  }
  return I4;
}
//--------------------------------------------------------------------fonction
// appelle de l'image cible
void loadPicture(const string &picture, vector<vector<int>> &red,
                 vector<vector<int>> &green, vector<vector<int>> &blue) {
  // Declaration des variables
  string line; // pour recuperer les lignes du fichier image au format .ppm, qui
               // est code en ASCII.
  string format; // pour recuperer le format de l'image : celui-ci doit être de
                 // la forme P3
  string name;   // au cas où l'utilisateur se trompe dans le nom de l'image a
                 // charger, on redemande le nom.
  int taille;
  vector<int> mypixels; // pour recuperer les donnees du fichier de maniere
                        // lineaire. On repartira ensuite ces   donnees dans les
                        // tableaux correspondants
  ifstream entree; // Declaration d'un "flux" qui permettra ensuite de lire les
                   // donnees de l'image.
  int hauteur;     // pour bien verifier que l'image est carree, et de taille
                   // respectant les conditions fixees par   l'enonce
  // Initialisation des variables
  name = picture;
  // Permet d'ouvrir le fichier portant le nom picture
  // ouverture du fichier portant le nom picture
  entree.open(name);
  // On verifie que le fichier a bien ete ouvert. Si cela n'est pas le cas, on
  // redemande un nom de fichier valide
  while (!entree) {
    // cin.rdbuf(oldbuf);
    cerr << "Erreur! Impossible de lire de fichier " << name << " ! " << endl;
    cerr << "Redonnez le nom du fichier a ouvrir SVP. Attention ce fichier "
            "doit avoir un nom du type nom.ppm."
         << endl;
    cin >> name;
    entree.open(name); // relance
  }
  // Lecture du nombre definissant le format (ici P3)
  entree >> format;
  // on finit de lire la ligne (caractere d'espacement)
  getline(entree, line);
  // Lecture du commentaire
  getline(entree, line);
  // lecture des dimensions
  entree >> taille >> hauteur;
  getline(entree, line); // on finit de lire la ligne (caractere d'espacement)
  // On verifie que l'image a une taille qui verifie bien les conditions
  // requises par l'enonce. Si cela n'est pas le cas, on redemande un fichier
  // valide, et ce, tant que necessaire.
  while (format != "P3") {
    if (format != "P3") {
      cerr << "Erreur! L'image que vous nous avez donnee a un format ne "
              "verifiant pas les conditions requises."
           << endl;
      cerr << "L'image que vous nous avez donnee doit etre codee en ASCII et "
              "non en brut."
           << endl;
    }
    entree.close();
    // On va redemander un nom de fichier valide.
    do {
      cerr << "Veuillez redonner un nom de fichier qui respecte les conditions "
              "de format et de taille. Attention, ce nom doit etre de la forme "
              "nom.ppm."
           << endl;
      cin >> name;
      entree.open(name); // relance
    } while (!entree);
    // Lecture du nombre definissant le format (ici P3)
    entree >> format;
    getline(entree, line); // on finit de lire la ligne (caractere d'espacement)
    // Lecture du commentaire
    getline(entree, line);
    // lecture des dimensions
    entree >> taille >> hauteur; // relance
    getline(entree, line); // on finit de lire la ligne (caractere d'espacement)
  }
  // Lecture de la valeur max
  getline(entree, line);
  // Lecture des donnees et ecriture dans les tableaux :
  //  Pour plus de simplicite, on stocke d'abord toutes les donnees dans
  //  mypixels dans l'ordre de lecture puis ensuite on les repartira dans les
  //  differents tableaux.
  // Les donnees stockees dans mypixels sont de la forme RGB RGB RGB ....
  //  Il faudra donc repartir les valeurs R correspondant a la composante rouge
  //  de l'image dans le tableau red, de même pour G et B.
  int pix;
  mypixels.resize(3 * taille *
                  hauteur); // taille fixe : on alloue une fois pour toutes
  for (int i = 0; i < 3 * taille * hauteur; i++) {
    entree >> pix;
    mypixels[i] = pix;
  }
  // Remplissage des 3 tableaux : on repartit maintenant les valeurs dans les
  // bonnes composantes Comme dans mypixels, les donnees sont stockees de la
  // maniere suivante : RGB RGB RGB, il faut mettre les valeurs correspondant a
  // la composante rouge dans red, ... Ainsi, les valeurs de la composante rouge
  // correspondent aux valeurs stockes aux indices congrus a 0 mod 3 dans
  // mypixels, que les valeurs de la composante verte correspond aux valeurs
  // stockes aux indices sont congrus a 1 mod 3, ...
  // les valeurs d'une ligne
  int val;
  red.resize(hauteur);
  green.resize(hauteur);
  blue.resize(hauteur);
  for (int i = 0; i < hauteur; i++) {
    vector<int> ligneR(taille);
    vector<int> ligneB(taille); // les lignes ont toutes la même taille
    vector<int> ligneG(taille);
    for (int j = 0; j < taille; j++) {
      val = mypixels[3 * j + 3 * taille * i];
      ligneR[j] = val;
      val = mypixels[3 * j + 1 + 3 * taille * i];
      ligneG[j] = val;
      val = mypixels[3 * j + 2 + 3 * taille * i];
      ligneB[j] = val;
    }
    red[i] = ligneR;
    green[i] = ligneG;
    blue[i] = ligneB;
  }
  // Informations a l'utilisateur pour dire que tout s'est bien passe
  cout << " L'image " << name << " a bien ete chargee dans les tableaux ."
       << endl;
  entree.close();
}
//------------------------------------------fonction demande nom de fichier
string demandenom() {
  cout << " donner le nom de l'image : ";
  string nom;
  cin >> nom;
  return nom;
}
//---------------------------------------------fonction menu de commande
void Image::menu() {
  ofstream of;
  int rep = 1;
  do {
    cout << "Voici votre interface pour controller votre image !" << endl;
    cout << "-------------Vous aurez le choix entre :-------------" << endl
         << "01 : Afficher votre image." << endl
         << "02 : Chercher un pixel en particulier." << endl
         << "03 : Creer un version à teinte rouge de votre image." << endl
         << "04 : Savoir si une pixel existe." << endl
         << "05 : Creer une version grise de votre image." << endl
         << "06 : Creer une version noir et blanc de votre image." << endl;
    cout << "07 : Conaitre l'histograme de l'image gris." << endl
         << "08 : Augmenter la luminosite de l'image." << endl
         << "09 : Dininuer la luminosite de l'image." << endl
         << "10 : Augmenter le contraste de l'image." << endl
         << "11 : Diminuer le contraste de l'image.";
    cout << endl << "Faites votre choix ";
    cin >> rep;
    if (rep == 1) {
      cout << "Vous avez choisi d'afficher votre image" << endl;
      affiche();
    }
    if (rep == 2) {
      cout << "Vous avez choisi de chercher un pixel en particulier" << endl;
      getpixel();
    }
    if (rep == 3) {
      cout << "Vous avez choisi de creer une version à teinte rouge de votre "
              "image"
           << endl;
      (Composanterouge()).Fichierppm(of);
    }
    if (rep == 4) {
      cout << "Vous avez choisi de savoir si une pixel existe" << endl;
      cout << "entrer les trois couleur rgb : ";
      int re, gr, bl;
      cin >> re >> gr >> bl;
      detection(re, gr, bl);
    }
    if (rep == 5) {
      cout << "Vous avez choisi de creer une version grise de votre image"
           << endl;
      (niveaugris()).Fichierppm(of);
    }
    if (rep == 6) {
      cout << "Vous avez choisi de creer une version noir et blanc de votre "
              "image"
           << endl;
      cout << "entrer le seuil : ";
      int s;
      cin >> s;
      (noirEtBlanc(s)).Fichierppm(of);
    }
    if (rep == 7) {
      cout << "Vous avez choisi de conaitre l'histograme de l'image gris"
           << endl;
      histogrammeGris();
    }
    if (rep == 8) {
      cout << "Vous avez choisi d'augmenter la luminosité de l'image" << endl;
      (luminosityUp()).Fichierppm(of);
    }
    if (rep == 9) {
      cout << "Vous avez choisi de diminuer la luminosité de l'image" << endl;
      (luminosityDown()).Fichierppm(of);
    }
    if (rep == 10) {
      cout << "Vous avez choisi d'augmenter le contraste de l'image" << endl;
      (contrasteUp()).Fichierppm(of);
    }
    if (rep == 11) {
      cout << "Vous avez choisi de diminuer le contraste de l'image" << endl;
      (contrasteDown()).Fichierppm(of);
    }
  } while (rep >= 1 && rep <= 11);
}
//-----------------------------------------------constructeur d'image avec ppm
Image::Image(const string &picture) {
  loadPicture(picture, _red, _green, _blue);
  _longueur = _red.size();
  _largeur = _red[0].size();
}
//------------------------------------------construction d'un fichier ppm
void Image::Fichierppm(ofstream &o) {
  // Creation d'un fichier .ppm
  string fileName;
  int maxPixel = 255;
  try {
    cout << "Name of file to create?";
    cin >> fileName;
    o.open(fileName);
    if (!(o.is_open()))
      throw(fileName);
    o << "P3" << endl;
    // On ecrit les dimensions de l'image
    o << "# Ceci est un fichier .ppm" << endl;
    o << _largeur << endl;
    o << _longueur << endl;
    o << maxPixel << endl;
    // On ecrit les donnees RGB
    for (int i = 0; i < _largeur; i++) {
      for (int j = 0; j < _longueur; j++) {
        o << _red[i][j] << endl;
        o << _green[i][j] << endl;
        o << _blue[i][j] << endl;
      }
    }
    o.close();
    cout<<"fichier "<<fileName<< " rempli "<<endl;
  } catch (const string &s) {
    cerr << "Problem encountered while opening file: " << s;
  }
}
