#include<stdio.h>
#include <stdlib.h> // malloc
#include<string.h>

struct tabInt_s {
	int nb;
	int nbMax;
	int * valeur;
	struct tabInt_s* suivant;
};

struct tabInt_s* creatTab(int nb){
	printf("\nCreate Tab\n");
	struct tabInt_s* res = (struct tabInt_s*) malloc(sizeof(int)*2+malloc(nb*sizeof(int))+sizeof(struct tabInt_s));
	res->nb = 0;
	res->nbMax = nb;
	res->valeur = (int *);
	res->suivant = (struct tabInt_s*) NULL;
	return res;
}

void  ajoutTab(struct tabInt_s *tab, int val){
	if(tab->nb >= tab->nbMax){
		if(tab->suivant == (struct tabInt_s*) NULL){
			tab->suivant = creatTab(tab->nbMax);
		}
		ajoutTab(tab->suivant,val);
	}else{
		tab->valeur[tab->nb] = val;
		//tab->valeur = (int *) val;
		tab->nb++;
		printf(" Val : %d\n",tab->valeur[tab->nb]);
	}
}


void tabOut(struct tabInt_s *tab){
	printf("\nAffichage\n");
	struct tabInt_s* var = tab;
	while(var != (struct tabInt_s *) NULL){
		int i = 0;
		while(i < var->nb){
			printf(" Val : %d\n",var->valeur[i]);
			
			i++;
		}
		var = var->suivant;
	}
	
}

void tabMirror(struct tabInt_s *tab){
	if(tab != (struct tabInt_s*)NULL){
		tabMirror(tab->suivant);
		int i = tab->nb-1;
		while(i>=0){
			printf("Val : %d\n",tab->valeur[i]);
			i--;
		}
	}
}

int main(){
	struct tabInt_s * tab=creatTab(10);
	{
		int i;
		for(i=0;i < 25; i++)ajoutTab(tab,i);
	}
	tabOut(tab);
	tabMirror(tab);
	return 0;
}
