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

#include <sys/types.h>
#include <stdio.h> // NULL  
#include <stdlib.h>         



int main(int argc,char * argv[]){


  struct passwd * pw;

  while  ((pw = getpwent())!= NULL) {
      printf("INFO PASSWD\n");
      printf("%s:",pw->pw_name);
      printf("%s:",pw->pw_passwd);
      printf("%d:",pw->pw_uid);
      printf("%d:",pw->pw_gid);
      printf("%s:",pw->pw_gecos);
      printf("%s:",pw->pw_dir);
      printf("%s",pw->pw_shell); 
  }   
}
