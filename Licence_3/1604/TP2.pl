/*=============================================================================*/
/*================================== Samuel LE BERRE ==========================*/
/*=============================================================================*/

/*village([[M1,N1,B1,A1,C1,E1],[M2,N2,B2,A2,C2,E2],[M3,N3,B3,A3,C3,E3],[M4,N4,B4,A4,C4,E4],[M5,N5,B5,A5,C5,E5]]).*/


[_,anglais,_,_,rouge,_]
[_,espagnol,_,chien,_,_]
[acrobate,japonais,_,_,_,_]
[_,_,cafe,_,verte,_]
[_,ukrainien,the,_,_,_]
[sculteur,_,_,escargot,_,_]
[diplomate,_,_,_,jaune,_]
[_,_,lait,_,_,3]
[_,norvegien,_,_,_,1]
[_,_,_,_,bleue,2]
[medecin,_,_,_,_,_]
[violoniste,_,jusdorange,_,_,_]
[_,_,eau,_,_,_]
[_,_,_,cheval,_,_]
[_,_,_,renard,_,_]
[_,_,_,zebre,_,_]
[_,_,_,_,blanche,_]

voisin([M1,N1,B1,A1,C1,E1],[M2,N2,B2,A2,C2,E2]) :- X is E2-1, Y is E2+1, ( E1==X ; E1===Y).
voisin([medecin,N1,B1,A1,C1,E1],[M2,N2,B2,renard,C2,E2]).
voisin([diplomate,N1,B1,A1,C1,E1],[M2,N2,B2,cheval,C2,E2]).
voisin([norvegien,N1,B1,A1,C1,E1],[M2,N2,B2,A2,bleue,E2]).
voisin([M1,N1,cafe,A1,verte,E1],[M2,N2,B2,A2,blanche,E2]).




/*--------- pas possible -----------*/
[_,norvegien,_,_,bleue,_]
[_,norvegien,_,_,rouge,_]
[diplomate,_,_,cheval,_,_]
[medecin,_,_,renard,_,_]
[_,_,_,_,_,_]

/* ------------ soluce ----------------*/
[diplomate,norvegien,_,_,jaune,1]
[_,_,_,_,bleue,2]
[_,_,lait,_,_,3]
[_,_,_,_,_,4]
[_,_,_,_,_,5]