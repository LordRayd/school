/** Samuel LE BERRE*/

/* ============ Exercice 1 =============== */
/* ------------ Question 1 --------------- */
mange(tobby,souris). 
/*tobis mange souris*/
mange(simba,chenille).
mange(marguerite,herbe).
animal(chenille).
animal(souris).
vegetal(herbe).
predateur(X):- animal(Y),mange(X,Y).

/* Partie 2 */
predateur(X)
/* X = simba
X = tobby*/

/* Partie 3 */
mange(X,chenille)
/* X = simba*/

/* Partie 4 */
mange(_,Y),animal(Y)
/* Y = souris
Y = chenille*/


/* ------------ Question 2 --------------- */
afficher(0):- write(0).
afficher(X):- Y is X-1, afficher(Y), nl(), write(X). 
lire(X):- write(X).
boucle:- read(X), lire(X), X\=='q', boucle.


/* ------------ Question 3 --------------- */
triple([],[]).
triple([H|T],[H2|T2]):- H2 is H*3, triple(T,T2).



/* ============ Exercice 1 =============== */
traducteur([],C):- C is 0.
traducteur('zero',C):- C is 0.
traducteur('un',C):- C is 1.
traducteur('deux',C):- C is 2.
traducteur('trois',C):- C is 3.
traducteur('quatre',C):- C is 4.
traducteur('cinq',C):- C is 5.
traducteur('six',C):- C is 6.
traducteur('sept',C):- C is 7.
traducteur('huit',C):- C is 8.
traducteur('neuf',C):- C is 9.
traducteur('dix',C):- C is 10.
traducteur('onze',C):- C is 11.
traducteur('douze',C):- C is 12.
traducteur('treize',C):- C is 13.
traducteur('quatorze',C):- C is 14.
traducteur('quinze',C):- C is 15.
traducteur('seize',C):- C is 16.
traducteur('vingt',C):- C is 20.
traducteur('trente',C):- C is 30.
traducteur('quarante',C):- C is 40.
traducteur('cinquante',C):- C is 50.
traducteur('soixante',C):- C is 60.
traducteur('cent',C):- C is 100.


traducteur([H,H2|T],C):- (H2 == 'vingt'; H2 == 'cent'), traducteur(H,C1), traducteur(H2,C2), C3 is C1 * C2,traducteur(T,C4),C is C4+C3.
traducteur([H|T],C):- traducteur(H,C1), traducteur(T,C2), C is C1 + C2.

