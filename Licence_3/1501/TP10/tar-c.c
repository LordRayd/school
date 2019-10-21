#include <stdio.h>
#include <ctype.h>
#include <fcntl.h> //appel systeme
#include <stdio.h> //librairie standard (stderr)
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <dirent.h>

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

int writeContent(int entree, int sortie){
	char buffer[512];
	char * ligne;
	while((ligne = readLine(buffer, 512, entree)) > 0){
		write(sortie,buffer,strlen(buffer));
	}
  return 0;char buff[FILENAME_MAX];
  GetCurrentDir( buff, FILENAME_MAX );
  printf("Current working dir: %s\n", buff);
}

int writeHeader(char* nom_fichier, int sortie){
    //char* file = get_current_dir_name();
    DIR * directorie;
    struct dirent *f;
    struct stat etat;

    if ((directorie = opendir( dirname( get_current_dir_name() ) ) )==NULL){
  		perror("du ");
  		exit(errno);
    }

  	while ((f = readdir(directorie))!=NULL) {
  			if( strcmp(f->d_name,*nom_fichier) ){
          printf("ok\n");
  			}
  	}
  	return 0;
}

int myTarT(char* nom_fichier, char* nom_archive){
  int entree=0;
  int sortie=0;
	char buffer[512];
	char * ligne;

	if ((entree = open(nom_fichier, O_RDONLY)) == -1){
		perror("open Fichier a lire");
		exit(2);
	}
  if((sortie = open(nom_archive, O_WRONLY | O_CREAT , 0644)) == -1){
    perror("open Fichier a ecrire");
    exit(2);
  }
  
  writeHeader(nom_fichier, sortie);
	writeContent(entree, sortie);

	close(entree);
  close(sortie);
  return 0;
}


int main(int argc, char** argv){
	int total=myTarT(argv[1],argv[2]);
  printf("Current working dir: %s\n", get_current_dir_name());
	return 0;
}
