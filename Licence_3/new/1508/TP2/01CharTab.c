#include <stdio.h>  // printf
#include <string.h>

void f1(char c[]){
	printf("\nTableau Size : %d\n",sizeof(c));
	printf("Tableau Str  : %d\n",strlen(c));
}

void f2(char * c){
	printf("\nPointeur Size : %d\n",sizeof(c));
	printf("Pointeur Str  : %d\n",strlen(c));
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
	
	printf("s1 : %d\n", sizeof(s1));
	printf("s2 : %d\n", sizeof(s2));
	printf("\ns1 : %d\n", strlen(s1));
	printf("s2 : %d\n", strlen(s2));
	
	f1(s1);
	f2(s2);
	
	swap(&s2,&s3);
	f2(s3);
	
	return 0;
}

