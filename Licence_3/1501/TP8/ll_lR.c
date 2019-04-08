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


void total(char* nom_directorie){
	
	DIR * directorie ; //descripteur de repertoire
    struct dirent *fichier2;
    struct stat etat;
    char path[4096];
    int total=0;
    
    if ((directorie = opendir(nom_directorie))==NULL){
		perror("ls :");
		exit(errno);
    }
	
	while ((fichier2 = readdir(directorie))!=NULL) {
		
		 path;// =malloc(strlen(nom_directorie)+strlen(fichier->d_name));
		 strcpy(path,nom_directorie);
		 strcat(path,"/");
		 strcat(path,fichier2->d_name);
		 strcat(path,"\0");
		
		 if(stat(path,&etat) != -1){
			total += etat.st_blocks;
		}
	}
	printf("total : %d \n",total);
}
void ls_lR(char* nom_directorie){
	
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
		
		 path;// =malloc(strlen(nom_directorie)+strlen(fichier->d_name));
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
        printf("\t%d\t%d\t%s\t%d\t%s\t%s\n",link,uid,gr->gr_name,taille,date,fichier->d_name);
        //free(path);*/
        
        if((etat.st_mode & S_IFDIR) && strcmp(fichier->d_name,".")!=0 && strcmp(fichier->d_name,"..")!=0){
			total(path);
			ls_lR(path);
		}
    } 
    //printf("total : %d \n",total);
    closedir(directorie);

	
}

int main(int argc,char** argv){
	total(argv[1]);
	printf("droit\t\tlien\tiud\t\tgroupe\ttaille\tdate\t\tnom\n");
	ls_lR(argv[1]);
	return 0;
}
