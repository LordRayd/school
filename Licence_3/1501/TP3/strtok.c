#include <stdio.h>  // printf

const char * DELIMITER;

char * mystrtok(char *str, const char * delim){
	char * ret;
	char phrase = str;
	if(delim != NULL) DELIMITER = delim;
	
	while(*str != *DELIMITER && *str){
		phrase += *str;
		str++;
	}
	*ret = phrase;
	ret++;
	phrase = NULL;
	if(!*str || DELIMITER == NULL)return ret;
	while(*str){
		phrase += *str;
		str++;
	}
	return ret;
}
				
int main (int argc, char * argv[]){
	char ph[] ="bonjour a\ttous";//avec espace et tab
	char *str = mystrtok(ph,"\t\n");//la chaine et les separateurs
	while(str != (char *)NULL){
		printf("%s\n",str);
		str=mystrtok((char*)NULL,"\t\n");//la chaine precedente
	}
}
