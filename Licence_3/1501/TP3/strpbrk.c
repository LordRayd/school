#include <stdio.h>  // printf

char * findStrpbrk(char *s, char *accept){
	char * debutAccept = accept;
	while(*s){
		accept = debutAccept;
		while(*accept){
			if(*accept == *s){
				return *s;
			}
			accept++;
		}
		s++;
	}
	return NULL;
}

int main (int argc, char * argv[]){
	
	printf("%c\n", findStrpbrk("bonjour","bgfhxb") );
	printf("%c\n", findStrpbrk("bonjour","ade") );
	printf("%c\n", findStrpbrk("bonjour","ader") );
	
	return 0;
}
