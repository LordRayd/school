#include <stdio.h>  // printf

int main (int argc, char * argv[]){
	int compteur = 0;
	int newLines = 0;
	FILE *fichier;
	int c;
	char *fileName;
	
	int optionC=0;
	int optionL=0;
	int optionW=0;
	int i;
	for(i=1; i<argc; i++){
		char * arg = argv[i];
		if (*arg == '-'){
			arg++;
			if(*arg = 'c') optionC = 1;
			if(*arg = 'l') optionL = 1;
			if(*arg = 'w') optionW = 1;
		}else{
			*fileName = argv[i];
		}
	}
	
	if((fichier=fopen(fileName,"r"))==NULL){
		fprintf(stderr,"remplace: probleme d'ouverture de fichier\n");
		exit(1);
	}
	while((c=fgetc(fichier))!=EOF){
		if(c!= '\n' && c != ' ' && c!='	'){
			putchar(c);
			compteur++;
		}
		if(c=='\n')newLines++;
	}
	fclose(fichier);
	
	printf("\n%d Lettres\n",compteur);
	printf("Nombre de nouvelles lignes : %d\n",newLines);
	printf("Nb de Bytes : %d\n",compteur/8);
}
