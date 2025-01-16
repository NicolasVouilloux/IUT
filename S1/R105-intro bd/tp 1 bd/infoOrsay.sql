DROP TABLE ligneCommande;
DROP TABLE commande;
DROP TABLE produit;
DROP TABLE client;
DROP TABLE categorie;


CREATE TABLE categorie (
  codeCategorie    CHAR(1) CONSTRAINT categorie_PK PRIMARY KEY,
  libelleCategorie VARCHAR2(20) CONSTRAINT categorie_libelle_NN NOT NULL,
  remise           NUMBER(3)
);

CREATE TABLE client (
  numClient       NUMBER(6) CONSTRAINT client_PK PRIMARY KEY,
  nomClient       VARCHAR2(20) CONSTRAINT client_nomClient_NN NOT NULL,
  prenomClient    VARCHAR2(20), 
  adresseClient   VARCHAR2(50),
  telClient       CHAR(14),
  categorieClient CHAR(1)
                  CONSTRAINT client_categorie_FK REFERENCES categorie
                  CONSTRAINT client_categorie_NN NOT NULL
);

CREATE TABLE produit (
  numProduit  NUMBER(6) CONSTRAINT produit_PK PRIMARY KEY,
  designation VARCHAR2(30) CONSTRAINT produit_designation_NN NOT NULL,
  prix        NUMBER(8,2)
);
  
CREATE TABLE commande (
  numCommande   NUMBER(6) CONSTRAINT commande_PK PRIMARY KEY,
  dateCommande  DATE,
  numClient     NUMBER(6)
                CONSTRAINT commande_client_FK REFERENCES client
                CONSTRAINT commande_numClient_NN NOT NULL
);

CREATE TABLE ligneCommande (
  numCommande NUMBER(6) CONSTRAINT lignec_commande_FK REFERENCES commande,
  numProduit  NUMBER(6) CONSTRAINT lignec_produit_FK REFERENCES produit,
  quantite    NUMBER(6) CONSTRAINT lignec_quantite_NN NOT NULL,
  CONSTRAINT lignec_PK PRIMARY KEY (numCommande, numProduit)
  INSERT INTO categorie VALUES('E', 'Entreprise', 10) ;
  INSERT INTO categorie VALUES('F', 'Carte de fidelite', 5) ;
  INSERT INTO categorie VALUES('P', 'Particulier', 0) ;
  INSERT INTO client VALUES(1, 'ROSSI', 'Maria',
'21 avenue de la Forêt, 91400 Orsay',
'01 74 23 21 33', 'E') ;
INSERT INTO client
VALUES(2, 'DEGHAR', 'Ali',
'33 avenue des PLatanes, 91400 Orsay',
'01 46 57 28 32', 'P') ;
INSERT INTO client
VALUES(3, 'TURNER', 'J.-Baptiste',
'3 rue des Rosiers, 92160 Antony',
'01 34 56 43 22', 'E') ;
INSERT INTO client
VALUES(4, 'SCHMITT', 'Michel',
'41 impasse des Tilleuls, 91000 Evry',
'01 53 22 41 33', 'P') ;
);
select* from categorie;

