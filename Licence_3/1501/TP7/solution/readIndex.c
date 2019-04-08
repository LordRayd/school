#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int cible;
	int size=0;
	
	if (argc < 3) {
		fprintf(stderr, "usage %s file index ...\n",argv[0]);
		exit(1);
	}
	
	if ((cible  = open(argv[1],O_RDONLY)) == -1){ // test l'ouverture	 
		perror("open READ");
		exit(errno);
	     
	}
	
	if (read(cible,&size,sizeof(int)) !=  sizeof(int)){
		fprintf(stderr, "probleme read size\n");
		exit(1);
	}
	printf("size %d \n",size);
 
	{
		int i;
		for (i=2;i<argc;i++){
			int index=atoi(argv[i]);
			int val;
			if (index < size) {
				lseek(cible,(index +1 )* sizeof(int),SEEK_SET);
				if (read(cible,&val,sizeof(int)) !=  sizeof(int)){
					fprintf(stderr, "probleme read val\n");
					exit(1);
				}
				printf("%d\n",val);
			}
		}
    }
	
	close(cible);
}	
