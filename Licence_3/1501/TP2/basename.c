#include <stdio.h>  // printf

int main (int argc, char * argv[]){
	if(argc == 1){
		fprintf(stderr, "usage : basename nom [suffixe]\n");
		exit(1);
	}
	{
		char *posDepart = argv[1];
		char *posFin = argv[1];
		char *str = argv[1];
		
		posDepart = str;
		while(*str)str++;
		posFin = str;
		while(str != argv[1] && *str!= '/')str--;
		if(*str == '/')str++;
		posDepart = str;
		
		if(argc > 2){
			char *str2 = argv[2];
			str = posFin;
			while(*str2)str2++;
			while(str2 != argv[2] && str != argv[1] && *str2 == *str){
				str--;
				str2--;
			}
			if(str2 == argv[2])	posFin = str-1;
			free(*str2);
		}	
		str = posDepart;
		while(*str && str <= posFin){
			putchar(*str);
			str++;
		}
		printf("\n");
	}
}
