#include <string.h>
#include <stdio.h>  // printf et scanf

int strpalindrome(char* str){
	if(*str == (char*)NULL)return 0;
	char * debut = str;
	while(*str){
		str++;
	}
	char * fin = --str;
	while(fin-- > debut++){
		if(*debut != *fin) return 0;
	}
	return 1;
}

int main (int argc, char * argv[]){
	printf("%d\n",strpalindrome("kayak"));//1
	printf("%d\n",strpalindrome("bonjour"));//0
	printf("%d\n",strpalindrome("serres"));//1
	printf("%d\n",strpalindrome(""));//0
}
