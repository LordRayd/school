#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char * tabAdresse[20];
int compteur = 0;

void sauvegarde(char * insert){
	strcpy(tabAdresse[compteur],insert);
	compteur++;
	char * tmp = malloc(sizeof(char*)); 
 	int j,i;
    for (j=0; j<compteur; j++){
        for (i=j+1; i<compteur; i++){ 
            if (strcmp(tabAdresse[j], tabAdresse[i]) > 0){  
                strcpy(tmp, tabAdresse[j]); 
                strcpy(tabAdresse[j], tabAdresse[i]); 
                strcpy(tabAdresse[i], tmp); 
            } 
        } 
    } 
}

/**
 * marche
 */
void saisie(){
	printf("==== Saisie\n");
	char saisie[100];
	int i=1;

	printf("1 : ");
	fgets(saisie,100,stdin);
	while(i<20 && strcmp(saisie,"fin\n")){
		sauvegarde(saisie);
		printf("%d : ",i+1);
		fgets(saisie,100,stdin);
		i++;
	}
}

/**
 * Marche
 */
void affichage(){
	printf("\n==== Affichage");
	int i;
	for(i=0; i<compteur; i++){
		printf("\n%d : ",i+1);
		printf("%s", tabAdresse[i]);
	}
}


int main(int argc, char * argv[]){
	int i;
	for(i=0; i<20; i++){
		tabAdresse[i] = malloc(sizeof(char*));
	}
	saisie();
	affichage();
	return 0;
}

