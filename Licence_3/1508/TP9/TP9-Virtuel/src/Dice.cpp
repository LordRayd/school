#include "Dice.h"

using namespace rpg;

Dice::Dice(int nf): valMin(1){
	this->nbFaces = nf;
}

Dice::Dice(int nf, int min){
	this->nbFaces = nf;
	this->valMin = min;
}

Dice::Dice(Dice const& d):valMin(1){
	this->nbFaces = d.nbFaces;
}

Dice::~Dice(){
	
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
