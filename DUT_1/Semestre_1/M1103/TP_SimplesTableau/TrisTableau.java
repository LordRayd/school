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
