#include <iostream>
#include <string.h>
#include <stdio.h>

namespace ns{
	const char* saisie(){
		std::string strtmp; 
		std::cout << "Enter les caracteres que vous souhaitez afficher : ";
		std::cin >> strtmp;
		const char* tmp = strtmp.c_str();
		return tmp;
	}

	void affichage(const char * tmp){
		while (*tmp){
			printf("%c\n",*tmp);
			tmp++;
		}
	}
}

int main(){
	const char* tmp = ns::saisie();
    ns::affichage(tmp);
	return 0;
}