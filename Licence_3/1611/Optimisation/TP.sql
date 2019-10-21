-- AllRows : retourne le plus rapide tous les soluces.
-- FirstRows : les premiers accessible le plus rapides. 
-- Rule : mode regle du sgbd appliqué meme si pas opti
-- Choose : se comporte generalement comme Rule


DELETE FROM paln_table;
EXPLAIN PLAN
SET statement_id = R1
FOR
SELECT count(*) FROM salaries;
COMMIT ;

SELECT operation, options, id, parent_id, object_name
FROM plan_table
WHERE statement_id = R1
ORDER BY id;


DELETE FROM plan_table;
EXPLAIN PLAN
SET statement_id = 'R2'
FOR
SELECT count(*) FROM salaries;
COMMIT ;

SELECT operation, options, id, parent_id, object_name
FROM plan_table
WHERE statement_id = 'R2'
ORDER BY id;

SELECT optimizer FROM plan_table
WHERE statement_id = 'R2';

ALTER SESSION SET OPTIMIZER_MODE='ALL_ROWS';

CREATE INDEX idxIdSalarieSalarie ON salaries (idSalarie)

ALTER TABLE salaries ADD CONSTRAINT pkSalarieIdSalaire PRIMARY KEY (idSalarie);


-- Parcours l'index pkSalaireIdSalaires et se possitionner sur la feuille tell que Salaire.idSalaire = 5000;
-- /* acceder au t-uples ASal de salaries
-- Aq ASalaire.idSalaire = 5000 */
-- read(ASal)
-- get(TSal)
-- R := R + <tSal>

-- Parcours index idxEname et se positionner qur la feulle tels que salarie.ename = 'Scott';
-- /*acceder au t-uple tSal de la table salarie tels que tSal.ename = Scott */
-- pour chaque t-uples tSal tels que ename = Scott faire 
-- read(tSal)
-- get(TSal)
-- Ri = R + <Sal>
-- fpour