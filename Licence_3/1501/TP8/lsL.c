#include <stdio.h> //librairie standard (stderr)
#include <dirent.h> // manipulation des repertoire
#include <stdlib.h>
#include <errno.h>
#include <time.h>
#include <sys/stat.h>
#include <string.h>

#include <pwd.h>    
#include <grp.h> 

char * cutEndCTime(char * t){
	char * deb = t;
	char * debdeb = deb;
	int i=0;
	while (i<20){
		*deb = *t;
		t++;
		deb++;
		i++;
	}
	*deb = '\0';
	deb = debdeb;
	return deb;
}

void ls(int argc, char **argv){
	DIR * nom_directorie ; // descriteur de repertoire
    struct dirent * fichier ; // structure d'une entree
    struct stat etat ;
	int optionL = 0;
	int optionR = 0;
	const char * dir = ".";
	struct passwd * pw;
	struct group *gr;
	char path[4096];
    
    // teste de bonne utilisation
    if ( argc < 2 ) { 
		printf("usage :  %s rep [-lR]\n",argv[0]);
		exit(1);
    }
    
    // OPTION l et R
    if(argc > 2 ){
		if(strcmp(argv[2] ,"-l") == 0){
			optionL = 1;
		}else if(strcmp(argv[2] ,"-lR") == 0){
			optionL = 1;
			optionR = 1;
		}
	}
	
    // ourverture du repertoire
    if ( (nom_directorie = opendir(argv[1])) == NULL ){
		printf("cible : %s \n",argv[1]);
		perror("ls ");
		exit(errno);
    }
    
    // lectures des entress
    while ((fichier = readdir(nom_directorie)) != NULL) {
		char * nom = fichier->d_name;
		if(strcmp(nom,".") != 0 && strcmp(nom,"..") != 0 ){
			stat(nom, &etat);

			// DROIT
			if(optionL == 1){
				printf( (S_ISDIR(etat.st_mode) ) ? "d" : "-");
				printf( (etat.st_mode & S_IRUSR) ? "r" : "-");
				printf( (etat.st_mode & S_IWUSR) ? "w" : "-");
				printf( (etat.st_mode & S_IXUSR) ? "x" : "-");
				printf( (etat.st_mode & S_IRGRP) ? "r" : "-");
				printf( (etat.st_mode & S_IWGRP) ? "w" : "-");
				printf( (etat.st_mode & S_IXGRP) ? "x" : "-");
				printf( (etat.st_mode & S_IROTH) ? "r" : "-");
				printf( (etat.st_mode & S_IWOTH) ? "w" : "-");
				printf( (etat.st_mode & S_IXOTH) ? "x" : "-");
				printf(" ");
			}
		
			pw = getpwuid(etat.st_uid);
			gr = getgrgid(etat.st_gid);
			
			printf("%3ld ", etat.st_nlink);
			printf("%s ", pw->pw_name);
			printf("%s ", gr->gr_name);
			printf("%5ld ", etat.st_size);
			
			// TEMPS 
			char * t = ctime(&etat.st_mtime);
			char * ti = cutEndCTime(t);
			printf("%19s ", ti);
			
			printf("%s\n",nom);

			/** Segmentation fault
			if(S_ISDIR(etat.st_mode) && optionR == 1){
				strcpy(path, argv[1]);
				strcat(path,"/");
				strcat(path, nom);
				strcat(path,"/");
				strcat(path, "\0");
				printf("%15s",path);

				char ** argv2;
				argv2 = malloc(argc * sizeof(char*));
				int j;
				for (j = 0; j < argc; j++) argv2[j] = malloc(sizeof(char));

				argv2[0] = "./ll";
				argv2[1] = path;
				argv2[2] = "-lR";
				ls(argc, argv2);
			}*/
		}
    }
                
    closedir(nom_directorie);
}

int main ( int argc, char **argv ) {
	ls(argc,argv);
}
