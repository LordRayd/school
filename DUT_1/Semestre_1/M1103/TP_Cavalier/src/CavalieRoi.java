public class CavalieRoi {

	int numCoup = 1;
	int tailleEchec;
	int[][] damier;
	char cavalieRoi; //c si cavalier, r si roi

	/**
	  *Methode avec toutes les autres dedans
	  */
	void principal() {

		//testAfficherDamier();
		//testDonnerSuivants();
		//testEstCeValide();
		//testEssayer();
		lanceur();	
	}

	/**
	  *Methode qui affiche le damier
	  */

	void afficherDamier() {

		int i;
		int j;
		int k;

		for(k = 0 ; k < tailleEchec ; k++) {
				System.out.print("____");
			}
		System.out.print("_");
		System.out.println("");
		for(i = 0 ; i < tailleEchec ; i++) {
			System.out.print("|");
			for(j = 0 ; j < tailleEchec ; j++) {
				if(damier[i][j] >= 100){
					System.out.print(""+damier[i][j]+"|");
				}
				else if(damier[i][j] >= 10 && damier[i][j] < 100) {
					System.out.print(" "+damier[i][j]+"|");
				}
				else {
					System.out.print("  "+damier[i][j]+"|");	
				}
			}
			System.out.println("");
			for(k = 0 ; k < tailleEchec ; k++) {
				System.out.print("|___");
			}
			System.out.print("|");
			System.out.println("");			
		}
	}

	/**
	  *Test de la methode afficherDamier
	  */

	void testAfficherDamier() {

		tailleEchec = 10;
		damier = new int[tailleEchec][tailleEchec];

		System.out.println("Test de la methode afficherDamier");

		//CAS NORMAL
		damier[2][2] = 20;
		System.out.println("===CAS NORMAL===");
		System.out.println("Test avec tout qui est normal");
		afficherDamier();
	}

	/**
	  *Methode qui donne les prochains cases que la piece va tester
	  *@param posX position en X de la piece
	  *@param posY position en Y de la piece
	  *@param candidats tableau a deux dimensions qui contient les futurs candidats
	  */
	  

	void donnerSuivants(int posX, int posY, int[][] candidats) {

		int i;
		int j;
		int[][] posiRelaCavalier = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
		int[][] posiRelaRoi = {{0, 1}, {1, 0}, {0, -1}, {-1, -0}, {1, 1}, {1, -1}, {-1, -1}, {1, -1}};
		int[][] posiRela = new int[2][8];

		if(cavalieRoi == 'c') {
			posiRela = posiRelaCavalier;
		}
		else {
			posiRela = posiRelaRoi;
		}

		for(i = 0 ; i < 8 ; i++) {
			j = 0;
			candidats[i][j] = posiRela[i][j] + posX;
			j++;
			candidats[i][j] = posiRela[i][j] + posY;
		}
	}

	/**
	  *Test de la methode donnerSuivants
	  */

	void testDonnerSuivants() {

		int[][] candidats = new int[8][2];
		int posX = 4;
		int posY = 4;

		System.out.println("Test de la methode donnerSuivants");

		//CAS NORMAL
		System.out.println("===CAS NORMAL===");

		System.out.println("Test avec les X et Y egalent a quatre");
		System.out.println("Test pour le cavalier");
		cavalieRoi = 'c';
		donnerSuivants(posX, posY, candidats);
		afficherTabDeuxDim(candidats, 8, 2);

		System.out.println("Test pour le roi");
		cavalieRoi = 'r';
		donnerSuivants(posX, posY, candidats);
		afficherTabDeuxDim(candidats, 8, 2);

	}

	/**
	  *Methode qui renvoie vrai si la case est valide pour la piece
	  *@param newX coordonnee en X
	  *@param newY coordonnee en Y
	  *@return boolean vrai si la case est valide
	  */

	boolean estCeValide(int newX, int newY) {

		boolean valide;

		if(newX < 0 || newY < 0 || newX > tailleEchec - 1 || newY > tailleEchec - 1) {
			//System.out.println("La case est en dehors du tableau");
			valide = false;
		}
		else if(damier[newX][newY] != 0) {
			//System.out.println("La case est deja prise");
			valide = false;
		}
		else {
			valide = true;
		}
		return valide;
	}

	/**
	  *Test de la methode estCeValide
	  */

	void testEstCeValide() {

		int newX;
		int newY;
		boolean valide;

		System.out.println("Test de la methode estCeValide");

		//CAS D'ERREUR
		System.out.println("===CAS D'ERREUR===");

		System.out.println("Test quand une case est hors du tableau");
		newY = -6;
		newX = 2;
		valide = estCeValide(newX, newY);
		System.out.println("La case est valide : "+valide);

		newY = 2;
		newX = 20;
		valide = estCeValide(newX, newY);
		System.out.println("La case est valide : "+valide);

		//CAS NORMAUX
		System.out.println("===CAS NORMAUX===");

		System.out.println("Test avec une case libre");
		newX = 4;
		newY = 4;
		valide = estCeValide(newX, newY);
		System.out.println("La case est valide : "+valide);

		System.out.println("Test avec une case prise");
		damier[newX][newY] = 50;
		valide = estCeValide(newX, newY);
		System.out.println("La case est valide : "+valide);
	}

	/**
	  *Methode qui renvoie vrai si le chemin a ete trouve
	  *@param posX position en X
	  *@param posY position en Y
	  *@return boolean renvoie vrai si le chemin a ete trouve
	  */

	boolean essayer(int posX, int posY) {

		int[][] newPos = new int[8][2];
		int newX;
		int newY;
		int i;
		boolean trouve = false;

		donnerSuivants(posX, posY, newPos);		

		i = 0;

		while(i < 8 && trouve == false) {
			newX = newPos[i][0];
			newY = newPos[i][1];
			if(estCeValide(newX, newY) == true) {
				damier[newX][newY] = numCoup;
				numCoup ++;
				if(numCoup - 1 == tailleEchec * tailleEchec) {
					trouve = true;
				}
				else {
					trouve = essayer(newX, newY);
				}
				if(trouve == false) {
					damier[newX][newY] = 0;
					numCoup--;
				}
			}
			i++;
		}
		return trouve;
	}

	/**
	  *Test de la methode essayer
	  */

	void testEssayer() {

		boolean trouve;
		int x;
		int y;

		System.out.println("Test de la methode Essayer");

		//CAS LIMITE
		System.out.println("===CAS LIMITE===");

		cavalieRoi ='c';
		tailleEchec = 2;
		damier = new int[tailleEchec][tailleEchec];
		x = 0;
		y = 0;
		System.out.println("Test avec un tableau trop petit(cavalier)");
		damier[x][y] = numCoup;
		numCoup++;
		trouve =  essayer(x, y);
		System.out.println("La piece a trouve son chemin : "+trouve);
		afficherDamier();

		//CAS NORMAUX
		System.out.println("===CAS NORMAUX===");

		numCoup = 1;
		tailleEchec = 5;
		x = 1;
		damier = new int[tailleEchec][tailleEchec];
		System.out.println("Test quand la piece ne trouve pas de solution(cavalier)");
		damier[x][y] = numCoup;
		numCoup++;
		trouve = essayer(x, y);
		System.out.println("La piece a trouve son chemin : "+trouve);
		afficherDamier();

		numCoup = 1;
		tailleEchec = 6;
		y = 1;
		damier = new int[tailleEchec][tailleEchec];
		System.out.println("Test quand cela marche(cavalier)");
		damier[x][y] = numCoup;
		numCoup++;
		trouve = essayer(x, y);
		System.out.println("La piece a trouve son chemin : "+trouve);
		afficherDamier();

		cavalieRoi = 'r';
		numCoup = 1;
		tailleEchec = 6;
		damier = new int[tailleEchec][tailleEchec];
		System.out.println("Test quand cela marche(roi)");
		damier[x][y] = numCoup;
		numCoup++;
		trouve = essayer(x, y);
		System.out.println("La piece a trouve son chemin : "+trouve);
		afficherDamier();
	}

	/**
	  *Methode qui va lancer le programme
	  */

	void lanceur() {

		int x;
		int y;
		boolean trouve = false;

		cavalieRoi = SimpleInput.getChar("Cavalier ou roi ? \n c pour cavalier, r pour roi");
		while(cavalieRoi != 'c' && cavalieRoi != 'r') {
			System.out.println("Il y a eu une erreur de saisie, il faut recommmencer");
			cavalieRoi = SimpleInput.getChar("Cavalier ou roi ? \n c pour cavalier, r pour roi");
		}

		tailleEchec = SimpleInput.getInt("Donner la taille du tableau");
		damier = new int[tailleEchec][tailleEchec];

		x = SimpleInput.getInt("Donner un X de depart");
		y = SimpleInput.getInt("Donner un Y de depart");

		while(estCeValide(x, y) == false) {
			System.out.println("Une des valeurs est fausse, il faut recommmencer la saisie");
			x = SimpleInput.getInt("Donner un X de depart");
			y = SimpleInput.getInt("Donner un Y de depart");
		}

		
		damier[x][y] = numCoup;
		numCoup++;
		trouve = essayer(x,y);
		if(trouve == true ) {
			afficherDamier();
		}
		else {
			System.out.println("Il n'y a pas de solution possible");
		}
		
	}

	/**
	  *Methode qui affiche un tableau a deux dimensions
	  *@param leTab tableau d'entier
	  *@param nbElemX nombre d'element en X
	  *@param nbElemY nombre d'element en Y	  
	  */

	void afficherTabDeuxDim(int[][] leTab, int nbElemX, int nbElemY) {

		int i;
		int j;

		for(i = 0 ; i < nbElemX ; i++) {
			for(j = 0 ; j < nbElemY ; j++) {
				if(leTab[i][j] >= 10 || leTab[i][j] < 0) {
					System.out.print("  "+leTab[i][j]);
				}
				else {
					System.out.print("   "+leTab[i][j]);	
				}
			}
			System.out.println("");
		}
	}
}