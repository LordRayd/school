#include <stdio.h>
#include <string.h>

void fTab(char str[10] ){
	printf("SIZEOF str1 : %d  STRLEN str1 : %d \n",sizeof(str), strlen(str));

}

void fPoint(char* str ){
	printf("SIZEOF str2 : %d  STRLEN str2 : %d \n",sizeof(str), strlen(str));

}



int main(){
	char str1[10] = "chaine1";
	char * str2 = "chaine2";
	printf("--- MAIN ---\n");
	printf("SIZEOF str1 : %d  STRLEN str1 : %d \n",sizeof(str1), strlen(str1));
	printf("SIZEOF str2 : %d  STRLEN str2 : %d \n",sizeof(str2), strlen(str2));

	
	printf("--- FONCTION ---\n");
	fTab(str1);
	fPoint(str2);


	printf("--- SWAP ---\n");
	char * str3 = "chaine3";
	printf("str2 : %s   str3 : %s\n", str2,str3);
	char * tmp = str2;
	str2 = str3;
	str3 = tmp;
	printf("str2 : %s   str3 : %s\n", str2,str3);

}