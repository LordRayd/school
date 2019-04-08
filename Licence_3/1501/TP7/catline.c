#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char * readLine(char * buf, int bsize, int fd){	
	int c;
	char * p;
	for (p = buf; bsize > 0; bsize--){
		if((c = read(fd,p,1)) == 0) break;
		if (*p == '\n'){
			p++;
			break;
		}
		p++;
	}
	*p = '\0';
	if (p == buf || c == 0)return NULL;
	return (p);
}


int main(int argc, char* argv[]){
	int fichier=0;
	char buffer[512];
	char * ligne;
	int nbLigne = 1;
	
	if(argc == 2){
		if ((fichier = open(argv[1],O_RDONLY)) == -1){
			perror("open Fichier a lire"); 
			exit(2);
		}
	}
	
	while((ligne = readLine(buffer, 512, fichier)) > 0){
		char str[7];
		sprintf(str, "%d : ", nbLigne);
		
		write(1,str,7);
		write(1,buffer,strlen(buffer));
		nbLigne++;
	}

	close(fichier);
	return 0;
}
