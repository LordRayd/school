// affiche les info recuperee
//   dans les fichiers passwd et group
//
//  usage :  pw [name]
//  
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
#include <sys/types.h>
 
#include <stdio.h> // NULL   
#include <stdlib.h> 
#include <unistd.h>  
#include <errno.h>    



int main(int argc,char * argv[]){


  struct passwd * pw;
  struct group *gr;

  if (argc == 1) { // utilisateur courant

    if ((pw = getpwuid(getuid()))== NULL){
	    perror("px getpwuid ");
	    exit(errno);
   
    } 
  }else { // un utilisateur particulier
    if ((pw = getpwnam(argv[1]))== NULL) {
	    perror("px getpwnam");
	    exit(errno);
   
    } 
  }
      printf("INFO PASSWD\n");
      printf("%s  \n",pw->pw_name);
      printf("%s  \n",pw->pw_passwd);
      printf("%d  \n",pw->pw_uid);
      printf("%d  \n",pw->pw_gid);
      printf("%s  \n",pw->pw_gecos);
      printf("%s  \n",pw->pw_dir);
      printf("%s  \n",pw->pw_shell);    
      // lecture du fichier group
    if ((gr = getgrgid(pw->pw_gid))== NULL) {
	    perror("px  getgrgid");
	    exit(errno);
   
    }   
      // ou  if ((gr = getgrnam("prof"))!= NULL) {
      printf("INFO GROUP\n");
      printf("%s  \n",gr->gr_name);
      printf("%s  \n",gr->gr_passwd);
      printf("%d  \n",gr->gr_gid);
      {
       char ** mem = gr->gr_mem;
       printf("Membre \n");
       /*while (*mem){
         printf("%s,",*mem);
         mem++;
       }*/
      }
   
}
