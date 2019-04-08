#include <stdio.h>
#include <stdlib.h>

struct vetement_s
{
    int taille;
	char* couleur;
	char* mat1;
	char* mat2;
	char* mat3;
}; 


struct produitComestible_s
{  	
	char* provenance;
	char* dlc;
}; 

struct article_s
{
	int type; //1-> vetement, 2-> produit
	int reference;
	char* designation;
	char* categorie;
	int nbExemplaire;
	union{
		struct vetement_s vetement;
		struct produitComestible_s produitComestible;
	};
};



struct magasin_s
{
	struct article_s articles[1000];
};

struct magasin_s magasin;
int cpt=0;

int menu(){
	int choix;
	printf("Que voulez-vous faire ?\n0-Quitter\n1-Créer un article\n2-Consulter un article\n3-Voir le nombre d'article en stock\n");
	scanf("%d",&choix);
	return choix;
}


int InitArticle(struct article_s* article){
	article->designation = malloc(50*sizeof(char));
	article->categorie = malloc(50*sizeof(char));
	article->vetement.couleur = malloc(50*sizeof(char));
	article->vetement.mat1 = malloc(50*sizeof(char));
	article->vetement.mat2 = malloc(50*sizeof(char));
	article->vetement.mat3 = malloc(50*sizeof(char));
	article->produitComestible.provenance = malloc(50*sizeof(char));
	article->produitComestible.dlc = malloc(50*sizeof(char));

}

int creerArticle(){
	struct article_s article;
	InitArticle(&article);
	int choix;
	int ref;
	printf("Que voulez-vous créer ?\n0-Annuler\n1-Vêtement\n2-Produit comestible\n");
	scanf("%d",&choix);
	if(choix==0)
		return 0;

	if(choix==1){
		printf("Référence (entre 1000 et 1999) ?\n");
		scanf("%d",&ref);
		while(ref<1000 || ref>1999){
			printf("Référence (entre 1000 et 1999) ?\n");
			scanf("%d",&ref);
		}
		article.reference=ref;
	}


	if(choix==2){
		printf("Référence (entre 2000 et 2999) ?\n");
		scanf("%d",&ref);
		while(ref<2000 || ref>2999){
			printf("Référence (entre 2000 et 2999) ?\n");
			scanf("%d",&ref);
		}
		article.reference=ref;
	}

	article.type=choix;
	printf("Désignation ?\n");
	scanf("%s",(article.designation));
	printf("Catégorie ?\n");
	scanf("%s",(article.categorie));
	printf("NbExemplaire ?\n");
	scanf("%d",&(article.nbExemplaire));
	if(choix==1){
		printf("Taille ?\n");
		scanf("%d",&(article.vetement.taille));
		printf("Couleur ?\n");
		scanf("%s",(article.vetement.couleur));
		printf("Matière 1 ?\n");
		scanf("%s",(article.vetement.mat1));
		printf("Matière 2 ?\n");
		scanf("%s",(article.vetement.mat2));
		printf("Matière 3 ?\n");
		scanf("%s",(article.vetement.mat3));
	}
	if(choix==2){
		printf("Provenance ?\n");
		scanf("%s",(article.produitComestible.provenance));
		printf("DLC ?\n");
		scanf("%s",(article.produitComestible.dlc));
	}
	magasin.articles[cpt]=article;
	cpt++;
	return 0;
}

void consulterArticle(){
	int ref;
	int i=0;
	int trouve=0;
	printf("Quelle est la référence de l'article ?\n");
	scanf("%d",&ref);
	while(i<cpt && !trouve){
		if(magasin.articles[i].reference == ref){
			trouve=1;
			if(magasin.articles[i].type==1)
				printf("--- Vêtement ---\n");
			else
				printf("--- Produit comestible ---\n");
			printf("Référence : %d\n", magasin.articles[i].reference);
			printf("Désignation : %s\n", magasin.articles[i].designation);
			printf("Catégorie : %s\n", magasin.articles[i].categorie);
			printf("NbExemplaire : %d\n", magasin.articles[i].nbExemplaire);

			if(magasin.articles[i].type==1){
				printf("Taille : %d\n", magasin.articles[i].vetement.taille);
				printf("Couleur : %s\n", magasin.articles[i].vetement.couleur);
				printf("Matière 1 : %s\n", magasin.articles[i].vetement.mat1);
				printf("Matière 2 : %s\n", magasin.articles[i].vetement.mat2);
				printf("Matière 3 : %s\n", magasin.articles[i].vetement.mat3);
			}else{
				printf("Provenance : %s\n", magasin.articles[i].produitComestible.provenance);
				printf("DLC : %s\n", magasin.articles[i].produitComestible.dlc);
			}
		}
		i++;

	}

}

void voirNbStock(){
	int i;
	int nbArticle=0;
	for(i=0;i<cpt;i++){
		nbArticle+=magasin.articles[i].nbExemplaire;
	}
	printf("Il y a %d sorte d'article et %d articles au total \n", cpt,nbArticle);
}

int main(){
	int choix = menu();
	while(choix!=0){
		switch(choix) 
		{
			case 0 :  return 0;
			case 1 :  creerArticle(); break;
			case 2 :  consulterArticle(); break;
			case 3 :  voirNbStock(); break;
			default : break;

		}
		choix=menu();
	}
}