#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char* argv[]){
	int source;
	int dest;
	int nbRead;
	int i;
	char buffer[512];

	if((dest = open(argv[argc-1],O_WRONLY | O_CREAT,0644)) == -1 ){
		perror("open"); 
		exit(2);  		
	}


	for(i=1;i<argc-1;i++){
		source = open(argv[i],O_RDONLY);
		nbRead = read(source,buffer,sizeof(buffer));
		while(nbRead>0){
			write(dest,buffer,nbRead);
			nbRead = read(source,buffer,sizeof(buffer));
		}
	}

	
	close(source);
	close(dest);
	return 0;
}