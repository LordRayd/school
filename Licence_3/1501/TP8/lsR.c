#include <stdio.h>
#include <ctype.h>
#include <fcntl.h> //appel systeme
#include <stdio.h> //librairie standard (stderr)
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <pwd.h>
#include <grp.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <dirent.h>
#include "time.h"

void ls_Recursif(char* nom_directorie){
	
	DIR * directorie ; //descripteur de repertoire
    struct dirent * fichier ; // structure d'une entree
    struct dirent *fichier2;
    struct stat etat ; 
    struct passwd *pw;
    struct group *gr;
    
    int link;
	int uid;
	int taille;
	int droit;
	char path[4096];
	char *date;
	
	if(nom_directorie != NULL){
		if((pw = getpwuid(getuid()))==NULL) exit(1);
	}else{
		if((pw = getpwnam(nom_directorie))==NULL) exit(2);
	}
   
    // ourverture du repertoire
    if ((directorie = opendir(nom_directorie))==NULL){
		perror("ls :");
		exit(errno);
    }
	
    // lectures des entress
    while ((fichier = readdir(directorie))!=NULL) {
		
		 path;
		 strcpy(path,nom_directorie);
		 strcat(path,"/");
		 strcat(path,fichier->d_name);
		 strcat(path,"\0");
		
		 if(stat(path,&etat) != -1){
			gr = getgrgid(pw->pw_gid);
			link = etat.st_nlink;
			uid = etat.st_uid;
			taille = etat.st_size;
			droit = (etat.st_mode & 0777);
			time_t time = etat.st_mtime;
			date = ctime(&time);
			date+=4;
			date[12] = '\0';
		}
		
		printf( (S_ISDIR(etat.st_mode)) ? "d" : "-");
		printf( (etat.st_mode & S_IRUSR) ? "r" : "-");
		printf( (etat.st_mode & S_IWUSR) ? "w" : "-");
		printf( (etat.st_mode & S_IXUSR) ? "x" : "-");
		printf( (etat.st_mode & S_IRGRP) ? "r" : "-");
		printf( (etat.st_mode & S_IWGRP) ? "w" : "-");
		printf( (etat.st_mode & S_IXGRP) ? "x" : "-");
		printf( (etat.st_mode & S_IROTH) ? "r" : "-");
		printf( (etat.st_mode & S_IWOTH) ? "w" : "-");
		printf( (etat.st_mode & S_IXOTH) ? "x" : "-");
        printf(" %3d %5d %s %s %5d %s %s\n",link,uid,pw->pw_name,gr->gr_name,taille,date,fichier->d_name);
        
        if((etat.st_mode & S_IFDIR) && strcmp(fichier->d_name,".")!=0 && strcmp(fichier->d_name,"..")!=0){
			ls_Recursif(path);
		}
    }
    closedir(directorie);
}

int main(int argc,char** argv){
	printf("droit  lien  iud  utilisateur  groupe  taille  date  nomFichier\n");
	ls_Recursif(argv[1]);
	return 0;
}
