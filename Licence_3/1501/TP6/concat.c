#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]){
	int fichierDepart, fichierFin, ligne;
	char buffer[512];

	if (argc < 2)return 0;
	
    if((fichierFin = open(argv[argc-1],O_WRONLY | O_CREAT,0644)) == -1 ){
		perror("open fichier ou ecrire"); 
		exit(2);  		
	}

    int i = 1;
    while(i<argc-1){
		fichierDepart = open(argv[i],O_RDONLY);
		ligne = read(fichierDepart,buffer,sizeof(buffer));
		while(ligne>0){
			write(fichierFin,buffer,ligne);
			ligne = read(fichierDepart,buffer,sizeof(buffer));
		}
        i++;
	}

	close(fichierDepart);
	close(fichierFin);
	return 0;
}