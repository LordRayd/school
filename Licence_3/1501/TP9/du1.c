#include <stdio.h>
#include <ctype.h>
#include <fcntl.h> //appel systeme
#include <stdio.h> //librairie standard (stderr)
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <dirent.h>

char* exten[5]={"o","ko","mo","go","to"};

int du (char* nom_directorie){
	DIR * directorie;
    struct dirent *f;
    struct stat etat;
    char path[4096];
    int tot=0;
    
    if ((directorie = opendir(nom_directorie))==NULL){
		perror("du ");
		exit(errno);
    }
	
	while ((f = readdir(directorie))!=NULL) {
		path;
		strcpy(path,nom_directorie);
		strcat(path,"/");
		strcat(path,f->d_name);
		
		if(stat(path,&etat) != -1){
			if(strcmp(f->d_name,".") && strcmp(f->d_name,"..")){
				tot += etat.st_size;
			}
		}
		
		if((etat.st_mode & S_IFDIR) && strcmp(f->d_name,".") && strcmp(f->d_name,"..")){
			strcat(path,"/");
			strcat(path,"\0");
			tot += du(path);
		}
		printf("%8d %s\n",tot,path);
	}
	return tot;
}

int main(int argc, char** argv){
	int total=du(argv[1]);
	float t=total;
	int i=0;
	while(t>=1000.0){
		t=t/1000.0;
		i++;
	}
	printf("%.3f%2s\n",t,exten[i]);
	return 0;
}
