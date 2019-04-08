#include <stdio.h> //librairie standard (stderr)
#include <dirent.h> // manipulation des repertoire
#include <stdlib.h>
#include <errno.h>
#include <time.h>
#include <sys/stat.h>

#include <pwd.h> // structure passwd
//struct passwd {
//                char   *pw_name;   /* Nom d'utilisateur             */
//                char   *pw_passwd; /* Mot de passe                  */
//                uid_t   pw_uid;    /* ID de l'utilisateur           */
//                gid_t   pw_gid;    /* ID du groupe de l'utilisateur */
//                char   *pw_gecos;  /* Nom réel de l'utilisateur     */
//                char   *pw_dir;    /* Répertoire de connexion       */
//                char   *pw_shell;  /* Programme Shell de connexion  */
//              };    
#include <grp.h>  // strucute group  
//  struct group {
//                   char   *gr_name;    /* Nom du groupe.          */
//                   char   *gr_passwd;  /* Mot de passe du groupe. */
//                   gid_t   gr_gid;     /* ID du groupe.           */
//                   char  **gr_mem;     /* Membres du groupe.      */
//              };      


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

int main ( int argc , char **argv ) {

    DIR * nom_directorie ; // descriteur de repertoire
    struct dirent * fichier ; // structure d'une entree
    struct stat etat ;
	int optionL = 0;
	int optionR = 0;
	const char * dir = ".";
	
	
	struct passwd * pw;
	struct group *gr;
	
    
    // teste de bonne utilisation
    if ( argc < 2 ) { 
		printf("usage :  %s rep [-lR]\n",argv[0]);
		exit(1);
    }
    if(argc > 2 ){
		if(argv[2]  == "-l")optionL = 1;
		else if(argv[2]  == "-lR"){
			optionL = 1;
			optionR = 1;
		}
		
	}
    // ourverture du repertoire
    if ( (nom_directorie = opendir(argv[1])) == NULL ){
		perror("ls :");
		exit(errno);
    }
    
    // lectures des entress
	write(0,"inode     droit      size iud      gid   date                 nom\n",67);
    while ((fichier = readdir(nom_directorie)) != NULL) {
		stat(fichier->d_name, &etat);
		printf("%d ",etat.st_ino);

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
    
		pw = getpwuid(etat.st_uid);
		gr = getgrgid(pw->pw_gid))
		printf(" %d",etat.st_size);
		printf(" %s",pw->pw_name);
		printf(" %d",etat.st_gid);
		
		char * t = ctime(&etat.st_mtime);
		char * ti = cutEndCTime(t);
		printf(" %s", ti);
		
		printf(" %s\n",fichier->d_name);
           
           
    }
    
            
    closedir(nom_directorie);
   
}
