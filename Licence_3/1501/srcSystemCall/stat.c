/*****************      stat.c  *************/



#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <errno.h>

/* effectue un ls -l rep  */




int main ( int argc , char **argv ) {

    struct stat etat ;   
    if ( argc != 2 ) {
      fprintf(stderr,"usage :  %s file \n",argv[0]);
      exit(1);
    }
           
    if ( stat(argv[1],&etat) == -1 ) {
      perror("stat :");
      exit(errno);   
    }  
    //if ((etat.st_mode & S_IFMT) == S_IFDIR)
    if (S_ISDIR(etat.st_mode))
            printf("l'entree %s  est un r\'epertoire\n",argv[1]);
      else 
            printf("l'entree %s  n'est pas un r\'epertoire\n",argv[1]); 
     

}
