/**
  * Cette classe effectue des operations elementaires sur un ou plusieurs tableaux d'entiers.
  * @author S.LEBERRE 
  * @version 1.0
  * @since JDK 1.8
  */
public class SimplesTableau {

	/**
	  * Point d'entree de l'execution
	  */
	void principal() {

		// appel des cas de test un par un
		testAfficherTab();
		testSaisirEtAfficherTabLgn();
		testTirerAleatoire();
		testRemplirAleatoire();
		testEgalite();
		testCopier();
		testNbOccurrences();
		testLeMinEtLeMax();
		testInverse();
		testEchange();
		testMelange();
		testDecalerGche();
		testSupprimerUneValeur();
		testInclusion();

	}

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
	  * Test de la methode afficherTab
	  */
	void testAfficherTab() {
		
		System.out.println("     ====== Test de la methode afficherTab ====== ");


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
	  * Saisie de nbElem valeurs dans un tableau par boite de dialogue. Tenir compte du cas particulier ou le tableau n'est pas cree. Verifier que nbElem &lt;= taille avant de commencer la saisie sinon afficher un message d'erreur.
	  * @param leTab - le tableau a remplir par saisies successives de l'utilisateur
	  * @param nbElem - le nombre d'entiers que le tableau contiendra reellement (&lt;= taille)
	  */ 
	void saisir(int [] leTab, int nbElem){
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
			while ( i < nbElem ){
			leTab[i] = SimpleInput.getInt ( "Rentrer un entier" );
			i = i+1;
			}
		}
	}
	
	/** 
	  *Test des methodes saisir et afficherTabLgn
	  */  
	void testSaisirEtAfficherTabLgn(){
		
		System.out.println("\n\n     ====== Test de la methode saisir et afficherTabLgn ====== ");

		int [] tab = null;
		int [] leTab = new int[10];
		
		saisir(leTab,10);

		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");

			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			afficherTabLgn(tab,10,2);
		
			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			afficherTabLgn(leTab,-1,2);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			afficherTabLgn(leTab,11,2);

		
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");

			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			afficherTabLgn(leTab,0,2);

			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			afficherTabLgn(leTab,10,2);


		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
		
			// Test 1
			System.out.println("\n------ Test d'un cas normal ------ ");
			afficherTabLgn(leTab,5,2);
	}
	
	/** 
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
	
	/** 
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
	
	/**
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
	
	/** 
	  * Renvoie la copie exacte (clone) du tableau passe en parametre.
	  * @param tabToCopy - le tableau a copier
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @return le nouveau tableau qui est la copie du tableau passe en parametre
	  */  
	int[] copier(int[] tabToCopy, int nbElem) {
		int [] copier = new int[0];
		if(tabToCopy == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > tabToCopy.length) {
			System.out.println("nbElem trop grand");
		}else {
			copier = new int[nbElem];
			int i = 0;
			while ( i < nbElem){
				copier[i] = tabToCopy[i];
				i = i+1;
			}
		}
		return copier;
	}
	
	/** a
	  * Test de la methode copier
	  */   
	void testCopier() {
		
		System.out.println("\n\n     ====== Test de la methode copier ====== ");
		
		// declaration tableau
		int [] tab = null ;
		int [] leTab = {0,1,2,3,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab,leTab.length);
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
		
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			copier(tab,10);

			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			copier(leTab,-10);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			copier(leTab,11);
			
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			copier(leTab,0);
			
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			afficherTab(copier(leTab,10),10);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");
			
			// Test 1
			System.out.println("\n------ Test 1 nbElem = 5 ------ ");
			afficherTab(copier(leTab,5),5);
			
			// Test 2
			System.out.println("\n------ Test 2 nbElem = 7 ------ ");
			afficherTab(copier(leTab,7),7);
	}
	
	/** 
	  * Renvoie le nombre d'occurrences d'un entier dans un tableau.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @param elem - l'entier a rechercher dans le tableau
	  * @return le nombre d'occurrences
	  */   
	int nbOccurrences(int[] leTab, int nbElem, int elem) {
		int compteur = -1;
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			compteur = 0;
			int i= 0;
			while(i < nbElem){
				if(leTab[i] == elem){
					compteur = compteur+1;
				}
				i = i+1;
			}
		}
		return compteur;
	}
	
	/** 
	  * Test de la methode nbOccurrences
	  */   
	void testNbOccurrences() {
		
		System.out.println("\n\n     ====== Test de la methode nbOccurrences ====== ");
		
		// declaration variable
		int [] tab = null ;
		int [] leTab = {4,1,2,3,4,5,4,5,8,9};
		int occurence;
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab,leTab.length);
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			occurence = nbOccurrences(tab,10,2);
			System.out.println(occurence);
		
			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			occurence = nbOccurrences(leTab,-1,2);
			System.out.println(occurence);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			occurence = nbOccurrences(leTab,11,2);
			System.out.println(occurence);
			
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			occurence = nbOccurrences(leTab,0,2);
			System.out.println(occurence);
			
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			occurence = nbOccurrences(leTab,10,2);
			System.out.println(occurence);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1
			System.out.println("\n------ Test 1 Occurence = 2 ------ ");
			occurence = nbOccurrences(leTab,10,5);
			System.out.println(occurence);
			
			// Test 2
			System.out.println("\n------ Test 2 Occurence = 3 ------ ");
			occurence = nbOccurrences(leTab,10,4);
			System.out.println(occurence);
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
	
	/** 
	  * Renvoie un nouveau tableau qui est l'inverse de celui passe en parametre. Son j eme element est egal au (nbElem+1-j) element du tableau initial (j=1 signifie premier element du tableau).
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @return le nouveau tableau qui est l'inverse de leTab sur la plage (0...nbElem-1)
	  */ 
	int[] inverse(int[] leTab, int nbElem) {
		int[] inverse = new int[0];
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			inverse = new int[nbElem];
			int i = 0;
			int j = nbElem-1;
			while( i < nbElem){
				inverse[i] = leTab[j];
				i = i+1;
				j = j-1;
			}
		}
		return inverse;
	}	  
	
	/** 
	  * Test de la methode inverse
	  */ 
	void testInverse() {
		
		System.out.println("\n\n     ====== Test de la methode inverse ====== ");
				
		// declaration variable
		int [] tab = null ;
		int [] leTab1 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab2 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab3 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab4 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab5 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab6 = {0,1,2,3,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab1,leTab1.length);
		
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			inverse(tab,10);
			afficherTab(tab,10);

			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			inverse(leTab1,-1);
			afficherTab(leTab1,10);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			inverse(leTab2,11);
			afficherTab(leTab2,10);
			
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			inverse(leTab3,0);
			afficherTab(leTab3,10);
			
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			inverse(leTab4,10);
			afficherTab(leTab4,10);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1 nbElem = 7
			System.out.println("\n------ Test 1 nbElem = 7 ------ ");
			inverse(leTab5,7);
			afficherTab(leTab5,7);
			
			// Test 2 nbElem = 5
			System.out.println("\n------ Test 2 nbElem = 5 ------ ");
			inverse(leTab6,5);
			afficherTab(leTab6,5);
	}
	
	/** 
	  * Echange les contenus des cases du tableau passe en parametre, cases identifiees par les indices ind1 et ind2. Verifier que les indices ind1 et ind2 sont bien compris entre zero et (nbElem-1), sinon afficher un message d'erreur.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @param ind1 - numero de la premiere case a echanger
	  * @param ind2 - numero de la deuxieme case a echanger
	  */ 
	void echange(int[] leTab, int nbElem, int ind1, int ind2) {
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
	  * Test de la methode echange
	  */
	void testEchange() {
	  
		System.out.println("\n\n     ====== Test de la methode echange ====== ");
		
		// declaration variable
		int [] tab = null ;
		int [] leTab = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab1 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab2 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab3 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab4 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab5 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab6 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab7 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab8 = {0,1,2,3,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab1,leTab1.length);
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			echange(tab,10,3,6);
			afficherTab(tab,10);
			
			// nbElem faux
				// Test quand nbElem est trop petit
				System.out.println("\n------ Test quand nbElem est trop petit ------ ");
				echange(leTab,-1,3,6);
				afficherTab(leTab,10);
				// Test quand nbElem est trop grand
				System.out.println("\n------ Test quand nbElem est trop grand ------ ");
				echange(leTab,11,3,6);
				afficherTab(leTab,10);
			
			// ind1 faux
				// Test quand ind1 est trop petit
				System.out.println("\n------ Test quand ind1 est trop petit ------ ");
				echange(leTab,9,-1,6);
				afficherTab(leTab,10);
				// Test quand ind1 est trop grand
				System.out.println("\n------ Test quand ind1 est trop grand ------ ");
				echange(leTab,9,10,6);
				afficherTab(leTab,10);
			
			// ind2 faux
				// Test quand ind2 est trop petit
				System.out.println("\n------ Test quand ind2 est trop petit ------ ");
				echange(leTab,9,3,-1);
				afficherTab(leTab,10);
				// Test quand ind2 est trop grand
				System.out.println("\n------ Test quand ind2 est trop grand ------ ");
				echange(leTab,9,3,10);
				afficherTab(leTab,10);
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			//nbElem
				// Test quand nbElem vaut 0
				System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
				echange(leTab1,0,3,6);
				afficherTab(leTab1,10);
				// Test quand nbElem vaut 10
				System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
				echange(leTab2,10,3,6);
				afficherTab(leTab2,10);
			
			// ind1
				// Test quand ind1 vaut 0
				System.out.println("\n------ Test quand ind1 vaut 0 ------ ");
				echange(leTab3,10,0,6);
				afficherTab(leTab3,10);
				// Test quand ind1 vaut 9
				System.out.println("\n------ Test quand ind1 vaut 9 ------ ");
				echange(leTab4,10,9,6);
				afficherTab(leTab4,10);
			
			// ind2
				// Test quand ind2 vaut 0
				System.out.println("\n------ Test quand ind2 vaut 0 ------ ");
				echange(leTab5,10,3,0);
				afficherTab(leTab5,10);
				// Test quand ind2 vaut 9
				System.out.println("\n------ Test quand ind2 vaut 9 ------ ");
				echange(leTab6,10,3,9);
				afficherTab(leTab6,10);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1 echange 3 et 9
			System.out.println("\n------ Test 1 echange 3 et 9 ------ ");
			echange(leTab7,10,3,9);
			afficherTab(leTab7,10);
			
			// Test 2 echange 7 et 4
			System.out.println("\n------ Test 2 echange 7 et 4 ------ ");
			echange(leTab8,10,7,4);
			afficherTab(leTab8,10);
	}
	
	/** 
	  * Retourne un nouveau tableau qui a la meme taille et les memes occurrences d'elements que le tableau passe en parametre mais ces elements sont repartis selon des indices aleatoires (0 &lt;= indice &lt;= nbElem-1). Une technique simple consiste a utiliser les methodes "echange" et "tirerAleatoire" pour effectuer le melange.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @return le nouveau tableau qui a le meme contenu que le tableau initial mais melange
	  */ 
	int[] melange(int[] leTab, int nbElem) { 
		int [] melange = new int [0];
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else{
			melange = new int [nbElem];
			melange = copier(leTab,nbElem);
			int i = 0;
			while(i < nbElem){
				int ind1 = tirerAleatoire(0,nbElem-1);
				int ind2 = tirerAleatoire(0,nbElem-1);
				echange(melange,nbElem,ind1,ind2);
				i = i+1;
			}
		}
		return melange;
	}
	
	/**
	  * Test de la methode melange
	  */ 
	void testMelange() {
		
		System.out.println("\n\n     ====== Test de la methode melange ====== ");
		
		// declaration variable
		int [] tab = null ;
		int [] leTab = {0,1,2,3,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab,leTab.length);
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			afficherTab(melange(tab,10),10);

			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			afficherTab(melange(leTab,-1),10);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			afficherTab(melange(leTab,11),10);
			
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			afficherTab(melange(leTab,0),10);
			
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			afficherTab(melange(leTab,10),10);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1 nbElem = 7
			System.out.println("\n------ Test 1 nbElem = 7 ------ ");
			afficherTab(melange(leTab,7),7);
			
			// Test 2 nbElem = 5
			System.out.println("\n------ Test 2 nbElem = 5 ------ ");
			afficherTab(melange(leTab,5),5);
	}
	 
	/** 
	  * Decale de une case de la droite vers la gauche toutes les cases d'un tableau a partir d'un indice "ind" et jusque nbElem-1 ([ind]&lt;-[ind+1]&lt;-[ind+2]&lt;-...&lt;-[nbElem-2]&lt;-[nbElem-1]). Verifier que ind est compris entre 0 et (nbElem-2) sinon afficher une erreur.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @param ind - l'indice a partir duquel commence le decalage a gauche
	  */ 
	void decalerGche(int[] leTab, int nbElem, int ind) {
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else if(ind < 0){
			System.out.println("ind trop petit");
		}else if(ind > nbElem-2){
			System.out.println("ind trop grand");
		}else {
			while(ind < nbElem-1){
				leTab[ind] = leTab[ind+1];
				ind = ind+1;
			}
		}
	}
	 
	/** 
	  * Test de la methode decalerGche
	  */
	void testDecalerGche() {
		
		System.out.println("\n\n     ====== Test de la methode decalerGche ====== ");

		// declaration variable
		int [] tab = null ;
		int [] leTab1 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab2 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab3 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab4 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab5 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab6 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab7 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab8 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab9 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab10 = {0,1,2,3,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab1,leTab1.length);
		
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			decalerGche(tab,10,5);
			afficherTab(tab,10);
			
			// nbElem faux
				// Test quand nbElem est trop petit
				System.out.println("\n------ Test quand nbElem est trop petit ------ ");
				decalerGche(leTab1,-1,5);
				afficherTab(leTab1,10);
				// Test quand nbElem est trop grand
				System.out.println("\n------ Test quand nbElem est trop grand ------ ");
				decalerGche(leTab2,11,5);
				afficherTab(leTab2,10);
			
			// ind faux
				// Test quand ind est trop petit
				System.out.println("\n------ Test quand ind est trop petit ------ ");
				decalerGche(leTab3,10,-1);
				afficherTab(leTab3,10);
				// Test quand ind est trop grand
				System.out.println("\n------ Test quand ind est trop grand ------ ");
				decalerGche(leTab4,10,10);
				afficherTab(leTab4,10);
				
				
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// nbElem
				// Test quand nbElem vaut 0
				System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
				decalerGche(leTab5,0,5);
				afficherTab(leTab5,10);
				// Test quand nbElem vaut 10
				System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
				decalerGche(leTab6,10,5);
				afficherTab(leTab6,10);
			
			// ind
				// Test quand ind vaut 0
				System.out.println("\n------ Test quand ind vaut 0 ------ ");
				decalerGche(leTab7,10,0);
				afficherTab(leTab7,10);
				// Test quand ind vaut 10
				System.out.println("\n------ Test quand ind vaut 9 ------ ");
				decalerGche(leTab8,10,9);
				afficherTab(leTab8,10);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1 ind = 7
			System.out.println("\n------ Test 1 ind = 7 ------ ");
			decalerGche(leTab9,10,7);
			afficherTab(leTab9,10);
			
			// Test 2 ind = 5
			System.out.println("\n------ Test 2 ind = 5 ------ ");
			decalerGche(leTab10,10,5);
			afficherTab(leTab10,10);
	}
	
	/** 
	  * Supprime du tableau la premiere case rencontree dont le contenu est egale a "valeur". La case du tableau est supprimee par decalage a gauche des cases du tableau. L'appel de la methode "decalerGche" est obligatoire. A l'issue de la suppression (si elle existe) le nombre d'elements dans le tableau est decremente et retourne.
	  * @param leTab - le tableau
	  * @param nbElem - le nombre d'entiers presents dans le tableau
	  * @param valeur - le contenu de la premiere case a supprimer
	  * @return le nombre d'elements dans le tableau (eventuellement inchange)
	  */
	int supprimerUneValeur(int[] leTab, int nbElem, int valeur) {
		if(leTab == null) {
			System.out.println("Le tableau est vide");
		}else if(nbElem == 0) {
			System.out.println("nbElem egale a 0");
		}else if(nbElem < 0) {
			System.out.println("nbElem trop petit");
		}else if(nbElem > leTab.length) {
			System.out.println("nbElem trop grand");
		}else {
			boolean detruite = false;
			int i=0;
			while(!detruite && i < nbElem){
				if(leTab[i]==valeur){
					decalerGche(leTab,nbElem,i);
					detruite = true;
					nbElem = nbElem-1;
				}
				i = i+1;
			}
		}
		return nbElem;
	}
	
	/** 
	  * Test de la methode supprimerUneValeur
	  */
	void testSupprimerUneValeur() {
		
		System.out.println("\n\n     ====== Test de la methode supprimerUneValeur ====== ");

		// declaration variable
		int [] tab = null ;
		int [] leTab1 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab2 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab3 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab4 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab5 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab6 = {0,1,2,3,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab1,leTab1.length);
		
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Test un tableau vide
			System.out.println("\n------ Test d'un tableau vide ------ ");
			supprimerUneValeur(tab,10,2);
			afficherTab(tab,9);
		
			// Test quand nbElem est trop petit
			System.out.println("\n------ Test quand nbElem est trop petit ------ ");
			supprimerUneValeur(leTab1,-1,7);
			afficherTab(leTab1,9);

			// Test quand nbElem est trop grand
			System.out.println("\n------ Test quand nbElem est trop grand ------ ");
			supprimerUneValeur(leTab2,11,8);
			afficherTab(leTab2,9);
			
			
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// Test quand nbElem vaut 0
			System.out.println("\n------ Test quand nbElem vaut 0 ------ ");
			supprimerUneValeur(leTab3,0,6);
			afficherTab(leTab3,9);
			
			// Test quand nbElem vaut 10
			System.out.println("\n------ Test quand nbElem vaut 10 ------ ");
			supprimerUneValeur(leTab4,10,4);
			afficherTab(leTab4,9);
			
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1 valeur = 7
			System.out.println("\n------ Test 1 valeur = 7 ------ ");
			supprimerUneValeur(leTab5,10,7);
			afficherTab(leTab5,9);
			
			// Test 2 valeur = 5
			System.out.println("\n------ Test 2 valeur = 5 ------ ");
			supprimerUneValeur(leTab6,10,5);
			afficherTab(leTab6,9);
	}
	
	/** 
	  * Renvoie vrai ssi le tableau tab1 est inclus dans tab2. Autrement dit, si tous les elements de tab1 se retrouvent integralement dans tab2 (y compris les doublons) mais pas necessairement dans le meme ordre. L'utilisation de methodes deja ecrites est autorise.
	  * @param tab1 - le premier tableau
	  * @param tab2 - le deuxieme tableau
	  * @param nbElem1 - le nombre d'entiers presents dans le tableau1
	  * @param nbElem2 - le nombre d'entiers presents dans le tableau2
	  * @return vrai ssi tableau1 est inclus dans tableau2
	  */
	boolean inclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		boolean estDedans = false;
		if(tab1 == null) {
			System.out.println("Le tableau 1 est vide");
		}else if(tab2 == null) {
			System.out.println("Le tableau 2 est vide");
		}else if(nbElem1 == 0 || nbElem2 == 0) {
			System.out.println("un des nbElem est egale a 0");
		}else if(nbElem1 < 0) {
			System.out.println("nbElem1 trop petit");
		}else if(nbElem1 > tab1.length) {
			System.out.println("nbElem1 trop grand");
		}else if(nbElem2 < 0) {
			System.out.println("nbElem2 trop petit");
		}else if(nbElem2 > tab2.length) {
			System.out.println("nbElem2 trop grand");
		}else {
			estDedans = true;
			int i=0;
			int j;
			while(estDedans==true && i < nbElem1){
				j = 0;
				estDedans = false;
				while(!estDedans && j < nbElem2){
					if(tab1[i] == tab2[j]){
						estDedans = true;
					}else{
						estDedans = false;
					}
					j = j+1;
				}
				i = i+1;
			}
		}
		return estDedans;
	}
	
	/**
	  * Test de la methode inclusion
	  */
	void testInclusion() {
		
		System.out.println("\n\n     ====== Test de la methode inclusion ====== ");

		// declaration variable
		int [] tab1 = null ;
		int [] tab2 = null ;
		int [] leTab1 = {0,1,2,3,4,5,6,7,8,9};
		int [] leTab2 = {0,1,2,11,4,5,6,7,8,9};
		
		// Le tableau de depart
		System.out.println("\n   ------ Le Tableau au debut ------ ");
		afficherTab(leTab1,leTab1.length);
		
		
		// Test les cas d'erreurs
		System.out.println("\n   ------ Test tous les cas d'erreurs ------ ");
			
			// Tableau vide
				// Tableau 1
				System.out.println("\n------ Test tableau 1 vide ------ ");
				System.out.println(inclusion(tab1,leTab2,10,10));
				// Tableau 2
				System.out.println("\n------ Test tableau 2 vide ------ ");
				System.out.println(inclusion(leTab2,tab1,10,10));
			
			// nbElem1
				// Test quand nbElem1 est trop petit
				System.out.println("\n------ Test quand nbElem1 est trop petit ------ ");
				System.out.println(inclusion(leTab1,leTab1,-1,10));
				// Test quand nbElem1 est trop grand
				System.out.println("\n------ Test quand nbElem1 est trop grand ------ ");
				System.out.println(inclusion(leTab1,leTab1,11,10));
			
			// nbElem2
				// Test quand nbElem2 est trop petit
				System.out.println("\n------ Test quand nbElem2 est trop petit ------ ");
				System.out.println(inclusion(leTab1,leTab1,10,-1));
				// Test quand nbElem2 est trop grand
				System.out.println("\n------ Test quand nbElem2 est trop grand ------ ");
				System.out.println(inclusion(leTab1,leTab1,10,11));
				
				
		// Test les cas limites
		System.out.println("\n   ------ Test tous les cas limites ------ ");
			
			// nbElem1
				// Test quand nbElem1 vaut 0
				System.out.println("\n------ Test quand nbElem1 vaut 0 ------ ");
				System.out.println(inclusion(leTab1,leTab1,0,10));
				// Test quand nbElem1 vaut 10
				System.out.println("\n------ Test quand nbElem1 vaut 10 ------ ");
				System.out.println(inclusion(leTab1,leTab1,10,10));
			
			// nbElem2
				// Test quand nbElem2 vaut 0
				System.out.println("\n------ Test quand nbElem2 vaut 0 ------ ");
				System.out.println(inclusion(leTab1,leTab1,10,0));
				// Test quand nbElem vaut 10
				System.out.println("\n------ Test quand nbElem2 vaut 10 ------ ");
				System.out.println(inclusion(leTab1,leTab1,10,10));
			
		// Test les cas normaux
		System.out.println("\n   ------ Test tous les cas normaux ------ ");
			
			// Test 1 Vrai
			System.out.println("\n------ Test 1 Vrai ------ ");
			System.out.println(inclusion(leTab1,leTab1,10,10));
			
			// Test 2 Faux
			System.out.println("\n------ Test 2 Faux ------ ");
			System.out.println(inclusion(leTab1,leTab2,10,10));
	} 

}
