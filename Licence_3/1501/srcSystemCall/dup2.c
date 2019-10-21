/* fichier cat.c */
#include <stdio.h> // fprintf librairie standard C
#include <fcntl.h>  // apple systeme unix
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

int main ( int argc , char **argv ) {

#define MAX 512   // taille du tampon 
    int file; // descripteur de fichier
    char  buf[MAX]; // zone memoire
    int nb;      // nbr de caratere lus
    if ( argc < 2 ) { // nombre d'arguments incorrect 
      fprintf(stderr,"usage :  %s file \n",argv[0]);
      exit(1); // sortie differente de 0
    }
    // ouverture du fichier
    if ((file = open(argv[1],O_RDONLY)) >= 0){
      if (dup2(file,0) == -1){
	  perror("dup2 :");
	  exit(errno); 
      }
      // lecture d'un bloc 
      while ((nb= read(0,buf,MAX)) > 0) {
         write(1,buf,nb); /* fd = 1 sortie standard */
      }
      close(file); // fermeture
    } 
}

