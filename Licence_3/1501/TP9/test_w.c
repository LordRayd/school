#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/stat.h>
#include <pwd.h> 
#include <grp.h>


int main ( int argc , char **argv ) {
    struct stat etat ;
    if(stat(argv[2], &etat) != 0) return 1;
    if( ((etat.st_uid == getuid()) && (etat.st_mode & S_IWUSR)) || ((etat.st_gid == getgid()) && (etat.st_mode & S_IWGRP)) ) return 0;
    return (etat.st_mode & S_IWOTH) ? 0 : 1;
}
