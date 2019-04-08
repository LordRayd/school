#include <stdio.h>
#include <stdlib.h>
#include "03Stock.h"

struct magasin_s MAGASIN;
int COMPTEUR=0;

int faireUnChoix(){
	int choix;
	printf("==================== Gestion des Stocks ====================\n");
	printf("Entrez 0 pour quitter\n");
	printf("Entrez 1 pour observer un article grace a ça reference\n");
	printf("Entrez 2 pour voir le nombre d article existant en stock\n");
	printf("Entrez 3 pour creer un nouvelle article\n");

	scanf("%d",&choix);
	return choix;
}


int initialisationArticle(struct article_s* article){
	article->designation = malloc(50*sizeof(char));
	article->categorie = malloc(50*sizeof(char));
	article->vetement.couleur = malloc(50*sizeof(char));
	article->vetement.matiere1 = malloc(50*sizeof(char));
	article->vetement.matiere2 = malloc(50*sizeof(char));
	article->vetement.matiere3 = malloc(50*sizeof(char));
	article->comestible.provenance = malloc(50*sizeof(char));
	article->comestible.dlc = malloc(50*sizeof(char));

}

int creerArticle(){
	struct article_s article;
	initialisationArticle(&article);
	int choix;
	int reference;

	printf("Entrez 0 pour arreter la creation\n");
	printf("Entrez 1 pour creer un vetement\n");
	printf("Entrez 2 pour creer un produit comestible\n");
	scanf("%d",&choix);
	
	if(choix==0){
		return 1;
	}
	article.type=choix;
	{// Choix de la reference
		if(choix==1){
			printf("La reference doit etre entre 1000 et 1999\n");
			scanf("%d",&reference);
			while(reference>=1000 && reference<2000){
				printf("La reference doit etre entre 1000 et 1999\n");
				scanf("%d",&reference);
			}
			article.reference=reference;
		}
		if(choix==2){
			printf("La reference doit etre entre 2000 et 2999\n");
			scanf("%d",&reference);
			while(reference>=2000 && reference<3000){
				printf("La reference doit etre entre 2000 et 2999\n");
				scanf("%d",&reference);
			}
			article.reference=reference;
		}
	}

	printf("La designation de l article\n");
	scanf("%s",(article.designation));
	printf("La categorie de l article\n");
	scanf("%s",(article.categorie));
	printf("Le nombre d exemplaire\n");
	scanf("%d",&(article.nbExemplaire));

	if(article.type==1){ // Vetement
		printf("Caracteristique du Vetement\n");
		printf("La taille\n");
		scanf("%d",&(article.vetement.taille));
		printf("La couleur\n");
		scanf("%s",(article.vetement.couleur));
		printf("La matiere 1\n");
		scanf("%s",(article.vetement.matiere1));
		printf("La matiere 2\n");
		scanf("%s",(article.vetement.matiere2));
		printf("La matiere 3\n");
		scanf("%s",(article.vetement.matiere3));
	}

	if(article.type==2){// Produit Comestible
		printf("Caracteristique du Produit Comestible\n");
		printf("La provenance ?\n");
		scanf("%s",(article.comestible.provenance));
		printf("La date limite de consommation (DLC)\n");
		scanf("%s",(article.comestible.dlc));
	}

	MAGASIN.articles[COMPTEUR]=article;
	COMPTEUR++;
	return 0;
}

int consulterArticle(){
	if(COMPTEUR == 0){
		printf("Le magasin ne possede aucun article\n");
		return 1;
	}
	int reference;
	int i=0;
	int find=0;
	printf("La reference de l'article que vous souhaitez observer\n");
	scanf("%d",&reference);
	while(i<COMPTEUR && !find){
		if(MAGASIN.articles[i].reference == reference){
			find=1;
			if(MAGASIN.articles[i].type==1){
				printf("Le produit est un vetement\n");
			}else{
				printf("Le produit est un produit comestible\n");
			}
			printf("La reference : %d\n", MAGASIN.articles[i].reference);
			printf("La designation : %s\n", MAGASIN.articles[i].designation);
			printf("La categorie : %s\n", MAGASIN.articles[i].categorie);
			printf("Le nombre d exemplaire : %d\n", MAGASIN.articles[i].nbExemplaire);

			if(MAGASIN.articles[i].type==1){ // Vetement
				printf("La taille : %d\n", MAGASIN.articles[i].vetement.taille);
				printf("La couleur : %s\n", MAGASIN.articles[i].vetement.couleur);
				printf("La matiere 1 : %s\n", MAGASIN.articles[i].vetement.matiere1);
				printf("La matiere 2 : %s\n", MAGASIN.articles[i].vetement.matiere2);
				printf("La matiere 3 : %s\n", MAGASIN.articles[i].vetement.matiere3);
			}
			if(MAGASIN.articles[i].type==2){ // Produit Comestible
				printf("La provenance : %s\n", MAGASIN.articles[i].comestible.provenance);
				printf("La Date Limite de Consommation : %s\n", MAGASIN.articles[i].comestible.dlc);
			}
		}
		i++;
	}
	return 0;
}

void afficherStock(){
	int i;
	int compteur=0;
	for(i=0; i<COMPTEUR; i++){
		compteur+=MAGASIN.articles[i].nbExemplaire;
	}
	printf("Le magasin possede %d article(s) different(s)\n", COMPTEUR);
	printf("Pour un total de %d article(s)\n", compteur);
}

int main(int argc, char * argv[]){
	int choix = faireUnChoix();
	while(choix){
        if(choix == 0){
            return 0;
        }
        if(choix == 1){
            consulterArticle();
        }
        if(choix == 2){
            afficherStock();
        }
        if(choix == 3){
            creerArticle();
        }
		choix=faireUnChoix();
	}
}