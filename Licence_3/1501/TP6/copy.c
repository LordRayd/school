#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]){
	int fichierDepart, fichierFin, ligne;
	char buffer[512];

	if (argc != 3)return 0;
	
    if ((fichierDepart = open(argv[1],O_RDONLY)) == -1){
		perror("open Fichier a lire"); 
		exit(2);      
	} 
	if((fichierFin = open(argv[2],O_WRONLY | O_CREAT,0644)) == -1 ){
		perror("open Fichier a ecrire"); 
		exit(2);  		
	}

	ligne = read(fichierDepart,buffer,sizeof(buffer));
	while(ligne>0){
		write(fichierFin,buffer,ligne);
		ligne = read(fichierDepart,buffer,sizeof(buffer));
	}

	close(fichierDepart);
	close(fichierFin);
	return 0;
}