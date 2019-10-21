/*
   ls.c
      
      affiche toute les entrees (fichier ou repertoire)  d'un repertoire
      
      utilise les appels systeme opendir,readdir,closedir 
     
      usage : ls rep

 */

#include <stdio.h> //librairie standard (stderr)
#include <dirent.h> // manipulation des repertoire
#include <stdlib.h>
#include <errno.h>

/* effectue un ls  rep  */

int main ( int argc , char **argv ) {

    DIR * nom_directorie ; // descriteur de repertoire
    struct dirent * fichier ; // structure d'une entree
   
    // teste de bonne utilisation
    if ( argc != 2 ) { 
      printf("usage :  %s rep \n",argv[0]);
      exit(1);
    }
   
    // ourverture du repertoire
    if ( (nom_directorie = opendir(argv[1]))== NULL ){
	perror("ls :");
	exit(errno);
    }
    // lectures des entress
    while ((fichier = readdir(nom_directorie)) != NULL) {
           printf(" %s\n",fichier->d_name);
    }
    closedir(nom_directorie);
   
}
