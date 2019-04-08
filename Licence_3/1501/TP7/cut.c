#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>
#include <stdlib.h>
#include <sys/stat.h>

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

void cut(char* buf, int depart, int longueur, int bsize){
    char* tmp = buf;
    int i = 0;
    for(; i<depart;i++){
        if(*tmp =='\0' || *tmp ==EOF || i > bsize) break;
        tmp++;
    }
    for(int j = 0; j<longueur;j++){
        if(*tmp =='\0' || *tmp ==EOF || j+i > bsize || *tmp=='\n') break;
        write(1, tmp, 1);
        tmp++;
    }
    write(1, "\n", 1);  
}

int max(int premier, int deuxieme){
    return premier > deuxieme ? premier : deuxieme;
}

int min(int premier, int deuxieme){
    return premier < deuxieme ? premier : deuxieme;

}

int main(int argc, char const *argv[]){
    int fd = 0;

    if(argc < 3) return -1;
	
	if(argc > 3){
		if ((fd = open(argv[3],O_RDONLY)) == -1){
			perror("open fichier a lire"); 
			exit(2);
		}
	}
	
	char buffer[512];
	int i = 1;
	int colDep = min(atoi(argv[1]), atoi(argv[2]));
	int longueur = max(atoi(argv[1]), atoi(argv[2]))-colDep+1;
	if(colDep < 0) return -1;
	while(readLine(buffer, 512, fd) != NULL){
		cut(buffer, colDep-1, longueur, 512);
		i++;
	}

	close(fd);
    return 0;
}