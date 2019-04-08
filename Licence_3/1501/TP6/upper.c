#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char* argv[]){
	int fichierDepart=0, fichierFin=0, ligne, i;
	char buffer[512];

	if(argc >= 2){
		if ((fichierDepart = open(argv[1],O_RDONLY)) == -1){
			perror("open file to upper"); 
			exit(2);      
		} 
	}
	if(argc==3){
		if((fichierFin = open(argv[2],O_WRONLY | O_CREAT,0644)) == -1 ){
			perror("open file to save"); 
			exit(2);  		
		}
	}

	ligne = read(fichierDepart,buffer,sizeof(buffer));
	while(ligne>0){
		for(i=0;i<ligne;i++)buffer[i]=toupper(buffer[i]);
		write(fichierFin,buffer,ligne);
		ligne = read(fichierDepart,buffer,sizeof(buffer));
	}
	
	close(fichierDepart);
	close(fichierFin);
	return 0;
}