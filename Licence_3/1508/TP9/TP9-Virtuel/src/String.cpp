#include <iostream>
#include <cstdlib>
#include <string.h>
#include "String.h"

String::String(const char * s){
	this->str = (char *) malloc(sizeof(char *));
	this->str = s;
}

String::String(String & s){
	str=s.str;
}

String::~String(){
}
		
String::operator const char * () const {
	return this->str;
}
/*
String String::operator+(const String s1,const String& s2){
	const char* un= s1;
    const char* deux=s2;
    int nb=(strlen(un))+(strlen(deux))+1;
    char* c=new char[nb];
    strcpy(c,un);
    strcat(c,deux);
    return String(c);
}

String String::operator+(const String s,const char* c){
	return s+String(c);
}

String String::operator+(const char* c,const String s){
	return String(c)+s;	
}*/

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
