/*  mknod.c
    cree un indoe de type  fichier
    // reserve a root
*/
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main ( int argc , char **argv ) {

    
    if ( argc != 2 ) { // manque le nom du fichier a traiter
      fprintf(stderr,"usage :  %s nomDeFichier \n",argv[0]); 
      exit(1);
    }
    umask(0); // position le umask
    if (mknod(argv[1],S_IFREG|0666,0) == -1){// creation du fichier
      perror("mknod :"); 
      exit(errno);
    } 
}


 
