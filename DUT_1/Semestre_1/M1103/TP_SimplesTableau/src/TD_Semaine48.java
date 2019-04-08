	int [] triParComptageFreq ( int [] leTab, int nbElem){
		int [] tabFreq = new int[leMax(leTab,nbElem)+1;
		int i=0;
		while(i<nbElem){
			int n = leTab[i];
			tabFreq[i] = tabFreq[i]-1;
			i++;
		}
		return tabFreq
	}
	
	void testTripParComptageFreq(){
		int [] leTab = {5,47,20,3,4,47,6,7,20,9};
		tab1 = triParComptageFreq ( leTab, 10);
		afficherTab(leTab,10);
	}
		
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
