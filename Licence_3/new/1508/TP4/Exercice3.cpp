#include <iostream>
#include <cstdlib>
#include <string.h>
#include "Exercice3.h"

String::String(const char * s){
	this->str = (char *) malloc(sizeof(char *));
	str = s;
}

String::String(String & s){
	str=s.str;
}

String::~String(){
}
		
String::operator const char * () const {
	return str;
}

/*
int main(){
	String *s1 = new String("Ceci est un test");
	String *s2 = new String(*s1);
	std::cout << "S1 : ";
	std::cout << *s1;
	delete s1;
	
	std::cout << "\nS2 : ";
	std::cout << *s2;
	std::cout << "\n";
	delete s2;
}
*/
