/*  tee.c
    duplique les caractere arrivant sur l'entree standard
       sur la sortie standard et dans un fichier
       exemple d'utilisation
           pr | tee trace
*/
#include <fcntl.h> //appel systeme
#include <stdio.h> //librairie standard (stderr)
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

int main ( int argc , char **argv ) {

    int file; // numero du fichier
    if ( argc != 2 ) { // manque le nom du fichier a traiter
      // message d'erreur type d'utilisation de la commande
      fprintf(stderr,"usage :  %s nomDeFichier \n",argv[0]); 
      exit(1);
    }
    if ((file = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0644)) < 0){
      // message d'erreur problme d'ouverture du fichier
      // fprintf(stderr,"%s : probleme de creation du fichier %s\n",
      //                      argv[0],argv[1]); 
      perror("tee :");
      exit(errno);
    }  
    { 
      #define MAX 512 // taille d'un bloc 
      char  buf[MAX]; // zone tampon (bloc)
      int nb;  // nombre caracters lu par read
      while ((nb= read(0,buf,MAX)) > 0) { //lecture sur l'entree standard
         write(1,buf,nb); /* fd = 1 sortie standard */
         write(file,buf,nb); /* fd = 1 sortie standard */ 
      }
      close(file); //fermeture du fichier
    } 
}


 
