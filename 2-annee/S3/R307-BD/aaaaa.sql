CREATE TABLE clientTp7 (
    login VARCHAR2(50) PRIMARY KEY, -- Identifiant unique pour chaque client
    nomClient VARCHAR2(100) NOT NULL, -- Nom du client, obligatoire
    prenomClient VARCHAR2(100) NOT NULL, -- Prénom du client, obligatoire
    motDePasse VARCHAR2(200) NOT NULL, -- Mot de passe du client, obligatoire
    adresse VARCHAR2(255) -- Adresse du client, facultative
);



INSERT INTO clienttp7 (login, nomClient, prenomClient, motDePasse, adresse)
VALUES ('client01', 'Dupont', 'Jean', 'password123', '123 rue Principale, Paris');

INSERT INTO clienttp7(login, nomClient, prenomClient, motDePasse, adresse)
VALUES ('client02', 'Martin', 'Sophie', 'sophie2023', '45 avenue des Lilas, Lyon');

INSERT INTO clienttp7(login, nomClient, prenomClient, motDePasse, adresse)
VALUES ('client03', 'Durand', 'Paul', 'paulSecure#1', '78 boulevard Haussmann, Marseille');

INSERT INTO clienttp7(login, nomClient, prenomClient, motDePasse, adresse)
VALUES ('client04', 'Lemoine', 'Claire', 'cl@irePWD', '5 place de la République, Toulouse');

INSERT INTO clienttp7(login, nomClient, prenomClient, motDePasse, adresse)
VALUES ('client05', 'Morel', 'Thomas', 'thomas2025!', '88 chemin des Vignes, Bordeaux');


commit;

UPDATE clienttp7 SET adresse = 'a'
WHERE login = 'client01' ;

SELECT * FROM clienttp7 ;

//question 1
// le resultat dans la fenetre de modification est "a" et dans l'autre fenetre est toujours l'original car la connextion na pas ete commit

//question 2
// apres le commit la modification prend place mais chacune des connexion a un resultat different
// a a liberer le verrou pour que b puisse faire la maj (que ddans b)

// le commit realiser dans une page met a jour dans l'autre page

//a) 
// oui mais la table sera sur la version avant l'update de l'autre fenetre

//b)
// elle sera mise en attente tant que le verrou ne sera pas liberer

//c)
// oui on peut la mettre a jour

//d)
// 