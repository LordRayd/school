/**
 * Cette classe effectue des opérations élémentaires sur un ou plusieurs tableaux d'entiers. La taille d'un tableau est par définition le nombre TOTAL de cases = tab.length. Un tableau d'entiers crée possède nbElem élements qui ne correspond pas forcément à la taille de tableau.Il faut donc toujours considéré que nbElem <= tab.length (= taille).
 *@author L.Toudoire
 *@version 1.0
 *@since JDK 1.8
 */
 public class SimplesTableau {
	 /**
	* Point d'entrée de l'éxecution
	*/
	void principal(){
		// appel des cas de test un par un
		//testAfficherTab() ;
		//testSaisir() ;
		//testAfficherTabLgn();
		//testTirerAleatoire();
		//testEgalite();
		//testRemplirAleatoire();
		//testCopier();
		//testNbOccurences();
		//testLeMin();
		//testLeMax();
		//testInverse ();
		//testEchange();
		//testMelange();
		//testDecalerGche();
		//testSupprimerUneValeur();
	}
	/**
	* Affiche le contenu des nbElem cases d'un tableau une par une.
	*@param leTab le tableau à afficher
	*@param nbElem le nombre d'élements du tableau à afficher
	*/
	void afficherTab(int[] leTab ,int nbElem ){
		if (leTab != null){
			if (nbElem >= 0 && nbElem <= leTab.length ){
				for ( int i = 0; i < nbElem ; i++){
					System.out.println ("leTab["+i+"]= "+leTab[i]);
				}
			}
			else {
				System.out.println ("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non cree ");
		}
	}
	/**
	* Test de la methode afficherTab()
	*/
	void testAfficherTab() {
		System.out.println("\n===Test methode afficherTab ===");
		System.out.println("Test du contenu du tableau ");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		afficherTab(tab,4);
		System.out.println("Test avec 0 elements ");
		afficherTab(tab,0);
		System.out.println("Test avec lengh elements");
		afficherTab(tab,tab.length);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		afficherTab(tab2,2);
		System.out.println("Cas d'erreur : nbElem <0");
		afficherTab(tab,-1);
		System.out.println("Cas d'erreur :nbElem > length ");
		afficherTab(tab,(tab.length + 1));
	}
	/**
	 * Saisie le nbElem valeurs dans un tableau par boite de dialogue.
	 *@param leTab le tableau à afficher
	*@param nbElem le nombre d'élements du tableau à afficher
	 */
	void saisir( int [] leTab , int nbElem ){
		 if (leTab != null){
			if (nbElem >= 0 && nbElem <= leTab.length ){
				for ( int i = 0; i < nbElem ; i++){
					leTab[i] = SimpleInput.getInt ("Entrez un entier");
				}
			}
			else {
				System.out.println ("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non cree ");
		}
	}
	/**
	* Test de la methode afficherTab()
	*/
	void testSaisir() {
		System.out.println("\n ===Test méthode saisir ===");
		System.out.println("Test du contenu du tableau : 4 éléments");
		int [] tab = new int[10];
		saisir(tab,4);
		afficherTab(tab,4);
		System.out.println("Test avec 0 elements ");
		saisir(tab,0);
		System.out.println("Test avec lengh elements");
		saisir(tab,tab.length);
		afficherTab(tab,tab.length);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		saisir(tab2,2);
		System.out.println("Cas d'erreur : nbElem <0");
		saisir(tab,-1);
		System.out.println("Cas d'erreur :nbElem > length ");
		saisir(tab,(tab.length + 1));
	}
	/**
	*Affiche le contenu d'un tableau case par case et par ligne de nbLgn elements
	*@param leTab Le tableau à afficher
	*@param nbElem le nombre d'entiers que contient le tableau
	*@param nbLgn le nombre d'elements par ligne
	*/
	void afficherTabLgn( int[] leTab , int nbElem , int nbLgn ){
		if (leTab != null){
			if (nbElem >= 0 && nbElem <= leTab.length ){
				if ( nbLgn > 0){
					for ( int i = 1; i <= nbElem ; i++){
						if (i%nbLgn == 0 ){
							System.out.println(leTab[i-1]+" ");
						}
						else{
							System.out.print(leTab[i-1]+" ");
						}
					}
				}
				else{
					System.out.print("nbLgn hors domaine");
				}
			}
			else {
				System.out.println ("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non cree ");
		}
	}
	/**
	*Test de la méthode TabLgn
	*/
	void testAfficherTabLgn (){
		System.out.println("\n===Test méthode afficherTabLgn ===");
		System.out.println("Test du contenu du tableau : 4 elements et 3 par lignes");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		afficherTabLgn(tab,4,3);
		System.out.println("\nTest avec 0 elements ");
		afficherTabLgn(tab,0,3);
		System.out.println("\nTest avec lengh elements");
		afficherTabLgn(tab,tab.length,2);
		System.out.println("\nCas d'erreur : Tableau null");
		int [] tab2 = null ;
		afficherTabLgn(tab2,2,3);
		System.out.println("\nCas d'erreur : nbElem <0");
		afficherTabLgn(tab,-1,3);
		System.out.println("\nCas d'erreur :nbElem > length ");
		afficherTabLgn(tab,(tab.length + 1),3);
		System.out.println("\nCas d'erreur : nbLgn <=0");
		afficherTabLgn(tab,(tab.length + 1),0);
	}			
	/**
	*Renvoie un entier aléatoirement compris entre min et max
	*@param min la valeur de l'entier minimum
	*@param max la valuer de l'entier max
	*@return randomNb l'entier aleatoire
	*/
	int tirerAleatoire (int min , int max) {
		int ret = 0 ;
		if (min <= max ){
			ret = (int)(Math.random()* (max+1 - min ))+ min;
		}
		else {
			System.out.println("Max < Min");
		}
		return ret;
	}
	/**
	* Test de la méthode tirerAleatoire
	*/
	void testTirerAleatoire(){
		System.out.println("\n===Test methode tirerAleatoire===");
		System.out.println("\nTest avec min = 1 et max = 10)");
		System.out.println(tirerAleatoire(1,10));
		System.out.println(tirerAleatoire(1,10));
		System.out.println(tirerAleatoire(1,10));
		System.out.println(tirerAleatoire(1,10));
		System.out.println(tirerAleatoire(1,10));
		System.out.println("\nCas erreur : min > max");
		System.out.print(tirerAleatoire(1,0));
	}
	/**
	*Renvoie vrai si les 2 tableaux passés en paramètre sont exactement les même en nombre d'éléments 
	*et en contenu (case par case ). Verifier que les 2 tableau sont crées sinon afficher un message d'erreur.
	*@param tab1 Premier tableau d'entier a comparer
	*@param tab2 Second tableau d'entier a comparer
	*@param nbElem1 le nombre d'entiers présents dans le 1er tableau
	*@param nbElem2 le nombre d'entiers présents dans le 2nd tableau
	*@return  true si égalité parfaite sinon false
	*/
	boolean egalite ( int [] tab1 , int []tab2 ,int nbElem1 , int nbElem2){
		boolean ret = true ;
		if (tab1 != null && tab2 != null) {
			if (nbElem1 >= 0 && nbElem1 <= tab1.length && nbElem2 >= 0 && nbElem2 <= tab2.length  ){
				if (nbElem1 == nbElem2){
					int i = 0; 
					while (i < nbElem1  && ret == true){
						if (tab1[i] != tab2[i]){
							ret = false ;
						}
						i ++ ;
					} 				
				}
				else {
					System.out.println("nbElem1 != nbElem2");
				}
			}
			else {
				ret = false ;
				System.out.println ("nbElem(s) hors domaine");
			}
		}
		else {
			ret = false ;
			System.out.println("Tableau(x) non cree");
		}
		System.out.print("L'egalite est   ");
		return ret;
	}
	/**
	*Test de la méthode egalite()
	*/
	void testEgalite(){
		System.out.println("\n===Test methode egalite ===");
		System.out.println("\nTest d'une egalite");
		int [] tab1 = new int [4];
		for (int i = 0 ; i < 4 ; i++){
			tab1[i] = i ;			
		}
		int [] tab2 = new int [4];
		for (int i = 0 ; i < 4 ; i++){
			tab2[i] = i ;			
		}
		System.out.println(egalite(tab1,tab2,4,4));
		System.out.println("\nCas erreur : nbElem1 hors domaine");
		System.out.println("\nnbElem1 premier Tableau");
		System.out.println(egalite(tab1,tab2,-1,3));
		System.out.println("\nnbElem1 second Tableau");
		System.out.println(egalite(tab1,tab2,99,3));
		System.out.println("\nCas erreur : nbElem2 hors domaine");
		System.out.println("\nnbElem2 premier Tableau");
		System.out.println(egalite(tab1,tab2,3,-5));
		System.out.println("\nnbElem2 second Tableau");
		System.out.println(egalite(tab1,tab2,1,99));
		System.out.println("\nCas erreur : tableau non cree");
		int [] tab3 = null ;
		System.out.println(egalite(tab3,tab2,3,3));
	}
	/**
	*A partir d'un tableau cree,remplir aleatoirement le tableau de nbElem valeurs comprises entre min et max tenir compte du cas particulier ou le tableau n'est pas cree. Verfier que nbElem <= taille sinon afficher une erreur. Verifier que min <= max, sinon afficher une erreur.
	*@param leTab le tableau a remplir de valeurs tirees aleatoirement
	*@param nbElem le nombre d'entiers que contiendra le tableau
	*@param min la valeur de l'entier minimum
	*@param max la valeur de l'entier maximum
	*/
	void remplirAleatoire(int [] leTab, int nbElem , int min, int max ){
		if (leTab != null){
			if (nbElem >= 0 && nbElem <= leTab.length ){
				if (min <= max ){
					for ( int i = 0; i < nbElem ; i++){
					leTab[i] = tirerAleatoire(min,max);
					}
				}
				else{
					System.out.println("Erreur : cause : min > max");
				}
			}
			else {
				System.out.println ("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non cree ");
		}
	}
	/**
	* Test de le methode remplirAleatoire()
	*/
	void testRemplirAleatoire(){
		System.out.println("\n===Test methode remplirAleatoire ===");
		System.out.println("Test du contenu du tableau rempli aleatoirement");
		System.out.println("min = 0 et max = 10 et nbElem = 4");
		int [] tab = new int[10];
		remplirAleatoire(tab,4,0,10);
		afficherTab(tab,4);
		System.out.println("Test avec 0 elements ");
		int [] tab2 = new int[10];
		remplirAleatoire(tab2,0,0,10);
		afficherTab(tab2,4);
		System.out.println("Test avec lengh elements");
		int [] tab3 = new int[10];
		remplirAleatoire(tab3,tab3.length,0,10);
		afficherTab(tab3,4);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab4 = null ;
		remplirAleatoire(tab4,2,0,10);
		System.out.println("Cas d'erreur : nbElem <0");
		int [] tab5 = new int[10];
		remplirAleatoire(tab5,-1,0,10);
		System.out.println("Cas d'erreur :nbElem > length ");
		int [] tab6 = new int[10];
		remplirAleatoire(tab6,(tab6.length + 1),0,10);
		System.out.println("Cas d'erreur : min (=10) < max (=0) ");
		int [] tab7 = new int[10];
		remplirAleatoire(tab,(tab.length + 1),10,0);
	}
	/**
	*Renvoie la copie exacte du tableau passe en parametre.
	*@param tabToCopy le tableau à copier
	*@param nbElem le nombre d'entier présents dans le tableau
	*@return le nouveau tableau qui est la copie du tableau passe en parametre
	*/
	int [] copier(int[] tabToCopy, int nbElem ){
		int [] ret = new int [0];
		if (tabToCopy!= null){
			if (nbElem >= 0 && nbElem <= tabToCopy.length ){
				ret = new int [nbElem];
				for (int i = 0; i < nbElem ; i ++){
					ret [i] = tabToCopy[i];
				}
			}
			else {
				System.out.println ("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non cree ");
		}
		return ret ;	
	}
	/**
	*Test de la methode copier()
	*/
	void testCopier (){
		System.out.println("\n===Test methode copier() ===");
		System.out.println("**Test d'egalite de contenu des tableaux **");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		System.out.println("Tableau 1 :");
		afficherTab(tab,4);
		System.out.println("Clone Tableau 1 :");
		afficherTab(copier(tab,4),4);
		System.out.println("**Test avec 0 elements **");
		System.out.println("Tableau 1 :");
		afficherTab(tab,0);
		System.out.println("Clone Tableau 1 :");
		System.out.println("Tableau 1 :");
		afficherTab(copier(tab,0),0);
		System.out.println("**Test avec lengh elements**");
		System.out.println("Tableau 1 :");
		afficherTab(tab,tab.length);
		System.out.println("Clone Tableau 1 :");
		afficherTab(copier(tab,tab.length),tab.length);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		copier(tab2,4);
		System.out.println("Cas d'erreur : nbElem <0");
		copier(tab,-1);
		System.out.println("Cas d'erreur :nbElem > length ");
		copier(tab,(tab.length + 1));
	}
	/**
	*Renvoie le nombre d'occurences d'un entier dans un tableau
	*@param leTab le tableau d'entier
	*@param nbElem le nombre d'entier present dans le tableau
	*@param elem l'entier a rechercher dans le tableau
	*@return le nombre d'occurences
	*/
	int nbOccurences(int[] leTab , int nbElem, int elem){
		int ret = 0;
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				int i = 0;
				while ( i < nbElem){
					if ( elem == leTab[i]){
						ret ++;
					}
					i++;
				}
			}
			else { 
				System.out.println("nbElem hors dommaine");
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return ret;	
	}
	/**
	*Test de la methode nbOccurences()
	*/
	void testNbOccurences(){
		System.out.println("\n===Test methode nbOccurences() ===");
		System.out.println("Test de l'occurences du tableau pour cinq 1 avec nbElem = 6");
		int [] tab = new int[10];
		tab[0] = 1 ;
		tab[1] = 1 ;
		tab[2] = 1 ;
		tab[3] = 1 ;
		tab[4] = 1 ;
		tab[5] = 0 ;
		System.out.println(nbOccurences(tab,6,1));
		System.out.println("Test avec nbElem = 0 ");
		System.out.println(nbOccurences(tab,0,1));
		System.out.println("Test avec nbElem = tab.length");
		System.out.println(nbOccurences(tab,tab.length,1));
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		System.out.println(nbOccurences(tab2,2,1));
		System.out.println("Cas d'erreur : nbElem <0");
		System.out.println(nbOccurences(tab,-1,1));
		System.out.println("Cas d'erreur :nbElem > length ");
		System.out.println(nbOccurences(tab,(tab.length + 1),1));
	}	
	/**
	*Renvoie le minimum parmi les éléments du tableau.
	*@param leTab le tableau
	*@param nbElem le nombre d'entiers présents dans le tableaux
	*@return le min des elements du tableau
	*/
	int leMin (int [] leTab , int nbElem ){
		int ret = 0;
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				ret = leTab[0];
				for (int i = 0; i < nbElem ; i++ ){
					if ( ret > leTab[i] ){
						ret = leTab[i];
					}
				}
			
			}
			else { 
				System.out.println("nbElem hors dommaine");
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return ret ;		
	}
	/**
	*Test de la methode leMin()
	*/
	void testLeMin(){
		System.out.println("\n===Test methode leMin() ===");
		System.out.println("Test du minimum du tableau");
		System.out.println(" Tableau rempli de 1 sauf pour case n°4 = 0");
		int [] tab = new int[10];
		for (int i = 0 ; i < 5 ;i++){
			tab[i] = 1 ;
		}
		tab[4] = 0;
		System.out.println(leMin(tab,6));
		System.out.println("Test avec nbElem = 0 ");
		System.out.println(leMin(tab,0));
		System.out.println("Test avec nbElem = tab.length");
		System.out.println(leMin(tab,tab.length));
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		System.out.println(leMin(tab2,2));
		System.out.println("Cas d'erreur : nbElem <0");
		System.out.println(leMin(tab,-1));
		System.out.println("Cas d'erreur :nbElem > length ");
		System.out.println(leMin(tab,(tab.length + 1)));	
	}
	/**
	*Renvoie le maximum parmi les éléments du tableau.
	*@param leTab le tableau
	*@param nbElem le nombre d'entiers présents dans le tableaux
	*@return le max des elements du tableau
	*/
	int leMax (int [] leTab , int nbElem ){
		int ret = 0;
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				ret = leTab[0];
				for (int i = 0; i < nbElem ; i++ ){
					if ( ret < leTab[i] ){
						ret = leTab[i];
					}
				}
			
			}
			else { 
				System.out.println("nbElem hors dommaine");
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return ret;		
	}
	/**
	*Test de la methode leMax()
	*/
	void testLeMax(){
		System.out.println("\n===Test methode leMax() ===");
		System.out.println("Test du maximum du tableau");
		System.out.println(" Tableau rempli de 0 sauf pour case n°4 = 1");
		int [] tab = new int[10];
		for (int i = 0 ; i < 5 ;i++){
			tab[i] = 0 ;
		}
		tab[4] = 1;
		System.out.println(leMax(tab,6));
		System.out.println("Test avec nbElem = 0 ");
		System.out.println(leMax(tab,0));
		System.out.println("Test avec nbElem = tab.length");
		System.out.println(leMax(tab,tab.length));
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		System.out.println(leMax(tab2,2));
		System.out.println("Cas d'erreur : nbElem <0");
		System.out.println(leMax(tab,-1));
		System.out.println("Cas d'erreur :nbElem > length ");
		System.out.println(leMax(tab,(tab.length + 1)));	
	}
	/**
	* Renvoie un nouveau tableau qui est l'inverse de celui passé en parametre. Son jème élément est égalt au (nbElem+i-j) élément
	*du tableau initial ( j= 1 signifie le premier élément du tableau).
	*@param leTab le tableau
	*@param nbElem le nombre d'entiers présent dans le tableau
	*@return le nouveau tableau qui est l'inverse de leTab sur la pagle 0...nbElem-1
	*/
	int [] inverse (int [] leTab , int nbElem){
		int [] ret = new int [0] ;
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				ret =  new int [nbElem];
				for (int i = 0 ; i < nbElem ;i++ ){
					ret[nbElem - 1 - i] = leTab [i];
				}
			}
			else { 
				System.out.println("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return ret;	
	}
	/**
	* Test de la methode inverse()
	*/
	void testInverse (){
		System.out.println("\n===Test methode inverse() ===");
		System.out.println("Test de l'inverse du tableau");
		System.out.println("** Tableau 1 : **");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		afficherTab(tab,6);
		System.out.println("** Tableau inverse : **");
		afficherTab(inverse(tab,6),6);
		System.out.println("Test avec nbElem = 0 ");
		afficherTab(inverse(tab,0),6);
		System.out.println("Test avec nbElem = tab.length");
		afficherTab(inverse(tab,tab.length),tab.length);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		afficherTab(inverse(tab2,6),6);
		System.out.println("Cas d'erreur : nbElem <0");
		afficherTab(inverse(tab,(-3)),10);
		System.out.println("Cas d'erreur :nbElem > length ");
		afficherTab(inverse(tab,tab.length+1),6);
	}
	/**
	*Echange les contenus des cases du tableau passé en paramètre, cases identifiées par les indices ind1 et ind2. 
	*Vérifier que les indices ind1 et ind2 sont bien compris entre zéro et (nbElem-1), sinon afficher un message d'erreur.
	*@param leTab - le tableau
	*@param nbElem - le nombre d'entiers présents dans le tableau
	*@param ind1 - numéro de la première case à échanger
	*@param ind2 - numéro de la deuxième case à échange
	*/
	void echange ( int [] leTab , int nbElem , int ind1 , int ind2){
		if (leTab != null){
			if (nbElem >= 0 && nbElem <= leTab.length ){
				if (ind1 <= nbElem-1 && ind1 >=0 && ind2 <= nbElem-1 && ind2 >=0 ){
					int temp = leTab[ind1];
					leTab[ind1] = leTab[ind2];
					leTab[ind2] = temp ;
				}
				else {
					System.out.println("ind1 ou ind2 hors dommaine");
				}
			}
			else {
				System.out.println ("nbElem hors domaine");
			}
		}
		else {
			System.out.println("Tableau non cree ");
		}	
	}
	/**
	*Test de la méthode echange()
	*/
	void testEchange(){
		System.out.println("\n===Test methode echange() ===");
		System.out.println("Tableau rempli 0 a 9 , echange entre la case 1 et 8");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		echange(tab,10,1,8);
		afficherTab(tab,10);
		System.out.println("Test avec 0 elements ");
		echange(tab,0,1,8);
		System.out.println("Test avec lengh elements ,echange de la case 2 et 6");
		echange(tab,tab.length,2,6);
		afficherTab(tab,10);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		echange(tab2,10,1,8);
		System.out.println("Cas d'erreur : nbElem <0");
		echange(tab,-1,1,8);
		System.out.println("Cas d'erreur :nbElem > length ");
		echange(tab,tab.length+1,1,8);
		System.out.println("Cas d'erreur :ind1 < 0 ");
		echange(tab,10,-1,8);
		System.out.println("Cas d'erreur : ind1> length ");
		echange(tab,10,tab.length+1,8);
		System.out.println("Cas d'erreur :ind2 < 0 ");
		echange(tab,10,1,-1);
		System.out.println("Cas d'erreur : ind2 > length ");
		echange(tab,10,1,tab.length+1);
	}
	/**
	*Retourne un nouveau tableau qui a la même taille et les mêmes occurences d'élements que le tableau passé en paramètre mais ces éléments sont répartis selon des indices aléatoires (0 <= indice <= nbElem-1). Une technique simple consiste à utiliser les méthodes "echange" et "tirerAleatoire" pour effectuer le mélange.
	*@param leTab - le tableau
	*@param nbElem - le nombre d'entiers présents dans le tableau
	*@return le nouveau tableau qui a le même contenu que le tableau initial mais mélangé
	*/
	int [] melange(int [] leTab , int nbElem){
		int [] ret = new int [0] ;
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				ret = copier(leTab,nbElem);
				for (int i = 0 ; i < nbElem ; i++){
					int indice1 = tirerAleatoire(0,nbElem-1);
					int indice2 = tirerAleatoire(0,nbElem-1);
					echange(ret,nbElem,indice1,indice2);
				}
			}
			else{
				System.out.println("nbElem hors domaine");
				
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return ret;	
	}
	/**
	*Test de la méthode melange()
	*/
	void testMelange(){
		System.out.println("\n===Test methode melange() ===");
		System.out.println("Test du melange du tableau");
		System.out.println("** Tableau 1 : **");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		afficherTab(tab,6);
		System.out.println("** Tableau melange : **");
		afficherTab(melange(tab,6),6);
		System.out.println("Test avec nbElem = 0 ");
		melange(tab,0);
		System.out.println("Test avec nbElem = tab.length");
		afficherTab(melange(tab,tab.length),tab.length);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		melange(tab2,6);
		System.out.println("Cas d'erreur : nbElem <0");
		melange(tab,-1);
		System.out.println("Cas d'erreur :nbElem > length ");
		melange(tab,tab.length+1);
	}
	/**
	*Décale de une case de la droite vers la gauche toutes les cases d'un tableau à partir d'un indice "ind" et  jusque nbElem-1 ([ind]<[ind+1]<-[ind+2]<-...<-[nbElem-2]<-[nbElem-1]). Vérifier que ind est compris entre 0 et (nbElem-2) sinon afficher une erreur.
	*@param leTab - le tableau
	*@param nbElem - le nombre d'entiers présents dans le tableau
	*@param ind - l'indice à partir duquel commence le décalage à gauche
	*@return le nouveau tableau 
	*/
	int [] decalerGche(int[] leTab,int nbElem,int ind){
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				if ( ind >= 0 && ind <= nbElem -2 ){
					for (int i = ind ; i < nbElem -1; i++){
						leTab[i] = leTab[i+1];
					}
					leTab = copier(leTab,nbElem -1);
				}
				else {
					System.out.println (" ind hors domaine");
				}
			}
			else{
				System.out.println("nbElem hors domaine");
				
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return leTab ;
	}
	/**
	*Test de la méthode decalerGche()
	*/
	void testDecalerGche (){
		System.out.println("\n===Test methode decalerGche() ===");
		System.out.println("Test du decalage du tableau à partir du 5");
		System.out.println("** Tableau 1 : **");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		afficherTab(tab,10);
		System.out.println("** Tableau decale : **");
		afficherTab(decalerGche(tab,10,5),9);
		System.out.println("Test avec nbElem = 0 ");
		decalerGche(tab,0,5);
		System.out.println("Test avec nbElem = tab.length");
		decalerGche(tab,tab.length,5);
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		decalerGche(tab2,6,5);
		System.out.println("Cas d'erreur : nbElem <0");
		decalerGche(tab2,-1,5);
		System.out.println("Cas d'erreur :nbElem > length ");
		decalerGche(tab,tab.length+1,5);
		System.out.println("Cas d'erreur : ind >nbElem-2");
		decalerGche(tab,6,9999);
		System.out.println("Cas d'erreur : ind < 0");
		decalerGche(tab,6,-1);
		
	}
	/**
	*Supprime du tableau la première case rencontrée dont le contenu est égale à "valeur". La case du tableau est supprimée par décalage à gauche des cases du tableau. L'appel de la méthode "decalerGche" est obligatoire. A l'issue de la suppression (si elle existe) le nombre d'éléments dans le tableau est décrémenté et retourné.
	*@param leTab - le tableau
	*@param nbElem - le nombre d'entiers présents dans le tableau
	*@param valeur - le contenu de la première case à supprimer
	*@return le nouveau tableau
	*/
	int supprimerUneValeur(int[] leTab, int nbElem, int valeur){
		int  ret = nbElem ;
		if (leTab != null){
			if (nbElem <= leTab.length && nbElem >= 0){
				for (int i = 0 ; i < nbElem ; i++){
					if (valeur == leTab[i]){
						decalerGche(leTab,nbElem,i);
						ret -- ;
					}
				}
			}
			else { 
				System.out.println("nbElem hors dommaine");
			}
		}
		else {
			System.out.println("Tableau non crée");
		}
		return ret ;
	}
	/**
	* Test de le méthode supprimerUneValeur()
	*/
	void testSupprimerUneValeur (){
		System.out.println("\n===Test methode supprimerUneValeur() ===");
		System.out.println("Test de la suppression de 5 du tableau");
		System.out.println("** Tableau 1 : **");
		int [] tab = new int[10];
		for (int i = 0 ; i < 10 ;i++){
			tab[i] = i ;
		}
		afficherTab(tab,10);
		System.out.println("** Nouveau tableau : **");
		afficherTab(tab,supprimerUneValeur(tab,10,5));
		System.out.println("Test avec nbElem = 0 ");
		afficherTab(tab,supprimerUneValeur(tab,0,5));
		System.out.println("Test avec nbElem = tab.length");
		afficherTab(tab,supprimerUneValeur(tab,tab.length,8));
		System.out.println("Cas d'erreur : Tableau null");
		int [] tab2 = null ;
		supprimerUneValeur(tab2,10,5);
		System.out.println("Cas d'erreur : nbElem <0");
		supprimerUneValeur(tab,-1,5);
		System.out.println("Cas d'erreur :nbElem > length ");
		supprimerUneValeur(tab,tab.length+1,5);
	}

}
