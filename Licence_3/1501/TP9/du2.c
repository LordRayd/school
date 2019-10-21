#include <ftw.h>
#include <stdio.h>
#include <sys/stat.h>

char* exten[5]={"o","ko","mo","go","to"};
int nb = 0;

int list(const char *name, const struct stat *status, int type) {
	if(type == FTW_NS) return 0;

	if(type == FTW_F){
		printf("%8d %s\n", status->st_size, name);
		
		nb += status->st_size;
	}
	if(type == FTW_D && strcmp(".", name) != 0) {
		printf("%8d %s\n", status->st_size, name);
		nb += status->st_size;
	}
	return 0;
}

int main(int argc, char *argv[]) {
	if(argc == 1) ftw(".", list, 1);
	else  ftw(argv[1], list, 1);
	
	float t=nb;
	int i=0;
	while(t>=1000.0){
		t=t/1000.0;
		i++;
	}
	printf("%.3f%2s\n",t,exten[i]);
	return 0;
}


