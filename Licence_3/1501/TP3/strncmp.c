#include <stdio.h>  // printf

int main (int argc, char * argv[]){
	
	printf("Phrase 1 : %d\n",compare("bonjour","bonsoir",3));
	printf("Phrase 2 : %d\n",compare("bonjour","bonsoir",5));
	printf("Phrase 3 : %d\n",compare("bonjour","bo",5));
	printf("Phrase 4 : %d\n",compare("bo","bonsoir",5));
	printf("Phrase 5 : %d\n",compare("bo","bo",5));
	
	
	return 0;
}

int compare(char * s1, char * s2, size_t n){
	while( n > 0){
		if(*s1 != *s2) return *s1 - *s2;
		s1++;
		s2++;
		n--;
	}
	return 0;
}
