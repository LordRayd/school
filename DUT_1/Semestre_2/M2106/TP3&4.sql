-- SUPRESSION DES TABLES EXISTANTES =========================================================================================================================================
DROP TABLE Reservation;
DROP TABLE Bateau;
DROP TABLE Emplacement;
DROP TABLE Proprietaire;


-- CREATION DES TABLES ======================================================================================================================================================
CREATE TABLE Proprietaire(
  identifiant NUMBER(4)
  CONSTRAINT pkProprietaire PRIMARY KEY,
  nom VARCHAR2(20)
  CONSTRAINT nnNomP NOT NULL,
  prenom VARCHAR2(20)
  CONSTRAINT nnPrenomP NOT NULL,
  CONSTRAINT uqProprietaire UNIQUE (nom, prenom),
  adresse VARCHAR2(40)
  CONSTRAINT nnAdresse NOT NULL);
  
CREATE TABLE Emplacement(
  numero NUMBER(4)
  CONSTRAINT pkEmplacement PRIMARY KEY,
  longueur NUMBER(2)
  CONSTRAINT nnLongueurE NOT NULL);  

CREATE TABLE Bateau(
  noImm NUMBER(4)
  CONSTRAINT pkBateau PRIMARY KEY,
  nom VARCHAR2(20)
  CONSTRAINT nnNomB NOT NULL,
  longueur NUMBER(2)
  CONSTRAINT nnLongueurB NOT NULL,
  largeur NUMBER(2)
  CONSTRAINT nnLargeurB NOT NULL,
  leProprietaire NUMBER(4)
  CONSTRAINT fkProprietaire NOT NULL
  REFERENCES Proprietaire(identifiant),
  CONSTRAINT uqfkProprietaire UNIQUE(leProprietaire),
  lEmp NUMBER(4)
  CONSTRAINT fkEmplacement REFERENCES Emplacement(numero),
  CONSTRAINT uqfkEmplacement UNIQUE(lEmp),
  dateD DATE,
  dateF DATE);

CREATE TABLE Reservation(
  numero NUMBER(4)
  CONSTRAINT pkReservation PRIMARY KEY,
  dateDebut DATE,
  dateFin DATE,
  leBateau NUMBER(4)
  CONSTRAINT fkBateau NOT NULL
  REFERENCES Bateau(noImm),
  lEmplacement NUMBER(4)
  CONSTRAINT fkEmplacementR NOT NULL
  REFERENCES Emplacement(numero));


-- DEBUT TEST DES CONTRAINTES DES TABLES =====================================================================================================================================

-- Test contrainte table Proprietaire
INSERT INTO Proprietaire VALUES (1,'BINOT','Justine','12 rue les bleuets 56000 Vannes');          -- OK
INSERT INTO Proprietaire VALUES (3,'SATTLER','Donatien','1 squarre des venètes 56000 Vannes');    -- OK
INSERT INTO Proprietaire VALUES (4,'COMISSO','Alan','1 squarre des venètes 56000 Vannes');        -- OK
INSERT INTO Proprietaire VALUES (5,'FURNO','Tristan','1 squarre des venètes 56000 Vannes');       -- OK
INSERT INTO Proprietaire VALUES (6,'NICOLLE','Malo','1 squarre des venètes 56000 Vannes');        -- OK
INSERT INTO Proprietaire VALUES (7,'COMTE','Adrien','1 squarre des venètes 56000 Vannes');        -- OK
INSERT INTO Proprietaire VALUES (8,'LORANS','Gurvan','1 squarre des venètes 56000 Vannes');       -- OK

INSERT INTO Proprietaire VALUES (2,'BINOT','Justine','12 rue les bleuets 56000 Vannes');          -- violation de l'unicité (nom,prenom)

INSERT INTO Proprietaire VALUES (1,'BASTARD','Gauthier','31 rue mimosa 56000 Vannes');            -- violation de la cle primaire unique
INSERT INTO Proprietaire VALUES (NULL,'BASTARD','Gauthier','31 rue mimosa 56000 Vannes');         -- violation de la cle primaire non-null

INSERT INTO Proprietaire VALUES (4,'BASTARD','Gauthier',NULL);                                    -- violation de la non nullité de l'adresse



-- Test contrainte table Emplacement
INSERT INTO Emplacement VALUES (1,12);      -- OK
INSERT INTO Emplacement VALUES (3,12);      -- OK

INSERT INTO Emplacement VALUES (1,12);      -- violation de la cle primaire numero unique
INSERT INTO Emplacement VALUES (NULL,12);   -- violation de la cle primaire numero non-null

INSERT INTO Emplacement VALUES (2,NULL);    -- violation longueur non-null



-- Test contrainte table Bateau
INSERT INTO Bateau VALUES (1,'bateau1',12,4,1,1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));     -- OK
INSERT INTO Bateau VALUES (3,'bateau4',6,4,3,3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));      -- OK

INSERT INTO Bateau VALUES (1,'bateau2',12,4,4,1,TO_DATE('20/11/2015','dd/mm/yyyy'),TO_DATE('08/12/2015','dd/mm/yyyy'));     -- Violation cle primaire noImm unique
INSERT INTO Bateau VALUES (NULL,'bateau2',12,4,5,1,TO_DATE('20/11/2015','dd/mm/yyyy'),TO_DATE('08/12/2015','dd/mm/yyyy'));  -- Violation cle primaire noImm non-null

INSERT INTO Bateau VALUES (4,'bateau3',12,4,54,1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));    -- violation cle leP pas trouve dans la table Proprietaire
INSERT INTO Bateau VALUES (5,'bateau3',12,4,NULL,3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));  -- violation cle leP non-null
INSERT INTO Bateau VALUES (6,'bateau3',12,4,1,1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));     -- violation cle leP unique

INSERT INTO Bateau VALUES (7,'bateau3',12,4,6,54,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));    -- violation cle lEmp pas trouve dans la table Emplacement
INSERT INTO Bateau VALUES (8,'bateau3',12,4,7,NULL,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));  -- violation cle lEmp non-null
INSERT INTO Bateau VALUES (9,'bateau3',12,4,8,1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'));     -- violation cle lEmp unique



-- Test contrainte table Reservation
INSERT INTO Reservation VALUES (1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,1);     -- OK
INSERT INTO Reservation VALUES (4,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),3,3);     -- OK

INSERT INTO Reservation VALUES (1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,1);     -- violation de la cle primaire numero unique
INSERT INTO Reservation VALUES (NULL,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,1);  -- violation de la cle primaire numero non-null

INSERT INTO Reservation VALUES (2,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),12,1);    -- violation cle leBateau pas trouve dans la table Bateau
INSERT INTO Reservation VALUES (2,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),NULL,1);  -- violation cle leBateau non-nul

INSERT INTO Reservation VALUES (3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,12);    -- violation cle lEmplacement pas trouve dans la table Emplacement
INSERT INTO Reservation VALUES (3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,NULL);  -- violation cle lEmplacement non-null


-- FIN TEST DES CONTRAINTES DES TABLES  =====================================================================================================================================

-- CREATION DES TRIGGERS ====================================================================================================================================================
CREATE OR REPLACE TRIGGER VerifStat
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
  RAISE_APPLICATION_ERROR(-20001, 'Le bateau n a pas reserve cet emplacement');
  END IF;
END;
/

/
CREATE OR REPLACE TRIGGER VerifDate
BEFORE INSERT OR UPDATE ON Reservation
FOR EACH ROW
WHEN((NEW.dateDebut IS NOT NULL) AND (NEW.dateFin IS NOT NULL))
BEGIN
  IF(:NEW.dateDebut > :NEW.dateFin) THEN
  RAISE_APPLICATION_ERROR(-20002, 'La Date du début de la réservation ne peut etre supérieur à la date de Fin');
  END IF;
END;
/

/
CREATE OR REPLACE TRIGGER VerifLong
BEFORE INSERT OR UPDATE ON Reservation
FOR EACH ROW
DECLARE
  tailleEmp Emplacement.longueur%TYPE;
  tailleBat Bateau.longueur%TYPE;
BEGIN
  SELECT longueur INTO tailleEmp
  FROM Emplacement
  WHERE numero = :NEW.noEmp;
  SELECT longueur INTO tailleBat
  FROM Bateau
  WHERE noImm = :NEW.noBat;
  IF (tailleBat > tailleEmp) THEN
  RAISE_APPLICATION_ERROR(-20003, 'Le Bateau est plus grand que l emplacement');
  END IF;
END;
/

-- DEBUT TEST DES TRIGGERs ====================================================================================================================================================

-- Creation de t-uples afin de les utiliser dans les Tests
INSERT INTO Proprietaire VALUES(9,'BARRE','Samuel','1 squarre des venètes 56000 Vannes');
INSERT INTO Proprietaire VALUES(10,'MARTIN','Simon','1 squarre des venètes 56000 Vannes');
INSERT INTO Emplacement VALUES(4,15);
INSERT INTO Bateau VALUES(10,'Bateau10',10,4,9,NULL,NULL,NULL);
INSERT INTO Bateau VALUES(11,'Bateau11',20,6,10,NULL,NULL,NULL);
INSERT INTO Reservation VALUES(5,TO_DATE('10/02/2017','dd/mm/yyyy'),TO_DATE('26/02/2017','dd/mm/yyyy'),10,6);

-- Test VerifStat
UPDATE Bateau SET lEmp=4,dateD=TO_DATE('09/02/2017','dd/mm/yyyy'),dateF=TO_DATE('26/02/2017','dd/mm/yyyy') WHERE noImm=10;  -- Test DateD pas une dateDebut de reservation
UPDATE Bateau SET lEmp=4,dateD=TO_DATE('10/02/2017','dd/mm/yyyy'),dateF=TO_DATE('27/02/2017','dd/mm/yyyy') WHERE noImm=10;  -- Test DateF pas une dateFin de reservation
UPDATE Bateau SET lEmp=5,dateD=TO_DATE('10/02/2017','dd/mm/yyyy'),dateF=TO_DATE('26/02/2017','dd/mm/yyyy') WHERE noImm=10;  -- Test lEmp pas un emplacement de reservation
UPDATE Bateau SET lEmp=4,dateD=TO_DATE('10/02/2017','dd/mm/yyyy'),dateF=TO_DATE('26/02/2017','dd/mm/yyyy') WHERE noImm=54;  -- Test noImm pas un numero de reservation

-- Test VerifDate
INSERT INTO Reservation VALUES(6,TO_DATE('26/02/2017','dd/mm/yyyy'),TO_DATE('10/02/2017','dd/mm/yyyy'),10,4); -- Test dateDebut > dateFin

-- Test VerifLong
UPDATE Reservation SET lEmplacement=4,leBateau=11 WHERE numero=5; -- Test longueur Emplacement < longueur bateau

-- FIN TEST DES TRIGGERS =====================================================================================================================================================