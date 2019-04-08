#include <stdio.h>
#include <string.h>
#include <stdlib.h>
char * TAB[20];
int CPT=0;


void trie(){
	char* temp=malloc(sizeof(char*)); 
 	int j,i;
    for (j=0; j<CPT-1; j++) 
    {
        for (i=j+1; i<CPT; i++) 
        { 
            if (strcmp(TAB[j], TAB[i]) > 0) 
            {  
                strcpy(temp, TAB[j]); 
                strcpy(TAB[j], TAB[i]); 
                strcpy(TAB[i], temp); 
            } 
        } 
    } 
}

void init(){
	int i;
	for(i=0;i<20;i++){
		TAB[i]=malloc(sizeof(char*));
	}
}

void afficher(){
	printf("=== Affichage ===\n");
	int i;
	for(i=0;i<CPT;i++)
		printf("%s\n", TAB[i]);
	printf("=== Fin ===\n");
}

void save(char * saisie){
	strcpy(TAB[CPT],saisie);
	CPT++;
	trie();
}

void saisie(){
	char saisie[100];
	printf("Saissisez des chaines de caractères \n");
	fgets(saisie,100,stdin);
	while(strcmp(saisie,"fin\n")){
		save(saisie);
		fgets(saisie,100,stdin);
	}
}

int main(){
	init();
	saisie();
	afficher();
}
