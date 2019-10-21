/* cat .c
     affiche le contenu d'un fichier sur la sortie standard
     le nom du fichier est passe en parametre de la commande
     le fichier est lu par bloc de 512 caracteres
*/  
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

int main ( int argc , char **argv ) {

    int file; // numero du fichier
    if ( argc != 2 ) { // manque le nom du fichier a traiter
      // message d'erreur
      fprintf(stderr,"usage :  %s file \n",argv[0]); 
      exit(1);
    }
    if ((file = open(argv[1],O_RDONLY)) == -1 ){
      // message d'erreur problme d'ouverture du fichier
      //fprintf(stderr,"%s : le fichier %s n'existe pas \n",argv[0],argv[1]);
      perror("cat"); // cat: No such file or directory
      exit(errno);
    }   
    #define MAX 512 // taille d'un bloc 
    char  buf[MAX]; // zone tampon (bloc)
    int nb;  // nombre caracters lu par read
    while ((nb= read(file,buf,MAX)) > 0) { //lecture dans le fichier
         write(1,buf,nb); /* fd = 1 sortie standard */
    }
    close(file); //fermeture du fichier
     
}
