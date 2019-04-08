/**
  * Cette classe effectue des Tris différents sur un tableaux d'entiers.
  * @author S.LEBERRE 
  * @version 0.1
  * @since JDK 1.8
  */
public class TrisTableau {

	/**
	  * Point d'entree de l'execution
	  */
	void principal() {

		// appel des cas de test un par un
		//testTriParComptageFreqEfficacite();
		//testTriABullesEfficacite();
		//testTriSimpleEfficacite();
		//testTriRapideEfficacite();
		//testRechercheDichoEfficacite();
		//testRechercheSeqEfficacite();
		//testTriSimpleEtVeriftri();
		//testTriRapide();
		//testSeparer();
		//testRechercheDicho();
		//testRechercheSeq();
		//testCreerTabFreq();
		//testTriParComptageFreq();
		//testTriABulles();
		
	}

	/**
	  * Test de l'efficacité de la méthode triParComptageFreq 
	  */ 
	void testTriParComptageFreqEfficacite(){
		
	}

	/**
	  * Test de l'efficacité de la méthode triABulles
	  */
	void testTriABullesEfficacite(){
		
	}

	/**
	  * Test de l'efficacité de la méthode triSimple
	  */
	void testTriSimpleEfficacite(){
		
	}
	
	/**
	  * Test de l'efficacité de la méthode triRapide
	  */
	void testTriRapideEfficacite(){
	
	}
	
	/**
	  * Test de l'efficacité de la méthode rechercheDicho
	  */
	void testRechercheDichoEfficacite(){
		
	}
	
	/**
	  * Test de l'efficacité de la méthode rechercheSeq
	  */
	void testRechercheSeqEfficacite(){
		
	} 
	
	/**
	  * Test des méthodes triSimple et verifTri
	  */
	void testTriSimpleEtVeriftri(){
		
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
			afficherTab(tab,10);
		
			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			int [] leTab = {0,1,2,3,4,5,6,7,8,9};
			afficherTab(leTab,-1);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			afficherTab(leTab,11);

		
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");

			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			afficherTab(leTab,0);

			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			afficherTab(leTab,10);

		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
		
			// Test un cas normal
			System.out.println("\n------ Test d'un cas normal ------ ");
			afficherTab(leTab,5);
	}
	
	/**
	  * Test de la méthode de séparation
	  */
	void testSeparer(){
		
	}
	
	/**
	  * Test de la méthode rechercheSeq
	  */
	void testRechercheDicho(){
		
	}
	
	/**
	  * Test de la méthode rechercheSeq
	  */
	void testRechercheSeq(){
		
	}
	
	/**
	  * Test de la méthode creerTabFreq
	  */
	void testCreerTabFreq(){
		
		System.out.println("     ====== Test de la methode creerTabFreq ====== ");

		int [] tab1 = {2,5,0,14,6,25,10,2};
		int [] tab2 = {0,0,0,0,0,0};
		int [] tab3 = {5,5,5,5,5};
		int [] tab4 = {-1,-2,-3,-6,-1};
		int [] tabFreq1;
		int [] tabFreq2;
		int [] tabFreq3;
		int [] tabFreq4;
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
		
			// element max = 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			tabFreq1 = creerTabFreq(tab2,6);
			afficherTabLgn(tabFreq1,tabFreq1.length,5);
			
			
			// element max < 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			tabFreq4 = creerTabFreq(tab4,5);
			afficherTabLgn(tabFreq4,tabFreq4.length,5);
			
			// element min < 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			tabFreq1 = creerTabFreq(tab2,6);
			afficherTabLgn(tabFreq1,tabFreq1.length,5);
		
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
		
			// element min = 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
		
			
			// element min = max
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
		
			
		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
		
			// test 1
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			
	}
	
	/**
	  * Test de la méthode triParComptageFreq
	  */
	void testTriParComptageFreq(){
		
	}
	
	/**
	  * Test de la méthode triABulles
	  */ 
	void testTriABulles(){
		
	}
	
	/** fait C
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
		while ( !trouve && ( i < nbElem ) ) {
			if ( aRech == leTab[i] ) {
			trouve = true;
			}
			else {
			i++;
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
		
	}
	
	/** fait C
	  * Méthode de tri récursive selon le principe de séparation. La méthode s'appelle elle-même sur les tableaux gauche et droite par
	  * rapport à un pivot.
	  * @param tab le tableau sur lequel est effectué la séparation
	  * @param indL l'indice gauche de début de tableau
	  * @param indR l'indice droite de fin de tableau
	  */
	void triRapideRec(int[] tab, int indL, int indR){
		int indS;
		indS = separer ( tab, indL, indR );
		if ( (indS-1) > indL ) {
			triRapideRec ( tab, indL, (indS-1) );
		}
		if ( (indS+1) < indR ) {
			triRapideRec ( tab, (indS+1), indR );
		}
	}
	
	/** fait C
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
	
	/** fait C
	  * Tri par ordre croissant d'un tableau selon la méthode du tri à bulles : tant que le tableau n'est pas trié, permuter le contenu de 2
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
			}
			k = k-1;
		}
	}
	
	/** fait C
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
			}
		}
	}
	
	/** fait C
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
	
	/** Fait
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
	
	/** fait C
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
	
	/** fait C
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
				}
				i=i+1;
			}
		}
		return leTab;
	}
	
	/** fait C
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
		
		
//----------------------------------------------------------------------------------
//-------------------  Ancienne Procedure ------------------------------------------
//----------------------------------------------------------------------------------
	/** Fait
	  * Renvoie vrai si les 2 tableaux passes en parametre sont exactement les memes en nombre d'elements et en contenu (case par case). Verifier que les 2 tableaux sont crees sinon afficher un message d'erreur.
	  * @param tab1 - le 1er tableau a comparer
	  * @param tab2 - le 2eme tableau a comparer
	  * @param nbElem1 - le nombre d'entiers presents dans le 1er tableau
	  * @param nbElem2 - le nombre d'entiers presents dans le 2eme tableau
	  * @return true si egalite parfaite sinon false
	  */ 
	boolean egalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		boolean estEgale = false;
		
		if(tab1 == null || tab2 == null) {
			System.out.println("Un des deux tableaux est vide");
		}else if(nbElem1 == 0 || nbElem2 == 0) {
			System.out.println("Un des nbElem est egale a 0");
		}else if(nbElem1 < 0 || nbElem2 < 0) {
			System.out.println("L'un des deux nbElem est trop petit");
		}else if(nbElem1 > tab1.length || nbElem2 > tab2.length) {
			System.out.println("L'un des deux nbElem est trop grand");
		}else if(nbElem1 != nbElem2){
			System.out.println("Les deux tableaux n'ont pas le meme nombre d'elements");
		}else {
			estEgale = true;
			int i = 0;
			while(i < nbElem1){
				if(tab1[i] != tab2[i]){
					estEgale = false;
				}
				i = i+1;
			}
		}
		return estEgale;
	}

	/** Fait
	  *Test de la methode egalite
	  */
	void testEgalite() {
		
		System.out.println("\n\n     ====== Test de la methode egalite ====== ");
		
		// Tableau vide
		int [] tab1 = null;
		int [] tab2 = null;
		
		// Bon Tableau 
		int [] tab3 = new int[4];
		int [] tab4 = new int[4];
		tab3[0]=1; tab4[0]=1; 
		tab3[1]=3; tab4[1]=3; 
		tab3[2]=9; tab4[2]=9; 
		tab3[3]=4; tab4[3]=4; 
		
		// Mauvais Tableau
		int [] tab5 = new int[2];
		int [] tab6 = new int[1];
		tab5[0]=1; tab6[0]=1; 
		tab5[1]=3;
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");

			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			boolean test1 = egalite(tab1,tab2,4,4);
			System.out.println(test1);
		
			// Test quand nbElem1 est trop petit
			System.out.println("\n------ Test quand nbElem1 est trop petit ------ ");
			boolean test2 = egalite(tab3,tab4,2,4);
			System.out.println(test2);
		
			// Test quand nbElem1 est trop grand
			System.out.println("\n------ Test quand nbElem1 est trop grand ------ ");
			boolean test3 = egalite(tab3,tab4,5,4);
			System.out.println(test3);

			// Test quand nbElem1 est different de nbElem2
			System.out.println("\n------ Test quand nbElem1 est different de nbElem2 ------ ");
			boolean test4 = egalite(tab5,tab6,2,1);
			System.out.println(test4);
		
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");

			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			boolean test5 = egalite(tab5,tab6,0,0);
			System.out.println(test5);

			/* Test quand nbElem vaut 4*/
			System.out.println("\n------ Test quand nbElem vaut 4 ------ ");
			boolean test6 = egalite(tab3,tab4,4,4);
			System.out.println(test6);

		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
		
			// Test 1
			System.out.println("\n------ Test d'un cas normal ------ ");
			boolean test7 = egalite(tab3,tab4,4,4);
			System.out.println(test7);
	}
	
	/** Fait
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
	
	/** Fait
	  * Test de la methode remplirAleatoire 
	  */ 
	void testRemplirAleatoire() {
		
		System.out.println("\n\n     ====== Test de la methode remplirAleatoire ====== ");
		
		int [] tab = null ;
		int [] leTab = new int[10];
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
		
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			remplirAleatoire(tab,10,0,20);
						
			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			remplirAleatoire(leTab,-1,0,20);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			remplirAleatoire(leTab,15,0,20);
			
			// Test quand min > max
			System.out.println("\n------ Test min > max ------ ");
			remplirAleatoire(leTab,10,20,5);
			
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			remplirAleatoire(leTab,0,0,20);
			
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			remplirAleatoire(leTab,10,0,20);
			afficherTab(leTab,10);
		
		
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1
			System.out.println("\n------ Test 1 ------ ");
			remplirAleatoire(leTab,10,0,20);
			afficherTab(leTab,10);
			
			// Test 2
			System.out.println("\n------ Test 2 ------ ");
			remplirAleatoire(leTab,10,0,20);
			afficherTab(leTab,10);
	}  
	
	/** Fait
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
	
	/** Fait
	  * Test de la methode tirerAleatoire
	  */  
	void testTirerAleatoire() {
		
		System.out.println("\n\n     ====== Test de la methode tirerAleatoire ====== ");

									
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
	
			// Test quand min > max
			System.out.println("\n------ Test min > max ------ ");
			int test1 = tirerAleatoire(21,20);
			System.out.println(test1);	
	
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
	
			// Test quand min = max
			System.out.println("\n------ Test min = max ------ ");
			int test2 = tirerAleatoire(11,11);
			System.out.println(test2);	
	
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
	
			// Test 1
			System.out.println("\n------ Test 1 ------ ");
			int test3 = tirerAleatoire(0,20);
			System.out.println(test3);
	
			// Test 2
			System.out.println("\n------ Test 2 ------ ");
			int test4 = tirerAleatoire(0,20);
			System.out.println(test4);
	
			// Test 3
			System.out.println("\n------ Test 3 ------ ");
			int test5 = tirerAleatoire(0,20);
			System.out.println(test5);	
	}
	
	/** Fait
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
	
	/** Fait
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
	
	/** Fait
	  * Test des methodes leMin et leMax
	  */   
	void testLeMinEtLeMax() {
		
		// declaration variable
		int [] tab = null ;
		int [] leTab = {4,3,2,5,8,1,4,0,15,9};
				
		System.out.println("\n\n     ====== Test de la methode leMax ====== ");
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab,leTab.length);
		
			// Test les cas d'erreurs
			System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
				// Test un tableau vide
				System.out.println("\n------ Test d'un tableau vide ------ ");
				System.out.println(leMax(tab,10));
		
				// Test quand nbElem est trop petit
				System.out.println("\n------ Test quand nbElem est trop petit ------ ");
				System.out.println(leMax(leTab,-1));
	
				// Test quand nbElem est trop grand
				System.out.println("\n------ Test quand nbElem est trop grand ------ ");
				System.out.println(leMax(leTab,11));
			
			// Test les cas limites
			System.out.println("\n   ------ Test tous les cas limites ------ ");
				
				// Test quand nbElem vaut 0
				System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
				System.out.println(leMax(leTab,0));
				
				// Test quand nbElem vaut 10
				System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
				System.out.println(leMax(leTab,10));
				
				
			// Test les cas normaux
			System.out.println("\n   ------ Test tous les cas normaux ------ ");
				
				// Test 1
				System.out.println("\n------ Test 1 Doit trouver 8 ------ ");
				System.out.println(leMax(leTab,7));
				
				// Test 2
				System.out.println("\n------ Test 2 Doit trouver 5 ------ ");
				System.out.println(leMax(leTab,4));
			
			
		System.out.println("\n\n     ====== Test de la methode leMin ====== ");
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab,leTab.length);
		
			// Test les cas d'erreurs
			System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
				
				// Test un tableau vide
				System.out.println("\n------ Test d'un tableau vide ------ ");
				System.out.println(leMin(tab,10));
		
				// Test quand nbElem est trop petit
				System.out.println("\n------ Test quand nbElem est trop petit ------ ");
				System.out.println(leMin(leTab,-1));
	
				// Test quand nbElem est trop grand
				System.out.println("\n------ Test quand nbElem est trop grand ------ ");
				System.out.println(leMin(leTab,11));
				
			// Test les cas limites
			System.out.println("\n   ------ Test tous les cas limites ------ ");
				
				// Test quand nbElem vaut 0
				System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
				System.out.println(leMin(leTab,0));
				
				// Test quand nbElem vaut 10
				System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
				System.out.println(leMin(leTab,10));
				
			// Test les cas normaux
			System.out.println("\n   ------ Test tous les cas normaux ------ ");
				
				// Test 1
				System.out.println("\n------ Test 1 Doit trouver 1 ------ ");
				System.out.println(leMin(leTab,7));
				
				// Test 2
				System.out.println("\n------ Test 2 Doit trouver 2 ------ ");
				System.out.println(leMin(leTab,4));
	}
	
	/** Fait
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
}
