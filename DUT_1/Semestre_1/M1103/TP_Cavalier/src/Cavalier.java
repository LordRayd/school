/**
  * Cette classe met en oeuvre l&acute;algorithme par essai/erreur r&eacute;cursif du d&eacute;placement d&acute;un cavalier sur un &eacute;chiquier. A partir d&acute;une case de
  * d&eacute;part, si un chemin pour parcourir toutes les cases une seule fois est trouv&eacute; alors l&acute;&eacute;chiquier est affich&eacute; avec le parcours complet du cavalier.
  * @author S.LEBERRE - Decembre 2016
  * @version 1.0
  * @since JDK 1.8
  */
  public class Cavalier {
	
	// variables globales
		/** La taille de l&acute;&eacute;chiquier en constante */
		final int TAILLE_ECHEC=6;
		/** L&acute;&eacute;chiquier qui permet de visualiser les d&eacute;placements du cavalier */
		int[][] damier;
		/** Le nombre de coups jou&eacute;s qui permet de num&eacute;roter chaque d&eacute;placement et de savoir si le jeu est termin&eacute; */
		int numCoup = 1;
	
	
	/**
	  * Point d&acute;entr&eacute;e de l&acute;&eacute;x&eacute;cution
	  */
	void principal() {

		// appel du lanceur
			lanceur();

		// appel des cas de test un par un
			testAfficherDamier();
			testEstCeValide();
			testDonnerSuivants();
			testEssayer();
	}
	
	/** 
	  * Test de la m&eacute;thode afficherDamier()
	  */ 
	void testAfficherDamier(){
		
		System.out.println("=========================== Test de la methode afficherDamier ===============================");
			
		// Test les cas normaux
		System.out.println("\n--------- Test les cas normaux");
			
			// test
			afficherDamier();
		
		// Test les cas d'erreurs
		System.out.println("\n--------- Test tous les cas d'erreurs");
			
			System.out.println("On ne peut pas tester les cas d'erreurs");
			System.out.println("Car cela implique de modifier le damier");
			/*
			// tableau null
			damier = null;
			afficherDamier();
			*/
	}
	
	
	/** 
	  * Test de la m&eacute;thode estCeValide()
	  */
	void testEstCeValide(){
		
		System.out.println("\n\n\n=========================== Test de la methode estCeValide ===============================");
		 // variables locales
		 boolean valide;
		 
		// Test les cas d'erreurs
		System.out.println("\n\n--------- Test tous les cas d'erreurs");
			
			// newX < 0
			System.out.println("\n--- Test newX < 0");
			valide = estCeValide(-1,5);
			System.out.println("Le résultat est " + valide);
			
			// newX > TAILLE_ECHEC
			System.out.println("\n--- Test newX > TAILLE_ECHEC");
			valide = estCeValide(TAILLE_ECHEC,2);
			System.out.println("Le résultat est " + valide);
			
			// newY < 0
			System.out.println("\n--- Test newY < 0");
			valide = estCeValide(4,-1);
			System.out.println("Le résultat est " + valide);
			
			// newY > TAILLE_ECHEC
			System.out.println("\n--- Test newY > TAILLE_ECHEC");
			valide = estCeValide(3,TAILLE_ECHEC);
			System.out.println("Le résultat est " + valide);
			
			// case[newX][newY] déja visité
			System.out.println("\n--- Test case[newX][newY] déja visité");
			damier[3][4] = 1;
			valide = estCeValide(3,4);
			System.out.println("Le résultat est " + valide);
		
		// Test les cas limites
		System.out.println("\n\n--------- Test tous les cas limites ------ ");

			// Test quand newX vaut 0
			System.out.println("\n--- Test newX = 0");
			valide = estCeValide(0,3);
			System.out.println("Le résultat est " + valide);
			
			// Test quand newX vaut TAILLE_ECHEC-1
			System.out.println("\n--- Test newX = TAILLE_ECHEC-1");
			valide = estCeValide(3,TAILLE_ECHEC-1);
			System.out.println("Le résultat est " + valide);
			
			// Test quand newY vaut 0
			System.out.println("\n--- Test newY = 0");
			valide = estCeValide(4,0);
			System.out.println("Le résultat est " + valide);
			
			// Test quand newY vaut TAILLE_ECHEC-1
			System.out.println("\n--- Test newY = TAILLE_ECHEC-1");
			valide = estCeValide(3,TAILLE_ECHEC-1);
			System.out.println("Le résultat est " + valide);
			
			
		// Test les cas normaux
		System.out.println("\n\n--------- Test les cas normaux");

			// test vrai
			valide = estCeValide(3,3);
			System.out.println("Le résultat est " + valide);

			// test faux
			valide = estCeValide(3,4);
			System.out.println("Le résultat est " + valide);
	}
	
	/** 
	  * Test de la m&eacute;thode donnerSuivants()
	  */
	void testDonnerSuivants(){
		
		System.out.println("\n\n\n=========================== Test de la methode donnerSuivants ===============================");
		
		// variables locales
		int[][] candidats = new int [8][2];
		int posX = 4;
		int posY = 5;
		
		// Test les cas normaux
		System.out.println("\n\n--------- Test les cas normaux");
		System.out.println("Pour posX = 4 et posY = 5");
		donnerSuivants(posX,posY,candidats);
		afficherCandidats(candidats);
	}

	/**
	  * Test de la m&eacute;thode essayer()
	  */
	void testEssayer(){

		System.out.println("\n\n\n=========================== Test de la methode essayer ===============================");

		//variables locales
		int x;
		int y;
		boolean trouver;

		// Test les cas normaux
		System.out.println("\n\n--------- Test les cas normaux");

			// test 
			System.out.println("Test vrai");
			numCoup = 1;
			x = 0;
			y = 4;
			damier = new int[TAILLE_ECHEC][TAILLE_ECHEC];
			damier[x][y] = numCoup;
			numCoup++;
			trouver = essayer(x, y);
			afficherDamier();
	}
	
	/** 
	  * Lanceur de l&acute;application : cr&eacute;e le damier &agrave; la bonne taille et positionne le cavalier sur une premi&egrave;re case en X et en Y. Le compteur est
	  * initialis&eacute; &agrave; 1. On v&eacute;rifiera que les coordonn&eacute;es de la premi&egrave;re case sont valides. La coordonn&eacute;e (0, 0) correspond au coin sup&eacute;rieur
	  * gauche du damier. Ensuite, appeler une premi&egrave;re fois "essayer(...)". Suite au r&eacute;sultat renvoy&eacute; par "essayer(...)", soit le damier est
	  * affich&eacute; car le chemin est trouv&eacute;, soit il n&acute;y a pas de solution possible.
	  */
	void lanceur(){
		
		// variables
		int posX;
		int posY;
		boolean trouver;

		//définition du damier
			damier = new int [TAILLE_ECHEC][TAILLE_ECHEC];
			for(int i=0; i<TAILLE_ECHEC; i++){
				for(int j=0; j<TAILLE_ECHEC; j++){
					damier[i][j]=0;
				}
			}
			
		// definition de la position du cavalier
		posX = SimpleInput.getInt("Donner la position X de depart du cavalier");
		posY = SimpleInput.getInt("Donner la position Y de depart du cavalier");

		damier[posX][posY] = numCoup;
		numCoup=numCoup+1;
		trouver = essayer(posX,posY);
		if(trouver == true ) {
			afficherDamier();
		}else {
			System.out.println("Le cavalier ne peut parcourir tout le damier");
		}
	}
	
	/** 
	  * A partir des cordonn&eacute;es (posX, posY), cette m&eacute;thode remplit le tableau "candidats" des 8 d&eacute;placements possibles du cavalier. Elle ne v&eacute;rifie 
	  * pas que les 8 d&eacute;placements sont valides. Cette v&eacute;rification est r&eacute;alis&eacute;e par la m&eacute;thode "estCeValide(...)". Les d&eacute;placements
	  * sont m&eacute;moris&eacute;s dans un tableau &agrave; 2 entr&eacute;es de taille 8 lignes X 2 colonnes. A chaque ligne correspond 1 position, sur le damier,
	  * possible (parmi 8) du cavalier apr&egrave;s son d&eacute;placement. Une position est repr&eacute;sent&eacute;e par le couple de coordonn&eacute;es (posX, posY).
	  * @param posX la position du cavalier en X (horizontale)
	  * @param posY la position du cavalier en Y (verticale)
	  * @param candidats tableau (8 lignes X 2 colonnes) qui m&eacute;morisent les 8 d&eacute;placements possibles du cavalier
	  */
	void donnerSuivants(int posX, int posY, int[][] candidats) {
		
		candidats[0][0]= posX-2;
		candidats[0][1]= posY+1;
		
		candidats[1][0]= posX-1;
		candidats[1][1]= posY+3;
		
		candidats[2][0]= posX+1;
		candidats[2][1]= posY+3;
		
		candidats[3][0]= posX+3;
		candidats[3][1]= posY+1;
		
		candidats[4][0]= posX+3;
		candidats[4][1]= posY-1;
		
		candidats[5][0]= posX+1;
		candidats[5][1]= posY-3;
		
		candidats[6][0]= posX-1;
		candidats[6][1]= posY-3;
		
		candidats[7][0]= posX-3;
		candidats[7][1]= posY-1;
	}
	
	/**
	  * M&eacute;thode qui renvoie vrai si la nouvelle coordonn&eacute;e (ou nouveau d&eacute;placement) du cavalier est possible.
	  * Le d&eacute;placement est possible si : la nouvelle coordonn&eacute;e ne sort pas du damier
	  * et la nouvelle case (newX, newY) n&acute;a pas encore &eacute;t&eacute; visit&eacute;e
	  * @param newX la nouvelle coordonn&eacute;e en X
	  * @param newY la nouvelle coordonn&eacute;e en Y
	  * @return vrai si la nouvelle coordonn&eacute;e (newX, newY) est valide
	  */
	boolean estCeValide(int newX, int newY) {
		boolean ret = false;
		if(newX <0 || newX > TAILLE_ECHEC-1){
			//System.out.println("Le nouveau X est faux");
		}else if(newY <0 || newY > TAILLE_ECHEC-1){
			//System.out.println("Le nouveau Y est faux");
		}else if(damier[newX][newY] != 0){
			//System.out.println("La case a deja ete visite");
		}else {
			ret = true;
			//System.out.println("On peut se deplacer dans la case");
		}
		return ret;
	}
	
	/**
	  * A partir des coordonn&eacute;es (posX, posY) du cavalier, calculer les 8 d&eacute;placements suivants possibles par appel de la m&eacute;thode &laquo;
	  * donnerSuivants(...) &raquo;. Ensuite, examiner les 8 d&eacute;placements possibles (newXi, newYi) un par un :
	  * V&eacute;rifier la validit&eacute; de la coordonn&eacute;e (newX, newY) &agrave; l&acute;aide de la m&eacute;thode &laquo; estCeValide(...) &raquo;.
	  * Si la coordonn&eacute;e est valide, inscrire le num&eacute;ro du coup jou&eacute; dans la case de coordonn&eacute;e (newX, newY) du tableau &laquo; damier &raquo; et
	  * incr&eacute;menter le nombre de coups.
	  * Si le nombre de coups == TAILLE_ECHEC X TAILLE_ECHEC alors la solution est trouv&eacute;e et renvoyer vrai (fin de la r&eacute;cursivit&eacute;).
	  * Sinon, &agrave; partir de cette nouvelle case valide (newX, newY), appeler &agrave; nouveau &laquo; essayer (...) &raquo; (appel r&eacute;cursif).
	  * Si ce nouvel appel de &laquo; essayer (...) &raquo; renvoie vrai, la solution finale est trouv&eacute;e.
	  * Sinon, revenir "en arri&egrave;re" en &eacute;crivant z&eacute;ro dans la case aux coordonn&eacute;es (newX, newY) du damier en d&eacute;cr&eacute;mentant le nombre
	  * de coups puis examiner la case suivante parmi les 8 d&eacute;placements possibles.
	  * @param posX la position du cavalier en X (horizontale)
	  * @param posY la position du cavalier en Y (verticale)
	  * @return vrai si le chemin des d&eacute;placements est trouv&eacute;
	  */
	boolean essayer(int posX, int posY){
		
		// variables locales
		boolean ret = false;
		int[][] candidats = new int[8][2];
		int newX;
		int newY;
		int i=0;

		// Corps
		donnerSuivants(posX, posY, candidats);		
		while(i < 8 && ret == false) {
			newX = candidats[i][0];
			newY = candidats[i][1];
			if(estCeValide(newX, newY) == true) {
				damier[newX][newY] = numCoup;
				numCoup=numCoup+1;
				if(numCoup-1 == TAILLE_ECHEC * TAILLE_ECHEC) {
					ret = true;
				}
				else {
					ret = essayer(newX, newY);
				}
				if(ret == false) {
					damier[newX][newY] = 0;
					numCoup=numCoup-1;
				}
			}
			i=i+1;
		}

		//retour
		return ret;
	}
	
	/**
	  * Affiche le damier &agrave; l&acute;&eacute;cran. Le coin sup&eacute;rieur gauche correspond aux coordonn&eacute;es (0, 0). L&acute;affichage consistera simplement &agrave;
	  * imprimer &agrave; l&acute;&eacute;cran TAILLE_ECHEC lignes de TAILLE_ECHEC entiers, chaque entier &eacute;tant le num&eacute;ro du coup jou&eacute;. Chaque
	  * d&eacute;placement du cavalier sur le damier incr&eacute;mente de un le num&eacute;ro du coup qui commence &agrave; la valeur 1 jusqu&acute;&agrave; TAILLE_ECHEC X
	  * TAILLE_ECHEC (lorsque le cavalier a termin&eacute; son parcours).
	  */
	void afficherDamier(){
		if(damier != null){
			int i = 0;
			int j;
			while (i < TAILLE_ECHEC ) {
				j = 0;
				while(j < TAILLE_ECHEC){
					System.out.print(damier[i][j] + "      ");
					j=j+1;
				}
				System.out.println("\n\n");
				i=i+1;
			}
		}else{
			System.out.println("Tableau null");
		}
	}

	/** 
	  * Affiche le contenu d'un tableau a 2 dimensions de 8 sur 2
	  * @param candidats le tableau 2D a afficher
	  */
	void afficherCandidats(int [][] candidats) {
		
		if(candidats == null) {
			System.out.println("afficherCandidats Le tableau est vide");
		}else {
			int i = 0;
			while (i < 8 ) {
				System.out.print(candidats[i][0] + "    ");
				System.out.print(candidats[i][1]);
				System.out.println("\n");
				i=i+1;
			}
		}
	}

}
