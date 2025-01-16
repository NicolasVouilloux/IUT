// QUESTION 1 
//a)

CREATE OR REPLACE FUNCTION nbFilmRealiseById(numInd ens2004.individu.numIndividu%TYPE)Return NUMBER AS
    nbFilm NUMBER;
BEGIN
    SELECT count(*) into nbFilm
    from ens2004.FILM F
    where F.realisateur = numInd;
    RETURN nbFilm;
End;
/
// RUN 
BEGIN
    DBMS_OUTPUT.PUT_LINE(nbFilmRealiseById(1280));
END;
/
//b)
CREATE OR REPLACE FUNCTION nbFilmRealiseByName(nomInd ens2004.individu.nomIndividu%TYPE)Return NUMBER AS
    nbFilm NUMBER;
BEGIN
    SELECT count(*) into nbFilm
    from ens2004.FILM F
    inner join ens2004.individu I on f.realisateur = i.numindividu 
    where i.nomindividu = nomInd;
    RETURN nbFilm;
End;
/
// RUN 
BEGIN
    DBMS_OUTPUT.PUT_LINE(nbFilmRealiseByName('TARANTINO'));
END;
/
//c)
CREATE OR REPLACE PROCEDURE FilmRealiseByName(nomInd ens2004.individu.nomIndividu%TYPE)AS
    CURSOR FilmByName IS
        SELECT titre
        FROM ens2004.Film F
        INNER JOIN ens2004.individu I ON F.realisateur = I.numindividu 
        WHERE i.nomindividu = nomInd;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Le réalisateur '||nomInd||' a realise :');
    For LigneC IN FilmByName
    LOOP
        DBMS_OUTPUT.PUT_LINE(LigneC.Titre);
    END LOOP;
End;
/
// RUN 
BEGIN
    FilmRealiseByName('TARANTINO');
END;
/
// QUESTION 2 
//a)


Select NUMFILM ,
TITRE ,
REALISATEUR 
from ens2004.Film;


SELECT *
FROM ens2004.individu I
WHERE I.nomindividu = 'FONDA';

Create table CLIENT(
    IdClient INT PRIMARY KEY,
    NOM VARCHAR2(100),
    PRENOM VARCHAR2(100));

CREATE TABLE LOCATION(
    IdClient INT,
    IdFilm INT,
    DateEmprunt DATE NOT NULL,
    DateRetour DATE,
    
    FOREIGN KEY (IdClient) REFERENCES CLIENT(IdClient)
);

CREATE TABLE clientfilm(
    numclient NUMBER(5) PRIMARY KEY,
    nomclient VARCHAR2(50),
    prenomclient VARCHAR2(50),
    motpasse VARCHAR2(50),
    adrclient VARCHAR(100),
    cpclient NUMBER(5)
);

CREATE TABLE location (
    numexemplaire NUMBER(38),
    numclient NUMBER(5),
    datelocation DATE,
    dateenvoi DATE,
    dateretour DATE,
    PRIMARY KEY(numexemplaire, numclient),
    CONSTRAINT FK_loc_exemp FOREIGN KEY (numexemplaire) REFERENCES ens2004.exemplaire(numexemplaire),
    CONSTRAINT FK_loc_client FOREIGN KEY (numclient) REFERENCES clientfilm(numclient)    
);


insert into clientfilm (numclient, nomclient, prenomclient, motpasse, adrclient, cpclient) values (2, 'Swinglehurst', 'Clay', 'kC2>P(@eM0', 'PO Box 87007', null);
insert into clientfilm (numclient, nomclient, prenomclient, motpasse, adrclient, cpclient) values (3, 'Loney', 'Sunny', 'kC8(7nFblj', 'PO Box 25421', null);

insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(1112, '01-01-2008', 2, '01-01-2008', null);
insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(1111, '01-01-2008', 2, '01-01-2008', '04-01-2008');
insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(5503, SYSDATE, 2, null, null);
insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(5443, '02-01-2008', 2, '02-01-2008', '05-01-2008');
insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(2864, '12-01-2008', 3, '13-01-2008', null);
insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(15674, SYSDATE, 3, SYSDATE, null);
insert into location(numexemplaire, datelocation, numclient, dateenvoi, dateretour) VALUES(3437, SYSDATE, 3, SYSDATE, null);

set serveroutput on;

drop table CLIENTFILM;
drop table LOCATION;

-- Insérer des clients
INSERT INTO CLIENT (IDCLIENT, NOM, PRENOM)
VALUES (1, 'Dupont', 'Jean');

INSERT INTO CLIENT (IDCLIENT, NOM, PRENOM)
VALUES (2, 'Martin', 'Sophie');

INSERT INTO CLIENT (IDCLIENT, NOM, PRENOM)
VALUES (3, 'Leclerc', 'Pierre');

INSERT INTO CLIENT (IDCLIENT, NOM, PRENOM)
VALUES (4, 'Bernard', 'Alice');

INSERT INTO CLIENT (IDCLIENT, NOM, PRENOM)
VALUES (5, 'Durand', 'Luc');

-- Jean Dupont a emprunté un film le 20 septembre 2024 et l'a rendu le 25 septembre 2024
INSERT INTO LOCATION (IDCLIENT, IDFILM, DATEEMPRUNT, DATERETOUR)
VALUES (1, 101, TO_DATE('2024-09-20', 'YYYY-MM-DD'), TO_DATE('2024-09-25', 'YYYY-MM-DD'));

-- Sophie Martin a emprunté un film le 23 septembre 2024 et l'a rendu aujourd'hui
INSERT INTO LOCATION (IDCLIENT, IDFILM, DATEEMPRUNT, DATERETOUR)
VALUES (2, 102, TO_DATE('2024-09-23', 'YYYY-MM-DD'), TO_DATE('2024-09-25', 'YYYY-MM-DD'));

-- Pierre Leclerc a emprunté un film le 25 septembre 2024 et ne l'a pas encore rendu
INSERT INTO LOCATION (IDCLIENT, IDFILM, DATEEMPRUNT, DATERETOUR)
VALUES (3, 103, TO_DATE('2024-09-25', 'YYYY-MM-DD'), NULL);

-- Alice Bernard a emprunté un film le 22 septembre 2024 et l'a rendu aujourd'hui
INSERT INTO LOCATION (IDCLIENT, IDFILM, DATEEMPRUNT, DATERETOUR)
VALUES (4, 104, TO_DATE('2024-09-22', 'YYYY-MM-DD'), TO_DATE('2024-09-25', 'YYYY-MM-DD'));

-- Luc Durand a emprunté un film aujourd'hui et ne l'a pas encore rendu
INSERT INTO LOCATION (IDCLIENT, IDFILM, DATEEMPRUNT, DATERETOUR)
VALUES (5, 105, TO_DATE('2024-09-25', 'YYYY-MM-DD'), NULL);



