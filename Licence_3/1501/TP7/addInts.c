#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

int main(int argc, char* argv[]){
	int cible;
	int size=0;
	
	if (argc < 3) {
		fprintf(stderr, "usage %s file ints ...\n",argv[0]);
		exit(1);
	}
	
	if ((cible  = open(argv[1],O_RDWR)) == -1){
		if (errno!=ENOENT ){
			perror("open RDWR");
			exit(errno);
	    }
	    
		if ( (cible  = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0666)) < 0){
			perror("open O_CREAT");
			exit(errno);
	    }
		if (write(cible,&size,sizeof(int)) !=  sizeof(int)){
			perror("write size");
			exit(errno);
		}
	} else{
		if (read(cible,&size,sizeof(int)) !=  sizeof(int)){
			fprintf(stderr, "probleme read size\n");
			exit(1);
		}
	}
	printf("size %d \n",size);
	
	if (size !=0 ) lseek(cible,(size +1 )* sizeof(int),SEEK_SET);
	   
	{
	  int i;
	  for (i=2;i<argc;i++){
		int val=atoi(argv[i]);
		if (write(cible,&val,sizeof(int)) !=  sizeof(int)){
			perror("write val ");
			exit(errno);
		}
		size++;
	  }
	}
	
	lseek(cible,0,SEEK_SET);
	if (write(cible,&size,sizeof(int)) !=  sizeof(int)){
		perror("write size");
		exit(errno);
	}
	
	close(cible);
}
