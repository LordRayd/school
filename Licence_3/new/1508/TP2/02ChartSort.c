#include <stdio.h>  // printf
#include <string.h>
#include <stdlib.h>

char * tabAdresse;

void print(char ** s){
	while(*s){
		printf("%s", *s);
		s++;
	}
}

void swap( char ** p1, char ** p2){
	char * tmp = *p1;
	*p1 = *p2;
	*p2 = tmp;
}

void saisie(){
	char tmp[100];
	while(strcmp(tmp,"fin\n")!=0){
		fgets(tmp,100,stdin);
		printf("%s","ok");
		save(tmp);
	}
	
}

void save(char insert[100]){
	int i;
	int bool=0;
	char * tmp = tabAdresse;
	for(i=0; i<20; i++){
		if(strcmp(*tabAdresse,insert)>0 )bool=i;
		tabAdresse++;
	}
	for(i=19; bool!=0 && i>bool; i--){
		*tabAdresse = *tabAdresse--;
	}
	tabAdresse = tmp;
}

int main(int argc, char * argv[]){
	tabAdresse = malloc(20*sizeof(char*));
	saisie();
	print(tabAdresse);
	return 0;
}

