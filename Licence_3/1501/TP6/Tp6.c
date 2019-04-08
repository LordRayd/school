#include <fcntl.h>
#include <unistd.h>
int main(int argc, char* argv[]){
	
	int fileR;
	int fileW;
	// ouverture du fichier en lecture
	if ((fileR = open("fichier.txt",O_RDONLY)) == -1)exit(2);
	if ((fileW = open("fichier2.txt",O_WRONLY || O_CREAT , 0644)) == -1)printf("err");
	     
	{
		char c[512];
		int nbRead = read(fileR,&c,512);
		while(nbRead >0 ){
			printf("%s",c);
			write(fileW,c,512);
			nbRead = read(fileR,&c,512);
		}
	}
	
}
