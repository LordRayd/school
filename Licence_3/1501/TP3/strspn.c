#include <stdio.h>  // printf

size_t findStrtok(char *s, char *accept){
	int ret=0;
	int bool = 1;
	char * debutAccept = accept;
	while(*s && bool == 1){
		bool = 0;
		accept = debutAccept;
		while(*accept){
			if(*accept == *s){
				bool=1;
				ret++;
			}
			accept++;
		}
		s++;
	}
	return ret;
}
				
int main (int argc, char * argv[]){
	
	printf("%d\n", findStrtok("bonjour","bonj") ); //5
	printf("%d\n", findStrtok("bonjour","onj") ); //0
	printf("%d\n", findStrtok("bonjour","abder") ); //1
	printf("%d\n", findStrtok("bonjour","ade") ); //0
	
	return 0;
}
