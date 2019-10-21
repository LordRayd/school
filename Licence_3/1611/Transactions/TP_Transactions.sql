éINSERT INTO articleTest VALUES (6, 'ciseaux',10.5,200) ;
DELETE FROM articleTest WHERE idArticle=1;
UPDATE articleTest SET prixunit=prixunit*2 WHERE idArticle=2 ;
SELECT * FROM articleTest;
RollBACK;
SELECT * FROM articleTest;

GRANT SELECT, INSERT, UPDATE, DELETE ON articleTest TO E1603727;
SELECT * FROM E1603727.articleTest;
LOCK TABLE articleTest IN EXCLUSIVE MODE;


INSERT INTO E1603727.articleTest VALUES (6, 'ciseaux',10.5,200) ;
DELETE FROM articleTest WHERE idArticle=1;
UPDATE E1603727.articleTest SET prixunit=prixunit*2 WHERE idArticle=3 ;
SELECT * FROM E1603727.articleTest;
SELECT * FROM articleTest;
COMMIT;
LOCK TABLE E1603727.articleTest IN SHARE MODE;
UPDATE articleTest SET prixunit=prixunit*2 WHERE idArticle=2 ;
SELECT object_id FROM dba_objects WHERE object_name='articleTest';


ROllBAck;
