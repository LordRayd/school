public class TrisTableau {

	long cpt;

	/**
	  *<b>Principal avec toutes les appels de methodes dedans</b>
	  */
	
	void principal () {

		//testAfficherSousTab();
		//testRemplacerAuHasard();
		//testRechercheSeq();
		testRechercheSeqEfficacite();
		//testRechercheDicho();
		testRechercheDichoEfficacite();
		//testVerifTri();
		//testTriSimple();
		testTriSimpleEfficacite();
		//testSeparer();
		//testTriRapideRec();
		//testTriRapide();
		testTriRapideEfficacite();
		//testCreerTabFreq();
		//testTriParComptageFreq();
		testTriParComptageFreqEfficacite();
		//testTriABulles();
		testTriABullesEfficacite();

	 }


	/**
	  *Methode qui remplace une la valeur d'une case du tableau tiré aléatoirement par la valeur contenue dans nexInt
	  *@param leTab tableau d'entier
	  *@param nbElem le nombre d'élement du tableau
	  *@param newInt la valeur qui va remplacer une case du tableau
	  */

	void remplacerAuHasard (int[] leTab, int nbElem, int newInt) {

		int alea;
		if(nbElem == 0) {
		}
		else {
			alea = tirerAleatoire(0, nbElem-1);
		leTab[alea] = newInt;
		}		
	}

	/**
	  *Test de la methode remplacerAuHasard
	  */

	void testRemplacerAuHasard() {

		int newInt = 1337;
		int nbElem;
		int[] leTab = {0,1,2,3,4,5,6,7,8,9};

		System.out.println("Test de la methode");

		//CAS LIMITE
		System.out.println("===CAS LIMITE===");
 
		nbElem = 0;
		System.out.println("Test avec nbElem = 0");
		afficherTab(leTab, nbElem);
		remplacerAuHasard(leTab, nbElem, newInt);
		afficherTab(leTab, nbElem);

		//CAS NORMAL
		System.out.println("===CAS NORMAL===");

		nbElem = 6;
		System.out.println("Test normal");
		afficherTab(leTab, nbElem);
		remplacerAuHasard(leTab, nbElem, newInt);
		afficherTab(leTab, nbElem);
	}

	/**
	  *Methode qui affiche un tableau entre deux indices
	  *@param leTab tableau d'entier
	  *@param indL indice de gauche
	  *@param indR indice de droit
	  */

	void afficherSousTab(int[] leTab, int indL, int indR) {

		int i;

		if(indCorrect(indL, indR) == false ) {

		}
		else {
			for(i = indL ; i <=		 indR ; i++) {
			System.out.println("tab["+i+"]="+leTab[i]);
			}	
		}
	}

	/**
	  *Test de la methode afficherSousTab
	  */

	void testAfficherSousTab() {

		int[] leTab = {0,1,2,3,4,5,6,7,8,9};
		int indL;
		int indR;

		System.out.println("Test de la methode afficherSousTab");

		//CAS D'ERREUR
		System.out.println("===CAS D'ERREUR===");

		indR = -1;
		indL = indR;
		System.out.println("Test avec des indices negatifs");
		afficherSousTab(leTab, indL, indR);

		indR = 5;
		indL = 9;
		System.out.println("Test avec indR < indL");
		afficherSousTab(leTab, indL, indR);

		//CAS LIMITE
		System.out.println("===CAS LIMITE");

		indL = indR;
		System.out.println("Test avec indR = indL");
		afficherSousTab(leTab, indL, indR);

		//CAS NORMAL
		System.out.println("===CAS NORMAL===");

		indL = 2;
		indR = 9;
		System.out.println("Test avec tout qui est en ordre");
		afficherSousTab(leTab, indL, indR);
	}

	/**
	  *Methode qui fait une recherche sequentielle dans un tableau et rend la case ou la valeur se trouve
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  *@param aRech entier a rechercher
	  *@return int retourne la position de l'entier ou -1 si il existe pas
	  */

	int rechercheSeq(int[] leTab, int nbElem, int aRech) {

		int i;
		boolean trouve;

		trouve = false;
		i = 0;
		while(i < nbElem && trouve ==  false) {
			if(leTab[i] == aRech) {
				trouve = true;
			}
			i++;
			cpt++;
		}
		if(trouve == false) {
			i = -1;
		}
	
	return i;
	}

	/**
	  *Test de la methode rechercheSeq
	  */

	void testRechercheSeq() {

		int aRech = 4;
		int res;
		int nbElem;
		int[] leTab= {0,1,2,3,4,5,6,7,8,9};

		System.out.println("Test de la methode rechercheSeq");

		//CAS LIMITE
		System.out.println("===CAS LIMITE===");
 
		nbElem = 0;
		res = rechercheSeq(leTab, nbElem, aRech);
		System.out.println("La valeur est en : "+res);


		//CAS NORMAL
		System.out.println("===CAS NORMAL===");

		nbElem = 6;
		System.out.println("Test normal avec la valeur dans le tableau");
		res = rechercheSeq(leTab, nbElem, aRech);
		System.out.println("La valeur est en : "+res);

		aRech = 100;
		System.out.println("Test normal sans la valeur dans le tableau");
		res = rechercheSeq(leTab, nbElem, aRech);
		System.out.println("La valeur est en : "+res);
		}

	/**
	*Test d'efficacite de la methode rechercheSeq
	*/

	void testRechercheSeqEfficacite() {

		int i;
		int nbElem = 50000;
		int[] leTab = new int[800000];
		int res;
		int aRech;
		int tempsExe;
		int cste;

		System.out.println("Test d'efficacite de la methode rechercheSeq");

		for(i = 0 ; i < 5 ; i++) {

			leTab = remplirAleatoire(leTab, nbElem, -10000, 10000);
			aRech = 20000;

			System.out.println("Test avec "+nbElem+" valeurs dans le tableau");
			cpt = 0;
			tempsExe = (int)System.nanoTime();
			res = rechercheSeq(leTab, nbElem, aRech);
			tempsExe = (int)System.nanoTime() - tempsExe;
			cste = (int)cpt/nbElem;
			System.out.println("La methode a mis "+tempsExe+" nano-secondes a s'executer et on obtient cste = "+cste);
			nbElem = nbElem * 2;
		}
	}

	/**
	  *Methode qui fait une recherche dichotomique dans un tableau trie et rend la case ou la valeur se trouve
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  *@param aRech entier a trouver
	  *@return la position de l'entier dans le tableau ou -1 si il est pas la
	  */

	int rechercheDicho(int[] leTab, int nbElem, int aRech) {

		int indInf;
		int indSup;
		int milieu;
		int res;

		indInf = 0;
		indSup = nbElem-1;
		if(nbElem == 0) {

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
	  *Test de le methode rechercheDicho
	  */

	void testRechercheDicho() {

		int aRech = 4;
		int res;
		int nbElem;
		int[] leTab = {0,1,2,3,4,5,6,7,8,9};

		System.out.println("Test de la methode rechercheDicho");

		//CAS LIMITE
		System.out.println("===CAS LIMITE===");
 
		nbElem = 0;
		res = rechercheDicho(leTab, nbElem, aRech);
		System.out.println("La valeur est en : "+res);


		//CAS NORMAL
		System.out.println("===CAS NORMAL===");

		nbElem = 9;
		System.out.println("Test normal avec la valeur dans le tableau");
		res = rechercheDicho(leTab, nbElem, aRech);
		System.out.println("La valeur est en : "+res);

		aRech = 100;
		System.out.println("Test normal sans la valeur dans le tableau");
		res = rechercheDicho(leTab, nbElem, aRech);
		System.out.println("La valeur est en : "+res);
	}

	/**
	  *Test d'efficacite de la methode rechercheDicho
	  */

	void testRechercheDichoEfficacite() {

		int nbElem = 100000;
		int[] leTab = new int[1600000];
		int res;
		int aRech;
		int tempsExe;
		double cste;
		int i;

		System.out.println("Test d'efficacite de la methode rechercheDicho");

		for(i = 0 ; i < 5 ; i++) {

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
		}
	}

	/**
	  *Methode qui verifie si un tableau est trie et renvoie vrai si c'est le cas
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  *@return boolean renvoie vrai si le tableau est trie
	  */

	boolean verifTri(int[] leTab, int nbElem) {

		int i;
		boolean trie = true;
		
		i = 0;
		while(i < nbElem - 1 && trie == true) {
			if(leTab[i] > leTab[i+1]) {
				trie = false;
			}
			i++;
		}
		return trie;
	}

	/**
	  *Test de la methode verifTri
	  */

	void testVerifTri() {

		boolean res;
		int nbElem;
		int[] leTab = new int[10];

		System.out.println("Test de la methode verifTri");

		//CAS LIMITE
		System.out.println("===CAS LIMITE===");
		
		nbElem = 10;
		leTab = remplirAleatoire(leTab, nbElem, 0, 10);
		nbElem = 0;
		System.out.println("Test avec nbElem = 0");
		res = verifTri(leTab, nbElem);
		System.out.println("Le tableau est trie : "+res);

		//CAS NORMAUX
		System.out.println("===CAS NORMAUX===");

		nbElem = 6;
		System.out.println("Test avec un tableau non trie");
		res = verifTri(leTab, nbElem);
		System.out.println("Le tableau est trie : "+res);

		leTab = creerTableauAleatoireEtTrie(leTab, nbElem, 2);
		System.out.println("Test avec un tableau trie");
		res = verifTri(leTab, nbElem);
		System.out.println("Le tableau est trie : "+res);
	}

	/**
	  *Methode qui trie un tableau 
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  */

	void triSimple(int[] leTab, int nbElem) {

		int i;
		int j;
		int min;
		int ind;
		
		for(i = 0 ; i < nbElem ; i++) {
			min =  leTab[i];
			ind = i;
			for(j = i + 1 ; j < nbElem ; j++) {
				cpt++;
				if(min > leTab[j]) {
					min = leTab[j];
					ind = j;
				}
			}
			echange(leTab, nbElem, i, ind);
		}
	}

	/**
	  *Test de la methode triSimple
	  */

	void testTriSimple() {

		int nbElem;
		int[] leTab = {9,6,3,4,2,8,4,2,9,78};

		System.out.println("Test de la methode triSimple");

		//CAS LIMITE

		System.out.println("===CAS LIMITE===");

		nbElem = 0;
		System.out.println("Test avec un tableau vide");
		triSimple(leTab, nbElem);

		//CAS NORMAL

		System.out.println("===CAS NORMAL===");

		nbElem = 10;
		System.out.println("Test avec tout qui va bien");
		triSimple(leTab, nbElem);
		afficherTab(leTab, nbElem);
	}

	/**
	  *Test d'efficacite de la methode triSimple
	  */

	void testTriSimpleEfficacite() {

		int nbElem = 12500;
		int[] leTab = new int[200000];
		int res;
		int tempsExe;
		float cste;
		int i;

		System.out.println("Test d'efficacite de la methode triSimple");

		for(i = 0 ; i < 5 ; i++) {

			leTab = remplirAleatoire(leTab, nbElem, -10000, 10000);

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
		}
	}

	/**
	  *Methode qui consiste a placer un pivot dans un tableau et a renvoyer son indice
	  *@param leTab tableau d'entier
	  *@param indL indice de debut du tableau
	  *@param indR indice de fin du tableau
	  *@return int indice du pivot
	  */

	int separer(int[] leTab, int indL, int indR) {

		int pivot;
		int nbElem;

		nbElem = indR - indL;

		if(indCorrect(indL, indR) == false) {
			indL = -1;
		}
		else {
			pivot = leTab[indL];

			while(indL < indR) {
				if(leTab[indL] > leTab[indR]) {
					echange(leTab, nbElem, indL, indR);
				}

				if(leTab[indL] == pivot) {
					indR--;
				}
				else {
					indL++;
				}
				cpt++;				
			}
		}
		return  indL;
	}

	/**
	  *Test de la methode separe
	  */

	void testSeparer() {

		int indL;
		int indR;
		int pivot;
		int[] leTab = {7,1,9,3,8,5,4,6,4,1};

		System.out.println("Test de la methode separer");

		//CAS D'ERREUR

		System.out.println("===CAS D'ERREUR===");

		indR = -1;
		indL = indR;
		System.out.println("Test avec des indices negatifs");
		pivot = separer(leTab, indL, indR);

		indR = 5;
		indL = 9;
		System.out.println("Test avec indR < indL");
		pivot = separer(leTab, indL, indR);


		//CAS LIMITE

		System.out.println("===CAS LIMITE===");

		indL = indR;
		System.out.println("Test avec indR = indL");
		pivot = separer(leTab, indL, indR);
		System.out.println("Le pivot est place en case : "+pivot);

		//CAS NORMAL

		System.out.println("===CAS NORMAL");

		indR = 9;
		indL = 0;
		System.out.println("Test dans des conditions normales");
		pivot = separer(leTab, indL, indR);
		afficherTab(leTab, (indR - indL + 1));
		System.out.println("Le pivot est place en case : "+pivot);
	}

	/**
	  *Methode recursive du tri rapide qui tri un tableau entre deux indices
	  *@param leTab tableau d'entier
	  *@param indL indice gauche du tableau
	  *@param indR indice droit du tableau
	  */

	void triRapideRec(int[] leTab, int indL, int indR) {

		int indPivot;

		if(indCorrect(indL, indR) == false) {
		}
		else {
			indPivot = separer(leTab, indL, indR);

			if( (indPivot - 1) > indL) {
				triRapideRec(leTab, indL, (indPivot - 1) );
			}	
			
			if( (indPivot + 1) < indR) {
				triRapideRec(leTab, (indPivot + 1), indR);
			}
			cpt++;
		}
	}

	/**
	  *Test de la methode triRapideRec
	  */

	void testTriRapideRec() {

		int indL;
		int indR;
		int[] leTab = {5,6,9,7,2,6,4,8,6,2};

		System.out.println("Test de la methode triRapideRec");

		//CAS D'ERREUR

		System.out.println("===CAS D'ERREUR===");


		indR = -1;
		indL = indR;
		System.out.println("Test avec des indices negatifs");
		triRapideRec(leTab, indL, indR);

		indL = 8;
		indR = 2;
		System.out.println("Test avec indR inferieur a indL");
		triRapideRec(leTab, indL, indR);

		//CAS LIMITE

		System.out.println("===CAS LIMITE===");

		indR = indL;
		System.out.println("Test avec indR et indL egaux");
		triRapideRec(leTab, indL, indR);
		afficherTab(leTab, (indR - indL + 1));

		//CAS NORMAL

		System.out.println("===CAS NORMAL===");

		indL = 0;
		indR = 9;
		System.out.println("Test dans avec des parametres normaux");
		triRapideRec(leTab, indL, indR);
		afficherTab(leTab, (indR - indL + 1));		
	}

	/**
	  *Methode qui tri un tableau tout en entier
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  */

	void triRapide(int[] leTab, int nbElem) {

		int indL;
		int indR;

		indL = 0;
		indR = nbElem - 1;

		triRapideRec(leTab, indL, indR);
	}

	/**
	  *Test de la methode triRapide
	  */

	void testTriRapide() {

		int nbElem;
		int[] leTab = {4,5,2,5,4,7,1,7,2,5};

		//CAS LIMITE

		System.out.println("===CAS LIMITE===");

		nbElem = 0;
		System.out.println("Test avec un nombre d'element egale a zero");
		triRapide(leTab, nbElem);

		//CAS NORMAL

		System.out.println("===CAS NORMAL===");

		nbElem = 10;
		System.out.println("Test ou rien n'est a signaler");
		triRapide(leTab, nbElem);
		afficherTab(leTab, nbElem);
	}

	/**
	  *Test d'efficacite de la methode triRapide
	  */

	void testTriRapideEfficacite() {
		
		int nbElem = 50000;
		int[] leTab = new int[800000];
		int res;
		int tempsExe;
		double cste;
		int i;
		
		System.out.println("Test d'efficacite de la methode triRapide");

		for(i = 0 ; i < 5 ; i++) {

			leTab = remplirAleatoire(leTab, nbElem, -10000, 10000);

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
		}
	}

	/**
	  *Methode qui rend un tableau avec les frequences d'apparition
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  *@return int[] tableau avec les frequences d'apparition
	  */

	int[] creerTabFreq(int[] leTab, int nbElem) {

		int nbMax;
		int i;
		int j;

		nbMax = leMax(leTab, nbElem);

		int[] leTabFreq = new int[nbMax + 1];
		
		j = 0;

		for(i=0 ; i < nbElem ; i++) {
			j = leTab[i];
			leTabFreq[j] = leTabFreq[j] + 1;
		}
		return leTabFreq;
	}

	/**
	  *Test de la methode creerTabFreq
	  */
	
	void testCreerTabFreq() {
		
		
		int nbElem;
		int[] leTab = {2,6,7,8,5,2,7,8,6,1};
		int[] leTabFreq;

		System.out.println("Test de la methode creerTabFreq");
	
		//CAS LIMITE
	
		System.out.println("===CAS LIMITE===");
	
		nbElem = 0;
		System.out.println("Test avec un tableau vide");
		leTabFreq = creerTabFreq(leTab, nbElem);
	
		//CAS NORMAL
	
		System.out.println("===CAS NORMAL===");
	
		nbElem = 10;
		System.out.println("Test avec aucune erreur");
		leTabFreq = creerTabFreq(leTab, nbElem);
		afficherTab(leTabFreq, leTabFreq.length);
	}

	/**
	  *Methode qui tri un tableau en utilisant le comptage des frequences
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  */

	void triParComptageFreq(int[] leTab, int nbElem) {

		int[] leTabFreq;
		int i;
		int j;
		int longTabFreq;

		leTabFreq = creerTabFreq(leTab, nbElem);
		longTabFreq = leTabFreq.length;
		
		j = 0;
		for(i = 0 ; i < longTabFreq ; i++) {
			while(leTabFreq[i] > 0) {
				leTab[j] = i;
				j++;
				leTabFreq[i]--;
				cpt++;
			}
		}
	}

	/**
	  *Test de la methode triParComptageFreq
	  */

	void testTriParComptageFreq() {

		int nbElem;
		int[] leTab = {8,6,2,47,8,2,4,8,6,9};

		System.out.println("Test de la methode triParComptageFreq");

		//CAS LIMITE

		System.out.println("===CAS LIMITE===");

		nbElem = 0;
		System.out.println("Test avec un tableau vide");
		triParComptageFreq(leTab, nbElem);

		//CAS NORMAL

		System.out.println("===CAS NORMAL===");

		nbElem = 10;
		System.out.println("Test avec tous les indicateurs au vert");
		triParComptageFreq(leTab, nbElem);
		afficherTab(leTab, nbElem);
	}

	void testTriParComptageFreqEfficacite() {

		int nbElem = 50000;
		int[] leTab = new int[800000];
		int res;
		int tempsExe;
		int cste;
		int i;

		System.out.println("Test d'efficacite de la methode triParComptageFreq");

		for(i = 0 ; i < 5 ; i++) {

			leTab = remplirAleatoire(leTab, nbElem, 0, 10000);

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
		}
	}

	/**
	  *Methode qui tri un tableau en utilisant le tri a bulle
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  */

	void triABulles(int[] leTab, int nbElem) {

		int i;
		int j;
		int nbElemATrier;

		for(i = 0 ; i < nbElem ; i++) {
			nbElemATrier = nbElem;
			j = 0;
			while(j < nbElemATrier - 1) {
				if(leTab[j] > leTab[j+1]) {
					echange(leTab, nbElem, j, j+1);
				}
				cpt++;
				j++;
			}
			nbElemATrier--;
		}
	}

	/**
	  *Test de la methode de triABulles
	  */

	void testTriABulles() {

		int nbElem;
		int[] leTab = {1,5,9,8,8,3,5,6,2,13};

		System.out.println("Test de la methode triABulles");

		//CAS LIMITE

		System.out.println("===CAS LIMITE===");

		nbElem = 0;
		System.out.println("Test avec un tableau vide");
		triABulles(leTab, nbElem);

		// Test les cas normaux
		System.out.println("\n   ------ Test les cas normaux ------ ");

		nbElem = 10;
		System.out.println("Test qui va bien se passer");
		triABulles(leTab, nbElem);
		afficherTab(leTab, nbElem);
	}

	/**
	  *Test de l'efficacite de la methode triABulles
	  */

	void testTriABullesEfficacite() {

		int nbElem = 12500;
		int[] leTab = new int[200000];
		int res;
		int tempsExe;
		float cste;
		int i;
		
		System.out.println("Test d'efficacite de la methode triABulles");

		for(i = 0 ; i < 5 ; i++) {

			leTab = remplirAleatoire(leTab, nbElem, -10000, 10000);

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
		}
	}

	/**
	  *Methode qui rend un tableau rempli de valeurs aleatoires et trie
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  *@param ecart ecart max entre deux valeurs aleatoires
	  *@return int[] tableau d'entier aleatoire et trie
	  */

	int[] creerTableauAleatoireEtTrie(int[] leTab, int nbElem, int ecart) {

		int alea;
		int i;

		alea = 0;
		for(i = 0 ; i < nbElem ; i ++) {
			alea = tirerAleatoire(alea, ecart);
			leTab[i] = alea;
		}
	return leTab;
	}

	/**
	  *Methode qui verifie si les deux indices d'un tableau sont bons et renvoie vrai si c'est le cas
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
	  *<b>Methode qui va faire des tests sur le tableau et sa longueur</b>
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'elements du tableau
	  *@return boolean vrai si tout est correct
	  */

	boolean paramCorrect(int[] leTab, int nbElem) {

		boolean correct;

		correct = false;

		if(leTab == null) {
			System.out.println("Le tableau n'est pas déclare");
		}
		else if(nbElem > leTab.length) {
			System.out.println("Il y a trop d'elements a regarder");
		}
		else if(nbElem < 0) {
			System.out.println("Il n'existe pas d'indice negatif");
		}
		else {
			correct = true;
		}
		return correct;
	}

	/**
	  *<b>Methode qui consiste a inverser les valeurs entre 2 cases d'un tableau</b>
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element du tableau
	  *@param ind1 indice d'une case
	  *@param ind2 indice d'une case
	  */

	void echange (int[] leTab, int nbElem, int ind1, int ind2) {

		int temp;

		if(paramCorrect(leTab, nbElem) == false) {
		}
		else if (ind1 < 0 || ind2 < 0) {
			System.out.println("L'un des indices est en dehors des bornes du tableau");
		}
		else {
			temp = leTab[ind1];
			leTab[ind1] = leTab[ind2];
			leTab[ind2] = temp;
		}
	}

	/**
	  *<b>Methode qui renvoie le max d'un tabeau d'entier</b>
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'elements dans le tableau
	  *@return int le max du tableau
	  */

	int leMax(int[] leTab, int nbElem) {

		int i;
		int max;

		if(paramCorrect(leTab, nbElem) == false) {
			max = 1337;
		}
		else {
			i = 0;
			max = leTab[i];
			for(i = 0 ; i < nbElem - 1 ; i ++) {
				if(leTab[i+1] > max) {
					max = leTab[i+1];
				}
			}
		}
		return max;
	}

	/**
	  *<b>Methode qui renvoie une copie du tableau saisie en parametre</b>
	  *@param tabToCopy tableau d'entier
	  *@param nbElem nombre d'element dans le tableau
	  *@return leTabCopie la copie du tableau passe en entree
	  */

	int[] copier(int[] tabToCopy, int nbElem) {

		int i;
		int[] leTabCopie;

		if(paramCorrect(tabToCopy, nbElem) == false) {
			leTabCopie = null;
		}
		else {
			leTabCopie = new int[nbElem];
			for(i = 0 ; i < nbElem ; i++) {
				leTabCopie[i] = tabToCopy[i];
			}
		}
		return leTabCopie;
	}

	/**
	  *<b>Methode qui affiche les n premieres valeurs d'un tableau</b>
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'element a afficher
	  */
	
	void afficherTab(int[] leTab, int nbElem) {
		
		int i;

		if(paramCorrect(leTab, nbElem) == false) {
		}
		else {
			for(i = 0; i < nbElem; i++) {
				System.out.println("tab["+i+"] = "+leTab[i]);
			}
		}
	}

	/**
	  *Methode qui consiste a remplir un tableau de nombre aléatoire
	  *@param leTab : tableau d'entier
	  *@param nbElem : nombre d'elements dans le tableau
	  *@param min : nombre minimum dans le tableau
	  *@param max : nombre max dans le tableau
	  */

	int[] remplirAleatoire(int[] leTab, int nbElem, int min, int max) {

		int i;

		if(leTab == null) {
			System.out.println("Le tableau n'est pas déclare");
		}
		else if(nbElem > leTab.length) {
			System.out.println("Il y a trop d'elements à regarder");
		}
		else if(nbElem < 0) {
			System.out.println("Il n'existe pas d'indice negatif");
		}
		else if(min > max) {
			System.out.println("Il faut un intervalle de aleatoire logique");
		}
		else {
			for(i = 0 ; i < nbElem ; i++) {
				leTab[i] = tirerAleatoire(min, max);
			}
		}
		return leTab;
	}

	/**
	  *<b>Methode qui rend un nombre aleatoire entre un min et un max</b>
	  *@param min minimum du nombre rendu
	  *@param max maximum du nombre rendu
	  *@return int nombre aleatoire entre max et min
	  */

	int tirerAleatoire (int min, int max) {

		int rand;

		if(min > max) {
			System.out.println("La valeur min est superieur a la valeur max");
			rand = 1337;
		}
		else {
			rand = (int) (Math.random() * ((max - min)+ 1) + min);
		}
		return rand;
	}

	/**
	  *<b>Methode qui consiste afficher le contenu d'un tableau case par case et par ligne de n elements</b>
	  *@param leTab tableau d'entier
	  *@param nbElem nombre d'elements dans le tableau
	  *@param nbLgn nombre d'elements a afficher par ligne
	  */

	void afficherTabLgn (int[] leTab, int nbElem, int nbLgn) {

		int i;
		int j;

		if(paramCorrect(leTab, nbElem) == false) {
		}
		else if(nbLgn > nbElem) {
			System.out.println("Il y a trop d'elements a afficher par ligne");
		}
		else if(nbLgn < 0) {
			System.out.println("Le nombre d'elements a afficher par ligne est negatif");
		}
		else if(nbLgn == 0 && nbElem != 0) {
			System.out.println("Impossible d'afficher 0 elements par ligne");
		}
		else {
			i = 0;
			j = 0;
			while(j < nbElem) {
				while(i < nbLgn && j < nbElem) {
					System.out.print(leTab[j]+" ");
					i++;
					j++;
				}
				System.out.println(" ");
				i = 0;
			}
		}
	}
}