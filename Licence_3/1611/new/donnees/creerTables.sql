DROP TABLE affectation;
DROP TABLE avion;
DROP TABLE appareil;
DROP TABLE pilote;
DROP TABLE vol;

CREATE TABLE vol
(
idVol          VARCHAR2(6),
villeDepart    VARCHAR2(20)
               CONSTRAINT volVilleDepNotNull NOT NULL,
villeArrivee   VARCHAR2(20)
               CONSTRAINT volVilleArrNotNull NOT NULL,
heureDepart    NUMBER(10,2)
               CONSTRAINT volHeureDep0_24 CHECK (heureDepart >= 0 AND heureDepart < 24),
heureArrivee   NUMBER(10,2)
               CONSTRAINT volHeureArr0_24 CHECK (heureArrivee >= 0 AND heureArrivee < 24),
decalage       NUMBER(3) DEFAULT 0,
jour           NUMBER(1) DEFAULT 0
               CONSTRAINT volJourDecal CHECK (jour = 0 OR jour = 1 OR jour = -1),
CONSTRAINT volClePrim PRIMARY KEY (idVol)
);

CREATE TABLE pilote
(
idPilote       VARCHAR2(4),
nomPilote      VARCHAR2(30)
               CONSTRAINT piloteNomNotNull NOT NULL,
adrPilote      VARCHAR2(40),
salairePilote  NUMBER(10,2)
               CONSTRAINT piloteSalairePositif CHECK (salairePilote > 0),
embauchePilote DATE
               CONSTRAINT piloteEmbaucheNotNull NOT NULL,
CONSTRAINT piloteClePrim PRIMARY KEY (idPilote)
);

CREATE TABLE avion
(
idAvion        VARCHAR2(4),
typeAppareil   VARCHAR2(3),
miseEnService  NUMBER
               CONSTRAINT avionServiceNotNull NOT NULL,
CONSTRAINT avionClePrim PRIMARY KEY (idAvion)
);

-- ========================= MoI =============================

CREATE TABLE appareil(
  typeAppareil VARCHAR2(3),
  capacite NUMBER
  CONSTRAINT appareilCapacite CHECK (capacite >= 0)
  CONSTRAINT appareilCapaciteNotNull NOT NULL,
  designation VARCHAR2(40),
  CONSTRAINT appareilClePrim PRIMARY KEY(typeAppareil)
);

CREATE TABLE affectation(
  idVol VARCHAR2(6),
  dateVol DATE,
  idPilote VARCHAR2(4),
  idAvion VARCHAR2(4),
  nbPassagers NUMBER DEFAULT 0
  CONSTRAINT affectationNbPassager CHECK (nbPassagers >= 0),
  CONSTRAINT affectationClePrim PRIMARY KEY (idVol,dateVol)
);

ALTER TABLE avion
ADD CONSTRAINT avionCleEtrangtypeAppareil
    FOREIGN KEY (typeAppareil)
    REFERENCES appareil(typeAppareil);

ALTER TABLE affectation
ADD CONSTRAINT affectationCleEtrangIdVol
    FOREIGN KEY (idVol)
    REFERENCES vol(idVol);

ALTER TABLE affectation
ADD CONSTRAINT affectationCleEtrangIdAvion
    FOREIGN KEY (idAvion)
    REFERENCES avion(idAvion);

ALTER TABLE affectation
ADD CONSTRAINT affectationCleEtrangIdPilote
FOREIGN KEY (idPilote)
REFERENCES pilote(idPilote);


-- QUESTION 3
CREATE OR REPLACE TRIGGER T_Avionpassager
BEFORE INSERT OR UPD+-ATE ON affectation
FOR EACH ROW
DECLARE
    num NUMBER;
BEGIN
SELECT typeAppareil INTO typeAppareil
FROM avion
WHERE idAvion = :NEW.idAvion;
SELECT capacite into num
FROM appareil
WHERE typeAppareil = typeApp;
  --SELECT capacite INTO num
  --FROM appareil, avion
--  WHERE :NEW.idAvion = avion.idAvion
  --AND appareil.typeAppareil = avion.typeAppareil;
  IF (num < :NEW.nbPassagers) THEN
    RAISE_APPLICATION_ERROR(-20001,'Avion pas assez grand');
  END IF;
END;
/
INSERT INTO affectation VALUES ('AF8810', TO_DATE('2018/04/21', 'yyyy/mm/dd'),'0001', '8802', 170);

ALTER TABLE avion ADD nbHeuresVol NUMBER(10,2);
ALTER TABLE avion ADD CONSTRAINT nbHeuresVolPositif CHECK (nbHeuresVol >= 0);
ALTER TABLE vol ADD dureeVol NUMBER(10,2);

CREATE OR REPLACE PROCEDURE avionDuree AS
BEGIN
  LOOP
    UPDATE avion SET dureeVol=duree WHERE idVol=id;
  END LOOP;
END;
/