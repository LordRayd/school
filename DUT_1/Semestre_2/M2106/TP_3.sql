DROP TABLE Reservation;
DROP TABLE Emplacement;
DROP TABLE Bateau;
DROP TABLE Proprietaire;

CREATE TABLE Proprietaire(
	identifiant NUMBER(4)
	CONSTRAINT pkIdentifiant PRIMARY KEY,
	nom VARCHAR2(20),
	prenom VARCHAR2(20),
	CONSTRAINT uqPropriétaire UNIQUE (nom,prenom),
	adresse VARCHAR2(40)
	CONSTRAINT nnAdresse NOT NULL);
	
CREATE TABLE Bateau(
	noImm NUMBER(4)
	CONSTRAINT pkNoImmo PRIMARY KEY,
	nom VARCHAR2(20),
	longueur NUMBER(2),
	largeur NUMBER(2),
	noProprio NUMBER(4)
	CONSTRAINT fkProprietaire NOT NULL
	REFERENCES Proprietaire(identifiant));
	
CREATE TABLE Emplacement(
	numero NUMBER(4)
	CONSTRAINT pkNumeroE PRIMARY KEY,
	longueur NUMBER(2),
	noBat NUMBER(4)
	CONSTRAINT fkBateauE NOT NULL
	REFERENCES Bateau(noImm),
	dateDebut DATE,
	dateFin DATE);

CREATE TABLE Reservation(
	numero NUMBER(4)
	CONSTRAINT pkNumeroR PRIMARY KEY,
	dateDebut DATE,
	dateFin DATE,
	noBat NUMBER(4)
	CONSTRAINT fkBateauR NOT NULL
	REFERENCES Bateau(noImm),
	noEmp  NUMBER(4)
	CONSTRAINT fkEmplacement NOT NULL
	REFERENCES Emplacement(numero));
	
INSERT INTO Proprietaire VALUES (1,'BINOT','Justine','12 rue les bleuets 56000 Vannes'); -- OK
INSERT INTO Proprietaire VALUES (2,'BINOT','Justine','12 rue les bleuets 56000 Vannes'); -- violation de l'unicité (nom,prenom)
INSERT INTO Proprietaire VALUES (1,'BASTARD','Gauthier','31 rue mimosa 56000 Vannes'); -- violation de la cle primaire unique
INSERT INTO Proprietaire VALUES (NULL,'BASTARD','Gauthier','31 rue mimosa 56000 Vannes'); -- violation de la cle primaire non-null
INSERT INTO Proprietaire VALUES (4,'BASTARD','Gauthier',NULL); -- violation de la non nullité de l'adresse
INSERT INTO Proprietaire VALUES (3,'SATTLER','Donatien','1 squarre des venètes 56000 Vannes'); -- OK

INSERT INTO Bateau VALUES (1,'bateau1',12,4,1); -- OK
INSERT INTO Bateau VALUES (1,'bateau2',12,4,3); -- Violation cle primaire noImm unique
INSERT INTO Bateau VALUES (NULL,'bateau2',12,4,3); -- Violation cle primaire noImm non-null
INSERT INTO Bateau VALUES (2,'bateau3',12,4,54); -- violation cle noProprio pas trouve dans la table Proprietaire
INSERT INTO Bateau VALUES (2,'bateau3',12,4,NULL); -- violation cle noProprio non-null
INSERT INTO Bateau VALUES (3,'bateau4',6,4,3); -- OK

INSERT INTO Emplacement VALUES (1,12,1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy')); -- OK
INSERT INTO Emplacement VALUES (1,12,1,TO_DATE('20/11/2015','dd/mm/yyyy'),TO_DATE('08/12/2015','dd/mm/yyyy')); -- violation de la cle primaire numero unique
INSERT INTO Emplacement VALUES (NULL,12,1,TO_DATE('20/11/2015','dd/mm/yyyy'),TO_DATE('08/12/2015','dd/mm/yyyy')); -- violation de la cle primaire numero non-null
INSERT INTO Emplacement VALUES (2,12,12,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy')); -- violation cle noBat pas trouve dans la table Bateau
INSERT INTO Emplacement VALUES (2,12,NULL,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy')); -- violation cle noBat non-null
INSERT INTO Emplacement VALUES (3,12,3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy')); -- OK

INSERT INTO Reservation VALUES (1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,1); -- OK
INSERT INTO Reservation VALUES (1,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,1); -- violation de la cle primaire numero unique
INSERT INTO Reservation VALUES (NULL,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,1); -- violation de la cle primaire numero non-null
INSERT INTO Reservation VALUES (2,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),12,1); -- violation cle noBat pas trouve dans la table Bateau
INSERT INTO Reservation VALUES (2,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),NULL,1); -- violation cle noBat non-nul
INSERT INTO Reservation VALUES (3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,12); -- violation cle noEmp pas trouve dans la table Emplacement
INSERT INTO Reservation VALUES (3,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),1,NULL); -- violation cle noEmp non-null
INSERT INTO Reservation VALUES (4,TO_DATE('01/08/2013','dd/mm/yyyy'),TO_DATE('03/08/2013','dd/mm/yyyy'),3,3); -- OK
