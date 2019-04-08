#include <stdio.h>  // printf
#include <string.h>

void f1(char c[]){
	printf("\nTableau Size : %ld\n",sizeof(c));
	printf("Tableau Str  : %ld\n",strlen(c));
}

void f2(char * c){
	printf("\nPointeur Size : %ld\n",sizeof(c));
	printf("Pointeur Str  : %ld\n",strlen(c));
}

void swap( char ** p1, char ** p2){
	char * tmp = *p1;
	*p1 = *p2;
	*p2 = tmp;
}

int main(int argc, char * argv[]){
	char s1[] = {'b','o','n','j','o','u','r'};
	char * s2 = "bonjour c  est pas moi qui galere";
	char * s3 = "vdgdfhnb fdhtyfb ftgb drtbd ";
	
	printf("s1 : %ld\n", sizeof(s1));
	printf("s2 : %ld\n", sizeof(s2));
	printf("\ns1 : %ld\n", strlen(s1));
	printf("s2 : %ld\n", strlen(s2));
	
	f1(s1);
	f2(s2);
	
	swap(&s2,&s3);
	f2(s3);
	
	return 0;
}

