#include <stdio.h>
#include <string.h>
#include"txt.h"
#include"txtfile.h"

int txtSavefile(struct txt_s* texte, char* path){
	FILE* fichier = NULL;
    fichier = fopen(path, "w");
    if (fichier != NULL){
		if(texte->premier){
			struct maillon_s* tmp = texte->premier;
			while(tmp != NULL){
				fprintf(fichier,"%s\n",tmp->ligne);
				tmp = tmp->suivant;
			}
		}else{
			printf("%s","Texte vide");
		}
        fclose(fichier);
    }
    return 0;
}

struct txt_s* txtLoadFile(char * path){
	struct txt_s* texte = txtCreat();
	FILE* fichier = NULL;
	char line;
	char c;
	int i = 1;
	
    if((fichier=fopen(path,"r"))==NULL){
		fprintf(stderr,"remplace: probleme d'ouverture de fichier\n");
		exit(1);
	}
	while((c=fgetc(fichier))!=EOF){
		if(c == '\n'){
			txtInsertPos(texte,i,line);
			line = NULL;
			i++;
		}
		if(c != '\n')line += c;
		
	}
	fclose(fichier);
	return texte;
}
