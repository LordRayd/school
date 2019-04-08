#include "Dice.h"

#include <iostream>

using namespace rpg;
using namespace std;

Dice::Dice(int nf): valMin(1){
	this->nbFaces = nf;
	clog << "Dice," << this << ",Constructeur" << std::endl;
}

Dice::Dice(int nf, int min){
	this->nbFaces = nf;
	this->valMin = min;
	clog << "Dice," << this << ",Constructeur" << std::endl;
}

Dice::Dice(Dice const& d):valMin(1){
	this->nbFaces = d.nbFaces;
	clog << "Dice," << this << ",Constructeur" << std::endl;
}

Dice::~Dice(){
	clog << "Dice," << this << ",Destructeur" << std::endl;
}

Dice::operator int(){
	return this->getValue();
}

int Dice::getValue(){
	srand(time(NULL));
	return (this->getMinValue() + (rand() % (int)(this->getMaxValue())));
}

int Dice::getMaxValue(){
	return this->nbFaces;
}

int Dice::getMinValue(){
	
	return 1;
	//return this->valMin;
}
