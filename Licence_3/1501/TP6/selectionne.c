#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char* argv[]){
	int file, ligne, position, nb, depart, fait=0;
	char buffer[512];
	char * tmp;
	
	if (argc != 4)return 0;
    
	nb = (int) atoi(argv[2]);
	depart = (int) atoi(argv[1]);
	if((file = open(argv[3],O_RDONLY)) == -1 ){
		perror("open file to select"); 
		exit(2);  		
	}

	file = read(file,buffer,sizeof(buffer));
	tmp = buffer;
	while(ligne > 0){
		if(sizeof(buffer) >= depart && !fait){
			fait=1;
			tmp += depart-1;
			write(1,tmp,nb);
		}else{
			depart=depart-sizeof(buffer);
		}
		ligne = read(file,buffer,sizeof(buffer));
		tmp=buffer;
	}

	close(file);
	return 0;
}