/*M1 voisin de droite de M2 (E=emplacement)*/
voisin(M1,M2,L) :- member(M1,L), append(_,[E1],M1), E1>1, append(_,[E2],M2), E2 is E1-1, member(M2,L).
/*M1 voisin de gauche de M2 (E=emplacement)*/
voisin(M1,M2,L) :- member(M1,L), append(_,[E1],M1), E1<5, append(_,[E2],M2), E2 is E1+1, member(M2,L).
/*M1 voisin de droite de M2 (E=emplacement)*/
droite(M1,M2,L) :- member(M1,L), append(_,[E1],M1), E1>1, append(_,[E2],M2), E2 is E1-1, member(M2,L).

/* Sans append:
voisin([X1,X2,X3,X4,X5,E1],[Y1,Y2,Y3,Y4,Y5,E2],L) :- member([X1,X2,X3,X4,X5,E1],L), E1>1, E2 is E1-1, member([Y1,Y2,Y3,Y4,Y5,E2],L).
voisin([X1,X2,X3,X4,X5,E1],[Y1,Y2,Y3,Y4,Y5,E2],L) :- member([X1,X2,X3,X4,X5,E1],L), E1<5, E2 is E1+1, member([Y1,Y2,Y3,Y4,Y5,E2],L).
droite([X1,X2,X3,X4,X5,E1],[Y1,Y2,Y3,Y4,Y5,E2],L) :- member([X1,X2,X3,X4,X5,E1],L), E1<5, E2 is E1+1, member([Y1,Y2,Y3,Y4,Y5,E2],L).*/

village(L) :- 
    	member([         _,  anglais,        _,       _,rouge,_], L),
		member([  acrobate, japonais,        _,       _,    _,_], L),
		member([         _, espagnol,        _,   chien,    _,_], L),
		member([         _,        _,     cafe,       _,verte,_], L),
		member([         _,ukrainien,      the,       _,    _,_], L),
		member([ sculpteur,        _,        _,escargot,    _,_], L),
		member([ diplomate,        _,        _,       _,jaune,_], L),
		member([         _,        _,     lait,       _,    _,3], L),
		member([         _,norvegien,        _,       _,    _,1], L),
		member([   medecin,        _,        _,       _,    _,_], L),
		member([violoniste,        _,jusOrange,       _,    _,_], L),
		member([         _,        _,        _,       _,bleue,_], L),
        member([         _,        _,      eau,       _,    _,_], L),
        member([         _,        _,        _,   zebre,    _,_], L),
        droite([_,_,cafe,_,verte,_],[_,_,_,_,blanche,_],L),
   		voisin([medecin,_,_,_,_,_],[_,_,_,renard,_,_],L),
    	voisin([diplomate,_,_,_,_,_],[_,_,_,cheval,_,_],L),
        voisin([_,norvegien,_,_,_,1],[_,_,_,_,bleue,_],L).

/*Solution:
village([[A1,A2,A3,A4,A5,1],[B1,B2,B3,B4,B5,2],[C1,C2,C3,C4,C5,3],[D1,D2,D3,D4,D5,4],[E1,E2,E3,E4,E5,5]]).*/
