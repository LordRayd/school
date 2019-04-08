#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <ctype.h>

int main(int argc, char* argv[]){
	int source=1;
	int dest=1;
	int nbRead;
	int i;
	char buffer[512];


	if(argc>=2){
		if ((source = open(argv[1],O_RDONLY)) == -1){
			perror("open"); 
			exit(2);      
		} 
	}
	if(argc==3){
		if((dest = open(argv[2],O_WRONLY | O_CREAT,0644)) == -1 ){
			perror("open"); 
			exit(2);  		
		}
	}


	nbRead = read(source,buffer,sizeof(buffer));
	while(nbRead>0){
		for(i=0;i<nbRead;i++){
			if(islower(buffer[i]))
				buffer[i]=toupper(buffer[i]);
		}
		write(dest,buffer,nbRead);
		nbRead = read(source,buffer,sizeof(buffer));
	}
	
	close(source);
	close(dest);
	return 0;
}