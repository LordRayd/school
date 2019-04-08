-- LORANS-CANO Gurvan
-- Info 1A2
-- TP3 et 4


-- La destruction des tables se fait selon les dépendances aux autres tables.
-- Destruction de la table Reservation
DROP TABLE Reservation;
-- Destruction de la table Bateau
DROP TABLE Bateau;
-- Destruction de la table Emplacement
DROP TABLE Emplacement;
-- Destruction de la table Proprietaire
DROP TABLE Proprietaire;

-- Creation de la table Proprietaire
CREATE TABLE Proprietaire(
            identifiant NUMBER(4)
            CONSTRAINT pkProprietaire PRIMARY KEY,
            nom VARCHAR2(20)
            CONSTRAINT nnNomProp NOT NULL,
            prenom VARCHAR2(20)
            CONSTRAINT nnPrenomProp NOT NULL,
            CONSTRAINT uqProprietaire UNIQUE (nom, prenom),
            adresse VARCHAR2(40)
            CONSTRAINT nnAdresse NOT NULL
);

-- Creation de la table Emplacement
CREATE TABLE Emplacement(
      numero NUMBER(4)
      CONSTRAINT pkEmplacement PRIMARY KEY,
      longueur NUMBER(2)
      CONSTRAINT nnLongueur NOT NULL
);
  
-- Creation de la table Bateau
CREATE TABLE Bateau(
      noImm NUMBER(4)
      CONSTRAINT pkBateau PRIMARY KEY,
      nom VARCHAR2(20)
      CONSTRAINT nnNom NOT NULL,
      longueur NUMBER(2)
      CONSTRAINT nnLongueurBat NOT NULL,
      largeur NUMBER(2)
      CONSTRAINT nnLargeur NOT NULL,
      leProprietaire NUMBER(4)
      CONSTRAINT fkProprietaire NOT NULL
      REFERENCES Proprietaire(identifiant),
      CONSTRAINT uqfkProprietaire UNIQUE(leProprietaire),
      lEmp NUMBER(4)
      CONSTRAINT fkEmplacement REFERENCES Emplacement(numero),
      CONSTRAINT uqfkEmplacement UNIQUE(lEmp),
      dateD DATE,
      dateF DATE
      
);

-- Creation de la table Reservation
CREATE TABLE Reservation(
      numero NUMBER(4)
      CONSTRAINT pkReservation PRIMARY KEY,
      dateDebut DATE,
      dateFin DATE,
      leBateau NUMBER(4)
      CONSTRAINT fkBateau NOT NULL
      REFERENCES Bateau(noImm),
      lEmplacement NUMBER(4)
      CONSTRAINT fkEmplacementRes NOT NULL
      REFERENCES Emplacement(numero)
);

-- Creation des Triggers
-- Un bateau ne peut stationner dans un emplacement que si une réservation correspondante à été effectuée
/

CREATE OR REPLACE TRIGGER Statio12
BEFORE UPDATE ON Bateau
FOR EACH ROW
WHEN((NEW.lEmp IS NOT NULL) AND (NEW.dateD IS NOT NULL) AND (NEW.dateF IS NOT NULL))
DECLARE 
  nbResa NUMBER;
BEGIN
  SELECT COUNT(*) INTO nbResa
  FROM Reservation
  WHERE lEmplacement = :NEW.lEmp
  AND leBateau = :NEW.noImm
  AND dateFin = :NEW.dateF
  AND dateDebut = :NEW.dateD;
  IF (nbResa = 0) THEN
  RAISE_APPLICATION_ERROR(-20001, 'Le bateau ne peut stationner dans cet emplacement car une réservation correspondante n a pas été effectuée');
  END IF;
END;
/


-- La date de debut de reservation precède celle de fin de reservation
/
CREATE OR REPLACE TRIGGER VerDat
BEFORE INSERT OR UPDATE ON Reservation
FOR EACH ROW
WHEN((NEW.dateDebut IS NOT NULL) AND (NEW.dateFin IS NOT NULL))
BEGIN
  IF(:NEW.dateDebut > :NEW.dateFin) THEN
  RAISE_APPLICATION_ERROR(-20002, 'La date de fin ne peut pas précéder celle du début');
  END IF;
END;
/

-- Une réservation concernant un bateau, ne peut pas concerner un emplacement de longueur inférieur à celle du bateau
/
CREATE OR REPLACE TRIGGER VerLong
BEFORE INSERT OR UPDATE ON Reservation
FOR EACH ROW
DECLARE
  tailleEmp Emplacement.longueur%TYPE;
  tailleBat Bateau.longueur%TYPE;
BEGIN
  SELECT longueur INTO tailleEmp
  FROM Emplacement
  WHERE numero = :NEW.lEmplacement;
  SELECT longueur INTO tailleBat
  FROM Bateau
  WHERE noImm = :NEW.leBateau;
  IF (tailleBat > tailleEmp) THEN
  RAISE_APPLICATION_ERROR(-20003, 'La longueur du bateau est supérieur à celle de l emplacement sélectionné');
  END IF;
END;
/



-- Insertion des T-uples
-- Insertion dans la table Propriétaire
INSERT INTO Proprietaire VALUES(1, 'AUGEREAUX', 'Yan', '12 Avenue Montaigne 56000 Vannes');
INSERT INTO Proprietaire VALUES(2, 'DESCHAREAUX', 'Julian', '8 Rue de la lune 56000 Vannes');
INSERT INTO Proprietaire VALUES(3, 'BINOT', 'Justine', '21 rue des bleuets 56000 Vannes');
INSERT INTO Proprietaire VALUES(4, 'FURNO', 'Tristan', '2 rue Paul Signac 56000 Vannes');

-- Insertion dans la table Emplacement
INSERT INTO Emplacement VALUES(1, 4);
INSERT INTO Emplacement VALUES(2, 5);
INSERT INTO Emplacement VALUES(3, 12);
INSERT INTO Emplacement VALUES(4, 7);

-- Insertion dans la table Bateau
INSERT INTO Bateau VALUES(44, 'Le Libellule', 3, 1, 1, NULL, NULL, NULL);
INSERT INTO Bateau VALUES(56, 'Le Cygne', 5, 2, 2, NULL, NULL, NULL);
INSERT INTO Bateau VALUES(38, 'Le France', 10, 3, 3, NULL, NULL, NULL);
INSERT INTO Bateau VALUES(74, 'La Tournette', 4, 2, 4, NULL, NULL, NULL);

-- Insertion dans la table Reservation
INSERT INTO Reservation VALUES(1, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'), 44, 1);
INSERT INTO Reservation VALUES(2, TO_DATE('28/02/2016','DD/MM/YY'), TO_DATE('06/04/2016','DD/MM/YY'), 56, 2);
INSERT INTO Reservation VALUES(3, TO_DATE('16/10/2016','DD/MM/YY'), TO_DATE('25/12/2016','DD/MM/YY'), 38, 3);
INSERT INTO Reservation VALUES(4, TO_DATE('16/06/2016','DD/MM/YY'), TO_DATE('15/11/2016','DD/MM/YY'), 74, 4);


UPDATE Bateau SET lEmp = 1, dateD = TO_DATE('11/12/2016','DD/MM/YY'), dateF = TO_DATE('08/02/2017','DD/MM/YY') WHERE noImm = 44;
UPDATE Bateau SET lEmp = 2, dateD = TO_DATE('28/02/2016','DD/MM/YY'), dateF = TO_DATE('06/04/2016','DD/MM/YY') WHERE noImm = 56;
UPDATE Bateau SET lEmp = 3, dateD = TO_DATE('16/10/2016','DD/MM/YY'), dateF = TO_DATE('25/12/2016','DD/MM/YY') WHERE noImm = 38;
UPDATE Bateau SET lEmp = 4, dateD = TO_DATE('16/06/2016','DD/MM/YY'), dateF = TO_DATE('15/11/2016','DD/MM/YY') WHERE noImm = 74;

-- Test des triggeurs
-- Test Statio
-- Creation de T-Uples pour les tests

INSERT INTO Proprietaire VALUES(6, 'MARTEL', 'Benoit', '15 Avenue de la Republique 56000 Vannes');
INSERT INTO Emplacement VALUES(6, 8);
INSERT INTO Bateau VALUES(01, 'Le Semnoz', 6, 3, 6, NULL, NULL, NULL);
INSERT INTO Reservation VALUES(5, TO_DATE('21/12/2016','DD/MM/YY'), TO_DATE('17/02/2017','DD/MM/YY'), 01, 6);
-- Test de dateD non correspondante à une réservation
UPDATE Bateau SET lEmp = 6, dateD = TO_DATE('16/06/2016','DD/MM/YY'), dateF = TO_DATE('17/02/2016','DD/MM/YY') WHERE noImm = 01;
-- Test de dateF non correspondante à une réservation
UPDATE Bateau SET lEmp = 6, dateD = TO_DATE('21/12/2016','DD/MM/YY'), dateF = TO_DATE('18/02/2016','DD/MM/YY') WHERE noImm = 01;
-- Test de l'emplacement non correspondante à une réservation
UPDATE Bateau SET lEmp = 7, dateD = TO_DATE('21/12/2016','DD/MM/YY'), dateF = TO_DATE('17/02/2016','DD/MM/YY') WHERE noImm = 01;
-- Test du bateau non correspondant à une réservation
UPDATE Bateau SET lEmp = 6, dateD = TO_DATE('21/12/2016','DD/MM/YY'), dateF = TO_DATE('17/02/2016','DD/MM/YY') WHERE noImm = 74;

-- Test VerDate
-- Test de création de réservation avec une date début plus récente que date fin
INSERT INTO Reservation VALUES(6, TO_DATE('21/12/2017','DD/MM/YY'), TO_DATE('17/02/2017','DD/MM/YY'), 01, 5);

-- Test VerLong
-- Test de création de réservation avec emplacement plus petit que la taille du bateau
UPDATE Reservation SET lEmplacement = 1, leBateau = 38 WHERE numero = 5;




-- Test des contraintes de tables

 
-- Test de la table Proprietaire
-- Test d'unicité de clé primaire
INSERT INTO Proprietaire VALUES(1, 'MARTEL', 'Benoit', '15 Avenue de la Republique 56000 Vannes');
-- Test de non nullité de la clé primaire
INSERT INTO Proprietaire VALUES(NULL, 'MARTEL', 'Benoit', '15 Avenue de la Republique 56000 Vannes');
-- Test de non nullité de nom
INSERT INTO Proprietaire VALUES(5, NULL, 'Benoit', '15 Avenue de la Republique 56000 Vannes');
-- Test de non nullité de prenom
INSERT INTO Proprietaire VALUES(5, 'MARTEL', NULL, '15 Avenue de la Republique 56000 Vannes');
-- Test d'unicité du couple nom, prenom
INSERT INTO Proprietaire VALUES(5, 'BINOT', 'Justine', '15 Avenue de la Republique 56000 Vannes');
-- Test de non nullité de l'adresse
INSERT INTO Proprietaire VALUES(1, 'MARTEL', 'Benoit', NULL);


-- Test de la table Emplacement
-- Test d'unicité de la clé primaire
INSERT INTO Emplacement VALUES(1, 4);
-- Test de non nullité de la clé primaire
INSERT INTO Emplacement VALUES(NULL, 4);
-- Test de non nullité de la longueur
INSERT INTO Emplacement VALUES(1, NULL);


-- Test de la table Bateau
-- Insertion de T-Uples pour les tests
INSERT INTO Proprietaire VALUES(5, 'COMISSOT', 'Allan', '15 Avenue de la Republique 56000 Vannes');
INSERT INTO Emplacement VALUES(5, 7);

-- Test d'unicité de la clé primaire
INSERT INTO Bateau VALUES(44, 'Le Sorgia', 5, 1, 5, 5, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));
-- Test de non nullité de la clé primaire
INSERT INTO Bateau VALUES(NULL, 'Le Sorgia', 5, 1, 5, 5, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));
-- Test de non nullité de la longueur
INSERT INTO Bateau VALUES(73, 'Le Sorgia', NULL, 1, 5, 5, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));
-- Test de non nullité de la largueur
INSERT INTO Bateau VALUES(73, 'Le Sorgia', 5, NULL, 5, 5, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));
-- Test de non nullité du propriétaire
INSERT INTO Bateau VALUES(73, 'Le Sorgia', 5, 1, NULL, 5, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));
-- Test d'unicité du propriétaire
INSERT INTO Bateau VALUES(73, 'Le Sorgia', 5, 1, 1, 5, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));
-- Test d'unicité de l'emplacement
INSERT INTO Bateau VALUES(73, 'Le Sorgia', 5, 1, 5, 1, TO_DATE('11/12/2016','DD/MM/YY'), TO_DATE('08/02/2017','DD/MM/YY'));


-- Test de la table Reservation
-- Test d'unicité de la clé primaire
INSERT INTO Reservation VALUES(4, TO_DATE('16/06/2016','DD/MM/YY'), TO_DATE('15/11/2016','DD/MM/YY'), 74, 4);
-- Test de non nullité de la clé primaire
INSERT INTO Reservation VALUES(NULL, TO_DATE('16/06/2016','DD/MM/YY'), TO_DATE('15/11/2016','DD/MM/YY'), 74, 4);
-- Test de non nullité du bateau
INSERT INTO Reservation VALUES(5, TO_DATE('16/06/2016','DD/MM/YY'), TO_DATE('15/11/2016','DD/MM/YY'), NULL, 4);
-- Test de non nullité de l'emplacement
INSERT INTO Reservation VALUES(5, TO_DATE('16/06/2016','DD/MM/YY'), TO_DATE('15/11/2016','DD/MM/YY'), 74, NULL);

