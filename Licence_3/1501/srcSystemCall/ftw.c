//  ftw.c
//
// exemple d'utilisation de ftw
//  qui parcourt recusivement  un répertoire
//
//  L Courtrai
//

#include <sys/types.h>
#include <sys/stat.h>
#include <ftw.h>
#include <stdlib.h>
#include <stdio.h>
//              FTW_F     Fichier normal
//              FTW_D     Répertoire
//              FTW_NS    Echec de stat sur cet élément
//              FTW_DNR   Répertoire non lisible   

// fonction appelle pour chaque  entrre
int list(const char *name, const struct stat *status, int type)
{
  if (type == FTW_NS)
    return 0;
  if (type == FTW_F)
    printf("%-30s\t0%3o\n", name, status->st_mode & 0777);
  else
    printf("%-30s*\t0%3o\n", name, status->st_mode & 0777);
  return 0;
}


// test la fonction ftw
int main(int argc, char *argv[]){
  
  if (argc <= 1)
    ftw(".", list, 1);
  else
    ftw(argv[1], list, 1);
  exit(0);
}
