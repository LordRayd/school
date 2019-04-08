#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char* argv[]){
	int source;
	int dest;
	int nbRead;
	char buffer[512];

	if (argc != 3)
	{
		printf("Erreur ! Utilisation : ./copy [source] [destination]\n");
		return 0;
	}

	if ((source = open(argv[1],O_RDONLY)) == -1){
		perror("open"); 
		exit(2);      
	} 

	if((dest = open(argv[2],O_WRONLY | O_CREAT,0644)) == -1 ){
		perror("open"); 
		exit(2);  		
	}

	nbRead = read(source,buffer,sizeof(buffer));
	while(nbRead>0){
		write(dest,buffer,nbRead);
		nbRead = read(source,buffer,sizeof(buffer));
	}
	close(source);
	close(dest);

	return 0;
}