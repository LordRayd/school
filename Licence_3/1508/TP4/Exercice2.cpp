#include "Exercice2.h"
#include <iostream>

A::A(double a){
	std::cout << "Constructeur value\n";
	this->value = a;
}
A::A(const A & a){
	std::cout << "Copie Constructeur\n";
	this->value = a.value;
}
A::~A(){
	std::cout << "Destructeur\n";
}

void f(){
	A af1(13.0);
	A *af2 = new A(3.1);
	std::cout << "Attendu  Destructeur Destructeur\n";
	delete af2;
}

int main(int argc, char * argv[]){
	A a1(13.0);
	A a2(a1);
	A *a3 = new A(3.1);
	delete a3;
	std::cout << "\nDebut f\n";
	f();
	std::cout << "Fin f\n\n";
}
