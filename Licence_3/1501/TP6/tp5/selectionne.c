#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char* argv[]){
	int source;
	int nbRead;
	int position;
	char buffer[512];
	char * tmp;
	int done=0;

	if (argc != 4)
	{
		printf("Erreur ! Utilisation : ./selectionne [depart] [nb] [source]\n");
		return 0;
	}
	int nb=(int) atoi(argv[2]);
	int depart=(int) atoi(argv[1]);
	if((source = open(argv[3],O_RDONLY)) == -1 ){
		perror("open"); 
		exit(2);  		
	}

	nbRead = read(source,buffer,sizeof(buffer));
	tmp=buffer;
	while(nbRead>0){
		if(sizeof(buffer)>=depart && !done){
			done=1;
			tmp+=depart-1;
			write(1,tmp,nb);
		}else{
			depart=depart-sizeof(buffer);
		}
		nbRead = read(source,buffer,sizeof(buffer));
		tmp=buffer;
	}


	printf("\n");
	close(source);
	return 0;
}