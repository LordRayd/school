DROP TABLE affectation;
DROP TABLE avion;
DROP TABLE appareil;
DROP TABLE pilote;
DROP TABLE vol;

CREATE TABLE vol(
  idVol VARCHAR2(6)
  CONSTRAINT volClePrim PRIMARY KEY,
  villeDepart VARCHAR2(20)
  CONSTRAINT volVilleDepNotNull NOT NULL,
  villeArrivee VARCHAR2(20)
  CONSTRAINT volVilleArrNotNull NOT NULL,
  heureDepart NUMBER(10,2)
  CONSTRAINT volHeureDep0_24 CHECK (heureDepart >= 0 AND heureDepart < 24),
  heureArrivee   NUMBER(10,2)
  CONSTRAINT volHeureArr0_24 CHECK (heureArrivee >= 0 AND heureArrivee < 24),
  decalage NUMBER(3) DEFAULT 0,
  jour NUMBER(1) DEFAULT 0
  CONSTRAINT volJourDecal CHECK (jour = 0 OR jour = 1)
);

CREATE TABLE pilote(
  idPilote VARCHAR2(4)
  CONSTRAINT piloteClePrim PRIMARY KEY,
  nomPilote VARCHAR2(30)
  CONSTRAINT piloteNomNotNull NOT NULL,
  adrPilote VARCHAR2(40),
  salairePilote NUMBER(10,2)
  CONSTRAINT piloteSalairePositif CHECK (salairePilote > 0),
  embauchePilote DATE
  CONSTRAINT piloteEmbaucheNotNull NOT NULL
);

CREATE TABLE appareil(
  typeAppareil VARCHAR2(3)
  CONSTRAINT appareilClePrim PRIMARY KEY,
  capacite NUMBER
  CONSTRAINT appareilCapaciteNotNull NOT NULL,
  designation VARCHAR2(40)
);

CREATE TABLE avion(
  idAvion VARCHAR2(4)
  CONSTRAINT avionClePrim PRIMARY KEY,
  typeAppareil VARCHAR2(3),
  CONSTRAINT avionCleEtrangtypeAppareil
  FOREIGN KEY (typeAppareil) REFERENCES appareil(typeAppareil),
  miseEnService NUMBER
  CONSTRAINT avionServiceNotNull NOT NULL
);

CREATE TABLE affectation(
  idVol VARCHAR2(6),
  CONSTRAINT affectationCleEtrangIdVol
  FOREIGN KEY (idVol) REFERENCES vol(idVol),
  dateVol DATE,
  CONSTRAINT affectationClePrim PRIMARY KEY (idVol,dateVol),
  idPilote VARCHAR2(4),
  CONSTRAINT affectationCleEtrangIdPilote
  FOREIGN KEY (idPilote) REFERENCES pilote(idPilote),
  idAvion VARCHAR2(4),
  CONSTRAINT affectationCleEtrangIdAvion
  FOREIGN KEY (idAvion) REFERENCES avion(idAvion)
);
