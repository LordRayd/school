/*===========================================EXERCICE 1=====================*/
homme(albert).
homme(jean).
homme(paul).
homme(bertrand).
homme(louis).
homme(benoit).
femme(germaine).
femme(christiane).
femme(simone).
femme(marie).
femme(sophie).
femme(cindy).
pere(albert,jean).
pere(jean,paul).
pere(paul,bertrand).
pere(paul,sophie).
pere(jean,cindy).
pere(jean,simone).
pere(louis,benoit).
mere(germaine,jean).
mere(christiane,simone).
mere(christiane,paul).
mere(christiane,cindy).
mere(simone,benoit).
mere(marie,bertrand).
mere(marie,sophie).
parent(X,Y) :- mere(X,Y); pere(X,Y).
fils(X,Y):- homme(X), (mere(Y,X); pere(Y,X)). /* vrai si X est le fils de Y */
fille(X,Y):- femme(X), (mere(Y,X); pere(Y,X)).
grandpere(X,Y):- pere(X,Z), parent(Z,Y).
grandmere(X,Y):- mere(X,Z), parent(Z,Y).
frere(X,Y):- homme(X), pere(P,X), pere(P,Y), mere(M,X),mere(M,Y), X\== Y.
soeur(X,Y):- femme(X), pere(P,X), pere(P,Y), mere(M,X),mere(M,Y), X\== Y.
freresoeur(X,Y) :- frere(X,Y);soeur(X,Y).

homme(paul) 
/* true*/
femme(benoit). 
/* false*/
homme(X) 
/*
    X = albert
    X = jean
    X = paul
    X = bertrand
    X = louis
    X = benoit
*/
femme(X)
/**
    X = germaine
    X = christiane
    X = simone
    X = marie
    X = sophie
    X = cindy
*/
mere(marie,sophie)
/* true */
mere(marie,benoit).
/* false*/
mere(X,jean).
/* X = germaine */
pere(paul,X).
/* 
    X = bertrand
    X = sophie
*/
homme(X),pere(X,Y).
/*
    X = albert,
    Y = jean
    X = jean,
    Y = paul
    X = jean,
    Y = cindy
    X = jean,
    Y = simone
    X = paul,
    Y = bertrand
    X = paul,
    Y = sophie
    X = louis,
    Y = benoit
*/

/*======================================= EXERCICE 2 ==========================*/
mortel(X) :- homme(X).
homme(socrate).

mortel(socrate).
/* true */

/*======================================= EXERCICE 3 ==========================*/
fact(0,1).
fact(X,Y):- X > 0,XP is X-1, fact(XP,R), Y is X * R.

belong(X,[X]).
belong(X,Y):- Y=[H|T], (   belong(X,H); belong(X,T)).

belongCount(X,[],0).
belongCount(X,[X|L],A) :- belongCount(X,L,A1), A is A1+1.
belongCount(X,[T|L],A) :-belongCount(X,L,A), X \==T.


/*=========================================== Soluce 1 ==========================*/
mydelete(L,X,L1) :- append(L3,L4,L), append(L2,[X],L3), append(L2,L4,L1).

/*=========================================== Soluce 2 ==========================*/
mydelete([X|Q],X,Q).
mydelete([Y|Q],X,[Y|Q1]) :- mydelete(Q,X,Q1).

mydeleteall([],_,[]).
mydeleteall([X|Q],X,Q1) :- mydeleteall(Q,X,Q1),!.
mydeleteall([Y|Q],X,[Y|Q1]) :- mydeleteall(Q,X,Q1).