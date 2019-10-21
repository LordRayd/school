/*  open.c
    cree un fichier vide
    montre l'utilisation du umak
*/
#include <fcntl.h> //appel systeme
#include <stdio.h> //librairie standard (stderr)
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>


int main ( int argc , char **argv ) {

    int file; // numero du fichier
    if ( argc != 2 ) { // manque le nom du fichier a traiter
      // message d'erreur type d'utilisation de la commande
      fprintf(stderr,"usage :  %s nomDeFichier \n",argv[0]); 
      exit(1);
    }
    umask(0); // position le umask
    if ((file = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0666)) < 0){
      // message d'erreur problme d'ouverture du fichier
      //fprintf(stderr,"%s : probleme de creation du fichier %s \n",
      //                      argv[0],argv[1]);
      perror("umask :");                  
      exit(errno);
    } else { 
      close(file); //fermeture du fichier
    } 
}


 
