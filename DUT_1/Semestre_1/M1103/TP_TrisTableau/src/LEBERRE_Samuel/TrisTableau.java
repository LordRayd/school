/**
  * Cette classe effectue des Tris différents sur un tableaux d'entiers.
  * @author S.LEBERRE 
  * @version 1
  * @since JDK 1.8
  */
public class TrisTableau {
	
	long cpt;
	
	/**
	  * Point d'entree de l'execution
	  */
	void principal() {

		// appel des cas de test un par un
		testTriParComptageFreqEfficacite();
		testTriABullesEfficacite();
		testTriSimpleEfficacite();
		testTriRapideEfficacite();
		testRechercheDichoEfficacite();
		testRechercheSeqEfficacite();
		testTriSimpleEtVeriftri();
		testTriRapide();
		testSeparer();
		testRechercheDicho();
		testRechercheSeq();
		testCreerTabFreq();
		testTriParComptageFreq();
		testTriABulles();
		
	}

	/** 
	  * Test de l'efficacité de la méthode triParComptageFreq 
	  */ 
	void testTriParComptageFreqEfficacite(){
		
		System.out.println("     ====== Test d'efficacite de la methode triParComptageFreq ====== ");
		
		int nbElem = 50000;
		int[] leTab = new int[800000];
		int res;
		int tempsExe;
		int cste;
		int i=0;
		while(i < 5) {
			remplirAleatoire(leTab, nbElem, 0, 10000);
			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int) System.nanoTime();
			triParComptageFreq(leTab, nbElem);
			tempsExe = (int) System.nanoTime() - tempsExe;
			cste = (int) cpt/nbElem;
			System.out.println("La methode a mis "+tempsExe+" nano-secondes a s'executer et on obtient cste = "+cste);
			if(verifTri(leTab, nbElem) == false) {
				System.out.println("Le tableau n'est pas trie");
			}
			nbElem = nbElem * 2;	
			i=i+1;
		}
	}

	/** 
	  * Test de l'efficacité de la méthode triABulles
	  */
	void testTriABullesEfficacite(){
		
		System.out.println("     ====== Test d'efficacite de la methode triABulles ====== ");
		
		int nbElem = 12500;
		int[] leTab = new int[200000];
		int res;
		int tempsExe;
		float cste;
		int i=0;
		while(i < 5) {
			remplirAleatoire(leTab, nbElem, -10000, 10000);
			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int) System.currentTimeMillis();
			triABulles(leTab, nbElem);
			tempsExe = (int) System.currentTimeMillis() - tempsExe;
			tempsExe = (int) tempsExe / 1000;
			cste = (float) cpt / ((long)nbElem * (long)nbElem);
			System.out.println("La methode a mis "+tempsExe+" s a s'executer et on obtient cste = "+cste);
			if(verifTri(leTab, nbElem) == false) {
				System.out.println("Le tableau n'est pas trie");
			}
			nbElem = nbElem * 2;	
			i=i+1;
		}
	}

	/** 
	  * Test de l'efficacité de la méthode triSimple
	  */
	void testTriSimpleEfficacite(){
		
		System.out.println("     ====== Test d'efficacite de la methode triSimple ====== ");
		
		int nbElem = 12500;
		int[] leTab = new int[200000];
		int res;
		int tempsExe;
		float cste;
		int i = 0;
		while(i < 5) {
			remplirAleatoire(leTab, nbElem, -10000, 10000);
			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int) System.currentTimeMillis();
			triSimple(leTab, nbElem);
			tempsExe = (int) System.currentTimeMillis() - tempsExe;
			cste = (float) cpt / ( (long)nbElem *(long)nbElem);
			System.out.println("La methode a mis "+tempsExe+" ms a s'executer et on obtient cste = "+cste);
			if(verifTri(leTab, nbElem) == false) {
				System.out.println("Le tableau n'est pas trie");
			}
			nbElem = nbElem * 2;
			i = i+1;
		}
	}
	
	/** 
	  * Test de l'efficacité de la méthode triRapide
	  */
	void testTriRapideEfficacite(){
		
		System.out.println("     ====== Test d'efficacite de la methode triRapide ====== ");
		
		int nbElem = 50000;
		int[] leTab = new int[800000];
		int res;
		int tempsExe;
		double cste;
		int i=0;
		while(i < 5) {
			remplirAleatoire(leTab, nbElem, -10000, 10000);
			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int) System.currentTimeMillis();
			triRapide(leTab, nbElem);
			tempsExe = (int) System.currentTimeMillis() - tempsExe;
			cste = cpt / ( (long) (nbElem) * (long) ( (Math.log(10) / Math.log(2) ) ) );
			System.out.println("La methode a mis "+tempsExe+" ms a s'executer et on obtient cste = "+cste+" avec cpt "+cpt);
			if(verifTri(leTab, nbElem) == false) {
				System.out.println("Le tableau n'est pas trie");
			}
			nbElem = nbElem * 2;
			i=i+1;			
		}
	}
	
	/** 
	  * Test de l'efficacité de la méthode rechercheDicho
	  */
	void testRechercheDichoEfficacite(){
		
		System.out.println("     ====== Test d'efficacite de la methode rechercheDicho ====== ");
		
		int nbElem = 100000;
		int[] leTab = new int[1600000];
		int res;
		int aRech;
		int tempsExe;
		double cste;
		int i=0;
		while(i < 5) {
			leTab = creerTableauAleatoireEtTrie(leTab, nbElem, 10);
			aRech = leTab[tirerAleatoire(0,nbElem-1)];
			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int) System.nanoTime();
			res = rechercheDicho(leTab, nbElem, aRech);
			tempsExe = (int) System.nanoTime() - tempsExe;
			cste = cpt / (Math.log10 (nbElem) / Math.log10  (2) );
			System.out.println("La methode a mis "+tempsExe+" nano-secondes a s'executer et on obtient cste = "+cste);
			nbElem = nbElem * 2;
			i=i+1;
		}
	}
	
	/** 
	  * Test de l'efficacité de la méthode rechercheSeq
	  */
	void testRechercheSeqEfficacite(){
		
		System.out.println("     ====== Test d'efficacite de la methode rechercheSeq ====== ");
		
		int nbElem = 50000;
		int[] leTab = new int[800000];
		int res;
		int aRech;
		int tempsExe;
		int cste;
		int i=0;
		while(i < 5) {
			remplirAleatoire(leTab, nbElem, -10000, 10000);
			aRech = 20000;
			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int)System.nanoTime();
			res = rechercheSeq(leTab, nbElem, aRech);
			tempsExe = (int)System.nanoTime() - tempsExe;
			cste = (int)cpt/nbElem;
			System.out.println("La methode a mis "+tempsExe+" nano-secondes a s'executer et on obtient cste = "+cste);
			nbElem = nbElem * 2;
			i=i+1;
		}
	} 
	
	/** 
	  * Test des méthodes triSimple et verifTri
	  */
	void testTriSimpleEtVeriftri(){
		
		System.out.println("     ====== Test de la methode triSimple ====== ");
		
			int[] leTab = {9,6,3,4,2,8,4,2,9,78};
	
			// Test les cas limites
			System.out.println("\n   ------ Test tous les cas limites ------ ");

				//nbElem = 0
				System.out.println("nbElem egale 0");
				triSimple(leTab, 0);

			// Test les cas normaux
			System.out.println("\n   ------ Test les cas normaux ------ ");

				//nbElem = 10
				System.out.println("nbElem egale 10");
				triSimple(leTab, 10);
				afficherTab(leTab,10);
		
		
		System.out.println("     ====== Test de la methode triSimple ====== ");
		
			boolean res;
			leTab = new int[10];

			// Test les cas limites
			System.out.println("\n   ------ Test tous les cas limites ------ ");
		
				//nbElem = 0
				remplirAleatoire(leTab, 10, 0, 10);
				System.out.println("nbElem = 0");
				res = verifTri(leTab, 0);
				System.out.println("Le tableau est trie : "+res);

			// Test les cas normaux
			System.out.println("\n   ------ Test les cas normaux ------ ");

				//nbElem = 6
				System.out.println("Test avec un tableau non trie");
				res = verifTri(leTab, 6);
				System.out.println("Le tableau est trie : "+res);

				leTab = creerTableauAleatoireEtTrie(leTab, 6, 2);
				System.out.println("Test avec un tableau trie");
				res = verifTri(leTab, 6);
				System.out.println("Le tableau est trie : "+res);
	}
	
	/** 
	  * Test de la méthode triRapide
	  */
	void testTriRapide(){
		
		System.out.println("     ====== Test de la methode triRapide ====== ");


		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");

			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			int [] tab = null ;
			triRapide(tab,10);
		
			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			int [] leTab = {4,5,2,5,4,7,1,7,2,5};
			triRapide(leTab,-1);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			triRapide(leTab,11);

		
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");

			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			triRapide(leTab,0);
			afficherTab(tab,0);

			
		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
		
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			triRapide(leTab,10);
			afficherTab(tab,10);
	}
	
	/** 
	  * Test de la méthode de séparation
	  */
	void testSeparer(){
		
		System.out.println("     ====== Test de la methode separer ====== ");
		
		int indL;
		int indR;
		int pivot;
		int[] leTab = {7,1,9,3,8,5,4,6,4,1};

		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// indice < 0
			indR = -1;
			indL = indR;
			System.out.println("Test avec des indices negatifs");
			pivot = separer(leTab, indL, indR);
			
			// indR < indL
			indR = 5;
			indL = 9;
			System.out.println("Test avec indR < indL");
			pivot = separer(leTab, indL, indR);


		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// indL = indR
			indL = indR;
			System.out.println("Test avec indR = indL");
			pivot = separer(leTab, indL, indR);
			System.out.println("Le pivot est place en case : "+pivot);

		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
			
			// Cas normal 
			indR = 9;
			indL = 0;
			System.out.println("cas normales");
			pivot = separer(leTab, indL, indR);
			afficherTab(leTab, (indR - indL + 1));
			System.out.println("Le pivot est place en case : "+pivot);
	}
	
	/** 
	  * Test de la méthode rechercheSeq
	  */
	void testRechercheDicho(){
		
		System.out.println("     ====== Test de la methode rechercheDicho ====== ");
		
		int res;
		int[] leTab = {0,1,2,3,4,5,6,7,8,9};

		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
 
			//nbElem = 0 et aRech = 5
			System.out.println("nbElem egale 0");
			res = rechercheDicho(leTab, 0, 5);
			System.out.println("La valeur est en : "+res);


		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");

			// nbElem = 8 et aRech = 3
			System.out.println("Test normal avec la valeur dans le tableau");
			res = rechercheDicho(leTab, 8, 3);
			System.out.println("La valeur est en : "+res);

			//nbElem = 10 et aRech = 11
			System.out.println("Test normal sans la valeur dans le tableau");
			res = rechercheDicho(leTab, 10, 11);
			System.out.println("La valeur est en : "+res);
	}
	
	/** 
	  * Test de la méthode rechercheSeq
	  */
	void testRechercheSeq(){
		
		System.out.println("     ====== Test de la methode rechercheSeq ====== ");
		
		int res;
		int[] leTab= {0,1,2,3,4,5,6,7,8,9};

		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
 
			//nbElem = 0 et aRech = 5
			System.out.println("nbElem egale 0");
			res = rechercheSeq(leTab, 0, 5);
			System.out.println("La valeur est en : "+res);


		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");

			// nbElem = 8 et aRech = 3
			System.out.println("Test normal avec la valeur dans le tableau");
			res = rechercheSeq(leTab, 8, 3);
			System.out.println("La valeur est en : "+res);

			//nbElem = 10 et aRech = 11
			System.out.println("Test normal sans la valeur dans le tableau");
			res = rechercheSeq(leTab, 10, 11);
			System.out.println("La valeur est en : "+res);
	}
	
	/** 
	  * Test de la méthode creerTabFreq
	  */
	void testCreerTabFreq(){
		
		System.out.println("     ====== Test de la methode creerTabFreq ====== ");

		int[] leTab = {2,6,7,8,7,2,7,8,6,7};
		int[] leTabFreq;

		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");;
	
			// nbElem = 0
			System.out.println("nbElem egale 0");
			leTabFreq = creerTabFreq(leTab, 0);
	
		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
	
			// nbElem = 10
			System.out.println("nbElem egale 10");
			leTabFreq = creerTabFreq(leTab, 10);
			afficherTab(leTabFreq, leTabFreq.length);		
	}
	
	/** 
	  * Test de la méthode triParComptageFreq
	  */
	void testTriParComptageFreq(){
		
		System.out.println("     ====== Test de la methode triParComptageFreq ====== ");

		int[] leTab = {8,6,2,47,8,2,4,8,6,9};

		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");

			// Test quand nbElem vaut 0
			System.out.println("nbElem egale 0");
			triParComptageFreq(leTab, 0);

		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");

			// Test quand nbElem vaut 10
			System.out.println("nbElem egale 10");
			triParComptageFreq(leTab, 10);
			afficherTab(leTab, 10);
	}
	
	/** 
	  * Test de la méthode triABulles
	  */ 
	void testTriABulles(){
		
		System.out.println("     ====== Test de la methode triABulles ====== ");
		
		int[] leTab = {1,5,9,8,8,3,5,6,2,13};
		afficherTab(leTab, 10);

		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");

			// nbElem = 0
			System.out.println("Test avec nbElem egale 0");
			triABulles(leTab, 0);
			
		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");

			//nbElem = 10
			System.out.println("Test avec nbElem egale 10");
			triABulles(leTab,10);
			afficherTab(leTab, 10);
	}
	
	/** 
	  * Recherche séquentielle d'une valeur dans un tableau. La valeur à rechercher peut exister en plusieurs exemplaires mais la recherche
	  * s'arrête dès qu'une première valeur est trouvée. On suppose que le tableau passé en paramètre est créé et possède au moins une
      * valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
      * @param leTab le tableau dans lequel effectuer la recherche
      * @param nbElem le nombre d'entiers que contient le tableau
      * @param aRech l'entier à rechercher dans le tableau
      * @return l'indice (>=0) de la position de l'entier dans le tableau ou -1 s'il n'est pas présent
	  */
	int rechercheSeq(int[] leTab, int nbElem, int aRech){	
		int i =0;
		boolean trouve = false;
		if (paramCorrect(leTab,nbElem) != false){
			while ( !trouve && ( i < nbElem ) ) {
				if ( aRech == leTab[i] ) {
					trouve = true;
				}
				else {
				i++;
				cpt++;
				}
			}
		}
		if ( !trouve ) i = -1;
		return i ;
	}
	  
	/** 
	  * Tri par ordre croissant d'un tableau selon la méthode du tri rapide (QuickSort). On suppose que le tableau passé en paramètre est
	  * créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié. Cette méthode appelle triRapideRec(...) qui elle
	  * effectue réellement le tri rapide selon la méthode de séparation récursive.
	  * @param leTab le tableau à trier par ordre croissant
	  * @param nbElem le nombre d'entiers que contient le tableau
	  */
	void triRapide(int[] leTab, int nbElem){
		if (paramCorrect(leTab,nbElem) != false){
			int indL = 0;
			int indR = nbElem-1;
			triRapideRec(leTab, indL, indR);
		}
	}
	
	/** 
	  * Méthode de tri récursive selon le principe de séparation. La méthode s'appelle elle-même sur les tableaux gauche et droite par
	  * rapport à un pivot.
	  * @param tab le tableau sur lequel est effectué la séparation
	  * @param indL l'indice gauche de début de tableau
	  * @param indR l'indice droite de fin de tableau
	  */
	void triRapideRec(int[] tab, int indL, int indR){
		if(indCorrect(indL, indR) != false){
			int indS;
			indS = separer ( tab, indL, indR );
			if ( (indS-1) > indL ) {
				triRapideRec ( tab, indL, (indS-1) );
			}
			if ( (indS+1) < indR ) {
				triRapideRec ( tab, (indS+1), indR );
			}
			cpt++;
		}
	}
	
	/** 
	  * Cette méthode renvoie l’indice de séparation du tableau en 2 parties par placement du pivot à la bonne case.
	  * @param tab le tableau des valeurs
	  * @param indR indice Right de fin de tableau
	  * @param indL indice Left de début de tableau
	  * @return l’indice de séparation du tableau
	  */
	int separer(int[] tab, int indL, int indR){
		int tmp;
		int pivot;
		pivot = tab[indL];
		while ( indL <= indR ) {
			// parcours droite -> gauche
			while ( tab[indR] > pivot ) {
				indR--;
			}
			tmp = indL;
			indL = indR;
			indR = tmp; 
			indL++;
			if ( indL == indR ) break;
			// parcours gauche -> droite
			while ( tab[indL] < pivot ) {
			indL++;
			}
			tmp = indL;
			indL = indR;
			indR = tmp;
			indR--;
		}
		return indL;
	}
	
	/** 
	  * Tri par ordre croissant d'un tableau selon la méthode du tri à bulles : tant que le tableau n'est pas trie, permuter le contenu de 2
	  * cases successives si leTab[i] > leTab[i+1]. On suppose que le tableau passé en paramètre est créé et possède au moins une valeur
	  * (nbElem > 0). Ceci ne doit donc pas être vérifié.
	  * @param leTab le tableau à trier par ordre croissant
	  * @param nbElem le nombre d'entiers que contient le tableau
	  */ 
	void triABulles(int[] leTab, int nbElem){
		int i;
		int tmp;
		int k = nbElem-1;
		while( k < nbElem && k > 0){
			i = 0;
			while(i < k){
				if(leTab[i] > leTab[i+1]){
					echange(leTab, i, i+1);
				}
				i=i+1;
				cpt++;
			}
			k = k-1;
		}
	}
	
	/** 
	  * Tri par ordre croissant d'un tableau selon la méthode simple : l'élément minimum est placé en début de tableau (efficacité en n
	  * carré). On suppose que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas
	  * être vérifié.
	  * @param leTab le tableau à trier par ordre croissant
	  * @param nbElem le nombre d'entiers que contient le tableau
	  */
	void triSimple(int[] leTab, int nbElem){
		for(int i=0; i<nbElem-1; i++){
			for(int j=i+1; j<nbElem; j++){
				if(leTab[i]>leTab[j]){
					echange(leTab,i,j);
				}
				cpt++;
			}
		}
	}
	
	/** 
	  * Vérifie que le tableau passé en paramètre est trié par ordre croissant des valeurs. On suppose que le tableau passé en paramètre est
	  * créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	  * @param leTab le tableau à vérifier (trié en ordre croissant)
	  * @param nbElem le nombre d'entiers présents dans le tableau
	  * @return true si le tableau est trié
	  */
	boolean verifTri(int[] leTab, int nbElem){
		boolean correct = true;
		int i =0;
		while(i < nbElem-1){
			if(leTab[i] > leTab[i+1]){
				correct = false;
			}
			i = i+1;
		}
		return correct;
	}
	
	/** 
	  * Echange les contenus des cases du tableau passé en paramètre, cases identifiées par les indices ind1 et ind2. 
	  * Vérifier que les indices ind1 et ind2 sont bien compris entre zéro et (nbElem-1), sinon afficher un message d'erreur.
	  * @param leTab le tableau
	  * @param nbElem le nombre d'entiers présents dans le tableau
	  * @param ind1 numéro de la première case à échanger
	  * @param ind2 numéro de la deuxième case à échanger
	  */
	void echange(int[] leTab, int nbElem, int ind1, int ind2){
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else if(ind1 < 0 || ind1 > nbElem-1){
			System.out.println("ind1 non correct");
		}else if(ind2 < 0 || ind2 > nbElem-1){
			System.out.println("ind2 non correct");
		}else {
			int tmp = leTab[ind1];
			leTab[ind1] = leTab[ind2];
			leTab[ind2] = tmp;
		}
	}
	
	/** 
	  * Echange les contenus des cases du tableau passé en paramètre, cases identifiées par les indices ind1 et ind2.
	  * @param leTab le tableau
	  * @param ind1 numéro de la première case à échanger
	  * @param ind2 numéro de la deuxième case à échanger
	  */
	void echange(int[] leTab, int ind1, int ind2){
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(leTab.length == 0) {
			System.out.println("Tableau a 0 elements");
		}else if(ind1 < 0 || ind1 > leTab.length-1){
			System.out.println("ind1 non correct");
		}else if(ind2 < 0 || ind2 > leTab.length-1){
			System.out.println("ind2 non correct");
		}else {
			int tmp = leTab[ind1];
			leTab[ind1] = leTab[ind2];
			leTab[ind2] = tmp;
		}
	}
	
	/** 
	  * Tri par ordre croissant d'un tableau selon la méthode du tri par comptage de fréquences. 
	  * On suppose que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié.
	  * @param leTab le tableau à trier par ordre croissant
	  * @param nbElem le nombre d'entiers que contient le tableau
	  * @return le tableau initial trié par ordre croissant ou null si cette méthode de tri ne s'applique pas
	  */
	int[] triParComptageFreq(int[] leTab, int nbElem){
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			int [] tabFreq = creerTabFreq(leTab,nbElem);
			int i = 0;
			int j = 0;
			while(i < nbElem){
				while(tabFreq[i] != 0){
					leTab[j] = i;
					tabFreq[i] = tabFreq[i] -1;
					j = j+1;
					cpt++;
				}
				i=i+1;
			}
		}
		return leTab;
	}
	
	/** 
	  * A partir d'un tableau initial passé en paramètre "leTab", cette méthode renvoie un nouveau tableau "tabFreq" d'entiers où chaque
	  * case contient la fréquence d'apparition des valeurs dans le tableau initial. Pour simplifier, on suppose que le tableau initial ne contient
	  * que des entiers compris entre 0 et max (>0). Dès lors le tableau "tabFreq" se compose de (max+1) cases et chaque case "i"
	  * (0<=i<=max) contient le nombre de fois que l'entier "i" apparait dans le tableau initial. On suppose que le tableau passé en
	  * paramètre est créé et possède au moins une valeur (nbElem > 0). Ceci ne doit donc pas être vérifié. Par contre, on vérifiera que le
	  * max du tableau initial est > 0 et que le min est >= 0. Dans le cas contraire, renvoyer un tableau "null".
	  * @param leTab le tableau initial
	  * @param nbElem le nombre d'entiers présents dans le tableau
	  * @return le tableau des fréquences de taille (max+1) ou null si la méthode ne s'applique pas
	  */
	int[] creerTabFreq(int[] leTab, int nbElem){
		int [] tabFreq = null;
		if(leMax(leTab,nbElem) <= 0) {
			System.out.println("leMax du tableau est trop petit");
		}else if(leMin(leTab,nbElem) < 0) {
			System.out.println("leMin du tableau est trop petit");
		}else {
			tabFreq = new int[leMax(leTab,nbElem)+1];
			int i = 0;
			while(i < nbElem){
				int n = leTab[i];
				tabFreq[i] = tabFreq[i]-1;
				i++;
			}
		}
		return tabFreq;
	}
		
	/** 
	  * Renvoie le minimum parmi les elements du tableau.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @return le minimum des elements du tableau
	  */ 
	int leMin(int[] leTab, int nbElem) {
		int min = -1;
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			min = leTab[0];
			int i=1;
			while(i<nbElem){
				if(min < leTab[i]){
					min = leTab[i];
				}
				i=i+1;
			}
		}
		return min;
	}
	
	/** 
	  * Renvoie le maximum parmi les elements du tableau.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @return le maximum des elements du tableau
	  */ 
	int leMax(int[] leTab, int nbElem) {
		int max = -1;
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			max = leTab[0];
			int i=1;
			while(i<nbElem){
				if(max > leTab[i]){
					max = leTab[i];
				}
				i=i+1;
			}
		}
		return max;
	}
	
	/**
	  * Recherche dichotomique d'une valeur dans un tableau. On suppose que le tableau est trie par ordre croissant. La valeur a
	  * rechercher peut exister en plusieurs exemplaires, dans ce cas, c'est la valeur a l'indice le + faible qui sera trouvé. On suppose
	  * egalement que le tableau passe en parametre est cree et possede au moins une valeur (nbElem &gt; 0). Ceci ne doit donc pas etre verifie.
	  * @param leTab le tableau trie par ordre croissant dans lequel effectuer la recherche
	  * @param nbElemle nombre d'entiers que contient le tableau
	  * @param aRech  l'entier a rechercher dans le tableau
	  * @return l'indice (&ge;0) de la position de l'entier dans le tableau ou -1 s'il n'est pas present
	  */
	int rechercheDicho(int[] leTab, int nbElem, int aRech) {
		int indInf = 0;
		int indSup = nbElem-1;
		int milieu;
		int res;
		if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}
		else {
			while(indInf != indSup) {
				milieu = (int) (indInf + indSup) / 2;
				if(aRech > leTab[milieu]) {
					indInf = milieu + 1;
				}
				else {
					indSup = milieu;
				}
				cpt ++;
			}	
		}

		if(leTab[indInf] == aRech) {
			res = indInf;
		}
		else {
			res = -1;
		}
	return res;
	}

	/**
	  * Affiche le contenu d'un sous-tableau entre 2 indices (indL, indR) donnés.
	  * @param leTab le tableau à afficher
	  * @param indL l'indice du début du sous-tableau (minimum zéro)
	  * @param indR l'indice de fin du sous-tableau (maximum nbElem-1)
	  */
	void afficherSousTab(int[] leTab, int indL, int indR) {
		int i;
		if(indCorrect(indL, indR) == false ) {
		}
		else {
			for(i = indL; i <= indR; i++) {
			System.out.println("tab["+i+"]="+leTab[i]);
			}	
		}
	}

	/** 
	  * Affiche le contenu d'un tableau case par case et par ligne de nbLgn elements. Tenir compte du cas particulier ou le tableau n'est pas cree.
	  * @param nbLgn - le nombre d'elements par ligne
	  * @param leTab - le tableau a afficher
	  * @param nbElem - le nombre d'entiers que contient le tableau
	  */
	void afficherTabLgn(int [] leTab, int nbElem, int nbLgn) {
		
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			int i = 0;
			int compteur = 0;
			while(i < nbElem) {
				
				if (compteur == nbLgn){
					System.out.print("\n");
					compteur = 0;
				}
				System.out.print(leTab[i]+" ");
				compteur = compteur+1;
				i = i+1;
			}
		}
		
	}

	/** 
	  * A partir d'un tableau cree, remplit aleatoirement le tableau de nbElem valeurs comprises entre min et max. Tenir compte du cas particulier ou le tableau n'est pas cree. Verifier que nbElem &lt;= taille sinon afficher une erreur. Verifier que min &lt;= max, sinon afficher une erreur.
	  * Utiliser obligatoirement la methode "int tirerAleatoire (int min, int max)".
	  * @param leTab - le tableau a remplir de valeurs tirees aleatoirement
	  * @param nbElem - le nombre d'entiers que contiendra le tableau
	  * @param min - la valeur de l'entier minimum
	  * @param max - la valeur de l'entier maximum
	  */
	void remplirAleatoire(int[] leTab, int nbElem, int min, int max) {
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else if(min > max){
			System.out.println("min est plus grand que max");
		}else {
			int i = 0;
			while(i < nbElem){
				leTab[i] = tirerAleatoire(min,max);
				i = i+1;
			}
		}
	}
	
	/**
	  * Remplace dans le tableau passé en paramètre une case tirée au hasard entre 0 et (nbElem-1) par une nouvelle valeur "newInt". On
	  * suppose que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem &gt; 0). Ceci ne doit donc pas être vérifié
	  * @param leTab tableau dont 1 case sera remplacée
	  * @param nbElem le nombre d'élements
	  * @param newInt le nouvel entier à placer au hasard dans le tableau
	  */
	void remplacerAuHasard (int[] leTab, int nbElem, int newInt) {
		int alea;
		if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}
		else {
			alea = tirerAleatoire(0, nbElem-1);
		leTab[alea] = newInt;
		}		
	}

	/** 
	  * Renvoie un entier aleatoire compris entre min et max (min &lt;= valeur &lt;= max).
	  * @param min - la valeur de l'entier minimum
	  * @param max - la valeur de l'entier maximum
	  * @return l'entier aleatoire
	  */ 
	int tirerAleatoire(int min, int max) {
		int nombreAleatoire = -1;
		if(min <= max){
			nombreAleatoire = min + (int)(Math.random() * ((max - min) + 1));
		}else {
			System.out.println("min est plus grand que max");
		}
		return nombreAleatoire;
	}
	
	//--------------------- Methode suplementaire ---------------
	
	/** 
	  * Affiche le contenu des nbElem cases d'un tableau une par une. Tenir compte du cas particulier ou le tableau n'est pas cree.
	  * @param leTab - le tableau a afficher
	  * @param nbElem - le nombre d'entiers que contient le tableau
	  */
	void afficherTab(int [] leTab, int nbElem) {
		
		if(leTab == null) {
			System.out.println("afficherTab Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("afficherTab nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("afficherTab nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("afficherTab nbElem trop grand");
		}else {
			for(int i=0; i < nbElem; i++) {
				System.out.println("tab [" + i + "] = " + leTab[i]);
			}
		}
	}
	
	/**
	  *Verifie si les deux indices d'un tableau sont bons et renvoie vrai si c'est le cas
	  *@param indL indice de gauche
	  *@param indR indice droit
	  *@return boolean vrai si les indices sont bons
	  */
	boolean indCorrect(int indL, int indR) {
		boolean correct = false;
		if(indR < indL) {
			System.out.println("L'indice gauche est superieur a l'indice gauche");
		}
		else if(indR < 0 || indL < 0) {
			System.out.println("Un indice ne peut pas etre negatif");
		}
		else {
			correct = true;
		}
		return correct;
	}
	
	/**
	  * Fait des tests sur le tableau et sa longueur
	  * @param leTab tableau d'entier
	  * @param nbElem nombre d'elements du tableau
	  * @return boolean vrai si tout est correct
	  */
	boolean paramCorrect(int[] leTab, int nbElem) {
		boolean correct = false;
		if(leTab == null) {
			System.out.println("Le tableau est null");
		}
		else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}
		else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}
		else {
			correct = true;
		}
		return correct;
	}

	/**
	  * Rend un tableau rempli de valeurs aleatoires et trie
	  * @param leTab tableau d'entier
	  * @param nbElem nombre d'elements
	  * @param ecart ecart max entre deux valeurs aleatoires
	  * @return Un tableau d'entier aleatoire et trie
	  */
	int[] creerTableauAleatoireEtTrie(int[] leTab, int nbElem, int ecart) {
		int alea = 0;
		int i = 0;
		while (i < nbElem) {
			alea = tirerAleatoire(alea, ecart);
			leTab[i] = alea;
			i = i+1;
		}
	return leTab;
	}

}